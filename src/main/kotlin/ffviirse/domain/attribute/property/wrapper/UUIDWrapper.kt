package ffviirse.domain.attribute.property.wrapper

import ffviirse.domain.attribute.binding.UUIDBinding
import java.util.UUID
import javafx.beans.value.ObservableValue

class UUIDWrapper(
    observable: ObservableValue<out UUID>
) : BaseWrapper<UUID>(observable), UUIDBinding
