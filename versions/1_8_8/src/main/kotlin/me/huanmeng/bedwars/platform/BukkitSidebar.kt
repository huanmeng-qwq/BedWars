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
    val upstream: SidebarUpstream
) : Sidebar {

    override fun line(line: Int, text: Component?) {
        upstream.line(line, text)
    }

    override fun title(title: Component) {
        upstream.title(title)
    }

    override fun addUser(user: User) {
        upstream.addPlayer(user.player)
    }

    override fun removeUser(user: User) {
        upstream.addPlayer(user.player)
    }
}
