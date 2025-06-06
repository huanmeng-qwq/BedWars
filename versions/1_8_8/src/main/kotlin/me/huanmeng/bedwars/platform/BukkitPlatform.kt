package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.event.EventManager
import me.huanmeng.bedwars.event.impl.SimpleEventManager
import me.huanmeng.bedwars.util.WorldPos
import net.kyori.adventure.platform.bukkit.BukkitAudiences
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitPlatform(plugin: Plugin) : Platform<Player> {
    @get:JvmName("scoreboardLibrary")
    val scoreboardLibrary: ScoreboardLibrary = ScoreboardLibrary.loadScoreboardLibrary(plugin)

    val audiences = BukkitAudiences.create(plugin)

    private val userMap: MutableMap<Player, User> = hashMapOf()

    override fun createSideBar(): Sidebar {
        return BukkitSidebar(this, scoreboardLibrary.createSidebar())
    }

    override fun createNPC(pos: WorldPos): NPC {
        return BukkitNPC(this, pos)
    }

    override val logger: ComponentLogger = ComponentLogger.logger("BedWars")
    override val classLoader: ClassLoader = plugin.javaClass.classLoader
    override val eventManager: EventManager = SimpleEventManager(this)

    override fun getUser(user: Player): User {
        return userMap.getOrPut(user) {
            BukkitUser(this, user, user.name, audiences.player(user))
        }
    }

    fun removeUser(player: Player) {
        userMap.remove(player)
    }
}

val WorldPos.bukkit: Location
    get() {
        return Location((this.world as BukkitWorld).world, this.x, this.y, this.z)
    }

val User.player: Player
    get() = (this as BukkitUser).player