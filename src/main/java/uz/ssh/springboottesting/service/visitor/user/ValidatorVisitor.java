package uz.ssh.springboottesting.service.visitor.user;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
public class ValidatorVisitor implements Visitor {

    private final ValidationStrategy<User> userValidator = new UserValidationStrategy();
    private final ValidationStrategy<Product> productValidator = new ProductValidationStrategy();


    @Override
    public void visit(User user) {
        boolean isValid = userValidator.validate(user);
        System.out.println("User valid: " + isValid);
    }

    @Override
    public void visit(Product product) {
        boolean isValid = productValidator.validate(product);
        System.out.println("Product valid: " + isValid);
    }
}
