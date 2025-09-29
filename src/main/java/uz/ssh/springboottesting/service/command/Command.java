package uz.ssh.springboottesting.service.command;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
public interface Command {
    void execute();

    default void undo() {

    }
}
