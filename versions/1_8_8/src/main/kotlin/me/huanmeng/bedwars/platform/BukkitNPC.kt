package me.huanmeng.bedwars.platform

import com.github.retrooper.packetevents.protocol.player.UserProfile
import io.github.retrooper.packetevents.util.SpigotReflectionUtil
import me.huanmeng.bedwars.util.WorldPos
import me.tofaa.entitylib.wrapper.WrapperPlayer
import net.kyori.adventure.text.Component
import java.util.*

/**
 * 2024/3/10<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitNPC(override val platform: BukkitPlatform, pos: WorldPos) : NPC {
    val npcUpstream: WrapperPlayer

    init {
        val profile = UserProfile(UUID.randomUUID(), "")
        npcUpstream = WrapperPlayer(profile, SpigotReflectionUtil.generateEntityId())
        npcUpstream.consumeMeta {
            it.isCustomNameVisible = false
        }
    }

    override fun line(line: Int, text: Component?) {
    }

    override fun addUser(user: User) {
        npcUpstream.addViewer(user.uuid)
    }

    override fun removeUser(user: User) {
        npcUpstream.removeViewer(user.uuid)
    }
}