package com.example.pandas.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.FragmentSearchResultBinding
import com.example.pandas.databinding.LayoutLoadmoreBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView
import com.example.pandas.utils.TimeUtils

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/19/22 6:44 下午
 * @version: v1.0
 */
public class SearchListFragment : BaseLazyFragment<SearchViewModel, LayoutLoadmoreBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val mAdapter: MyAdapter by lazy { MyAdapter(mutableListOf()) }

    private var keywords: String = ""
    override fun initView(savedInstanceState: Bundle?) {
        keywords = arguments?.getString("keywords").toString()

        mViewModel.saveSearchHistory(mActivity, keywords)
        binding.recyclerLoad.run {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@SearchListFragment)
        }
    }

    override fun createObserver() {
        mViewModel.searchResult.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    if (!it.hasMore) {
                        binding.recyclerLoad.noMoreData()
                    }
                    mAdapter.refresh(it.listData)
                } else {

                    if (it.hasMore) {//还有更多数据
                        binding.recyclerLoad.loadMoreFinished()
                    } else {//已经是最后一页数据了
                        binding.recyclerLoad.noMoreData()
                    }
                    mAdapter.loadMore(it.listData)
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.searchRefresh(true, keywords)
    }

//    override fun onResume() {
//        super.onResume()
//        Log.e("1mean","search onResume2")
//
//    }

    override fun onLoadMore() {
        mViewModel.searchRefresh(false, keywords)
    }

    fun clear() {
        mAdapter.clear()
    }

    inner class MyAdapter(private val list: MutableList<PetViewData>) :
        RecyclerView.Adapter<BaseEmptyViewHolder>() {

        @SuppressLint("NotifyDataSetChanged")
        fun refresh(data: MutableList<PetViewData>) {

            if (data.isNotEmpty() && data != list) {
                list.clear()
                list.addAll(data)
                notifyDataSetChanged()
            }
        }

        fun loadMore(data: MutableList<PetViewData>) {

            if (data.isNotEmpty()) {
                val size = list.size
                list.addAll(data)
                Log.e("1mean", "listsize: $size")
                notifyItemRangeInserted(size, data.size)
            }
        }

        @SuppressLint("NotifyDataSetChanged")
        fun clear() {
            list.clear()
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
            val binding =
                FragmentSearchResultBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return MyViewHoodler(binding)
        }

        override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
            (holder as MyViewHoodler).handle(position)
        }

        override fun getItemCount() = list.size

        inner class MyViewHoodler(binding: FragmentSearchResultBinding) :
            BaseEmptyViewHolder(binding.root) {
            val cover = binding.imgSearchCover
            val duration = binding.txtSearchDuration
            val title = binding.txtSearchTitle
            val name = binding.txtSearchAuthor
            val layoutMore = binding.itemSearchMore

            fun handle(position: Int) {

                val video = list[position]

                loadRoundedCornerImage(itemView.context, 10, video.cover, cover)
                duration.text = TimeUtils.getMMDuration(video.duration.toLong())
                title.text = video.title
                name.text = video.authorName
                layoutMore.setOnClickListener {
                }
            }
        }
    }
}