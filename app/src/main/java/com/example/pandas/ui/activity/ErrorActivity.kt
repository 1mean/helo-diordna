package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.FileUtils
import com.example.pandas.biz.viewmodel.ErrorViewModel
import com.example.pandas.databinding.ActivityErrorBinding
import com.example.pandas.ui.adapter.ErrorAdapter
import java.io.File

/**
 * @description: 我的-日志文件
 * @author: dongyiming
 * @date: 3/24/22 11:34 下午
 * @version: v1.0
 */
public class ErrorActivity : BaseActivity<ErrorViewModel, ActivityErrorBinding>(),
    ErrorAdapter.ErrorListener {

    private val mAdapter: ErrorAdapter by lazy { ErrorAdapter(mutableListOf(), this) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.barTitle.setNavigationOnClickListener {
            finish()
        }
        binding.rvError.apply {
            layoutManager = LinearLayoutManager(this@ErrorActivity)
            adapter = mAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getAllLogFile(this)
    }

    override fun createObserver() {

        mViewModel.filesResult.observe(this) {

            if (it.isEmpty()) {
                binding.rvError.visibility = View.GONE
                binding.txtErrorMessage.visibility = View.VISIBLE
            } else {
                mAdapter.refreshAdapter(it)
            }
        }
    }

    val tag = "error_tag"
    override fun clickErrorItem(file: File) {

//        val intent = Intent()
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.action = Intent.ACTION_VIEW
//        intent.setDataAndType(Uri.fromFile(file), "txt")
//        startActivity(intent)

//        val intent2 = Intent(Intent.ACTION_GET_CONTENT)
//        val contentUri: Uri = FileProvider
//            .getUriForFile(this, "$packageName", file)
//        intent.setDataAndType(contentUri, "*/*")
//        startActivity(intent2)

        val intent = FileUtils.openFile(this,file.canonicalPath)
        startActivity(intent)

//        val transaction = supportFragmentManager.beginTransaction()
//        val fragment = supportFragmentManager.findFragmentByTag(tag)
//
//        if (fragment == null) {
//            val newFragment = ErrorFragment.newInstance(file.absolutePath)
//            transaction.add(R.id.flayout_content_error, newFragment, tag).addToBackStack(null)
//                .commit()
//        }
    }

    override fun onkeyBack() {

        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}