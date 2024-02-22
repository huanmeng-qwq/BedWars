package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.game.GameId
import me.huanmeng.bedwars.platform.Platform

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Event {
    val platform: Platform
    val gameId: GameId
}