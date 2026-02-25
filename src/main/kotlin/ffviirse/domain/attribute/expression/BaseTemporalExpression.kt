package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binding.BaseBinding
import ffviirse.domain.attribute.observable.ObservableTemporalValue
import ffviirse.domain.extension.isAfterOf
import ffviirse.domain.extension.isAfterOrSame
import ffviirse.domain.extension.isBeforeOf
import ffviirse.domain.extension.isBeforeOrSame
import ffviirse.domain.extension.isSameInstant
import java.time.ZoneId
import java.time.temporal.Temporal
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding

interface BaseTemporalExpression<T : Temporal, V : ObservableTemporalValue<T>, E> : BaseExpression<T, V>
    where E : BaseTemporalExpression<T, V, E>, E : BaseBinding<T> {

    fun toZoneSameInstant(zone: ZoneId): E

    fun <R : ObservableTemporalValue<*>> isAfterOf(temporal: R): BooleanBinding = Bindings.createBooleanBinding({ this.value.isAfterOf(temporal.value) }, this, temporal)

    fun <R : ObservableTemporalValue<*>> isAfterOrSame(temporal: R): BooleanBinding = Bindings.createBooleanBinding({ this.value.isAfterOrSame(temporal.value) }, this, temporal)

    fun <R : ObservableTemporalValue<*>> isBeforeOf(temporal: R): BooleanBinding = Bindings.createBooleanBinding({ this.value.isBeforeOf(temporal.value) }, this, temporal)

    fun <R : ObservableTemporalValue<*>> isBeforeOrSame(temporal: R): BooleanBinding = Bindings.createBooleanBinding({ this.value.isBeforeOrSame(temporal.value) }, this, temporal)

    fun <R : ObservableTemporalValue<*>> isSameInstant(temporal: R): BooleanBinding = Bindings.createBooleanBinding({ this.value.isSameInstant(temporal.value) }, this, temporal)

    fun isAfterOf(temporal: Temporal): BooleanBinding = Bindings.createBooleanBinding({ this.value.isAfterOf(temporal) }, this)

    fun isAfterOrSame(temporal: Temporal): BooleanBinding = Bindings.createBooleanBinding({ this.value.isAfterOrSame(temporal) }, this)

    fun isBeforeOf(temporal: Temporal): BooleanBinding = Bindings.createBooleanBinding({ this.value.isBeforeOf(temporal) }, this)

    fun isBeforeOrSame(temporal: Temporal): BooleanBinding = Bindings.createBooleanBinding({ this.value.isBeforeOrSame(temporal) }, this)

    fun isSameInstant(temporal: Temporal): BooleanBinding = Bindings.createBooleanBinding({ this.value.isSameInstant(temporal) }, this)

}
