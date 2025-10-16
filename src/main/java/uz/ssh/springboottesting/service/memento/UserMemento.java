package uz.ssh.springboottesting.service.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
@Getter
@Setter
@AllArgsConstructor
public class UserMemento {
    private final String firstName;
    private final String lastName;
}
