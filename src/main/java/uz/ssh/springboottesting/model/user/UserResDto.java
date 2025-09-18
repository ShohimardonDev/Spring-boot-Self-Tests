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
public class UserResDto {
    private Integer id;
    private String username;
    private String password;

    public UserResDto(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }
}
