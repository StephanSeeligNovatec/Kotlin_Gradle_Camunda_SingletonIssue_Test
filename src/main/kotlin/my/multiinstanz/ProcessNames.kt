package my.multiinstanz

import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/** Process constants. */
object Process {
    const val P1_BASE = "P1_Process_Base"

    /** Activity IDs of [Process]. */
    object ActivityIds {
        const val CREATE_SHOPPING_LIST = "CreateShoppingList"
    }

    /** Variable names of the [Process]. */
    object Variables {
        /** List of names of all goods which are to be bought. */
        const val DURATION = "duration"
        const val WERT = "wert"
    }
}