package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.appTitle
import javafx.beans.binding.Bindings
import org.springframework.stereotype.Component

@Component
class TabPartyData : AppTab(2, appTitle.tabPartyDataTitle) {

    init {
        labelProperty.bind(Bindings.createStringBinding({ appTitle.tabPartyDataTitle }, appBundleProperty))
    }

}
