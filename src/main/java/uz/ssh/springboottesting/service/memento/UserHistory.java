package uz.ssh.springboottesting.service.memento;

import java.util.Stack;

public class UserHistory {
    private final Stack<UserMemento> history = new Stack<>();

    public void push(UserMemento memento) {
        history.push(memento);
    }

    public UserMemento pop() {
        return history.isEmpty() ? null : history.pop();
    }
}