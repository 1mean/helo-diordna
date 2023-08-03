package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.VibrateUtils
import com.bumptech.glide.Glide
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.data.network.getGridItems
import com.example.pandas.databinding.AdapterPandansTopBinding
import com.example.pandas.databinding.AdapterPandasItemBinding
import com.example.pandas.databinding.ItemTitleAdapterPandaBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.ext.getHomePandaDesc
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
import com.example.pandas.utils.TimeUtils
import com.lxj.xpopup.XPopup

/**
 * @description: 首页-熊猫-adapter
 * @author: dongyiming
 * @date: 1/12/22 7:53 下午
 * @version: v1.0
 */
public class PandasAdapter(private val list: MutableList<PetVideo>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_TOP = 1
    private val TYPE_ITEM = 2
    private val TYPE_TITLE = 3

    override fun getItemCount(): Int {
        if (list.isEmpty()) {
            return 0
        } else {
            return list.size + 2
        }
    }

    /**
     * 下拉刷新后，数据刷新
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(data: MutableList<PetVideo>) {

        list.clear()
        if (data.isNotEmpty()) {
            list.addAll(data)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: MutableList<PetVideo>) {
        val size = list.size
        if (data.isNotEmpty()) {
            list.addAll(data)
        }
        notifyItemRangeInserted(size + 2, data.size)
    }

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        TYPE_TOP
    } else if (position == 1) {
        TYPE_TITLE
    } else {
        TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        if (viewType == TYPE_TOP) {
            val binding = AdapterPandansTopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return PandasTopViewHolder(binding)
        } else if (viewType == TYPE_TITLE) {
            val binding = ItemTitleAdapterPandaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TitleViewHolder(binding)
        } else {
            val binding = AdapterPandasItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return MyViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_TOP) {
            (holder as PandasTopViewHolder).handle()
        } else if (getItemViewType(position) == TYPE_ITEM) {
            (holder as MyViewHolder).handle(position)
        }
    }

    inner class MyViewHolder(binding: AdapterPandasItemBinding) :
        BaseEmptyViewHolder(binding.root) {

        val context = itemView.context
        val cover = binding.clayoutPandaItemCover
        val duration = binding.txtHomePandaItemDuration
        val name = binding.txtHomePandaItemName
        val title = binding.txtHomePandaItemTitle
        val typeName = binding.txtHomePandaItemTypename
        val deleteView = binding.clayoutHomePandaItemDelete
        var dialog: MoreBottomSheetDialog? = null

        fun handle(position: Int) {

            val petVideo = list[position - 2]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            //Glide.with(itemView).load(petVideo.cover).into(cover)
            loadCenterImage(itemView.context, petVideo.cover, cover)
            this.duration.text = duration
            petVideo.user?.let {
                name.text = it.userName
            }
            typeName.text = getHomePandaDesc(petVideo.period, petVideo.title!!)
            title.text = petVideo.title

            itemView.setOnLongClickListener {
                VibrateUtils.vibrate(2000)
                true
            }
            itemView.setOnClickListener {
                startVideoPlayingActivity(itemView.context, petVideo)
            }
            deleteView.setOnClickListener {
                val popuView =
                    XPopup.Builder(itemView.context).isDestroyOnDismiss(true)
                        .asConfirm("删除", "对当前视频不感兴趣，删除视频", "取消", "确定", {
                            list.removeAt(position - 2)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, list.size)
                        }, null, false)
                popuView.show()
            }
        }
    }

    inner class PandasTopViewHolder(binding: AdapterPandansTopBinding) :
        BaseEmptyViewHolder(binding.root) {

        val rv = binding.rvPandasTop
        fun handle() {
            val list = getGridItems()
            val gridAdapter = PandasGridAdapter(list)
            rv.run {
                layoutManager = GridLayoutManager(itemView.context, 5)
                adapter = gridAdapter
            }
        }
    }

    inner class TitleViewHolder(binding: ItemTitleAdapterPandaBinding) :
        BaseEmptyViewHolder(binding.root) {

    }
}