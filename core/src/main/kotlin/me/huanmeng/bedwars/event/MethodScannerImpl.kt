package me.huanmeng.bedwars.event

import net.kyori.event.method.MethodScanner
import java.lang.reflect.Method

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
object MethodScannerImpl : MethodScanner<Listener> {
    override fun shouldRegister(listener: Listener, method: Method): Boolean {
        return method.isAnnotationPresent(BedwarsEvent::class.java)
    }

    override fun postOrder(listener: Listener, method: Method): Int {
        return method.getAnnotation(BedwarsEvent::class.java).priority
    }

    override fun consumeCancelledEvents(listener: Listener, method: Method): Boolean {
        return false
    }
}