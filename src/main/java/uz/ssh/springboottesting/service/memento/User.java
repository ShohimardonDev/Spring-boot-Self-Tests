package uz.ssh.springboottesting.service.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String email;

    // Save current state into memento
    public UserMemento save() {
        return new UserMemento(firstName, lastName);
    }

    // Restore state from memento
    public void restore(UserMemento memento) {
        this.firstName = memento.getFirstName();
        this.lastName = memento.getLastName();
    }
}