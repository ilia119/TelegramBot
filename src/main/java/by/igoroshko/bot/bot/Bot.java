package by.igoroshko.bot.bot;

import by.igoroshko.bot.entities.City;
import by.igoroshko.bot.entities.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

	@Value("${bot.name}")
	private String botName;
	@Value("${bot.token}")
	private String botToken;

	@Autowired
	private CityRepository cityRepository;

	public void onUpdateReceived(Update update) {
		try {
			Message message = update.getMessage();
			SendMessage sendMessage = new SendMessage();
			if (message != null && message.hasText()) {
				City city = cityRepository.findByName(message.getText());
				if (city != null) {
					String answer = city.getInfo();
					sendMessage.setText(answer);
				} else {
					sendMessage.setText("Нет такого города. Попробуйте ещё раз");
				}
			}
			sendMessage.setChatId(update.getMessage().getChatId());
			execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public String getBotUsername() {
		return botName;
	}

	public String getBotToken() {
		return botToken;
	}
}
