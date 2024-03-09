package me.huanmeng.bedwars.platform

import net.kyori.adventure.text.Component
import org.jetbrains.annotations.Range

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Sidebar {
    val platform: Platform<*>
    fun line(line: @Range(from = 0L, to = 14L) Int, text: Component?)
    fun title(title: Component)

    fun addUser(user: User)
    fun removeUser(user: User)
}