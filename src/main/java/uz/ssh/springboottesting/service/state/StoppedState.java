package uz.ssh.springboottesting.service.state;

// Stopped state
public class StoppedState implements PlayerState {

    @Override
    public void pressPlay(Player player) {
        System.out.println("Starting playback.");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(Player player) {
        System.out.println("Cannot pause. Player is stopped.");
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Already stopped.");
    }
}
