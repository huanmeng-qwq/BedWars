package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.game.GameId
import me.huanmeng.bedwars.platform.Platform
import net.kyori.event.Cancellable

/**
 * 2024/4/11<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
sealed class BedwarsGameStateEvents(override val platform: Platform<*>, override val gameId: GameId) : Event {
    class Pre(platform: Platform<*>, gameId: GameId) : BedwarsGameStateEvents(platform, gameId),
        Cancellable by CancelEvent() {
    }

    class Post(platform: Platform<*>, gameId: GameId) : BedwarsGameStateEvents(platform, gameId)
}

sealed class BedwarsGameEndEvent(override val platform: Platform<*>, override val gameId: GameId) : Event {
    class Pre(platform: Platform<*>, gameId: GameId) : BedwarsGameEndEvent(platform, gameId),
        Cancellable by CancelEvent() {
    }

    class Post(platform: Platform<*>, gameId: GameId) : BedwarsGameEndEvent(platform, gameId)
}
