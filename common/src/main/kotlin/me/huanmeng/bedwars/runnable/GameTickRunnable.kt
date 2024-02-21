package me.huanmeng.bedwars.runnable

import me.huanmeng.bedwars.game.Game

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class GameTickRunnable(private val game: Game) : Runnable {
    var tick: Long = 0
    override fun run() {
        try {
            game.onTick(tick)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        ++tick
    }
}