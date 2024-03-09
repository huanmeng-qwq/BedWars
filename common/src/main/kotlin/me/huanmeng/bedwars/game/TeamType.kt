package me.huanmeng.bedwars.game

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
enum class TeamType(val color: TextColor,val key: String) {
    RED(NamedTextColor.RED, "red"),
    BLUE(NamedTextColor.BLUE, "blue"),
    YELLOW(NamedTextColor.YELLOW, "yellow"),
    GREEN(NamedTextColor.GREEN, "green"),

    AQUA(NamedTextColor.AQUA, "aqua"),
    PINK(NamedTextColor.LIGHT_PURPLE, "pink"),
    GRAY(NamedTextColor.GRAY, "gray"),
    WHITE(NamedTextColor.WHITE, "white"),
    ;
}