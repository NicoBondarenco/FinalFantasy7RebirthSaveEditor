package ffviirse.domain.attribute.expression

import com.sun.javafx.binding.StringFormatter
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.ObjectExpression
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableObjectValue

interface BaseExpression<T, V : ObservableObjectValue<T>> : ObservableObjectValue<T> {

    override fun getValue(): T = this.get()

    fun isEqualTo(observable: V): BooleanBinding {
        return Bindings.equal(this, observable)
    }

    fun isNotEqualTo(observable: V): BooleanBinding {
        return Bindings.notEqual(this, observable)
    }

    fun asString(): StringBinding {
        return StringFormatter.convert(this) as StringBinding
    }

    fun asObject(): ObjectExpression<T> {
        return object : ObjectBinding<T>() {
            init {
                this.bind(this)
            }

            override fun dispose() {
                this.unbind(this)
            }

            override fun computeValue(): T {
                return this.value
            }
        }
    }

}
