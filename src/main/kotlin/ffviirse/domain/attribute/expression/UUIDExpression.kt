package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.UUIDBinder
import ffviirse.domain.attribute.observable.ObservableUUIDValue
import java.util.UUID
import javafx.beans.value.ObservableObjectValue

interface UUIDExpression : BaseExpression<UUID, ObservableUUIDValue>, ObservableUUIDValue {

    companion object {

        fun uuidExpression(
            value: ObservableUUIDValue
        ): UUIDExpression = uuidExpression(value as ObservableObjectValue<UUID>)

        fun uuidExpression(
            value: ObservableObjectValue<UUID>
        ): UUIDExpression = value.takeIf {
            it is UUIDExpression
        }?.let {
            it as UUIDExpression
        } ?: UUIDBinder(value, { it }, listOf(value))

    }

}
