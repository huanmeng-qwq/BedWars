package me.huanmeng.bedwars.game

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
abstract class Team<GAME>(val teamType: TeamType, val game: GAME) {
    var initialize: Boolean = false
    abstract fun initialize()

    abstract fun onTick(tick: Int)
}