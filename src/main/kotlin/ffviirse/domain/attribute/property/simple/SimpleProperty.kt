package ffviirse.domain.attribute.property.simple

import javafx.beans.property.ReadOnlyProperty

interface SimpleProperty<T> : ReadOnlyProperty<T> {

    val _bean: Any?
    val _name: String

    override fun getBean(): Any? = _bean

    override fun getName(): String = _name

}
