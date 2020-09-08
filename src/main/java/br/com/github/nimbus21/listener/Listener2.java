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

public class Listener2 implements MessageCreateListener {

	int contadorHusbando = 0;

	List<String> comandosCasar = new ArrayList<String>();

	public List<String> getComandosCasar() {
		return comandosCasar;
	}

	public Listener2() {
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
		MessageAuthor messageAuthor = event.getMessageAuthor();

		CompletableFuture<MessageSet> messageSet = null;
		MessageSet aqui = null;

		if (messageAuthor.getName().equalsIgnoreCase("Mudamaid 23")) {

			messageSet = event.getMessage().getMessagesBefore(1);
		}

//		if (messageAuthor.getName().equalsIgnoreCase("Nimbus21")) {
//			System.out.println("Nimbus falou");
//		}
//		
//		if (messageAuthor.getName().equalsIgnoreCase("Mudamaid 23")) {
//			System.out.println("Bot falou");
//		}

		try {
			if (messageSet == null) {

			} else {
				aqui = messageSet.get();
			}

		} catch (InterruptedException e) {
			System.out.println("Não consegui");
		} catch (ExecutionException e) {
			System.out.println("Não consegui");
		}

		// System.out.println("Aqui ta vazio?" + aqui.isEmpty());
		// System.out.println("Aqui2 é oq?" + aqui2);

		if (aqui == null) {

		} else {

			try {
				Message messaga = aqui.first();

				if (comandosCasar.contains(messaga.getContent())) {
					contadorHusbando++;

					String nome = messaga.getAuthor().getName();

					System.out.println(nome);
					System.out.println(messaga.getContent());
					event.getChannel().sendMessage("Mudamaid 23 mandou waifu");
					event.getChannel().sendMessage("Contador de waifus enviadas na rodada: " + contadorHusbando);
				}

			} catch (Exception e) {
				System.out.println("algo diferente de mensagem");
			}
		}

		// System.out.println(message.isDone());

		// Message messageRaiz = message.

		// System.out.println("mostrar o aqui " + aqui.toString());
		// System.out.println("Mostrar o completable " + message.toString());

		// System.out.println("mostrar a raiz " + messageRaiz.getContent());
	}

}
