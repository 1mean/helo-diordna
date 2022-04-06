package com.example.pandas.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.controller.VideoIntroController
import com.example.pandas.biz.interaction.CommonResultListener
import com.example.pandas.databinding.FragmentVideoIntroBinding
import com.example.pandas.ui.adapter.VideoRecommendAdapter
import com.example.pandas.utils.TimeUtils

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/29/21 11:39 下午
 * @version: v1.0
 */
public class VideoIntroFragment : Fragment(), CommonResultListener<MutableList<EyepetozerBean>> {

    var eyepetozerBean: EyepetozerBean? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        lifecycle.addObserver(object : DefaultLifecycleObserver {


            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)

                eyepetozerBean =
                    activity?.intent?.getParcelableExtra<EyepetozerBean>("EyepetozerBean")
            }
        })
    }

    private var _binding: FragmentVideoIntroBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoIntroBinding.inflate(inflater, container, false)

        val controller = VideoIntroController(this)
        val videoId = eyepetozerBean?.videoId
        videoId?.let { controller.getRecommendVideos(it) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = eyepetozerBean?.user
        val headUrl = user?.userIcon
        Glide.with(requireContext()).load(headUrl)
            .apply(RequestOptions.bitmapTransform(CircleCrop())).into(binding.imgHead)
        binding.txtName.text = user?.userName
        binding.txtFans.text = String.format(user?.userCode.toString() + "粉丝")
        binding.txtCounts.text = String.format(user?.videoNum.toString() + "视频")
        binding.txtVideoTitle.text = eyepetozerBean?.title
        binding.ibComment.text = eyepetozerBean?.replyCount.toString()

        binding.txtVideoTime.text = eyepetozerBean?.releaseTime?.let { TimeUtils.getStringDate(it) }
        binding.txtLike.text = eyepetozerBean?.collectionCount.toString()
        binding.txtCollect.text = eyepetozerBean?.realCollectionCount.toString()
        binding.txtShare.text = eyepetozerBean?.shareCount.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResult(data: MutableList<EyepetozerBean>) {

        val adapter = VideoRecommendAdapter(data)
        val recyclerView = binding.rvVideo
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onFailure(errorMessage: String) {
        Log.e("pandas_error", "Failed to get recommend video for: $errorMessage")
    }
}