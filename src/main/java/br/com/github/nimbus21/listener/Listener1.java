package br.com.github.nimbus21.listener;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Listener1 implements MessageCreateListener {

	int contadorHusbando = 0;

	public Listener1() {

	}

	public void onMessageCreate(MessageCreateEvent event) {

		Message message = event.getMessage();

		if (message.getContent().equalsIgnoreCase("$ha")) {
			contadorHusbando++;
			event.getChannel().sendMessage("Tá rodando aí mano? Contador atualmente em... " + contadorHusbando);
		}

		if (message.getContent().equalsIgnoreCase("$wa") || message.getContent().equalsIgnoreCase("$ma")) {
			event.getChannel().sendMessage("Tá rodando aí mano?");
		}

		if (message.getContent().equalsIgnoreCase("r!zera")) {
			contadorHusbando = 0;
			event.getChannel().sendMessage("Blz, tá zerado essa porra");
		}

		if (message.getContent().equalsIgnoreCase("r!rita")) {
			event.getChannel().sendMessage("Quem apagar o público tá fudido!");
		}

		if (message.getContent().equalsIgnoreCase("r!publico")) {
			event.getChannel().sendMessage("O público tá vivo");
		}

		if (message.getContent().equalsIgnoreCase("r!salva")) {
			event.getChannel().sendMessage("Vou tentar...");
		}

	}

}
