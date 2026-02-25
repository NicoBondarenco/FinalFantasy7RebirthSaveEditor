package ffviirse.domain.attribute.readonly.property

import ffviirse.domain.attribute.readonly.base.ReadOnlyPropertyBase
import com.sun.javafx.binding.ExpressionHelper
import javafx.beans.InvalidationListener
import javafx.beans.WeakInvalidationListener
import javafx.beans.property.ReadOnlyProperty
import javafx.beans.value.ObservableObjectValue

abstract class SimpleReadOnlyProperty<T, V : ObservableObjectValue<T>>(
    protected val property: ReadOnlyProperty<T>,
) : ReadOnlyPropertyBase<T, V> {

    override var helper: ExpressionHelper<T>? = null
    protected var valid: Boolean = true

    protected val listener = InvalidationListener {
        valid.takeIf { it }?.apply {
            valid = false
            fireValueChangedEvent()
        }
    }

    init {
        property.addListener(WeakInvalidationListener(listener))
    }

    override fun get(): T = property.value.apply {
        valid = true
    }

    override fun getBean(): Any? = null

    override fun getName(): String = property.name

    override fun toString(): String = toText()

}
