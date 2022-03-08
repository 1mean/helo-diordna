import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.interaction.OnItemClickListener

/**
 * @description: 缓存文件夹分类
 * @author: dongyiming
 * @date: 3/8/22 4:55 下午
 * @version: v1.0
 */
public class CacheListAdapter(
    private val list: MutableList<PetViewData>,
    private val listener: OnItemClickListener<String>
) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_cache_list

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {

        val context = holder.itemView.context
        val fileNameStr = context.getString(R.string.str_file_name)
        val descStr = context.getString(R.string.str_desc)
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cache_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_cache_item_name)
        val fileName = holder.getWidget<AppCompatTextView>(R.id.txt_cache_file_name)
        val desc = holder.getWidget<AppCompatTextView>(R.id.txt_cache_desc)

        loadRoundedCornerImage(context, 10, data.cover, cover)
        title.text = titleName.getValue(data.title)
        fileName.text = StringBuilder(fileNameStr).append(data.title)
        desc.text = StringBuilder(descStr).append(descMap.getValue(data.title))

        holder.itemView.setOnClickListener {
            listener.onClick(position, data.title)
        }

    }

    private val titleName = mapOf(
        "music" to "音乐视频",
        "all" to "大熊猫成长记录",
        "baby" to "大熊猫宝宝",
        "bear" to "北极熊",
        "beauty" to "美人如玉",
        "bird" to "中国最美的鸟",
        "fox" to "白狐",
        "knowledge" to "大熊猫百科",
        "landscape" to "中国山水记",
        "monkey" to "川金丝猴",
        "penguin" to "企鹅",
        "red_panda" to "小熊猫(红熊猫)",
        "single" to "独居大熊猫",
        "group" to "幼年大熊猫",
        "mom" to "大熊猫妈妈",
        "cat" to "喵喵喵"
    )

    val descMap = mapOf(
        "music" to "成长阶段陪伴的音乐",
        "all" to "每一届大熊猫成长的记录",
        "baby" to "大熊猫宝宝，最可爱",
        "bear" to "极其濒危的可爱动物",
        "beauty" to "美人如玉隔云端",
        "bird" to "丹顶鹤、红腹锦鸡...",
        "fox" to "美人为什么叫狐狸精？",
        "knowledge" to "关于大熊猫的百科知识",
        "landscape" to "中国最美山水",
        "monkey" to "国家一级保护动物，濒危",
        "penguin" to "生活在南极",
        "red_panda" to "大熊猫的弟弟小熊猫",
        "single" to "独居、成年大熊猫",
        "group" to "和同级小伙伴生活在一起",
        "mom" to "妈妈会陪伴宝宝到一岁半",
        "cat" to "单身居家好伴侣"
    )
}