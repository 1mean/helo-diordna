import com.example.pandas.app.LoginInfo

/**
 * @description: AppInstance
 * @author: dongyiming
 * @date: 8/16/23 2:07 AM
 * @version: v1.0
 */
public class AppInstance private constructor() {

    //companion object格式写法反编译后，是一个饿汉式，在线程调用时就已经创建了唯一的对象，天生就是线程完全
    //对属性进行by lazy，就变成懒汉式
    var isNightMode: Boolean = false //是否是黑夜模式
    var timerType: Int = 0//定时任务的计划 0/1/2
    var timerDeadTime:Long = 0

    companion object {
        val instance = AppHolder.holder
    }

    private object AppHolder {
        val holder = AppInstance()
    }
}