import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.viewmodel.MoreDataViewModel
import com.example.pandas.databinding.FragmentMusicListBinding
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView2

/**
 * @description: MusicListFragment
 * @author: dongyiming
 * @date: 3/2/22 5:01 下午
 * @version: v1.0
 */
public class MusicListFragment : BaseFragment<MoreDataViewModel, FragmentMusicListBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: MusicListAdapter by lazy { MusicListAdapter(mutableListOf()) }
    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerMusicList.apply {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@MusicListFragment)
        }
    }

    override fun createObserver() {

        mViewModel.musicResult.observe(viewLifecycleOwner) {
            if (it.isSuccess && !it.isEmpty) {
                if (it.isRefresh) {
                    initBottomMenu(it.listData[0])
                    mAdapter.refreshAdapter(it.listData)
                    if (!it.hasMore) {
                        binding.recyclerMusicList.noMoreDataAndEmptyView()
                    }
                } else {
                    binding.recyclerMusicList.loadMoreFinished()
                    mAdapter.loadMore(it.listData)
                    if (!it.hasMore) {
                        binding.recyclerMusicList.noMoreDataAndEmptyView()
                    }
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getPageMusic()
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onLoadMore() {
        mViewModel.getPageMusic()
    }

    private fun initBottomMenu(music: MusicVo) {
        loadCircleImage(mActivity, music.cover!!, binding.imgMusicListCover)
        binding.txtMusicListSong.text = music.audioName
        binding.txtMusicListName.text = music.singerName

    }

}