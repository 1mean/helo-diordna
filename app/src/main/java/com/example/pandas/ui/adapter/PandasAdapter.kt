package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.bean.GridItem
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.databinding.AdapterPandansTopBinding
import com.example.pandas.databinding.AdapterPandasItemBinding
import com.example.pandas.databinding.ItemTitleAdapterPandaBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.ext.getHomePandaDesc
import com.example.pandas.utils.TimeUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnConfirmListener

/**
 * @description: PandasAdapter
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

        val cover = binding.clayoutPandaItemCover
        val duration = binding.txtHomePandaItemDuration
        val name = binding.txtHomePandaItemName
        val title = binding.txtHomePandaItemTitle
        val typeName = binding.txtHomePandaItemTypename
        val deleteView = binding.clayoutHomePandaItemDelete

        fun handle(position: Int) {

            val petVideo = list[position - 2]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            Glide.with(itemView).load(petVideo.cover).into(cover)
            this.duration.text = duration
            petVideo.user?.let {
                name.text = it.userName
            }
            typeName.text = getHomePandaDesc(petVideo.period, petVideo.title!!)
            title.text = petVideo.title

            itemView.setOnClickListener {
                startVideoPlayActivity(itemView.context, petVideo.code, false)
            }
            deleteView.setOnClickListener {

                val popuView =
                    XPopup.Builder(itemView.context).isDestroyOnDismiss(true)
                        .asConfirm("删除", "对当前视频不感兴趣，删除视频", "取消", "确定", object : OnConfirmListener {
                            override fun onConfirm() {
                                Log.e("1mean", "删除position: $position")
                                list.removeAt(position - 2)
                                notifyItemRemoved(position)
                                notifyItemRangeChanged(position, list.size)
                            }
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

    private fun getGridItems(): MutableList<GridItem> {

        val list = mutableListOf<GridItem>()
        val item1 = GridItem(
            "和花",
//            "https://i2.hdslb.com/bfs/face/8549bcf2c31f51b01d82e0c72a87435e0ff8c5c7.jpg@150w_150h.jpg"
            "https://i0.hdslb.com/bfs/face/a17f6f515d7bcc37ee8e452b343a2d1267c6c0a4.jpg@240w_240h_1c_1s.webp"
        )
        val item2 = GridItem(
            "绩笑",
            "https://i0.hdslb.com/bfs/face/356ff0f1c971b048f7c3df4c605fc7ba13a0560b.jpg@240w_240h_1c_1s.webp"
//            "https://i1.hdslb.com/bfs/face/05aaa9aae4702fed985ffb473dfaf76e060544ae.jpg@240w_240h_1c_1s.webp"
//            "https://i2.hdslb.com/bfs/face/94c778b5d966b770ee0de419d6d276930a94902f.jpg@240w_240h_1c_1s.webp"
        )
        val item3 = GridItem(
            "肉肉",
            "https://i2.hdslb.com/bfs/face/12cf0d762a6b7eea01c4dbb4e29ca96817bf06e1.jpg@150w_150h.jpg"
        )
        val item4 = GridItem(
            "萌兰",
//            "https://i1.hdslb.com/bfs/face/17809b9419f6a481d28ab6e0d56cb70fe67c2cbc.jpg@240w_240h_1c_1s.webp"
//            "https://i1.hdslb.com/bfs/face/fef5776f3c2139de2e154792f3c567f407107365.jpg@240w_240h_1c_1s.webp"
            "https://i0.hdslb.com/bfs/face/8c49cc01d26a2e521a2404bd7686fe3baa940b4a.jpg@240w_240h_1c_1s.webp"
        )
        val item5 = GridItem(
            "奥利奥",
            "https://i2.hdslb.com/bfs/face/e027ef65facad0f2fe7e44c144ff38e348e7f6c2.jpg@150w_150h.jpg"
        )
        val item6 = GridItem(
            "熊猫宝宝",
            "https://i2.hdslb.com/bfs/face/5c7a2b4cabcbd0621cacd1aa238379d6bbfd3923.jpg@150w_150h.jpg"
        )
        val item7 = GridItem(
            "熊猫妈妈",
            "https://i2.hdslb.com/bfs/face/000f55df2f0e9c28d486b8bb015e4913cb5e1823.jpg@150w_150h.jpg"
        )
        val item8 = GridItem(
            "幼年班",
            "https://i2.hdslb.com/bfs/face/02e2792704518967309dd53f87c02fc2290f7f04.jpg@150w_150h.jpg"
        )
        val item9 = GridItem(
            "成长记录",
            "https://i2.hdslb.com/bfs/face/5b346efd80b30daacc8d06e87e3d0fb367b18529.jpg@150w_150h.jpg"
        )
        val item10 = GridItem(
            "熊猫科普",
            "https://i2.hdslb.com/bfs/face/3eb095132ebeaef597d84f1129a1135439432807.jpg@150w_150h.jpg"
        )
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)
        list.add(item7)
        list.add(item8)
        list.add(item9)
        list.add(item10)
        return list
    }
}