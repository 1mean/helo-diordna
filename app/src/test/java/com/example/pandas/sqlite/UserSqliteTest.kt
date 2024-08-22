import com.android.android_sqlite.manager.userRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * @description: user sqlite test
 * @author: dongyiming
 * @date: 8/18/24 7:07 PM
 * @version: v1.0
 */
public class UserSqliteTest {

    /**
     * Error:这种直接测试会报错，因为sqlite模块的context没有初始化，database里context为null
     */
    @Test
    fun getLoginUser() = runBlocking<Unit> {
        userRepository.getLoginUser("account").collect {
            println("userName=${it.userName}")
            println("userCode=${it.userCode}")
            println("sex=${it.sex}")
            println("signature=${it.signature}")
            println("reservedString=${it.reservedString}")
        }
    }

}