package ffviirse.domain.attribute.writable

import javafx.beans.value.WritableValue

interface WritablePropertyValue<T>: WritableValue<T> {

    fun get(): T

    fun set(value: T)

}
