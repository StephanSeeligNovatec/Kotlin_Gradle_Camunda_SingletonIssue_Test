package my.multiinstanz

import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/** Process constants. */
object Process {
    const val SIMPLE_MULTI = "Process_Multiinstanz"
    const val KOMPLEX_MULTI = "Process_Multiinstanz_Komplex"
    const val FILE_NAME = "process.bpmn"

    /** Activity IDs of [Process]. */
    object ActivityIds {
        const val CREATE_SHOPPING_LIST = "CreateShoppingList"
        const val PREPARE_MEANS_OF_PAYMENT = "PrepareMeansOfPayment"
        const val PREPARE_CART_DEPOSIT = "PrepareShoppingCartDeposit"
        const val PREPARE_SHOPPING_COMPLETED = "PrepareShoppingCompleted"
        const val TAKE_CART = "TakeShoppingCart"
        const val CHOOSE_GOODS = "ChooseGoods#multiInstanceBody"
        const val PAY_GOODS = "PayGoods"
        const val CREATE_NEW_SHOPPING_LIST = "CreateNewShoppingList"
        const val SHOPPING_COMPLETED = "PerformShoppingCompleted"
        const val COMPLETED = "ShoppingCompleted"
        const val PREPARATION_FAILED = "ShoppingPreparationFailure"
        const val SHOPPING_FAILED = "ShoppingFailed"
    }

    object ErrorCodes {
        const val ERROR_BAD_ITEM = "ERROR"
    }

    /** Variable names of the [Process]. */
    object Variables {
        /** List of names of all goods which are to be bought. */
        const val SHOPPING_LIST = "shoppingList"

        const val SHOPPING_ITEM = "shoppingItem"

        /** All [Variables]. */
        val ALL: List<String> =
            Variables::class.memberProperties.filter { it.isAccessible }.map { it.name }
    }
}