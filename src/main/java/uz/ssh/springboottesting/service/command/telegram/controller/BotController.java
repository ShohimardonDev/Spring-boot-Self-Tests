package uz.ssh.springboottesting.service.command.telegram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.service.command.Command;
import uz.ssh.springboottesting.service.command.telegram.BotContext;
import uz.ssh.springboottesting.service.command.telegram.BotService;
import uz.ssh.springboottesting.service.command.telegram.state.IdleState;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class BotController {
    private final BotService botService;
    private final Map<Long, BotContext> userContexts = new ConcurrentHashMap<>();
    private final Queue<Command> queue = new LinkedList<>();

    public void handleUpdate(Long chatId, String text) {
        BotContext context = userContexts.computeIfAbsent(chatId,
                id -> new BotContext(chatId, botService));
        if (context.getState() == null) {
            context.setState(new IdleState());
        }

        context.getState().handle(context, text);
        executeQueue();
    }

    public void handleButton(Long chatId, String callbackData) {
        BotContext ctx = userContexts.computeIfAbsent(chatId,
                id -> new BotContext(chatId, botService));

        if (ctx.getState() != null) {
            ctx.getState().handleButton(ctx, callbackData);
        }
    }

    private void executeQueue() {
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }


}
