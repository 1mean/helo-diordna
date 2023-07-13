package com.example.pandas.ui.adapter

import ShortReplyCommentAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.ShortCommentListener
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.AdapterShortCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.ui.ext.startUserInfoActivity
import com.example.pandas.ui.view.NestedScrollableHost
import com.example.pandas.utils.TimeUtils

/**
 * @description: ShortCommentAdapter
 * @author: dongyiming
 * @date: 12/10/22 8:56 PM
 * @version: v1.0
 */
public class ShortCommentAdapter(
    private val data: MutableList<CommentAndUser>,
    private val listener: ShortCommentListener
) :
    Adapter<ViewHolder>() {

    //TopCommentId + RecyclerView : 解决RecyclerView的复用问题
    private val replyRecyclerViews = mutableMapOf<Int, RecyclerView>()

    fun refreshAdapter(list: MutableList<CommentAndUser>) {

        if (list.isNotEmpty() && list != data) {
            list.forEach {
                val comment = it.comment
                if (comment.replyCounts > 0) {
                    comment.state = 2
                }
            }
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加更多数据
     */
    fun loadMore(list: MutableList<CommentAndUser>) {
        if (list.isNotEmpty()) {
            list.forEach {
                val comment = it.comment
                if (comment.replyCounts > 0) {
                    comment.state = 2
                }
            }
            val size = data.size
            data.addAll(list)
            notifyItemRangeInserted(size, list.size)
        }
    }

    fun loadOneCmMessage(videoComment: CommentAndUser) {
        Log.e("lidandan", "add one message: $videoComment")
        data.add(0, videoComment)
        //bug:在数据首位添加一个元素后，list的缓存里的position并未改变，只有当我们滑动后，缓存更改后，position才会改变，所以我们必须使用notifyItemRangeChanged进行局部刷新
        notifyItemInserted(0)
        //notifyItemRangeChanged(0, data.size)
    }

    fun addOneMessage(videoComment: CommentAndUser, replyPosition: Int = 0) {

        val commentType = videoComment.comment.type
        if (commentType == 1) {//一级评论，直接放在第一个位置
            data.add(0, videoComment)
            notifyItemInserted(0)
        } else {//二级弹幕和三级弹幕需要先找准topcomment
            //1，先找到topComment
            var currentPos = replyPosition
            var topCommentUser = data[replyPosition]
            if (topCommentUser.comment.id != videoComment.comment.topCommentId) {
                data.forEachIndexed { index, commentAndUser ->
                    val comment = commentAndUser.comment
                    if (comment.type == 1 && comment.id == videoComment.comment.topCommentId) {
                        topCommentUser = commentAndUser
                        currentPos = index
                    }
                }
            }
            //2，将新评论添加到topComment中


        }
    }

    //RecyclerView的adapter会出现复用的情况，RecyclerView从展开变为收起，RecyclerView对象完全变了，adapter也同样变化
    override fun getItemViewType(position: Int): Int {
        return data[position].comment.commentId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = AdapterShortCommentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReplyCommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ReplyCommentViewHolder).handle(position)
    }

    override fun getItemCount(): Int = data.size

    /**
     * bug(是bug吗): RecyclerView + RecyclerView的嵌套，如果RecyclerView写在代码里，会为每个item创建一个RecyclerView，哪怕是Gone/INVISIABLE
     *
     * 解决：不再布局文件里写，写在代码里。目前不解决这个问题
     *
     */
    inner class ReplyCommentViewHolder(binding: AdapterShortCommentBinding) :
        ViewHolder(binding.root) {

        val mContext = itemView.context
        val header = binding.imgHeaderItemShortComment
        val name = binding.txtNameItemShortComment
        val content = binding.txtContentItemShortComment
        val time = binding.txtTimeItemShortComment
        val address = binding.txtAddressItemShortComment
        val reply = binding.txtReplyItemShortComment
        val likeLayout = binding.clayoutLikeItemShort
        val itemContentView = binding.clayoutContentItemShortComment
        val likes = binding.txtLikesItemShort
        val likeView = binding.imgLikeItemShort
        val comments = binding.txtCommentsItemShort
        private val arrows = binding.imgCommentsItemShort
        val replyCountsLayout = binding.flayoutReplyItemShort
        val replyCountView = binding.llayoutReplyItemShort
        private val replyLoadingView = binding.clayoutReplyLoading

        //private val replyRecyclerView = binding.rvReply
        private val replyLayout = binding.llayoutReply

        /**
         * 添加一条回复
         * - 一级弹幕直接放在第一个位置，并且弹到该位置
         * - 二级三级弹幕，放在当前页面最后一个位置
         */
        fun loadOne(comment: CommentAndUser, position: Int) {
            val topComment = data[position].comment
            val topCommentId = comment.comment.topCommentId
            Log.e(
                "1mean",
                "loadOne() position:$position, topCommentId:$topCommentId, commentId:${topComment.id}"
            )
            if (topComment.id != topCommentId) {
                throw IllegalArgumentException("不是该条消息的回复内容，请重新确认！")
            }
            var mRecyclerView: RecyclerView? = null
            mRecyclerView = replyRecyclerViews[topCommentId]
            if (mRecyclerView == null || mRecyclerView.adapter == null) {
                mRecyclerView = RecyclerView(mContext)
                mRecyclerView.layoutParams =
                    LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
                replyLayout.addView(mRecyclerView)
                mRecyclerView.run {
                    layoutManager = LinearLayoutManager(mContext)
                    isNestedScrollingEnabled = false
                    adapter = ShortReplyCommentAdapter(mutableListOf(comment), object :
                        ShortReplyCommentAdapter.ReplyItemClickListener {
                        override fun reply(commentUser: CommentAndUser) {
                            val curPos = comparePosition(position, commentUser.comment)
                            Log.e("1mean", "item click position: $position")
                            listener.showInputToReply(commentUser, curPos, false)
                        }
                    })
                }
                replyRecyclerViews[topCommentId] = mRecyclerView
            } else {
                (mRecyclerView.adapter as ShortReplyCommentAdapter).loadOne(comment)
                replyRecyclerViews[topCommentId] = mRecyclerView
            }
            when (topComment.state) {
                0 -> {//1，没有评论的item,添加回复
                    Log.e("1mean", "2222")
                    data[position].comment.state = 1
                }
                2 -> {//3,有评论，但是未点开
                    Log.e("1mean", "3333")
                    data[position].comment.state = 3
                }
            }
            if (mRecyclerView.adapter!!.itemCount < topComment.replyCounts) {
                Log.e("1mean", "4444")
                topComment.replyComments.add(mRecyclerView.adapter!!.itemCount - 1, comment)
            } else {
                Log.e("1mean", "5555")
                topComment.replyComments.add(comment)
            }
            topComment.newReplyCounts += 1
            topComment.replyCounts += 1
            Log.e("1mean", "topComment: $topComment")
        }

        /**
         * bug出现问题：
         *      - 点击"展开回复"，创建RecyclerView，加载评论数据，下滑后再回到该item时，handle方法里status=4的RecyclerView对象改变了，并且adapter=null
         *
         */
        fun loadReplyData(position: Int, replies: MutableList<CommentAndUser>) {

            replyLayout.visibility = View.VISIBLE
            val topComment = data[position].comment
            if (topComment.id != replies[0].comment.topCommentId) {
                throw IllegalArgumentException("不是该条消息的回复内容，请重新确认！")
            }
            val replyCounts = topComment.replyCounts

            var mRecyclerView: RecyclerView? = null
            mRecyclerView = replyRecyclerViews[topComment.id]
            val visibleSize = if (mRecyclerView == null || mRecyclerView.adapter == null) {
                0
            } else {
                mRecyclerView.adapter!!.itemCount
            }

            val hasMore = (visibleSize + replies.size) < replyCounts

            if (mRecyclerView == null || mRecyclerView.adapter == null) {

                mRecyclerView = RecyclerView(mContext)
                mRecyclerView.layoutParams =
                    LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
                replyLayout.addView(mRecyclerView)
                mRecyclerView.run {
                    layoutManager = LinearLayoutManager(mContext)
                    isNestedScrollingEnabled = false
                    adapter = ShortReplyCommentAdapter(replies, object :
                        ShortReplyCommentAdapter.ReplyItemClickListener {
                        override fun reply(commentUser: CommentAndUser) {
                            val curPos = comparePosition(position, commentUser.comment)
                            Log.e("1mean", "item click position: $position")
                            listener.showInputToReply(commentUser, curPos, false)
                        }
                    })
                }
                replyRecyclerViews[topComment.id] = mRecyclerView
            } else {
                (mRecyclerView.adapter as ShortReplyCommentAdapter).loadMore(replies)
                replyRecyclerViews[topComment.id] = mRecyclerView
            }
            mRecyclerView.post {
                replyLoadingView.visibility = View.GONE
                if (hasMore) {
                    comments.text = "展开更多回复"
                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                } else {
                    comments.text = "收起"
                    arrows.setImageResource(R.mipmap.img_short_comment_up)
                }
            }
            topComment.state = 4
            topComment.replyComments.addAll(replies)
        }

        /**
         * bug:复用的bug
         *     - 项目是大量的 RecyclerView + RecyclerView 的嵌套使用，RecyclerView是一定会被复用的
         *     - 无论你当前item的status是什么，只要涉及到当前item有 子RecyclerView，那么你在滑动后，再回来，可能RecyclerView就是之前其他item的
         *     - 一旦有的RecyclerView有adapter，有的RecyclerView没有adapter，那么滑动后就肯定会错位
         *          - 有adapter(即展开的评论数据)的RecyclerView，会在滑动后复用，展示到其他item下面去了
         *          - 有adapter的RecyclerView，再回来后会再创建一个新的RecyclerView，其中adapter为空，不会展示数据
         * 解决：缓存已展开的RecyclerView，与相应的topCommentId进行绑定
         */
        fun handle(position: Int) {

            val comment = data[position].comment
            val user = data[position].user
            val replyCounts = comment.replyCounts
            initWedget(comment, user)

            val rv = replyLayout.getChildAt(0)
            if (rv == null) {
                Log.e("1mean", "position:$position,recyclerView: null")
            } else {
                val adapter = (rv as RecyclerView).adapter
                Log.e("1mean", "position:$position, recyclerView: $rv, adapter: $adapter")
                replyLayout.removeViewAt(0)
            }

            val cacheRecyclerView = replyRecyclerViews.get(comment.id)
            Log.e("1mean", "position:$position, cacheRecyclerView: $cacheRecyclerView")
            if (comment.replyCounts == 0 && comment.state == 0) {//默认常规评论，没有回复
                replyLayout.visibility = View.GONE
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
            } else if (comment.state == 1) {//没有原始评论，有作者回复的单一评论
                replyLayout.visibility = View.VISIBLE
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
                replyLayout.addView(cacheRecyclerView)
            } else if (comment.state == 2) {//有评论，但是未点开
                replyLayout.visibility = View.GONE
                replyCountsLayout.visibility = View.VISIBLE
                replyLoadingView.visibility = View.GONE
                comments.text = "展开$replyCounts 条回复"
            } else if (comment.state == 3) {//有原始评论，但未展开，只是我回复的几条评论
                replyLayout.visibility = View.VISIBLE
                replyLayout.addView(cacheRecyclerView)
                cacheRecyclerView?.adapter?.let { mAdapter ->
                    val visibleCounts = mAdapter.itemCount
                    comments.text = "展开${replyCounts - visibleCounts} 条回复"
                }
            } else if (comment.state == 4) {//有评论，也展开了
                replyLayout.visibility = View.VISIBLE
                replyLayout.addView(cacheRecyclerView)
                cacheRecyclerView?.adapter?.let { mAdapter ->
                    val visibleCounts = mAdapter.itemCount
                    if (visibleCounts < replyCounts) {
                        comments.text = "展开更多回复"
                    } else {
                        comments.text = "收起"
                    }
                }
            }
            header.setOnClickListener {
                startUserInfoActivity(mContext, user)
            }

            name.setOnClickListener {
                startUserInfoActivity(mContext, user)
            }

            //点开回复 或 加载更多 或 收起
            replyCountsLayout.setOnClickListener {

//                when (comment.state) {
//                    2 -> {//默认有评论的常规评论，未点开
//                        val mRecyclerView = replyRecyclerViews[comment.id]
//                        if (mRecyclerView != null) {//说明
//
//                        }
//                    }
//                    3 -> {//有评论，但未展开，只是我回复的几条评论
//
//                    }
//                    4 -> {//有评论，也展开了
//
//                    }
//                }

                val replySize = comment.replyCounts

                val mRecyclerView = replyRecyclerViews[comment.id]
                if (mRecyclerView == null || mRecyclerView.adapter == null) {//还没有展开，直接加载数据
                    //2，当有缓存数据时，优先加载缓存数据
                    if (comment.replyComments.size > 0) {
                        //bug:这里直接对comment.replyComments进行subList方法，会导致多次操作后，原始comment的replyComments进行叠加
                        //这里只对同样数据的新list做处理，不涉及原始对象
                        val replyList = comment.replyComments.toMutableList()
                        val currentPageList = replyList.subList(0, 3)
                        val recyclerView = RecyclerView(mContext)
                        recyclerView.layoutParams =
                            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
                        replyLayout.addView(recyclerView)
                        recyclerView.run {
                            layoutManager = LinearLayoutManager(mContext)
                            isNestedScrollingEnabled = false
                            adapter = ShortReplyCommentAdapter(currentPageList, object :
                                ShortReplyCommentAdapter.ReplyItemClickListener {
                                override fun reply(commentUser: CommentAndUser) {
                                    val curPos = comparePosition(position, commentUser.comment)
                                    Log.e("1mean", "item click position: $position")
                                    listener.showInputToReply(commentUser, curPos, false)
                                }
                            })
                        }
                        replyRecyclerViews[comment.id] = recyclerView
                        recyclerView.post {
                            if (recyclerView.adapter!!.itemCount == comment.replyCounts) {
                                comments.text = "收起"
                                arrows.setImageResource(R.mipmap.img_short_comment_up)
                            } else {
                                comments.text = "展开更多回复"
                                arrows.setImageResource(R.mipmap.img_short_comment_down)
                            }
                        }
                        data[position].comment.state = 4
                    } else {
                        val curPos = comparePosition(position, comment)
                        //3，缓存数据加载完成了后，从网络加载数据
                        listener.loadMore(
                            curPos,
                            0,
                            3,
                            comment.videoCode,
                            comment.id
                        )
                        replyLoadingView.visibility = View.VISIBLE
                    }
                } else {//缓存里有该RecyclerView，并且adapter不为null，就一定有数据正在界面展示
                    val mAdapter = mRecyclerView.adapter
                    val visibleSize = mAdapter?.itemCount ?: 0
                    if (visibleSize == replySize) {//评论已全部展示，点击收起
                        Log.e("1mean", "replyRecyclerView.adapter=null")
                        mRecyclerView.adapter = null
                        replyRecyclerViews[comment.id] = mRecyclerView
                        replyLayout.visibility = View.GONE
                        comments.text = "展开$replySize 条回复"
                        arrows.setImageResource(R.mipmap.img_short_comment_down)
                        comment.state = 2
                        comment.newReplyCounts = 0 //涉及到下次startIndex的计算会出问题，必须重制
                        return@setOnClickListener
                    }
                    //1,计算出需要获取的数据
                    var startIndex: Int
                    val pageCounts: Int
                    if (visibleSize == 0) {
                        startIndex = 0
                        pageCounts = if (replySize < 3) replySize else 3
                    } else {
                        startIndex = visibleSize - comment.newReplyCounts
                        val inVisibleSize = replySize - visibleSize
                        pageCounts = if (startIndex >= 3) {
                            if (inVisibleSize < 10) inVisibleSize else 10
                        } else {
                            if (inVisibleSize < 3) inVisibleSize else 3
                        }
                    }

                    //2，当有缓存数据时，优先加载缓存数据
                    if (comment.replyComments.size > 0 && comment.replyComments.size > visibleSize) {
                        //bug:这里直接对comment.replyComments进行subList方法，会导致多次操作后，原始comment的replyComments进行叠加
                        //这里只对同样数据的新list做处理，不涉及原始对象
                        startIndex = visibleSize
                        val replyList = comment.replyComments.toMutableList()
                        val currentPageList = replyList.subList(startIndex, startIndex + pageCounts)
                        (mAdapter as ShortReplyCommentAdapter).loadMore(currentPageList)
                        mRecyclerView.post {
                            if (mRecyclerView.adapter!!.itemCount == comment.replyCounts) {
                                comments.text = "收起"
                                arrows.setImageResource(R.mipmap.img_short_comment_up)
                            } else {
                                comments.text = "展开更多回复"
                                arrows.setImageResource(R.mipmap.img_short_comment_down)
                            }
                        }
                        data[position].comment.state = 4
                    } else {
                        val curPos = comparePosition(position, comment)
                        //3，缓存数据加载完成了后，从网络加载数据
                        listener.loadMore(
                            curPos,
                            startIndex,
                            pageCounts,
                            comment.videoCode,
                            comment.id
                        )
                        replyLoadingView.visibility = View.VISIBLE
                    }
                }
            }

            reply.setOnClickListener {
                val curPos = comparePosition(position, comment)
                Log.e("1mean", "item click position: $position")
                listener.showInputToReply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.id,
                        user.userCode,
                        user.userName!!,
                        2
                    ), curPos, false
                )
            }

            //避免使用itemview的点击，导致点击空余地方也会触发item的渐变和点击效果
            itemContentView.setOnClickListener {
                val curPos = comparePosition(position, comment)
                Log.e("1mean", "item click position: $position")
                listener.showInputToReply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.id,
                        user.userCode,
                        user.userName!!,
                        2
                    ), curPos, false
                )
            }
        }

        private fun initWedget(comment: VideoComment, user: User) {
            loadImage(mContext, user.headUrl!!, header)

            if (user.ipAddress != null) {
                address.text = StringBuilder(" · ").append(user.ipAddress).toString()
            } else {
                val addressString = AppInfos.provinces.random()
                address.text = StringBuilder(" · ").append(addressString).toString()
            }

            name.text = user.userName
            val spannableStringBuilder = QqEmoticons.parseAndShowEmotion(mContext, comment.content)
            content.text = spannableStringBuilder
            time.text = TimeUtils.descriptiveData(comment.commitTime)

            if (comment.likeNum == 0) {
                likes.visibility = View.GONE
            } else {
                likes.visibility = View.VISIBLE
                likes.text = comment.likeNum.toString()
            }

            if (!comment.like) {
                likeView.setImageResource(R.mipmap.img_item_comment_like)
                likes.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.color_txt_right_comment_item_like
                    )
                )
            } else {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.color_txt_right_comment_item_liked
                    )
                )
            }

            likeLayout.setOnClickListener {
                likeView.post {
                    addScaleAnimation(likeView, 1.3f)
                }
                if (comment.like) {
                    likeView.setImageResource(R.mipmap.img_item_comment_like)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color_txt_right_comment_item_like
                        )
                    )
                    comment.likeNum -= 1
                    likes.text = comment.likeNum.toString()
                    if (comment.likeNum == 0) {
                        likes.visibility = View.GONE
                    }
                } else {
                    likeView.setImageResource(R.mipmap.img_item_comment_liked)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color_txt_right_comment_item_liked
                        )
                    )
                    comment.likeNum += 1
                    likes.visibility = View.VISIBLE
                    likes.text = comment.likeNum.toString()
                }
                comment.like = !comment.like
                listener.updateComment(comment)
            }
        }

        fun convertCommentAndUser(
            videoCode: Int,
            topCommentId: Int,
            toUserCode: Int,
            toUserName: String,
            type: Int
        ): CommentAndUser {

            val comment = VideoComment(
                videoCode = videoCode,
                topCommentId = topCommentId,
                toUserCode = toUserCode,
                toUserName = toUserName,
                type = type,
                fromUserCode = AppInfos.AUTHOR_ID,
                fromUserName = AppInfos.AUTHOR_NAME
            )
            val user = User(
                userCode = AppInfos.AUTHOR_ID,
                userName = AppInfos.AUTHOR_NAME,
                headUrl = AppInfos.HEAD_URL,
                ipAddress = "湖北"
            )
            return CommentAndUser(comment, user)
        }

        /**
         * 添加了一个新消息后，当面界面位置会发生改变，刷新几次后就会好
         */
        private fun comparePosition(position: Int, currentComment: VideoComment): Int {

            Log.e("1mean", "comparePosition position: $position")
            val commentInList = data[position].comment
            Log.e("1mean", "commentInList: $commentInList")
            Log.e("1mean", "currentComment: $currentComment")
            if (commentInList == currentComment || commentInList.id == currentComment.topCommentId) {
                return position
            } else {
                data.forEachIndexed { index, commentAndUser ->
                    if (commentAndUser.comment.id == currentComment.topCommentId) {
                        return index
                    }
                }
            }
            return -1
        }
    }
}