package `fun`.d1snin.usbnotifier.usbnotifier.service.impl

import `fun`.d1snin.usbnotifier.usbnotifier.configuration.SoundsConfiguration
import `fun`.d1snin.usbnotifier.usbnotifier.service.SoundPlayerService
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class SoundPlayerServiceImpl @Autowired constructor(
    val soundsConfiguration: SoundsConfiguration,
    val resourceLoader: ResourceLoader
) : SoundPlayerService {

    override fun playSoundOnAttach() {
        MediaPlayer(Media(resourceLoader.getResource(soundsConfiguration.soundOnAttach).uri.toString())).play()
    }
}