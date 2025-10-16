package uz.ssh.springboottesting.service.visitor.user;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
public class UserProcess {
    private static final Name faker = new Faker().name();

    public static void main(String[] args) {
        var userProcess = new User(faker.firstName(), faker.lastName());
        var productProcess = new Product(faker.username(), faker.bloodGroup());

        var auditVisitor = new AuditVisitor();
        var validator = new ValidatorVisitor();

        userProcess.accept(auditVisitor);
        productProcess.accept(auditVisitor);

        userProcess.accept(validator);
        productProcess.accept(validator);
    }
}
