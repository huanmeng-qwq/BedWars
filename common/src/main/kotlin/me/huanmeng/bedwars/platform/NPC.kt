package me.huanmeng.bedwars.platform

import net.kyori.adventure.text.Component

/**
 * 2024/3/10<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface NPC : PlatformScope {
    override val platform: Platform<*>

    fun line(line: Int, text: Component?)

    fun addUser(user: User)
    fun removeUser(user: User)
}