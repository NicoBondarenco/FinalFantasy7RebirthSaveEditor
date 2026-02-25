package ffviirse.adapter.ui.model

import ffviirse.domain.extension.nullString

data class ComboBoxItemView<T>(
    val displayOrder: Int = 0,
    val displayName: String = nullString(),
    val itemValue: T? = null,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ComboBoxItemView<*>

        if (displayOrder != other.displayOrder) return false
        if (displayName != other.displayName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = displayOrder
        result = 31 * result + displayName.hashCode()
        return result
    }

    override fun toString(): String = displayName

}
