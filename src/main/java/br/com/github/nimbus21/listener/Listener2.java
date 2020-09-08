package br.com.github.nimbus21.listener;

import java.util.Optional;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedImage;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Listener2 implements MessageCreateListener {

	private int contadorRolls = 0;

	private boolean contaBot = false;

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		MessageAuthor messageAuthor = event.getMessageAuthor();
		Message message = event.getMessage();

		if (contaBot == true && messageAuthor.getName().equalsIgnoreCase("Mudamaid 23")) {

			try {
				Embed embed = message.getEmbeds().get(0);
				Optional<EmbedImage> imagemEmbedada = embed.getImage();
				contadorRolls++;
				event.getChannel().sendMessage("Mudamaid 23 mandou waifu. Contador atualmente em " + contadorRolls);
			} catch (Exception e) {}

		}

		if (message.getContent().equalsIgnoreCase("r!zera")) {
			contadorRolls = 0;
			event.getChannel().sendMessage("Blz, tá zerado essa porra");
		}
		if (message.getContent().equalsIgnoreCase("r!rita")) {
			event.getChannel().sendMessage("Quem apagar o público tá fudido");
		}
		if (message.getContent().equalsIgnoreCase("r!publico")) {
			event.getChannel().sendMessage("O público tá vivo");
		}
		if (message.getContent().equalsIgnoreCase("r!salva")) {
			event.getChannel().sendMessage("Vou tentar...");
		}
		if (message.getContent().equalsIgnoreCase("r!contador")) {
			event.getChannel().sendMessage("Contador em " + contadorRolls);
		}

		if (message.getContent().equalsIgnoreCase("r!start")) {
			contaBot = true;
			event.getChannel().sendMessage("Opa, estou de olho em você!");
		}

		if (message.getContent().equalsIgnoreCase("r!stop")) {
			contaBot = false;
			event.getChannel().sendMessage("Vou ver como está o público e já volto");
		}
		
		if (message.getContent().equalsIgnoreCase("r!status")) {
			if (contaBot == true) {
				event.getChannel().sendMessage("Eu estou monitorando vocês! Mwahahahah");
			} else {
				event.getChannel().sendMessage("Eu estou vendo as tabelas do meu banco de dados agora, não tenho tempo pra vocês");
			}
		}
	}

}
