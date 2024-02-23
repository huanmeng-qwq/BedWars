package me.huanmeng.bedwars.platform

import org.bukkit.World

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitWorld(override val platform: Platform<*>, val world: World, override val name: String) : GameWorld {
}