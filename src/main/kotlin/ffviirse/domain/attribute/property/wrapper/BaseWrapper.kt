package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binder.BaseBinder
import javafx.beans.value.ObservableValue

abstract class BaseWrapper<T>(
    protected val observable: ObservableValue<out T>
) : BaseBinder<T, T>(
    observableValue = observable,
    valueComputer = { observable.value },
    observableValues = listOf(observable)
) {

    init {
        bind(observable)
    }

    override fun computeValue(): T = observable.value

    override fun dispose() {
        unbind(observable)
    }

}

