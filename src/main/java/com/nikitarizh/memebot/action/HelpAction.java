package com.nikitarizh.memebot.action;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.entity.MemeBot;
import com.nikitarizh.memebot.entity.UserResponse;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.function.Predicate.not;

@Component
@RequiredArgsConstructor
public class HelpAction implements Action {

    private final MemeBot bot;
    private final List<Action> actions;
    private final ReplyKeyboardMarkup markup;

    @Override
    public SendResponse act(Update update, BotRequestEntity botRequest) {
        long userId = update.message().from().id();
        var text = getText();
        var response = new UserResponse(text);
        var request = new SendMessage(userId, text).replyMarkup(markup);
        return bot.execute(request, response, botRequest);
    }

    @Override
    public String getBoundCommand() {
        return "/help";
    }

    @Override
    public String getCommandDescription() {
        return "Some assistance";
    }

    private String getText() {
        var builder = new StringBuilder();
        builder.append("Let me help you. Here is the list of commands that I know:\n");
        actions.stream()
                .filter(action -> action.getBoundCommand().startsWith("/"))
                .filter(not(this::equals))
                .forEach(action -> appendCommand(action, builder));
        appendCommand(this, builder);
        return builder.toString();
    }

    private void appendCommand(Action action, StringBuilder builder) {
        builder.append(action.getBoundCommand())
                .append(" - ")
                .append(action.getCommandDescription())
                .append("\n");
    }
}
