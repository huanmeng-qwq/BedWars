package me.huanmeng.bedwars.platform

import com.github.retrooper.packetevents.protocol.entity.data.EntityData
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes
import com.github.retrooper.packetevents.protocol.player.UserProfile
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata
import io.github.retrooper.packetevents.util.SpigotReflectionUtil
import me.huanmeng.bedwars.util.WorldPos
import net.kyori.adventure.text.Component
import java.util.*

/**
 * 2024/3/10<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BukkitNPC(override val platform: BukkitPlatform, pos: WorldPos) : NPC {
    val npcUpstream: NPCUpstream

    init {
        val profile = UserProfile(UUID.randomUUID(), "")
        npcUpstream = NPCUpstream(profile, SpigotReflectionUtil.generateEntityId())
        WrapperPlayServerEntityMetadata(npcUpstream.id, listOf(EntityData(3, EntityDataTypes.BOOLEAN, false)))
    }

    override fun line(line: Int, text: Component?) {
    }

    override fun addUser(user: User) {
    }

    override fun removeUser(user: User) {
    }
}