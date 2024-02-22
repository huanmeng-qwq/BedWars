package me.huanmeng.bedwars.game

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class UserScore(
    var kills: Int = 0,
    var deaths: Int = 0,
    var fKills: Int = 0,
    var win: Boolean = false,
)