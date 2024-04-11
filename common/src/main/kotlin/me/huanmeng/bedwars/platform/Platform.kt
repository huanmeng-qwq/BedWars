package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.event.EventManager
import me.huanmeng.bedwars.util.WorldPos
import org.slf4j.Logger

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Platform<USER> {
    fun createSideBar(): Sidebar

    fun createNPC(pos: WorldPos): NPC

    val logger: Logger
    val classLoader: ClassLoader
    val eventManager: EventManager

    fun getUser(user: USER): User
}