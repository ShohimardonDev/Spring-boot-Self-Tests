package uz.ssh.springboottesting.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.ssh.springboottesting.model.user.UserDto;
import uz.ssh.springboottesting.model.user.UserFilter;
import uz.ssh.springboottesting.model.user.UserResDto;
import uz.ssh.springboottesting.service.user.UserService;

import java.util.List;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping
    public UserResDto save(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/{id}")
    public UserResDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<UserResDto> all(UserFilter filter) {
        return userService.getAll(filter);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        userService.delete(id);
    }

}
