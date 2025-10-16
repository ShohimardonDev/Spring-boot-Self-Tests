package uz.ssh.springboottesting.service.visitor.user;

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
public class User extends Entity {
    private String firstName;
    private String lastName;

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
