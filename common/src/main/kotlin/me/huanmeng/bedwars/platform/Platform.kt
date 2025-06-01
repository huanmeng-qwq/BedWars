package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.event.Event
import me.huanmeng.bedwars.event.EventManager
import me.huanmeng.bedwars.util.WorldPos
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import org.slf4j.Logger

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Platform<USER> {
    fun createSideBar(): Sidebar

    fun createNPC(pos: WorldPos): NPC

    val logger: ComponentLogger
    val classLoader: ClassLoader
    val eventManager: EventManager

    fun getUser(user: USER): User
}


interface PlatformScope {
    val platform: Platform<*>
}

fun <T : Event> PlatformScope.callEvent(event: T): T {
    return platform.eventManager.call(event)
}
