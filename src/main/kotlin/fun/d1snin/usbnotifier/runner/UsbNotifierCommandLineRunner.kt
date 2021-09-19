package `fun`.d1snin.usbnotifier.runner

import `fun`.d1snin.usbnotifier.service.UsbListenerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class UsbNotifierCommandLineRunner @Autowired constructor(val usbListenerService: UsbListenerService) :
    CommandLineRunner {

    override fun run(vararg args: String?) {
        usbListenerService.startListening()
    }
}