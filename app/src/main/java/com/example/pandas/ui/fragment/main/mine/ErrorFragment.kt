package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.ErrorViewModel
import com.example.pandas.databinding.FragmentErrorBinding

/**
 * @description: ErrorFragment
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class ErrorFragment : BaseFragment<ErrorViewModel, FragmentErrorBinding>() {

    var fileName: String? = null

    override fun initView(savedInstanceState: Bundle?) {


        fileName = arguments?.getString("fileName")
        Log.e("1mean","fileName:$fileName")

    }

    override fun createObserver() {

        mViewModel.fileList.observe(viewLifecycleOwner){


            if (it.isNotEmpty()) {


                binding.rvContentError.run {
                    adapter = object : BaseCommonAdapter<String>(it) {

                        override fun getLayoutId(): Int = R.layout.adapter_error_item

                        override fun convert(holder: BaseViewHolder, data: String, position: Int) {

                            val content = holder.getWidget<AppCompatTextView>(R.id.txt_item_error_content)

                            content.text = data
                        }
                    }
                    layoutManager = LinearLayoutManager(mActivity)
                }
            }
        }
    }

    override fun firstOnResume() {

        fileName?.let {
            mViewModel.readFile(it)
        }
    }

    companion object {
        fun newInstance(fileName: String): ErrorFragment {
            val args = Bundle().apply { putString("fileName", fileName) }
            val fragment = ErrorFragment()
            fragment.arguments = args
            return fragment
        }
    }
}