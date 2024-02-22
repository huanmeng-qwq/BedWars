package me.huanmeng.bedwars.listener

import me.huanmeng.bedwars.game.Game
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class PlayerListener(private val game: Game) : Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
//        if (game.userJoin(e.player)) {
//            e.joinMessage = null
//        } else {
//            e.player.sendMessage("§c游戏加入失败")
//        }
    }
}