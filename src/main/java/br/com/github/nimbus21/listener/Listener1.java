package br.com.github.nimbus21.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Listener1 implements MessageCreateListener {

	int contadorHusbando = 0;

	List<String> comandosCasar = new ArrayList<String>();

	public List<String> getComandosCasar() {
		return comandosCasar;
	}

	public Listener1() {
		comandosCasar.add("$ha");
		comandosCasar.add("$wa");
		comandosCasar.add("$ma");
		comandosCasar.add("$hg");
		comandosCasar.add("$wg");
		comandosCasar.add("$HA");
		comandosCasar.add("$WA");
		comandosCasar.add("$MA");
		comandosCasar.add("$HG");
		comandosCasar.add("$WG");
	}

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		Message message = event.getMessage();
		MessageAuthor messageAuthor = event.getMessageAuthor();

		CompletableFuture<MessageSet> messageSet = null;
		MessageSet aqui = null;

		if (messageAuthor.getName().equalsIgnoreCase("Nimbus21") && comandosCasar.contains(message.getContent())) {
			System.out.println("Thandy falou e foi um comando de casamento");
			messageSet = event.getMessage().getMessagesAfter(1);

			try {
				if (messageSet == null) {
					System.out.println("NULL 1");
				} else {
					aqui = messageSet.get();
				}

			} catch (InterruptedException e) {
				System.out.println("Não consegui");
			} catch (ExecutionException e) {
				System.out.println("Não consegui");
			}

			if (aqui == null) {
				System.out.println("NULL 2");
			} else {

				try {
					Message messagemSeguinte = aqui.first();
					//System.out.println(messagemSeguinte.getAuthor().getName());
					contadorHusbando++;
					event.getChannel().sendMessage(messagemSeguinte.getAuthor().getName() + " mandou waifu");
					event.getChannel().sendMessage("Contador de waifus enviadas na rodada: " + contadorHusbando);
				} catch (Exception e) {
					System.out.println("algo diferente de mensagem");
				}
			}

		}

//		if (comandosCasar.contains(message.getContent())) {
//			event.getChannel().sendMessage("Tá rodando aí mano?");
//		}

		if (message.getContent().equalsIgnoreCase("r!zera")) {
			contadorHusbando = 0;
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
	}

}
