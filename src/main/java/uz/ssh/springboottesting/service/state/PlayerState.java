package uz.ssh.springboottesting.service.state;

/**
 * @author Shokhimardon
 * @since 9/24/25
 */
public interface PlayerState {
    void pressPlay(Player player);
    void pressPause(Player player);
    void pressStop(Player player);
}
