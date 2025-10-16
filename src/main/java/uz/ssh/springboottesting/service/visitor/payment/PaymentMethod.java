package uz.ssh.springboottesting.service.visitor.payment;

import lombok.Getter;

// The "Element" interface
@Getter
public abstract class PaymentMethod {
    protected double amount;

    abstract void accept(PaymentMethodVisitor visitor);
}

// Concrete Visitor: Validate Payment


