package me.huanmeng.bedwars.listener

import me.huanmeng.bedwars.BedwarsPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class PlayerListener : Listener {
    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        BedwarsPlugin.getInstance().platform.removeUser(e.player)
    }
}