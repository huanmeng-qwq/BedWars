package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.WorldPos
import java.util.*

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface User {
    val platform: Platform<*>
    val name: String
    val uuid: UUID
    fun getDisplayName(view: User): String
    fun sendMessage(message: String)
    fun teleport(pos: WorldPos)
}