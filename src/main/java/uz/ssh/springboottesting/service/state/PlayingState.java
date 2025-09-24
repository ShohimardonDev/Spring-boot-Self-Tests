package uz.ssh.springboottesting.service.state;

// Playing state
public class PlayingState implements PlayerState {

    @Override
    public void pressPlay(Player player) {
        System.out.println("Already playing...");
    }

    @Override
    public void pressPause(Player player) {
        System.out.println("Pausing playback.");
        player.setState(new PausedState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Stopping playback.");
        player.setState(new StoppedState());
    }
}

