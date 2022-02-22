package my.multiinstanz

import org.camunda.bpm.engine.delegate.BpmnError

class ForbiddenItemBpmnError : BpmnError {

    constructor(errorCode: String?) : super(errorCode)
    constructor(errorCode: String?, message: String?) : super(errorCode, message)
}

