import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.android.android_sqlite.PetManagerCoroutine
import com.android.base.utils.FileUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.android.base.vm.UnPeekLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * @description: AppViewModel
 * @author: dongyiming
 * @date: 6/21/23 1:27 AM
 * @version: v1.0
 */
public class AppViewModel : ViewModel() {

    //App主题颜色 中大型项目不推荐以这种方式改变主题颜色，比较繁琐耦合，且容易有遗漏某些控件没有设置主题色
    val appColorType by lazy { UnPeekLiveData<Int>() }

    val recommendType by lazy { UnPeekLiveData<Int>() }

    val recoArrangeType by lazy { UnPeekLiveData<Int>() }

    val headerUpdate by lazy { UnPeekLiveData<Boolean>() }

    val nameUpdate by lazy { UnPeekLiveData<String>() }

    val sexUpdate by lazy { UnPeekLiveData<Int>() }

    val loginStatus by lazy { UnPeekLiveData<Int>() }

    //安卓5.1后，规定AlarmManager时间间隔不得小于60秒，少于60秒的任务，使用timer，但是AlarmManager的稳定性不行，长时间使用
    //耗电和息屏放置会出现不准时，差距会有几分钟
    //Alarm 的方法 set() 在SDK_INT 19以前是精确的闹钟。19以后为了节能省电（减少系统唤醒和电池使用）
    //使用Alarm.set()和Alarm.setRepeating()已经不能保证精确性
    //19以后需要精确的闹钟就需要用到Alarm方法setWindow()和setExact()这两个方法了
    val timer by lazy { UnPeekLiveData<Int>() }

    fun startTimer(){


    }

    /**
     * 下载项目所有的封面图片到本地，防止远程项目被删除
     * DiskCacheStrategy.DATA： /data/user/0/com.example.hello_diordna/cache/image_manager_disk_cache/74a05aa0349bb3bb72622d1ca50e52882ba535458555fd9ff23993c4b98ef39a.0
     * 存储在专属外部存储空间：/storage/emulated/0/Android/data/com.example.hello_diordna/files/Download/landscape_40.jpg
     * 导出图片 adb pull /storage/emulated/0/Android/data/com.example.hello_diordna/files/Download /Users/dongyiming/Downloads/pandas
     * 导入视频位置 adb push /Users/dongyiming/Desktop/pet/pandas/hehua/videos/ /storage/emulated/0/Android/data/com.example.hello_diordna/files/videos/
     *
     * @date: 2/6/22 4:33 下午
     * @version: v1.0
     */
    var downloadIndex = 0
    fun downLoadVideoCovers(
        lifecycleOwner: LifecycleOwner,
        context: Context
    ) {

        lifecycleOwner.lifecycleScope.launch {

            val covers = PetManagerCoroutine.getAllPetCoverUrl() //获取视频封面
            Log.e("helo-download", "cover size: ${covers.size}")
            covers.forEach {

                withContext(Dispatchers.IO) {
                    val fileName = it.fileName
                    Glide.with(context).downloadOnly().load(it.cover)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .listener(object : RequestListener<File> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<File>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                            override fun onResourceReady(
                                resource: File?,
                                model: Any?,
                                target: Target<File>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                lifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
                                    downloadIndex++
                                    downLoad(context, fileName, resource)
                                }
                                //存储图片
                                return false
                            }

                        }).preload()
                }
            }
        }
    }

    fun downLoadUserCovers(
        lifecycleOwner: LifecycleOwner,
        context: Context
    ) {
        lifecycleOwner.lifecycleScope.launch {

            val covers = PetManagerCoroutine.getAllUserCovers() //获取用户头像
            Log.e("helo-download", "cover size: ${covers.size}")
            covers.forEach {

                withContext(Dispatchers.IO) {
                    val userCode = it.userCode
                    Glide.with(context).downloadOnly().load(it.headUrl)
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .listener(object : RequestListener<File> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<File>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                            override fun onResourceReady(
                                resource: File?,
                                model: Any?,
                                target: Target<File>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                lifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
                                    downloadIndex++
                                    withContext(Dispatchers.Default) {
                                        val fileDir =
                                            FileUtils.getExternalFileDirectory(
                                                context,
                                                Environment.DIRECTORY_DOWNLOADS
                                            )
                                        val newFile = File(fileDir, "/user/$userCode.jpg")
                                        FileUtils.copy(resource, newFile)
                                    }
                                }
                                //存储图片
                                return false
                            }

                        }).preload()
                }
            }
        }
    }

    suspend fun downLoad(context: Context, fileName: String, resource: File?) {
        withContext(Dispatchers.Default) {
            val fileDir =
                FileUtils.getExternalFileDirectory(
                    context,
                    Environment.DIRECTORY_DOWNLOADS
                )
            val newFile = File(fileDir, "$fileName.jpg")
            FileUtils.copy(resource, newFile)
            Log.e("helo-download", "downloadIndex:$downloadIndex")
        }
    }
}