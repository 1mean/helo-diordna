package com.example.pandas.ui.adapter

import androidx.fragment.app.Fragment
import com.example.pandas.ui.fragment.main.live.LiveFragment
import com.example.pandas.ui.fragment.main.pet.CutePetFragment
import com.example.pandas.ui.fragment.main.home.HomeFragment
import com.example.pandas.ui.fragment.main.eyepetozer.OtherFragment
import com.example.pandas.ui.fragment.main.mine.SelfFragment

/**
 * @description: 创建home界面的4个fragment
 * @author: dongyiming
 * @date: 2021/11/18 10:14 下午
 * @version: v1.0
 */
public class FragmentFactory {

    companion object instance {

        private const val PAGE_ONE = 0
        private const val PAGE_TWO = 1
        private const val PAGE_THREE = 2
        private const val PAGE_FOUR = 3
        private const val PAGE_FIVE = 4

        var fragments = HashMap<Int, Fragment>()

        fun buildFragment(page: Int): Fragment {

            var mFragment = fragments[page]

            if (mFragment == null) {
                when (page) {
                    PAGE_ONE -> mFragment = HomeFragment()
                    PAGE_TWO -> mFragment = LiveFragment()
                    PAGE_THREE -> mFragment = OtherFragment()
//                    PAGE_FOUR -> mFragment = FaceFragment()
                    PAGE_FOUR -> mFragment = CutePetFragment()
                    PAGE_FIVE -> mFragment = SelfFragment()
                }
                fragments[page] = mFragment!!
            }
            return mFragment
        }
    }
}