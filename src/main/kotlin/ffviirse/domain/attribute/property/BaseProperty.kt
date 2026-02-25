package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.readonly.BaseReadOnlyProperty
import ffviirse.domain.attribute.writable.WritablePropertyValue
import com.sun.javafx.binding.BidirectionalBinding
import javafx.beans.binding.Bindings
import javafx.beans.property.ObjectProperty
import javafx.beans.property.ObjectPropertyBase
import javafx.beans.property.Property
import javafx.beans.value.ObservableObjectValue

interface BaseProperty<T, V : ObservableObjectValue<T>> : BaseReadOnlyProperty<T, V>, WritablePropertyValue<T>, Property<T> {

    override fun getValue(): T = get()

    override fun setValue(value: T) = set(value)

    override fun bindBidirectional(var1: Property<T>) {
        Bindings.bindBidirectional(this, var1)
    }

    override fun unbindBidirectional(var1: Property<T>) {
        Bindings.unbindBidirectional(this, var1)
    }

    override fun asObject(): ObjectProperty<T> = object : ObjectPropertyBase<T>() {

        init {
            BidirectionalBinding.bind(this, this@BaseProperty)
        }

        override fun getBean(): Any? = null

        override fun getName(): String = this@BaseProperty.name

    }

}
