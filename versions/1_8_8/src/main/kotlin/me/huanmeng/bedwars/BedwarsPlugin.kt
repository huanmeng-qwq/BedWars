package me.huanmeng.bedwars

import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.plugin.java.JavaPlugin

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BedwarsPlugin : JavaPlugin() {
    @get:JvmName("scoreboardLibrary")
    val scoreboardLibrary: ScoreboardLibrary by lazy {
        ScoreboardLibrary.loadScoreboardLibrary(this)
    }

    override fun onEnable() {
        instance = this
        logger.info("Bedwars插件已加载")
    }

    override fun onDisable() {
        scoreboardLibrary.close()
    }

    companion object {
        private var instance: BedwarsPlugin? = null

        @JvmStatic
        fun getInstance(): BedwarsPlugin {
            return instance!!
        }
    }
}