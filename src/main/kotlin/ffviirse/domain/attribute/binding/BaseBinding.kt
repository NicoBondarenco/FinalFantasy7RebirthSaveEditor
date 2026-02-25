package ffviirse.domain.attribute.binding

import com.sun.javafx.binding.BindingHelperObserver
import com.sun.javafx.binding.ExpressionHelper
import javafx.beans.InvalidationListener
import javafx.beans.Observable
import javafx.beans.binding.Binding
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableObjectValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList

interface BaseBinding<T> : ObservableObjectValue<T>, Binding<T> {

    var bindingValue: T?
    var valid: Boolean
    var observer: BindingHelperObserver?
    var helper: ExpressionHelper<T>?

    override fun addListener(listener: InvalidationListener) {
        this.helper = ExpressionHelper.addListener(this.helper, this, listener)
    }

    override fun removeListener(listener: InvalidationListener) {
        this.helper = ExpressionHelper.removeListener(this.helper, listener)
    }

    override fun addListener(listener: ChangeListener<in T>) {
        this.helper = ExpressionHelper.addListener(this.helper, this, listener)
    }

    override fun removeListener(listener: ChangeListener<in T>) {
        this.helper = ExpressionHelper.removeListener(this.helper, listener)
    }

    fun bind(vararg observables: Observable) {
        if (observables.isNotEmpty()) {
            if (this.observer == null) {
                this.observer = BindingHelperObserver(this)
            }
            observables.forEach {
                it.addListener(this.observer)
            }
        }
    }

    fun unbind(vararg observables: Observable) {
        if (this.observer != null) {
            observables.forEach {
                it.removeListener(this.observer)
            }
        }
    }

    override fun dispose() {}

    override fun getDependencies(): ObservableList<*> {
        return FXCollections.emptyObservableList<Any>()
    }

    override fun get(): T {
        if (!this.valid) {
            this.bindingValue = this.computeValue()
            this.valid = true
        }

        return this.bindingValue ?: throw NullPointerException("${this::class.qualifiedName!!}.bindingValue is not initialized")
    }

    fun onInvalidating() {}

    override fun invalidate() {
        if (this.valid) {
            this.valid = false
            this.onInvalidating()
            ExpressionHelper.fireValueChangedEvent(this.helper)
        }
    }

    override fun isValid(): Boolean = this.valid

    fun computeValue(): T

    fun description(): String = ("value: ${this.get()}".takeIf { this.valid } ?: "invalid").let {
        "${this::class.simpleName} [${it}]"
    }

}
