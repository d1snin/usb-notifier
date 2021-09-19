package `fun`.d1snin.usbnotifier

import `fun`.d1snin.usbnotifier.javafx.JavaFxApplication
import javafx.application.Application
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication
import org.springframework.boot.runApplication
import java.util.concurrent.Executors

@SpringBootApplication
@ConditionalOnNotWebApplication
class UsbNotifierApplication

fun main(args: Array<String>) {
    Executors.newSingleThreadExecutor().execute {
        Application.launch(JavaFxApplication::class.java, *args)
    }

    runApplication<UsbNotifierApplication>(*args) {
        webApplicationType = WebApplicationType.NONE
    }
}
