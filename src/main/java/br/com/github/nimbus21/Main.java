package br.com.github.nimbus21;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import br.com.github.nimbus21.listener.Listener1;

public class Main {

	public static void main(String[] args) {
		String token = "NzUxNTc0MjgzNTc4NTA3Mjk0.X1LEGA.zbAi_Bs7texjayDG18mzHgHcDOk";
		
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		
		Listener1 listener1 = new Listener1();
		
		api.addListener(listener1);
		
//		Listener2 listener2 = new Listener2();
//		
//		api.addListener(listener2);
		
		//List<String> comandosCasar = new ArrayList<String>();
		
		//Adicionador eu = new Adicionador();
		
		//Adicionador.adicionaAK(comandosCasar);
		
		//System.out.println(comandosCasar.contains("our house"));
		
		//System.out.println(listener1.getComandosCasar().get(0));
		//System.out.println();
	}

}
