package ffviirse.domain.context.application

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

object ApplicationJobs {

    private val applicationJob = SupervisorJob()

    val ioScope = CoroutineScope(Dispatchers.IO + applicationJob)

    val uiScope = CoroutineScope(Dispatchers.Main + applicationJob)

}
