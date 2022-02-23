import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentInformationBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/14/22 9:48 下午
 * @version: v1.0
 */
public class VideoInfosFragment : BaseFragment<VideoViewModel, FragmentInformationBinding>(),
    View.OnClickListener, OnVideoItemClickLIstener {

    private val mAdapter: VideoRecoListAdapter by lazy {
        VideoRecoListAdapter(
            mutableListOf(),
            this
        )
    }

    private var isLike = false
    private var isLove = false
    private var isCollect = false

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.itemLike.setOnClickListener(this)
        binding.itemLove.setOnClickListener(this)
        binding.itemCollect.setOnClickListener(this)
        binding.itemShare.setOnClickListener(this)

        binding.rvVideoRecommend.run {

            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(viewLifecycleOwner) {

            if (it.isStar) {
                isLove = true
                binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
            }

            it.cover?.let { url ->
                loadCircleImage(mActivity, url, binding.imgVideoInfoHead)
            }

            it.authorName?.let { name ->
                binding.txtVideoInfoName.text = name
            }

            it.releaseTime?.let { time ->
                binding.txtVideoInfoTime.text = time
            }
            it.title?.let { title ->
                binding.txtVideoInfoTitle.text = title
            }

            binding.viewVideoInfo.visibility = View.VISIBLE
        }

        mViewModel.recommendVideos.observe(viewLifecycleOwner) { list ->

            mAdapter.refresh(list)
        }
    }

    override fun firstOnResume() {
        mViewModel.getRecommendVideos()
    }


    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(v: View?) {

        when (v!!.id) {

            R.id.item_like -> {
                if (isLike) {
                    binding.imgLike.setImageResource(R.mipmap.img_like_unpress)
                } else {
                    binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
                }
                isLike = !isLike
            }

            R.id.item_love -> {
                if (isLove) {
                    binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
                } else {
                    binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
                }
                isLove = !isLove
            }
            R.id.item_collect -> {
                if (isCollect) {
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_unpress)
                } else {
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_pressed)
                }
                isCollect = !isCollect
            }
            R.id.item_share -> {

            }
        }
    }

    override fun onClick(position: Int, code: Int) {
        mViewModel.setVideoItemClick(code)
    }
}