package uz.ssh.springboottesting.service.visitor.user;

public class ProductValidationStrategy implements ValidationStrategy<Product> {
    @Override
    public boolean validate(Product product) {
        return product.getProductName() != null && product.getProductDescription().length() > 2;
    }
}