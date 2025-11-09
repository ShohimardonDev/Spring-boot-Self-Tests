package uz.ssh.springboottesting.service.state;

public class Player {
    private PlayerState state;

    public Player() {
        this.state = new StoppedState(); // default state
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    // Delegate behavior to current state
    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressPause() {
        state.pressPause(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }
}
