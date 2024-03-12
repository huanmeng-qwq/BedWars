package me.huanmeng.bedwars.event

import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.util.Identifier
import net.kyori.event.EventBus
import net.kyori.event.SimpleEventBus
import net.kyori.event.method.MethodSubscriptionAdapter
import net.kyori.event.method.SimpleMethodSubscriptionAdapter
import net.kyori.event.method.asm.ASMEventExecutorFactory

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class SimpleEventManager(
    override val platform: Platform<*>
) : EventManager {
    private val eventBus: EventBus<Event> = SimpleEventBus(Event::class.java)
    private val methodSubscription: MethodSubscriptionAdapter<Listener> = SimpleMethodSubscriptionAdapter(
        eventBus,
        ASMEventExecutorFactory(platform.classLoader),
        MethodScannerImpl
    )
    private val listenerMap: MutableMap<Identifier, Listener> = hashMapOf()

    override fun <T : Event> callEvent(event: T): T {
        eventBus.post(event).apply {
            if (!wasSuccessful()) {
                platform.logger.error("An error occurred while processing some listening events")
                exceptions().forEach { (eventSubscription, exception) ->
                    platform.logger.error("{}", eventSubscription.genericType(), exception)
                }
            }
        }
        return event
    }

    override fun registerListener(identifier: Identifier, listener: Listener): Identifier {
        if (listenerMap.containsKey(identifier)) {
            throw IllegalStateException("Listener already registered: $identifier")
        }
        methodSubscription.register(listener)
        listenerMap[identifier] = listener
        return identifier
    }

    override fun unregisterListener(identifier: Identifier) {
        if (!listenerMap.containsKey(identifier)) {
            throw IllegalStateException("Listener not registered: $identifier")
        }
        methodSubscription.unregister(listenerMap[identifier]!!)
        listenerMap.remove(identifier)
    }
}