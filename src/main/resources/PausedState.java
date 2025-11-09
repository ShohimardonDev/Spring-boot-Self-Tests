package uz.ssh.springboottesting.service.state;

// Paused state
public class PausedState implements PlayerState {

    @Override
    public void pressPlay(Player player) {
        System.out.println("Resuming playback.");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(Player player) {
        System.out.println("Already paused.");
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Stopping playback from pause.");
        player.setState(new StoppedState());
    }
}
