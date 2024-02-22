package me.huanmeng.bedwars.platform

import org.slf4j.Logger

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface Platform {
    val logger: Logger
    val classLoader: ClassLoader
}