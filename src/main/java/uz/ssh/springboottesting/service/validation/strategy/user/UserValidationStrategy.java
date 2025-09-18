package uz.ssh.springboottesting.service.validation.strategy.user;

import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.model.user.User;
import uz.ssh.springboottesting.model.user.UserDto;
import uz.ssh.springboottesting.service.validation.strategy.base.ValidationStrategy;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */
@Component
public class UserValidationStrategy implements ValidationStrategy<UserDto> {
    @Override
    public void validate(UserDto input) {

    }
}
