package uz.ssh.springboottesting.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;

    public User(UserDto input) {
        this.id = input.getId();
        this.username = input.getUsername();
        this.password = input.getPassword();
    }
}
