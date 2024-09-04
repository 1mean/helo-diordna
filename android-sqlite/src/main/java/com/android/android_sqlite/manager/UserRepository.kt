package com.android.android_sqlite.manager

import androidx.room.Index
import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.dao.UserDao
import com.android.android_sqlite.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * @description: 处理User表相关的数据库操作
 * @author: dongyiming
 * @date: 8/18/24 5:21 PM
 * @version: v1.0
 */
val userRepository: UserRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { UserRepository() }

public class UserRepository : BaseRepository() {

    private val userDao: UserDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().userDao()
    }

    /**
     * Bug:
     *   在viewmodel里调用方法时，collect{}直接报错，对比Retrofit和Room使用collect的区别
     *     - wanAndroidInvoke.logOutWanAndroid().collect{...}
     *        - 使用的kotlin-coroutines-core-jvm-1.6.2里的方法
     *        - 注释里有方法使用介绍：myFlow.collect { value -> println("Collected $value") }
     *     - userRepository.insert(user).collect{...}
     *        - 使用的是kotlin-coroutines-core-jvm-1.5.2里的方法
     *        - 通过注释，添加map{},使用userRepository.insert(user).map {  }.collect{}没有报错
     *
     *   改正：升级Room到最新版本，包含的是kotlin-coroutines-core-jvm-1.7.1，能直接使用collect{...}
     *
     */
    fun getUserByCode(userCode: Int): Flow<User?> = flowIn(userDao.getUserByCode(userCode))

    /**
     * 默认reservedString="account"的为登录用户，用于区分普通用户
     */
    fun getLoginUser(reservedString: String = "account"): Flow<User> =
        flowIn(userDao.getLoginUser(reservedString))

    suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    suspend fun insert(users: MutableList<User>) {
        withContext(Dispatchers.IO) {
            userDao.insert(users)
        }
    }

    suspend fun delete(user: User) {
        withContext(Dispatchers.IO) {
            userDao.delete(user)
        }
    }

    suspend fun updateUser(newUser: User): User {
        return withContext(Dispatchers.IO) {
            val user = userDao.queryUserByCode(newUser.userCode)
            if (user != null) {
                newUser.id = user.id
                userDao.update(newUser)
            }
            userDao.queryUserByCode(newUser.userCode)
        }
    }

    suspend fun update(user: User) {
        withContext(Dispatchers.IO) {
            userDao.update(user)
        }
    }

    fun getAll(): Flow<MutableList<User>> = flowIn(userDao.getAll())

    fun queryLiveAttentionUsers(): Flow<MutableList<User>> =
        flowIn(userDao.queryLiveAttentionUsers())

    fun queryAllAttentionUsers(): Flow<MutableList<User>> =
        flowIn(userDao.queryAllAttentionUsers())

    fun queryAllAttentionCounts(): Flow<Int> =
        flowIn(userDao.queryAllAttentionCounts())

    fun queryLiveAttentionUserCodes(): Flow<MutableList<Int>> =
        flowIn(userDao.queryLiveAttentionUserCodes())

    suspend fun reName(newName: String) {
        flowIn(userDao.getLoginUser("account")).collect { user ->
            if (user != null) {
                user.userName = newName
                userDao.update(user)
            }
        }
    }

    suspend fun reSign(newSign: String) {
        flowIn(userDao.getLoginUser("account"))
            .collect { user ->
                if (user != null) {
                    user.signature = newSign
                    userDao.update(user)
                }
            }
    }

    suspend fun reSex(newSex: Int) {
        flowIn(userDao.getLoginUser("account"))
            .collect { user ->
                if (user != null) {
                    user.sex = newSex
                    userDao.update(user)
                }
            }
    }

    suspend fun getUser(userCode: Int): User {
        return withContext(Dispatchers.IO) {
            userDao.queryUserByCode(userCode)
        }
    }

    suspend fun updateAttention(userCode: Int) {
        withContext(Dispatchers.IO) {
            val user = userDao.queryUserByCode(userCode)
            user.attention = !user.attention
            userDao.update(user)
        }
    }

    suspend fun attention(isFollow: Boolean, userCode: Int): Int {
        return withContext(Dispatchers.IO) {
            val user = userDao.queryUserByCode(userCode)
            user.attention = isFollow
            userDao.update(user)
        }
    }

    fun attention1(isFollow: Boolean, userCode: Int): Flow<Int> = flow {
        val user = userDao.queryUserByCode(userCode)
        user.attention = isFollow
        emit(userDao.update(user))
    }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO)

    fun getAllFollowUsers(): Flow<MutableList<User>> = flowInDelay(userDao.queryAllAttentionUsers())
    fun getAllFollowCounts(): Flow<Int> = flowIn(userDao.queryAllAttentionCounts())

    suspend fun getLikedUser1(key: String, startIndex: Int, pageCount: Int): MutableList<User> {
        return withContext(Dispatchers.IO) {
            delay(500L)
            userDao.getLikedPageUser(key, startIndex, pageCount)
        }
    }

    fun getLikedUser(key: String, startIndex: Int, pageCount: Int): Flow<MutableList<User>> =
        flowIn(userDao.queryLikedPageUser(key, startIndex, pageCount))
}