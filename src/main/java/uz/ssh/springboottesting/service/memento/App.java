package uz.ssh.springboottesting.service.memento;

import com.github.javafaker.Faker;

public class App {
    private static Faker faker = new Faker();

    public static void main(String[] args) {
        User user = new User(faker.name().firstName(), faker.name().fullName(), faker.name().lastName());
        UserHistory history = new UserHistory();

        System.out.println("Initial: " + user.getFirstName() + " " + user.getLastName());

        // Save initial state
        history.push(user.save());

        // Change user state
        user.setFirstName("Bob");
        user.setLastName("Johnson");
        System.out.println("Modified: " + user.getFirstName() + " " + user.getLastName());

        // Undo / restore
        user.restore(history.pop());
        System.out.println("Restored: " + user.getFirstName() + " " + user.getLastName());
    }
}
