package uz.ssh.springboottesting.service.command.order;

import uz.ssh.springboottesting.service.command.Command;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
public class CreateOrderCommand implements Command {
    private final OrderService service;
    private final OrderPayload payload;

    public CreateOrderCommand(OrderService service, OrderPayload payload) {
        this.service = service;
        this.payload = payload;
    }

    @Override
    public void execute() {
        service.createOrder(payload);
    }

}
