package ffviirse.domain.attribute.property.base

import ffviirse.domain.attribute.property.BaseProperty
import ffviirse.domain.attribute.property.wrapper.BaseWrapper
import ffviirse.domain.extension.takeAs
import com.sun.javafx.binding.ExpressionHelper
import java.lang.ref.WeakReference
import javafx.beans.InvalidationListener
import javafx.beans.Observable
import javafx.beans.WeakListener
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableValue
import kotlin.reflect.KClass

abstract class PropertyBase<T, V : ObservableObjectValue<T>, W : BaseWrapper<T>>(
    protected var propertyValue: T,
    protected var klass: KClass<V>,
) : BaseProperty<T, V> {

    protected var observable: V? = null
    protected var listener: InvalidationListener? = null
    protected var valid = true
    protected var helper: ExpressionHelper<T>? = null

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

    protected open fun fireValueChangedEvent() {
        ExpressionHelper.fireValueChangedEvent(this.helper)
    }

    private fun markInvalid() {
        valid.takeIf { it }?.apply {
            valid = false
            invalidated()
            fireValueChangedEvent()
        }
    }

    protected open fun invalidated() {}

    override fun get(): T = (observable?.get() ?: propertyValue).apply {
        valid = true
    }

    override fun set(value: T) {
        if (!this.isBound) {
            if (this.propertyValue != value) {
                this.propertyValue = value
                this.markInvalid()
            }
        } else {
            val beanName = if (bean != null && name != null) "${bean::class.simpleName}.$name:" else ""
            throw RuntimeException(beanName + "A bound value cannot be set.")
        }
    }

    override fun isBound(): Boolean = observable != null

    override fun bind(value: ObservableValue<out T>) {
        val observed = value.takeIf { klass.isInstance(it) } ?: wrapperOf(value)
        if ((observed as V) != observable) {
            unbind()
            observable = observed
            listener = listener ?: Listener(this)
        }
    }

    override fun unbind() {
        if (observable != null) {
            propertyValue = observable!!.get()
            observable!!.removeListener(listener)
            observable!!.takeAs<BaseWrapper<T>>()?.dispose()
            observable = null
        }
    }

    protected abstract fun wrapperOf(value: ObservableValue<out T>): W

    override fun toString(): String = toText()

    private class Listener<T, V : ObservableObjectValue<T>, W : BaseWrapper<T>, B : PropertyBase<T, V, W>>(
        property: B,
    ) : InvalidationListener, WeakListener {

        private val reference: WeakReference<B> = WeakReference(property)

        override fun invalidated(observable: Observable) {
            val value = reference.get()
            if (value == null) {
                observable.removeListener(this)
            } else {
                value.markInvalid()
            }
        }

        override fun wasGarbageCollected(): Boolean = reference.get() == null

    }

}
