package me.huanmeng.bedwars

import me.huanmeng.bedwars.listener.PlayerListener
import me.huanmeng.bedwars.platform.BukkitPlatform
import org.bukkit.plugin.java.JavaPlugin

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BedwarsPlugin : JavaPlugin() {
    val platform: BukkitPlatform = BukkitPlatform(this)
    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(PlayerListener(), this)
        logger.info("Bedwars插件已加载")
    }

    override fun onDisable() {
        platform.scoreboardLibrary.close()
    }

    companion object {
        private var instance: BedwarsPlugin? = null

        @JvmStatic
        fun getInstance(): BedwarsPlugin {
            return instance!!
        }
    }
}