package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.game.GameId
import me.huanmeng.bedwars.platform.Platform
import net.kyori.event.Cancellable

/**
 * 2024/4/11<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
sealed class BedwarsGameStartEvent(override val platform: Platform<*>, override val gameId: GameId) : Event {
    class Pre(platform: Platform<*>, gameId: GameId) : BedwarsGameStartEvent(platform, gameId),
        Cancellable by CancelEvent() {
    }

    class Post(platform: Platform<*>, gameId: GameId) : BedwarsGameStartEvent(platform, gameId)
}

