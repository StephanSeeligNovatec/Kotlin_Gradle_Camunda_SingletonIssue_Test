package my.multiinstanz.rest

import my.multiinstanz.Process
import my.multiinstanz.delegate.MultiInstanzDelegate
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
    fun startProcess(@RequestBody shoppingItems: List<String>) {

        log.info("Starting process with list: $shoppingItems")

        runtimeService.startProcessInstanceByKey(
            Process.NAME,
            mapOf(Process.Variables.SHOPPING_LIST to shoppingItems)
        )
    }

    companion object {
        private val log = LoggerFactory.getLogger(MultiInstanzDelegate::class.java)
    }
}