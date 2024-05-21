package behavioral

// Context
class MediaPlayer {
    private var state: PlayerState = StoppedState()

    fun play() {
        state.play(this)
    }

    fun pause() {
        state.pause(this)
    }

    fun stop() {
        state.stop(this)
    }

    fun setState(state: PlayerState) {
        this.state = state
    }
}

interface PlayerState {
    fun play(player: MediaPlayer)
    fun pause(player: MediaPlayer)
    fun stop(player: MediaPlayer)
}

// Concrete states
class PlayingState : PlayerState {
    override fun play(player: MediaPlayer) {
        println("Already playing")
    }

    override fun pause(player: MediaPlayer) {
        println("Pausing player")
        player.setState(PausedState())
    }

    override fun stop(player: MediaPlayer) {
        println("Stopping player")
        player.setState(StoppedState())
    }
}

class PausedState : PlayerState {
    override fun play(player: MediaPlayer) {
        println("Resuming player")
        player.setState(PlayingState())
    }

    override fun pause(player: MediaPlayer) {
        println("Already paused")
    }

    override fun stop(player: MediaPlayer) {
        println("Stopping player")
        player.setState(StoppedState())
    }
}

class StoppedState : PlayerState {
    override fun play(player: MediaPlayer) {
        println("Starting player")
        player.setState(PlayingState())
    }

    override fun pause(player: MediaPlayer) {
        println("Cannot pause, player is already stopped")
    }

    override fun stop(player: MediaPlayer) {
        println("Already stopped")
    }
}