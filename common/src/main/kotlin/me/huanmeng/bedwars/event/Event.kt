package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.game.GameId
import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.platform.PlatformScope
import net.kyori.event.Cancellable

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Event: PlatformScope {
    override val platform: Platform<*>
    val gameId: GameId
}

class CancelEvent : Cancellable {
    private var cancelled = false
    override fun cancelled(): Boolean {
        return cancelled
    }

    override fun cancelled(cancelled: Boolean) {
        this.cancelled = cancelled
    }

}