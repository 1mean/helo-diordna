import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.ItemHeaderEyeBinding
import com.example.pandas.databinding.ItemVideoEyeBinding
import com.example.pandas.databinding.ItemVpEyeBinding
import com.example.pandas.ui.view.Banner

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/23 10:28 上午
 * @version: v1.0
 */
public class EyepetozerAdapter(
    val list: MutableList<EyepetozerBean>,
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = list.size
    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    public fun addList(items: MutableList<EyepetozerBean>) {

        if (items.isNotEmpty()) {
            list.addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        when (viewType) {
            1 -> {//viewpager
                val binding =
                    ItemVpEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Type1ViewHolder(binding)
            }
            2 -> {
                val header = AppCompatTextView(parent.context)
                header.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                return BaseEmptyViewHolder(header)
            }
            3 -> {
                val binding =
                    ItemVideoEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Type3ViewHolder(binding)
            }
        }
        return BaseEmptyViewHolder(
            ItemHeaderEyeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        when (getItemViewType(position)) {

            1 -> doType1ViewHodler(holder, position)
            2 -> {
                val header = holder.itemView as AppCompatTextView
                val bean = list[position]
                header.text = bean.title
            }
            3 -> {

                val bean = list[position]
                val user = bean.user
                val mHolder = holder as Type3ViewHolder
                holder.userName.text = user?.userName
                holder.descripetion.text = bean.description
                Glide.with(mHolder.itemView.context).load(bean.coverUrl).into(mHolder.cover)
                Glide.with(mHolder.itemView.context).load(user?.userIcon).apply(
                    RequestOptions.bitmapTransform(
                        CircleCrop()
                    )
                ).into(mHolder.userIcon)
            }
        }
    }

    private fun doType1ViewHodler(holder: BaseEmptyViewHolder, position: Int) {
        val mHolder = holder as Type1ViewHolder
        val mPager = mHolder.viewPager

        mPager.setPagePadding(50, 50, 9)
            .setAdapter(EyeViewPagerAdapter(list[position].horizontalCardList!!))
    }

    class Type1ViewHolder(binding: ItemVpEyeBinding) : BaseEmptyViewHolder(binding.root) {

        val viewPager: Banner = binding.vpEye

    }

    class Type3ViewHolder(binding: ItemVideoEyeBinding) : BaseEmptyViewHolder(binding.root) {

        val cover: AppCompatImageView = binding.imgVideo
        val userIcon: AppCompatImageView = binding.imgUser
        val descripetion: AppCompatTextView = binding.txtDescripetion
        val userName: AppCompatTextView = binding.txtUser
    }

//    override fun getItemCount(): Int = list.size + 1
//    override fun getItemViewType(position: Int): Int {
//        if (position == list.size) {
//            return 4
//        } else {
//            return list[position].type
//        }
//    }
//
//    public fun addList(items: MutableList<EyepetozerBean>) {
//
//        if (items.isNotEmpty()) {
//            list.addAll(items)
//            notifyDataSetChanged()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
//        when (viewType) {
//            1 -> {//viewpager
//                val binding =
//                    ItemVpEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return Type1ViewHolder(binding)
//            }
//            2 -> {
//                val header = AppCompatTextView(parent.context)
//                header.layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//                return BaseEmptyViewHolder(header)
//            }
//            3 -> {
//                val binding =
//                    ItemVideoEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return Type3ViewHolder(binding)
//            }
//            4 -> {
//                val binding =
//                    FooterRecyclerviewBinding.inflate(
//                        LayoutInflater.from(parent.context),
//                        parent,
//                        false
//                    )
//                return FooterViewHolder(binding)
//            }
//        }
//        return BaseEmptyViewHolder(
//            ItemHeaderEyeBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            ).root
//        )
//    }
//
//    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
//
//        when (getItemViewType(position)) {
//
//            1 -> doType1ViewHodler(holder, position)
//            2 -> {
//                val header = holder.itemView as AppCompatTextView
//                val bean = list[position]
//                header.text = bean.title
//            }
//            3 -> {
//
//                val bean = list[position]
//                val user = bean.user
//                val mHolder = holder as Type3ViewHolder
//                holder.userName.text = user?.userName
//                holder.descripetion.text = bean.description
//                Glide.with(mHolder.itemView.context).load(bean.coverUrl).into(mHolder.cover)
//                Glide.with(mHolder.itemView.context).load(user?.userIcon).apply(
//                    RequestOptions.bitmapTransform(
//                        CircleCrop()
//                    )
//                ).into(mHolder.userIcon)
//            }
//            4 -> {
//
//                val holder = holder as FooterViewHolder
//                holder.itemView.visibility= View.GONE
//                holder.txtFooter.visibility= View.GONE
//                holder.imgFooter.visibility= View.GONE
//            }
//        }
//    }
//
//    private fun doType1ViewHodler(holder: BaseEmptyViewHolder, position: Int) {
//        val mHolder = holder as Type1ViewHolder
//        val mPager = mHolder.viewPager
//
//        mPager.setPagePadding(50, 50, 9)
//            .setAdapter(EyeViewPagerAdapter(list[position].horizontalCardList!!))
//    }
//
//    class Type1ViewHolder(binding: ItemVpEyeBinding) : BaseEmptyViewHolder(binding.root) {
//
//        val viewPager: Banner = binding.vpEye
//
//    }
//
//    class Type3ViewHolder(binding: ItemVideoEyeBinding) : BaseEmptyViewHolder(binding.root) {
//
//        val cover: AppCompatImageView = binding.imgVideo
//        val userIcon: AppCompatImageView = binding.imgUser
//        val descripetion: AppCompatTextView = binding.txtDescripetion
//        val userName: AppCompatTextView = binding.txtUser
//    }
//
//    class FooterViewHolder(binding: FooterRecyclerviewBinding) : BaseEmptyViewHolder(binding.root) {
//
//        val imgFooter = binding.imgFooter
//        val txtFooter = binding.txtFooter
//        val footer = binding.footer
//    }
//
//    class MyItemDecoration : RecyclerView.ItemDecoration() {
//
//        override fun getItemOffsets(
//            outRect: Rect,
//            view: View,
//            parent: RecyclerView,
//            state: RecyclerView.State
//        ) {
//            outRect.right = 6
//        }
//    }

}