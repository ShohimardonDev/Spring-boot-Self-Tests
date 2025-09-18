package uz.ssh.springboottesting.service.validation.strategy.base;

import org.springframework.stereotype.Component;

@Component
public interface ValidationStrategy<I> {
    void validate(I input);
}