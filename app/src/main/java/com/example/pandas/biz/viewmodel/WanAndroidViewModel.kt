package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.manager.userRepository
import com.android.base.vm.BaseViewModel
import com.example.pandas.app.AppInfos.LOGIN_KEY
import com.example.pandas.app.AppInfos.PASSWORD_KEY
import com.example.pandas.app.AppInfos.USERNAME_KEY
import com.example.pandas.bean.*
import com.example.pandas.biz.http.invoker.wanAndroidInvoke
import com.example.pandas.utils.Preference
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @description: wan android
 * @author: dongyiming
 * @date: 8/15/24 3:26 PM
 * @version: v1.0
 */
public class WanAndroidViewModel : BaseViewModel() {

    private val _login: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val login = _login.asSharedFlow()
    private val _register: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val register = _register.asSharedFlow()
    private val _logout: MutableSharedFlow<LoginResponse> by lazy { MutableSharedFlow() }
    val logout = _logout.asSharedFlow()
    private val _wxarticles: MutableSharedFlow<WxarticleResponse> by lazy { MutableSharedFlow() }
    val wxarticles = _wxarticles.asSharedFlow()
    private val _pageArticles: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val pageArticles = _pageArticles.asSharedFlow()
    private val _homePageArticles: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val homePageArticles = _homePageArticles.asSharedFlow()
    private val _collectInnerArticle: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val collectInnerArticle = _collectInnerArticle.asSharedFlow()
    private val _removeCollectedArticle: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val removeCollectedArticle = _removeCollectedArticle.asSharedFlow()
    private val _collectOuterArticle: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val collectOuterArticle = _collectOuterArticle.asSharedFlow()
    private val _hotkey: MutableSharedFlow<HotKeyResponse> by lazy { MutableSharedFlow() }
    val hotkey = _hotkey.asSharedFlow()
    private val _pageSearch: MutableSharedFlow<WxPageArticleResponse> by lazy { MutableSharedFlow() }
    val pageSearch = _pageSearch.asSharedFlow()
    private val _coinFlow: MutableSharedFlow<CoinResponse> by lazy { MutableSharedFlow() }
    val coinFlow = _coinFlow.asSharedFlow()
    private val _coinHistoryFlow: MutableSharedFlow<CoinsResponse> by lazy { MutableSharedFlow() }
    val coinHistoryFlow = _coinHistoryFlow.asSharedFlow()


    fun login(userName: String, password: String) {
        viewModelScope.launch {
            wanAndroidInvoke.loginWanAndroid(userName, password).collect {
                if (it.errorCode == 0) {
                    var name: String by Preference(USERNAME_KEY, userName)
                    name = userName
                    var secret: String by Preference(PASSWORD_KEY, password)
                    secret = password
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = true
                } else {
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = false
                }
                _login.emit(it)
            }
        }
    }

    fun register(userName: String, password: String, repassowrd: String) {
        viewModelScope.launch {
            wanAndroidInvoke.registerWanAndroid(userName, password, repassowrd).collect {
                if (it.errorCode == 0) {
                    var name: String by Preference(USERNAME_KEY, userName)
                    name = userName
                    var secret: String by Preference(PASSWORD_KEY, password)
                    secret = password
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = true
                } else {
                    var isLogin: Boolean by Preference(LOGIN_KEY, false)
                    isLogin = false
                }
                _register.emit(it)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            wanAndroidInvoke.logOutWanAndroid().collect {
                Log.e("1mean", "logout thread:${Thread.currentThread().name}")
                _logout.emit(it)
            }
        }
    }

    fun insertUser(name: String, code: Int) {
        viewModelScope.launch {
            val user = User(userName = name, userCode = code, reservedString = "account")
            userRepository.insert(user)
        }
    }

    fun wxarticles() {
        viewModelScope.launch {
            wanAndroidInvoke.wxarticles().collect {
                _wxarticles.emit(it)
            }
        }
    }

    fun wxPageArticles(userId: Int, pageNo: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.wxPageArticles(userId, pageNo).collect {
                _pageArticles.emit(it)
            }
        }
    }

    fun homePageArticles(pageNo: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.homePageArticles(pageNo).collect {
                _homePageArticles.emit(it)
            }
        }
    }

    fun collectInnerArticle(id: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.collectInnerArticle(id).collect {
                _collectInnerArticle.emit(it)
            }
        }
    }

    fun removeCollectedArticle(id: Int, originId: Int) {
        viewModelScope.launch {
            wanAndroidInvoke.removeCollectedArticle(id, originId).collect {
                _removeCollectedArticle.emit(it)
            }
        }
    }

    fun collectOutsideArticle(title: String, author: String, link: String) {
        viewModelScope.launch {
            wanAndroidInvoke.collectOutsideArticle(title, author, link).collect {
                _collectOuterArticle.emit(it)
            }
        }
    }

    fun hotkey() {
        viewModelScope.launch {
            wanAndroidInvoke.hotkey().collect {
                _hotkey.emit(it)
            }
        }
    }

    fun pageSearch(page: Int, key: String) {
        viewModelScope.launch {
            wanAndroidInvoke.pageSearch(page, key).collect {
                _pageSearch.emit(it)
            }
        }
    }

    fun getCoin() {
        viewModelScope.launch {
            wanAndroidInvoke.getCoin().collect {
                _coinFlow.emit(it)
            }
        }
    }

    fun getCoinHistory(page:Int) {
        viewModelScope.launch {
            wanAndroidInvoke.getCoinHistory(page).collect {
                _coinHistoryFlow.emit(it)
            }
        }
    }
}