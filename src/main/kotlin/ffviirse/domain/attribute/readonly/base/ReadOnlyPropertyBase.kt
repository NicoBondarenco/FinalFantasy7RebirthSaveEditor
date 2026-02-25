package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.readonly.BaseReadOnlyProperty
import com.sun.javafx.binding.ExpressionHelper
import javafx.beans.InvalidationListener
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableObjectValue

interface ReadOnlyPropertyBase<T, V : ObservableObjectValue<T>>: BaseReadOnlyProperty<T, V> {

    var helper: ExpressionHelper<T>?

    override fun addListener(var1: InvalidationListener) {
        this.helper = ExpressionHelper.addListener(this.helper, this, var1)
    }

    override fun removeListener(var1: InvalidationListener) {
        this.helper = ExpressionHelper.removeListener(this.helper, var1)
    }

    override fun addListener(var1: ChangeListener<in T>) {
        this.helper = ExpressionHelper.addListener(this.helper, this, var1)
    }

    override fun removeListener(var1: ChangeListener<in T>) {
        this.helper = ExpressionHelper.removeListener(this.helper, var1)
    }

    fun fireValueChangedEvent() {
        ExpressionHelper.fireValueChangedEvent(this.helper)
    }

}
