package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.WorldPos
import net.kyori.adventure.text.Component

/**
 * 2024/3/10<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface NPC {
    val platform: Platform<*>

    fun line(line: Int, text: Component?)

    fun addUser(user: User)
    fun removeUser(user: User)
}