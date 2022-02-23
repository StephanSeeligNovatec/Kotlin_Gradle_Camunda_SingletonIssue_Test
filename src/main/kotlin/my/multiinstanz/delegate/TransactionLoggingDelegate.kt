package my.multiinstanz.delegate

import my.multiinstanz.ForbiddenItemBpmnError
import my.multiinstanz.Process
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TransactionLoggingDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution?) {
        log.info("TransactionLoggingDelegate run")
    }

    companion object {
        private val log = LoggerFactory.getLogger(TransactionLoggingDelegate::class.java)
    }
}

// Mit MultiInstanz before bleibt das Token auf der Multiinstanz 3 / 1 incident - Retry liest nicht neu die variablen liste. führt nur hund erneut aus
// Ohne Multiinstanz before geht das Token auf den vorherigen Task

// Normales Async before: MultiInstanz hat nur 1 Token und 1 Incident Retry läueft für alle 3