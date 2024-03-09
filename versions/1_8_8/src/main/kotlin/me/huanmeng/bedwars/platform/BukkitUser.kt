package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.WorldPos
import org.bukkit.entity.Player
import java.util.*

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitUser(override val platform: Platform<Player>, val player: Player, override val name: String) : User {
    override val uuid: UUID = player.uniqueId
    override fun getDisplayName(view: User): String {
        return player.displayName
    }

    override fun sendMessage(message: String) {
        player.sendMessage(message)
    }

    override fun teleport(pos: WorldPos) {
        player.teleport(pos.bukkit)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BukkitUser) return false

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }
}
