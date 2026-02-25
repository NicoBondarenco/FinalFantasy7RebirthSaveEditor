package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.appTitle
import javafx.beans.binding.Bindings
import org.springframework.stereotype.Component

@Component
class TabGeneralData : AppTab(1, appTitle.tabGeneralDataTitle) {

    init {
        labelProperty.bind(Bindings.createStringBinding({ appTitle.tabGeneralDataTitle }, appBundleProperty))
    }

}
