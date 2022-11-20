package io.ptoj3ct.telegrambotspring.service;

import io.ptoj3ct.telegrambotspring.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    @Autowired
    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String username = update.getMessage().getChat().getFirstName();
            switch (messageText) {
                case "/start":
                    startCommandReceived(username, chatId);
                    break;
                default:
                    someFunctionality(chatId);
            }
        }
    }

    private void startCommandReceived(String username, long chatId) {
        String answer = "Hello, " + username + ", nice to meet you!";
        sendMessage(answer, chatId);
        log.info("Replied to user: " + username);
    }

    private void sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());;
        }
    }

    private void someFunctionality(long chatId) {
        String text = "Sorry, command was not recognised";
        sendMessage(text, chatId);
    }
}
