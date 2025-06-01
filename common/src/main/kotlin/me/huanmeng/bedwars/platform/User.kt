package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.WorldPos
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import java.util.*

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface User : PlatformScope {
    override val platform: Platform<*>
    val name: String
    val uuid: UUID
    val audience: Audience
    fun getDisplayName(view: User): String
    fun sendMessage(message: String) {
        sendMessage(LegacyComponentSerializer.legacySection().deserialize(message))
    }

    fun sendMessage(messages: Component) {
        audience.sendMessage(messages)
    }

    fun teleport(pos: WorldPos)
}