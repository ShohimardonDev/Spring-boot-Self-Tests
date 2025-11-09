package uz.ssh.springboottesting.service.state;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        player.pressPlay();   // Starting playback.
        player.pressPause();  // Pausing playback.
        player.pressPlay();   // Resuming playback.
        player.pressStop();   // Stopping playback.
        player.pressPause();  // Cannot pause. Player is stopped.
    }
}
