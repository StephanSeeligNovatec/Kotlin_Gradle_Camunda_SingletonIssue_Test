package my.multiinstanz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CamundaConfig::class)
class ProcessApplication

fun main(args: Array<String>) {

    runApplication<ProcessApplication>(*args)
}