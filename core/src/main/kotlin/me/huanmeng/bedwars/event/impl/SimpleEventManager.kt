package me.huanmeng.bedwars.event.impl

import me.huanmeng.bedwars.event.BedwarsEvent
import me.huanmeng.bedwars.event.Event
import me.huanmeng.bedwars.event.EventManager
import me.huanmeng.bedwars.event.Listener
import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.util.Identifier
import me.huanmeng.event.AbstractEventManager
import net.kyori.event.EventBus

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class SimpleEventManager(
    override val platform: Platform<*>
) : EventManager, AbstractEventManager<Event, Listener, BedwarsEvent>(
    Event::class.java,
    Listener::class.java,
    BedwarsEvent::class.java,
    platform.logger
) {
    override val eventBus: EventBus<Event> = EventBusImpl(eventClass)
    private val listenerMap: MutableMap<Identifier, Listener> = hashMapOf()

    override fun <T : Event> call(event: T): T {
        callEvent(event)
        return event
    }

    override fun registerListener(identifier: Identifier, listener: Listener): Identifier {
        if (listenerMap.containsKey(identifier)) {
            throw IllegalStateException("Listener already registered: $identifier")
        }
        register(listener)
        listenerMap[identifier] = listener
        return identifier
    }

    override fun unregisterListener(identifier: Identifier) {
        if (!listenerMap.containsKey(identifier)) {
            throw IllegalStateException("Listener not registered: $identifier")
        }
        unregister(listenerMap[identifier]!!)
        listenerMap.remove(identifier)
    }

    override fun onRegister(listener: Listener) {
        logger.debug("Registered listener: {}", listener)
    }

    override fun onUnregister(listener: Listener) {
        logger.debug("Unregistered listener: {}", listener)
    }
}