package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.WorldPos

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface User {
    val platform: Platform<*>
    val name: String
    fun getDisplayName(view: User): String
    fun sendMessage(message: String)
    fun teleport(pos: WorldPos)
}