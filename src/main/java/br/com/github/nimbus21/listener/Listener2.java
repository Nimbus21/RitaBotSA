package br.com.github.nimbus21.listener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Listener2 implements MessageCreateListener {

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		MessageAuthor messageAuthor = event.getMessageAuthor();

		CompletableFuture<MessageSet> messageSet = null;

		if (messageAuthor.getName().equalsIgnoreCase("Nimbus21")) {
			messageSet = event.getMessage().getMessagesAfter(1);
		}

//		if (messageAuthor.getName().equalsIgnoreCase("Nimbus21")) {
//			System.out.println("Nimbus falou");
//		}
//		
//		if (messageAuthor.getName().equalsIgnoreCase("Mudamaid 23")) {
//			System.out.println("Bot falou");
//		}

		MessageSet aqui = null;

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
				System.out.println(messaga.getAuthor().getName());

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
