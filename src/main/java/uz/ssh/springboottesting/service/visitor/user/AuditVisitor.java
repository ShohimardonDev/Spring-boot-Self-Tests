package uz.ssh.springboottesting.service.visitor.user;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
public class AuditVisitor implements Visitor {
    @Override
    public void visit(User user) {
        System.out.println("Auditing User: " + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public void visit(Product product) {
        System.out.println("Auditing Product: " + product.getProductName() + " " + product.getProductDescription());
    }
}
