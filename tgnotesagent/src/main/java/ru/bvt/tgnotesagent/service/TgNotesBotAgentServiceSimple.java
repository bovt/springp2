package ru.bvt.tgnotesagent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.bvt.tgnotesagent.feign.NoteFeignClientBotEdition;
import ru.bvt.tgnotesagent.model.NoteVO;

@Service
public class TgNotesBotAgentServiceSimple extends TelegramLongPollingBot implements TgNotesBotAgentService {

    private NoteFeignClientBotEdition noteFeignClientBotEdition;
    private String botUsername;
    private String botToken;

    @Autowired
    public TgNotesBotAgentServiceSimple(NoteFeignClientBotEdition noteFeignClientBotEdition, @Value("${bot.name}") String botUsername, @Value("${bot.token}") String botToken) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.noteFeignClientBotEdition = noteFeignClientBotEdition;
    }

    ;

    @Override
    public void onUpdateReceived(Update update) {
        //      try {
//        System.out.println(update.getMessage().getText());
        noteFeignClientBotEdition.createOrSaveNote(new NoteVO(update.getMessage().getText()));
//  TODO: добавить команды телеграм, сделать хэндлеры к ним
//
        //           } catch (TelegramApiException e) {
        //           e.printStackTrace();
        //       }
    }

    // Геттеры, которые необходимы для наследования от TelegramLongPollingBot
    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}
