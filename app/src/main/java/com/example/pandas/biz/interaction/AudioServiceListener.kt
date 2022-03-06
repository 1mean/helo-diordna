/**
 * @description: TODO
 * @author: dongyiming
 * @date: 3/6/22 11:24 上午
 * @version: v1.0
 */
interface AudioServiceListener {

    fun getMusicDuration(duration: String, lDuration: Long)

    fun getCurrentPosition(position: String)

    fun getTimeBarPosition(position: Long, bufferedPosition: Long)

    fun playStateChanged(state: Int)
}