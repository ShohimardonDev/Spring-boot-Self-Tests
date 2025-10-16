package uz.ssh.springboottesting.service.visitor.user;

public interface ValidationStrategy<T> {
    boolean validate(T item);
}