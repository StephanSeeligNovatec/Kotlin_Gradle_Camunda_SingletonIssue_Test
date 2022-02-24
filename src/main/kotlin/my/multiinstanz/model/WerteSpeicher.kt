package my.multiinstanz.model

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class WerteSpeicher {

    var myValue: String = "DefaultValue"

}