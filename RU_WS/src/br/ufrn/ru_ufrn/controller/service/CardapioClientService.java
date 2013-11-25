package br.ufrn.ru_ufrn.controller.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.ufrn.ru_ufrn.model.Cardapio;
 

public class CardapioClientService {
	
	
	public CardapioClientService() {
	}

	public Cardapio getCardapioDoDia(){
	    Cardapio cardapio = null;
	    
	    Client client = Client.create(); 
	    WebResource resource = client.resource(ServiceResources.URL_RESOURCE+"/cardapio/hoje"); 
	    cardapio = resource.type("application/json").get(Cardapio.class);  
	    
	    return cardapio;
		
	}
	
	public Cardapio getCardapioDoDiaGson(){
		Cardapio cardapio = null;
		URL serverAddress;
		try {
			serverAddress = new URL(ServiceResources.URL_RESOURCE+"/cardapio/hoje");
			HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection(); 
			connection.setRequestMethod("GET"); 
			connection.connect(); 
			BufferedReader rd = new BufferedReader(new InputStreamReader( connection.getInputStream())); 			
			StringBuilder sb = new StringBuilder();
			String temp = rd.readLine();
			while(temp != null){
				sb.append(temp);
				temp = rd.readLine();
			}
			Gson gson = new Gson();			
			cardapio = gson.fromJson(sb.toString(), Cardapio.class);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return cardapio;
		
	}
	
	public static void main(String args[]){
		
		System.out.println(new CardapioClientService().getCardapioDoDiaGson().getAlmocoCarnivoro().getNome());
		
	}
	
	
}
