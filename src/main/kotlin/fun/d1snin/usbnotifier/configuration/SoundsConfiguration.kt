package `fun`.d1snin.usbnotifier.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "usb-notifier.sounds")
class SoundsConfiguration {
    var soundOnAttach: String = "classpath:moo.wav"
}