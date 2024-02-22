package me.huanmeng.bedwars.util

/**
 * 2024/2/21<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class Identifier(
    val namespace: String,
    val path: String,
) {
    override fun toString(): String {
        return "$namespace:$path"
    }

    companion object {
        fun of(identifier: String): Identifier {
            val index = identifier.indexOf(':')
            return if (index == -1) {
                Identifier("bedwars", identifier)
            } else {
                Identifier(identifier.substring(0, index), identifier.substring(index + 1))
            }
        }
    }
}

fun identifier(str: String): Identifier {
    return Identifier.of(str)
}

fun identifier(namespace: String = "bedwars", path: String): Identifier {
    return Identifier(namespace, path)
}