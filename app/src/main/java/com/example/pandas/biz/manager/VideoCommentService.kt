import com.example.pandas.biz.interaction.ICommentListener
import com.example.pandas.sql.entity.VideoComment

/**
 * @description: 处理评论相关的业务
 * @author: dongyiming
 * @date: 12/5/22 3:21 PM
 * @version: v1.0
 */
public class VideoCommentService : ICommentListener {

    override fun sendComment(comment: VideoComment): Boolean {


        return true
    }

    override fun deleteComment(comment: VideoComment): Boolean {
        return true
    }
}