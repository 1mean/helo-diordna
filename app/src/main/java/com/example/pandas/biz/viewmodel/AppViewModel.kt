import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.base.viewmodel.UnPeekLiveData
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.utils.FileUtils
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

    val headerUpdate by lazy { UnPeekLiveData<Boolean>() }

    val nameUpdate by lazy { UnPeekLiveData<String>() }

    val sexUpdate by lazy { UnPeekLiveData<Int>() }

    val loginStatus by lazy { UnPeekLiveData<Int>() }


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