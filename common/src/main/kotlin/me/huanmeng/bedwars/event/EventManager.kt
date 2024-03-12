package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.util.Identifier

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface EventManager {
    val platform: Platform<*>
    fun <T : Event> callEvent(event: T): T

    fun registerListener(identifier: Identifier, listener: Listener): Identifier

    fun unregisterListener(identifier: Identifier)

    operator fun set(identifier: Identifier, listener: Listener?) {
        if (listener == null) {
            unregisterListener(identifier)
            return
        }
        registerListener(identifier, listener)
    }
}