package ffviirse.domain.extension

import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.property.Property

fun <T> Property<T>.bindObject(
    vararg property: Observable,
    result: () -> T,
) = this.bind(Bindings.createObjectBinding({ result() }, *property))
