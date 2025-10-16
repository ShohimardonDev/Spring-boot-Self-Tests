package uz.ssh.springboottesting.service.visitor.user;

public interface Visitor {
    void visit(User user);

    void visit(Product product);
}