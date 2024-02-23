package me.huanmeng.bedwars.platform

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitSidebar(
    override val platform: Platform<Player>,
    val libSideBar: net.megavex.scoreboardlibrary.api.sidebar.Sidebar
) : Sidebar {

    override fun line(line: Int, text: Component?) {
        libSideBar.line(line, text)
    }

    override fun title(title: Component) {
        libSideBar.title(title)
    }

    override fun addUser(user: User) {
        libSideBar.addPlayer(user.player)
    }

    override fun removeUser(user: User) {
        libSideBar.addPlayer(user.player)
    }
}