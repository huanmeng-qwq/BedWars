package me.huanmeng.bedwars.event.impl

import me.huanmeng.bedwars.event.Event
import net.kyori.event.EventSubscriber
import net.kyori.event.SimpleEventBus

/**
 * 2024/4/11<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class EventBusImpl(type: Class<Event>) : SimpleEventBus<Event>(type) {

    override fun shouldPost(event: Event, subscriber: EventSubscriber<*>): Boolean {
        if (super.shouldPost(event, subscriber)) {
            return true
        }
        if (!subscriber.consumeCancelledEvents() && this.eventCancelled(event)) {
            return false
        }
        return event.javaClass.genericSuperclass == subscriber.genericType()
    }
}