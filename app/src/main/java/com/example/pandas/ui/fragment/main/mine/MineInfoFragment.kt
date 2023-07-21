import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import com.blankj.utilcode.util.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentMineInfoBinding
import com.example.pandas.ui.ext.toastTopShow
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: SelfInfoActivity-MineInfoFragment
 * @author: dongyiming
 * @date: 7/21/23 12:37 PM
 * @version: v1.0
 */
public class MineInfoFragment : BaseLazyFragment<SelfViewModel, FragmentMineInfoBinding>() {

    private val imgResource
        get() = arrayOf(
            R.mipmap.img_mine_selected,
            R.mipmap.img_mine_unselected
        )

    private var sexIndex = 0
    private var curSexIndex = 0
    private var name: String? = null

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    companion object {
        fun newInstance(name: String): MineInfoFragment {
            val args = Bundle().apply { putString("name", name) }
            val fragment = MineInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        name = arguments?.getString("name")
        when (name) {
            "修改昵称" -> {
                binding.clayoutUpdateName.visibility = View.VISIBLE
                binding.editUpdateName.requestFocus()
                binding.editUpdateName.post {
                    KeyboardUtils.showSoftInput(binding.editUpdateName)
                }
            }
            "修改性别" -> {
                binding.llayoutInfoSex.visibility = View.VISIBLE
            }
        }

        binding.btnDeleteNameInput.setOnClickListener {
            if (binding.editUpdateName.text != null) {
                binding.editUpdateName.text = null
                binding.editUpdateName.hint = "请输入新昵称"
                binding.editUpdateName.requestFocus()
            }
        }

        mViewModel.userInfo.value?.let {
            when (it.sex) {
                0 -> {
                    sexIndex = 0
                    binding.imgMale.setImageResource(imgResource[0])
                }
                1 -> {
                    sexIndex = 1
                    binding.imgSexFemale.setImageResource(imgResource[0])
                }
                -1 -> {
                    sexIndex = -1
                    binding.imgSexSecret.setImageResource(imgResource[0])
                }
            }

        }

        binding.clayoutSexType1.setOnClickListener {
            curSexIndex = 0
            binding.imgMale.setImageResource(imgResource[0])
            binding.imgSexFemale.setImageResource(imgResource[1])
            binding.imgSexSecret.setImageResource(imgResource[1])
        }

        binding.clayoutSexType2.setOnClickListener {
            curSexIndex = 1
            binding.imgMale.setImageResource(imgResource[1])
            binding.imgSexFemale.setImageResource(imgResource[0])
            binding.imgSexSecret.setImageResource(imgResource[1])
        }

        binding.clayoutSexType3.setOnClickListener {
            curSexIndex = -1
            binding.imgMale.setImageResource(imgResource[1])
            binding.imgSexFemale.setImageResource(imgResource[1])
            binding.imgSexSecret.setImageResource(imgResource[0])
        }
    }

    override fun createObserver() {

        mViewModel.updateName.observe(viewLifecycleOwner) {
            if (it) {
                val newName = binding.editUpdateName.text.toString()
                if (newName.isNotEmpty()) {
                    if (newName.length > 7) {
                        toastTopShow(mActivity, "昵称超过最大长度")
                        return@observe
                    }
                    showLoading()
                    val user = mViewModel.userInfo.value
                    user?.let { curUser ->
                        curUser.userName = newName
                        mViewModel.updateUser(curUser)
                    }
                } else {
                    //bug:直接使用fragmentManager或调用activity来进行关闭fragment，都能成功关闭，但是下一次无法继续点击进来
                    mViewModel.closeFragment.value = true
                }
            }
        }

        mViewModel.updateSex.observe(viewLifecycleOwner) {
            Log.e("1mean", "updateSex")
            if (curSexIndex == sexIndex) {
                mViewModel.closeFragment.value = true
            } else {
                showLoading()
                val user = mViewModel.userInfo.value
                user?.let { curUser ->
                    Log.e("1mean", "curSexIndex: $curSexIndex")
                    curUser.sex = curSexIndex
                    mViewModel.updateUser(curUser)
                }
            }
        }

        mViewModel.updateUserResult.observe(viewLifecycleOwner) {

            binding.editUpdateName.postDelayed({
                mViewModel.userInfo.value = it
                loadingPopup?.dismiss()
                mViewModel.closeFragment.value = true

                when (name) {
                    "修改昵称" -> {
                        appViewModel.nameUpdate.value = it.userName
                    }
                    "修改性别" -> {
                        appViewModel.sexUpdate.value = it.sex
                    }
                }
            }, 500)
        }
    }

    override fun firstOnResume() {
    }

    private var loadingPopup: LoadingPopupView? = null
    private fun showLoading() {
        if (loadingPopup == null) {
            loadingPopup =
                XPopup.Builder(mActivity).dismissOnBackPressed(true)
                    .isLightNavigationBar(true)
                    .dismissOnTouchOutside(true)
                    .isViewMode(false)
                    .asLoading(
                        null,
                        R.layout.layout_waiting,
                        LoadingPopupView.Style.ProgressBar
                    )
            loadingPopup!!.show()
        } else {
            loadingPopup!!.show()
        }
    }
}