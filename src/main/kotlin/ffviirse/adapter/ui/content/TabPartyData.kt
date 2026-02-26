package ffviirse.adapter.ui.content

import com.database.tesis.adapter.ui.component.AppTab
import ffviirse.domain.context.session.SessionContext.appBundleProperty
import ffviirse.domain.context.session.SessionContext.bundleContentPane
import javafx.beans.binding.Bindings
import org.springframework.stereotype.Component

@Component
class TabPartyData : AppTab(2, bundleContentPane.tabPartyDataTitle) {

    init {
        labelProperty.bind(Bindings.createStringBinding({ bundleContentPane.tabPartyDataTitle }, appBundleProperty))
    }

}
