package my.multiinstanz.delegate

import my.multiinstanz.model.WerteSpeicher
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
class ReadBeanDelegate(
    private val werteSpeicher: WerteSpeicher
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val value = werteSpeicher.myValue
        val pid = execution.processInstanceId
        log.info("Current value : $value at prozessinstanzid: $pid")
    }

    companion object {
        private val log = LoggerFactory.getLogger(ReadBeanDelegate::class.java)
    }
}