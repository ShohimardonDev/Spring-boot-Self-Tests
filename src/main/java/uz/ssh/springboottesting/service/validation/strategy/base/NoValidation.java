package uz.ssh.springboottesting.service.validation.strategy.base;

import org.springframework.stereotype.Component;

@Component
public class NoValidation<I> implements ValidationStrategy<I> {
    @Override
    public void validate(I input) {
        // do nothing
    }
}