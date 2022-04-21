package com.example.pandas.ui.view
import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @description: TabEntity
 * @author: dongyiming
 * @date: 4/21/22 3:50 下午
 * @version: v1.0
 */
class TabEntity(var title: String) :
    CustomTabEntity {
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int = 0

    override fun getTabUnselectedIcon(): Int = 0
}