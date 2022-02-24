package my.multiinstanz.delegate

import my.multiinstanz.Process
import my.multiinstanz.model.WerteSpeicher
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class UpdateBeanDelegate(val werteSpeicher: WerteSpeicher) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val wert = execution.getVariable(Process.Variables.WERT) as String
        werteSpeicher.myValue = wert
        val pid = execution.processInstanceId
        log.info("Set werteSpeicher with: $wert at prozessinstanzid $pid")
    }

    companion object {
        private val log = LoggerFactory.getLogger(UpdateBeanDelegate::class.java)
    }
}