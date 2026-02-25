package ffviirse.domain.attribute.binder

import ffviirse.domain.attribute.binding.BaseBinding
import com.sun.javafx.binding.BindingHelperObserver
import com.sun.javafx.binding.ExpressionHelper
import com.sun.javafx.collections.ImmutableObservableList
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList

abstract class BaseBinder<T, out R>(
    private val observableValue: ObservableValue<out R>,
    private val valueComputer: (R) -> T,
    private val observableValues: List<ObservableValue<*>>
) : BaseBinding<T> {

    override var bindingValue: T? = null
    override var valid: Boolean = false
    override var observer: BindingHelperObserver? = null
    override var helper: ExpressionHelper<T>? = null

    override fun get(): T = super.get()

    init {
        bind(observableValue)
    }

    override fun dispose() {
        unbind(observableValue)
    }

    override fun computeValue(): T = valueComputer(observableValue.value)

    override fun getDependencies(): ObservableList<*> = when (observableValues.size) {
        0 -> FXCollections.observableArrayList<T>()
        1 -> FXCollections.singletonObservableList(observableValues)
        else -> ImmutableObservableList(observableValues)
    }

    override fun toString(): String = description()

}
