package me.huanmeng.bedwars.event

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Listener

@Retention
@Target(AnnotationTarget.FUNCTION)
annotation class BedwarsEvent(
    /**
     * 0 -> 1
     */
    val priority: Int = 0
)