package structural

// Target interface expected by the client code
interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}

// Adaptee class with a different interface
class AdvancedMediaPlayer {
    fun playVlc(fileName: String) {
        println("Playing VLC file: $fileName")
    }

    fun playMp4(fileName: String) {
        println("Playing MP4 file: $fileName")
    }
}

// Adapter class that adapts the AdvancedMediaPlayer to the MediaPlayer interface
class MediaPlayerAdapter(private val advancedMediaPlayer: AdvancedMediaPlayer): MediaPlayer {
    override fun play(audioType: String, fileName: String) {
        when(audioType) {
            "vlc" -> advancedMediaPlayer.playVlc(fileName)
            "mp4" -> advancedMediaPlayer.playMp4(fileName)
            else -> throw IllegalArgumentException("Invalid audio type: $audioType")
        }
    }
}