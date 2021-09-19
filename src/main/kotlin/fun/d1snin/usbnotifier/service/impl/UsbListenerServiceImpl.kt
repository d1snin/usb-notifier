package `fun`.d1snin.usbnotifier.service.impl

import `fun`.d1snin.usbnotifier.service.SoundPlayerService
import `fun`.d1snin.usbnotifier.service.UsbListenerService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.usb.UsbHostManager
import javax.usb.event.UsbServicesEvent
import javax.usb.event.UsbServicesListener

@Service
class UsbListenerServiceImpl @Autowired constructor(val soundPlayerService: SoundPlayerService) : UsbListenerService {

    private val log = LogManager.getLogger(UsbListenerService::class.java)

    override fun startListening() {
        val services = UsbHostManager.getUsbServices()
        val queue: Queue<Int> = LinkedList(services.rootUsbHub.attachedUsbDevices.indices.toMutableList())

        services.addUsbServicesListener(object : UsbServicesListener {
            override fun usbDeviceAttached(event: UsbServicesEvent?) {
                queue.remove()

                if (queue.isEmpty()) { // preventing sound producing at startup.
                    log.info("Device attached. Playing sound.")
                    soundPlayerService.playSoundOnAttach()
                }
            }

            override fun usbDeviceDetached(event: UsbServicesEvent?) {
                log.info("Device unattached.")
            }
        })

        // a dummy way to block this thread to prevent application from shutting down.
        while (true) {
            Thread.sleep(Long.MAX_VALUE)
        }
    }
}
