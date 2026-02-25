package ffviirse.domain.attribute.readonly

import ffviirse.domain.attribute.expression.BaseExpression
import javafx.beans.InvalidationListener
import javafx.beans.WeakInvalidationListener
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectPropertyBase
import javafx.beans.property.ReadOnlyProperty
import javafx.beans.value.ObservableObjectValue

interface BaseReadOnlyProperty<T, V : ObservableObjectValue<T>> : BaseExpression<T, V>, ReadOnlyProperty<T> {

    fun toText(): String = listOfNotNull(
        bean?.let { "bean: $it" },
        name?.let { "name: $it" },
        "value: $value",
    ).joinToString(", ").let {
        "${this::class.simpleName} [$it]"
    }

    override fun asObject(): ReadOnlyObjectProperty<T> {
        return object : ReadOnlyObjectPropertyBase<T>() {
            private var valid = true

            private val listener = InvalidationListener {
                valid.takeIf { it }?.apply {
                    valid = false
                    fireValueChangedEvent()
                }
            }

            init {
                addListener(WeakInvalidationListener(this.listener))
            }

            override fun getBean(): Any? = null

            override fun getName(): String = this@BaseReadOnlyProperty.name

            override fun get(): T = value.apply { valid = true }

        }
    }

}
