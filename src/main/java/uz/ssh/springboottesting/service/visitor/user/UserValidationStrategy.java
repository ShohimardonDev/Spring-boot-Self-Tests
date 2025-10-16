package uz.ssh.springboottesting.service.visitor.user;

public class UserValidationStrategy implements ValidationStrategy<User> {
    @Override
    public boolean validate(User user) {
        return user.getFirstName() != null && user.getLastName() != null;
    }
}