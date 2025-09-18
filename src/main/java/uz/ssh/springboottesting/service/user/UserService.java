package uz.ssh.springboottesting.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.ssh.springboottesting.model.user.User;
import uz.ssh.springboottesting.model.user.UserDto;
import uz.ssh.springboottesting.model.user.UserFilter;
import uz.ssh.springboottesting.model.user.UserResDto;
import uz.ssh.springboottesting.service.base.BaseTemplateService;
import uz.ssh.springboottesting.service.validation.strategy.base.ValidationStrategy;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */
@Service
@Slf4j
public class UserService extends BaseTemplateService<UserDto, UserResDto, User, Integer, UserFilter> {

    protected UserService(ValidationStrategy<UserDto> validationStrategy) {
        super(validationStrategy);
    }

    @Override
    protected User mapToEntity(UserDto input) {
        return new User(input);
    }

    @Override
    protected User save(User entity) {
        return entity;
    }

    @Override
    protected UserResDto mapToResponse(User entity) {
        return new UserResDto(entity);
    }

    @Override
    protected void deleteEntity(Integer integer) {

    }

    @Override
    protected User findById(Integer integer) {
        return null;
    }

    @Override
    protected List<UserResDto> filter(UserFilter userFilter, Pageable pageable) {
        return List.of();
    }

    @Override
    protected void postCreate(User entity, UserResDto response) {
        log.info("Post Create {}", entity);
        super.postCreate(entity, response);
    }

    @Override
    protected void preCreate(UserDto input) {
        log.info("Pre Create {}", input);
        super.preCreate(input);
    }
}
