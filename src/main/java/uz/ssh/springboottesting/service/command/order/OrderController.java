package uz.ssh.springboottesting.service.command.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CommandDispatcher dispatcher;
    private final OrderService service;

    public OrderController(CommandDispatcher dispatcher, OrderService service) {
        this.dispatcher = dispatcher;
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody OrderPayload payload) {
        dispatcher.dispatch(new CreateOrderCommand(service, payload));
    }
}