package my.multiinstanz.rest

import my.multiinstanz.Process
import org.camunda.bpm.engine.RuntimeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class StartController(private val runtimeService: RuntimeService) {

    @PostMapping("/start")
    fun startProcess(@RequestBody inputData: List<InputData>) {

        log.info("Starting process with list: ${inputData}")

        for (data in inputData) {
            runtimeService.startProcessInstanceByKey(
                Process.P1_BASE,
                mapOf(Process.Variables.DURATION to data.duration, Process.Variables.WERT to data.wert)
            )
        }

    }

    companion object {
        private val log = LoggerFactory.getLogger(StartController::class.java)
    }
}

class InputData {
    lateinit var duration: String
    lateinit var wert: String
}