/**
 * @description: TODO
 * @author: dongyiming
 * @date: 11/16/21 2:16 PM
 * @version: v1.0
 */
interface CrashCallback {

    fun handleCrashResult(throwable: Throwable, map: Map<String, String>)
}