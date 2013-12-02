package br.ufrn.ru_ufrn.mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.ufrn.ru_ufrn.model.Alimento;
import br.ufrn.ru_ufrn.model.Cardapio;
import br.ufrn.ru_ufrn.model.Refeicao;

public class MockCardapio {


	private String date = new java.sql.Date(System.currentTimeMillis()).toString();
	private BufferedReader br;
	final int NUM_MAX_REFEICOES = 10;
	
	public Cardapio mock(String date_){
		date = date_;
		return mockRandom();
	}
	
	public Cardapio mock() {
		Refeicao refeicao;
		Cardapio c = new Cardapio();
		List<Alimento> listCafe = new ArrayList<Alimento>();

		listCafe.add(new Alimento("Café", "Café preto feito na máquina",
				"http://icons.iconarchive.com/icons/babasse/old-school/64/coffee-icon.png"));
		listCafe.add(new Alimento("Leite", "Leite de vaca pasteurizado",
				"leite.jpg"));
		listCafe.add(new Alimento("Bolo de ovos", "Bolo de ovos",
				"bolo_ovos.jpg"));

		refeicao = new Refeicao("Café da manhã");

		setRefeicao(refeicao, listCafe);

		c.setCafeDaManha(refeicao);

		List<Alimento> listAlmocoVeg = new ArrayList<Alimento>();

		listAlmocoVeg.add(new Alimento("Feijão", "Feijão preto", "feijao.jpg"));
		listAlmocoVeg.add(new Alimento("Arroz", "Arroz integral",
				"arroz_integral.jpg"));
		listAlmocoVeg.add(new Alimento("Salada", "Batatinha, cenoura e rúcula",
				"salada.jpg"));
		listAlmocoVeg.add(new Alimento("Torta de soja", "Torta de soja",
				"torta_soja.jpg"));

		refeicao = new Refeicao("Almoço vegetariano");

		setRefeicao(refeicao, listAlmocoVeg);

		c.setAlmocoVegetariano(refeicao);

		List<Alimento> listAlmocoCar = new ArrayList<Alimento>();

		listAlmocoCar.add(new Alimento("Feijão", "Feijão preto", "feijao.jpg"));
		listAlmocoCar.add(new Alimento("Arroz", "Arroz Branco",
				"arroz_branco.jpg"));
		listAlmocoCar.add(new Alimento("Salada", "Batatinha, cenoura e rúcula",
				"salada.jpg"));
		listAlmocoCar
				.add(new Alimento("Frango", "Frango assado", "frango.jpg"));

		refeicao = new Refeicao("Almoço Carnívoro");

		setRefeicao(refeicao, listAlmocoCar);

		c.setAlmocoCarnivoro(refeicao);

		List<Alimento> listJantaVeg = new ArrayList<Alimento>();

		listJantaVeg.add(new Alimento("Arroz", "Arroz integral",
				"arroz_integral.jpg"));
		listJantaVeg
				.add(new Alimento("Pão", "Pão integral", "pao_integral.jpg"));
		listJantaVeg.add(new Alimento("Sopa", "Sopa de legumes",
				"torta_soja.jpg"));

		refeicao = new Refeicao("janta Vegetariana");

		setRefeicao(refeicao, listJantaVeg);

		c.setJantaVegetariana(refeicao);

		List<Alimento> listJantaCar = new ArrayList<Alimento>();

		listJantaCar
				.add(new Alimento("Sopa", "Sopa de carne", "sopa_carne.jpg"));
		listJantaCar.add(new Alimento("Pão", "Pão", "pao.jpg"));
		listJantaCar.add(new Alimento("Macarronada", "Macarronada",
				"macarronada.jpg"));

		refeicao = new Refeicao("janta Carnívora");

		setRefeicao(refeicao, listJantaCar);

		c.setJantaCarnivora(refeicao);

		c.setData(date);

		
		return c;

	}
	
	public Cardapio mockRandom(){
		Random random = new Random();
		List<String> alimentos = carregarNomesAlimentos2();
		int TAM = alimentos.size()-1; 
		Refeicao refeicao;
		Cardapio c = new Cardapio();
		int n = 0;

		
		// Criando o cafe da manha
		List<Alimento> listCafe = new ArrayList<Alimento>();
		n = random.nextInt(NUM_MAX_REFEICOES);
		while(n <= 1){
			n = random.nextInt(NUM_MAX_REFEICOES);
		}
		for(int i = 0; i < n; i++ ){
			int num = random.nextInt(TAM);
			listCafe.add(new Alimento(alimentos.get(num).split(",")[0], alimentos.get(num), alimentos.get(num)));
		}
		
		refeicao = new Refeicao("Cafe da manha");
		refeicao.setTipo(Cardapio.CAFE_DA_MANHA);

		setRefeicao(refeicao, listCafe);

		c.setCafeDaManha(refeicao);
		
		
		// Criando o almoco vegetariano
		List<Alimento> listAlmocoVeg = new ArrayList<Alimento>();

		n = random.nextInt(NUM_MAX_REFEICOES);
		while(n <= 1){
			n = random.nextInt(NUM_MAX_REFEICOES);
		}
		for(int i = 0; i < n; i++ ){
			int num = random.nextInt(TAM);
			listAlmocoVeg.add(new Alimento(alimentos.get(num).split(",")[0], alimentos.get(num), alimentos.get(num)));
		}		
		refeicao = new Refeicao("Almoco vegetariano");
		refeicao.setTipo(Cardapio.ALMOCO_VEGETARIANO);

		setRefeicao(refeicao, listAlmocoVeg);

		c.setAlmocoVegetariano(refeicao);
		
		
		
		
		// Criando o almoco arnivoro
		List<Alimento> listAlmocoCar = new ArrayList<Alimento>();

		n = random.nextInt(NUM_MAX_REFEICOES);
		while(n <= 1){
			n = random.nextInt(NUM_MAX_REFEICOES);
		}
		for(int i = 0; i < n; i++ ){
			int num = random.nextInt(TAM);
			listAlmocoCar.add(new Alimento(alimentos.get(num).split(",")[0], alimentos.get(num), alimentos.get(num)));
		}

		refeicao = new Refeicao("Almoco Carnivoro");
		refeicao.setTipo(Cardapio.ALMOCO_CARNIVORO);

		setRefeicao(refeicao, listAlmocoCar);

		c.setAlmocoCarnivoro(refeicao);
		
		
		
		// Criando jantar vegetariano
		List<Alimento> listJantaVeg = new ArrayList<Alimento>();

		n = random.nextInt(NUM_MAX_REFEICOES);
		while(n <= 1){
			n = random.nextInt(NUM_MAX_REFEICOES);
		}
		for(int i = 0; i < n; i++ ){
			int num = random.nextInt(TAM);
			listJantaVeg.add(new Alimento(alimentos.get(num).split(",")[0], alimentos.get(num), alimentos.get(num)));
		}

		refeicao = new Refeicao("janta Vegetariana");
		refeicao.setTipo(Cardapio.JANTA_VEGETARIANA);

		setRefeicao(refeicao, listJantaVeg);

		c.setJantaVegetariana(refeicao);

		
		// Criando janta carnivora
		List<Alimento> listJantaCar = new ArrayList<Alimento>();

		n = random.nextInt(NUM_MAX_REFEICOES);
		while(n <= 1){
			n = random.nextInt(NUM_MAX_REFEICOES);
		}
		for(int i = 0; i < n; i++ ){
			int num = random.nextInt(TAM);
			listJantaCar.add(new Alimento(alimentos.get(num).split(",")[0], alimentos.get(num), alimentos.get(num)));
		}

		refeicao = new Refeicao("janta Carnivora");
		refeicao.setTipo(Cardapio.JANTA_CARNIVORA);

		setRefeicao(refeicao, listJantaCar);

		c.setJantaCarnivora(refeicao);

		c.setData(date);
		
		return c;
		
	}
	
	public List<String> carregarNomesAlimentos(){
		List<String> alimentos = new ArrayList<String>();
		File file = new File("alimentos.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		try {
			String line = br.readLine();
			while(line != null){
				alimentos.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alimentos;
		
	}

	

	private static void setRefeicao(Refeicao refeicao, List<Alimento> list) {
		for (Iterator<Alimento> iterator = list.iterator(); iterator.hasNext();) {
			Alimento alimento = iterator.next();
			refeicao.itens.add(alimento);
		}
	}
	
	
	public List<String> carregarNomesAlimentos2(){
		String[] strings = {"Creme de leite, light café ou mesa",
				"Refrigerante, dietético, cola, com aspartame, sem cafeína",
				"Refrigerante, cola, sem cafeína",
				"Refrigerante, cola, com alto teor de cafeína",
				"Refrigerante, dietético, que não cola, com aspartame, com cafeína",
				"Refrigerante, dietético, cola, com sacarina, com cafeína",
				"Café, ebulição, preparado com água encanada, sem cafeína",
				"Café, ebulição, preparo com água encanada",
				"Café, ebulição, expresso, restaurante",
				"Café, instantâneo, normal, pó",
				"Café, instantâneo, normal, preparado com água",
				"Café, instantâneo, sem cafeína, pó",
				"Café, instantâneo, sem cafeína, pó, preparado com água",
				"Chá, ebulição, preparado com água encanada, sem cafeína",
				"Chá, instantâneo, sem adoçante, pó, sem cafeína",
				"Chá, instantâneo, adoçado com sacarina, sabor limão, pó, sem cafeína",
				"Chá, instantâneo, com açucar, sabor limão, sem vit C, pó, sem cafeína",
				"Refrigerante, tipo cola, com cafeína",
				"Bebida alcoólica, licor, café, 26.5% de álcool",
				"Bebida alcoólica, licor, café com creme, 17% de álcool",
				"Refrigerante, dietético, cola, com aspartame, com cafeína",
				"Bebida alcoólica, licor, café, 31.5% de álcool",
				"Sopa, feijão preto, lata, concentrada, varejo",
				"Sopa, feijão com porco, lata, concentrada, varejo",
				"Sopa, feijão com salsicha, lata, concentrada, varejo",
				"Sopa, feijão com presunto, lata, encorpado, pronto para consumo, varejo",
				"Sopa, Lipton, Macarrão, e feijão, seca",
				"Sopa, feijão com bacon, desidratado, mistura seca",
				"Sopa, feijão preto, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão com porco, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão com salsicha, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão com bacon, desidratado, preparo com água",
				"Feijão, semente madura, cru",
				"Feijão, semente madura, cozido, sólido, sem sal",
				"Feijão-de-lima, semente imatura, crua",
				"Feijão-de-lima, semente imatura, cozido, sólido, sem sal",
				"Feijão-de-lima, semente imatura, lata, sólido e líquido",
				"Feijão-de-lima, semente imatura, congelado, sem preparo",
				"Feijão-de-lima, semente imatura, congelado, cozido, sólido, sem sal",
				"Feijão-de-lima, semente imatura, congelado, baby, sem preparo",
				"Feijão-de-lima, semente imatura, congelado, baby, cozido, sólido, sem sal",
				"Feijão-de-vaca, semente imatura, cru",
				"Feijão-de-vaca, semente imatura, cozido, sólido, sem sal",
				"Feijão-de-vaca, semente imatura, congelado, sem preparo",
				"Feijão-de-vaca, semente imatura, congelado, cozido, sólido, sem sal",
				"Feijão-de-vaca, vagem jovem com semente, cru",
				"Feijão-de-vaca, vagem jovem com semente, cozido, sólido, sem sal",
				"Feijão-de-vaca, folha, cru",
				"Feijão-de-vaca, folha, cozido, sólido, sem sal",
				"Feijão-soja, verde, cru",
				"Feijão-soja, verde, cozido, sólido, sem sal",
				"Feijão-soja, semente madura, broto, cru",
				"Feijão-soja, semente madura, broto, cozido, fogo baixo",
				"Feijão-soja, semente madura, broto, cozido, frito",
				"Feijão, semente madura, broto, cozido, sólido, com sal",
				"Feijão-de-lima, semente imatura, cozido, sólido, com sal",
				"Feijão-de-lima, semente imatura, lata, sem sal, sólido e líquido",
				"Feijão-de-lima, semente imatura, congelado, baby, cozido, sólido, com sal",
				"Feijão-de-lima, semente imatura, congelado, cozido, sólido, com sal",
				"Feijão-de-vaca, semente imatura, cozido, sólido, com sal",
				"Feijão-de-vaca, semente imatura, congelado, cozido, sólido, com sal",
				"Feijão-de-vaca, vagem jovem com semente, cozido, sólido, com sal",
				"Feijão-de-vaca, cozido, sólido, com sal",
				"Feijão-soja, verde, cozido, sólido, com sal",
				"Feijão-soja, semente madura, broto, cozido, ao vapor, com sal",
				"Feijão-soja, semente madura, broto, cozido, frito, com sal",
				"Feijão, azuki, semente madura, cru",
				"Feijão, azuki, semente madura, cozido, sem sal",
				"Feijão, azuki, semente madura, lata, adoçado",
				"Feijão, azuki, semente madura",
				"Feijão, cozido, preparo caseiro",
				"Feijão, cozido, lata, natural ou vegetariano",
				"Feijão, cozido, lata, com carne",
				"Feijão, cozido, lata, com salsicha",
				"Feijão, cozido, lata, com carne suína",
				"Feijão, cozido, lata, com carne suína e molho doce",
				"Feijão, cozido, lata, com carne suína e molho de tomate",
				"Feijão, preto, semente madura, cru",
				"Feijão, preto, semente madura, cozido, sem sal",
				"Feijão, todos os tipos, semente madura, cru",
				"Feijão, todos os tipos, semente madura, cozido, sem sal",
				"Feijão, todos os tipos, semente madura, lata",
				"Feijão, rosinha, semente madura, cru",
				"Feijão, rosinha, semente madura, cozido, sem sal",
				"Feijão, branco, semente madura, cru",
				"Feijão, branco, semente madura, cozido, sem sal",
				"Feijão, branco, semente madura, lata",
				"Chili com feijão, lata",
				"Feijão-de-vaca, Catjang, semente madura, cru",
				"Feijão-de-vaca, Catjang, semente madura, cozido, sem sal",
				"Feijão-de-vaca, comum, semente madura, cru",
				"Feijão-de-vaca, comum, semente madura, cozido, sem sal",
				"Feijão-de-vaca, comum, semente madura, lata, natural",
				"Feijão-de-vaca, comum, semente madura, lata, com carne suína",
				"Feijão-de-lima, grande, semente madura, cru",
				"Feijão-de-lima, grande, semente madura, cozido, sem sal",
				"Feijão-de-lima, grande, semente madura, lata",
				"Feijão-de-lima, baby, semente madura, cru",
				"Feijão-de-lima, baby, semente madura, cozido, sem sal",
				"Feijão-soja, semente madura, cru",
				"Feijão-soja, madura, cozido, sem sal",
				"Feijão-soja, semente madura, assado, salgada",
				"Feijão-soja, semente madura, torrada",
				"Feijão, azuki, semente madura, cozido, com sal",
				"Feijão, preto, semente madura, cozido, com sal",
				"Feijão, todos os tipos, semente madura, cozido, com sal",
				"Feijão, vermelho, semente madura, cozido, com sal",
				"Feijão, branco, semente madura, cozido, com sal",
				"Feijão, rosinha, semente madura, cozido, com sal",
				"Feijão, rajadinho, semente madura, cozido, com sal",
				"Feijão-de-vaca, comum, semente madura, cozido, com sal",
				"Feijão-de-lima, grande, semente madura, cozidocom sal",
				"Feijão-de-lima, baby, semente madura, cozido, com sal",
				"Feijão-soja, semente madura, cozida, com sal",
				"Feijão-soja, semente madura, assado, sem sal",
				"Óleo, vegetal, farelo de arroz",
				"Sopa, galinha com arroz, lata, encorpado, pronto para consumo",
				"Sopa, galinha com arroz, lata, concentrada, varejo",
				"Sopa, tomate e arroz, lata, condensada, varejo",
				"Sopa, galinha com arroz, desidratado, fórmula seca",
				"Sopa, galinha com arroz, lata, preparo com igual volume de água, varejo",
				"Sopa, tomate com arroz, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com arroz, desidratado, preparo com água",
				"Pão, farelo de arroz",
				"Pão, farelo de arroz, tostado",
				"Sobremesas, pudim, arroz, pronto para consumo",
				"Sobremesas, pudim, arroz, mistura seca",
				"Sobremesas, pudim, arroz, mistura seca, preparo com leite integral",
				"Sobremesas, pudim, Arroz, mistura seca, preparo com leite desnatado",
				"Arroz, integral, grão longo, cru",
				"Arroz, integral, grão longo, cozido",
				"Arroz, integral, grão médio, cru",
				"Arroz, integral, grão médio, cozido",
				"Arroz, branco, grão longo, normal, cru, enriquecido",
				"Arroz, branco, grão longo, normal, cozido",
				"Arroz, branco, grão longo, pré-cozido, seco, enriquecido",
				"Arroz, branco, grão longo, pré-cozido, cozido, enriquecido",
				"Arroz, branco, grão longo, pré-cozido ou instantâneo, enriquecido, seco",
				"Arroz, branco, grão longo, pré-cozido ou instantâneo, enriquecido, preparado",
				"Arroz, branco, grão médio, cru, enriquecido",
				"Arroz, branco, grão médio, cozido",
				"Arroz, branco, grão curto, cru",
				"Arroz, branco, grão curto, cozido",
				"Arroz, branco, com glúten, cru",
				"Arroz, branco, com glúten, cozido",
				"Arroz, branco, com macarrão, seco",
				"Arroz, branco, com macarrão, cozido",
				"Farelo de arroz, cru",
				"Farinha de arroz, branco",
				"Arroz selvagem, cru",
				"Arroz selvagem, cozido",
				"Farinha de arroz, integral",
				"Macarrão, de arroz, seco",
				"Macarrão, de arroz, cozido",
				"Arroz, branco, grão longo, normal, cozido, enriquecido, com sal",
				"Arroz, branco, grão longo, normal, cru, não enriquecido",
				"Arroz, branco, grão longo, normal, cozido, não enriquecido, sem sal",
				"Arroz, branco, grão longo, pré-cozido, seco, não enriquecido",
				"Arroz, branco, grão longo, pré-cozido, cozido, não enriquecido",
				"Arroz, branco, grão médio, cru, não enriquecido",
				"Arroz, branco, grão médio, cozido, não enriquecido",
				"Arroz, branco, grão curto, cru, não enriquecido",
				"Arroz, branco, grão curto, cozido, não enriquecido",
				"Arroz, branco, grão longo, normal, cozido, não enriquecido, com sal",
				"Sopa, carne com macarrão, lata, concentrada, varejo",
				"Sopa, galinha com macarrão, lata, encorpado, pronto para consumo",
				"Sopa, galinha com macarrão, lata, concentrada, varejo",
				"Sopa, galinha com macarrão, com almôndegas, lata, encorpado, pronto para consumo",
				"Sopa, Lipton, Macarrão, e feijão, seca",
				"Sopa, Campbell's galinha com macarrão, lata, condensada",
				"Sopa, tomate carne com macarrão, lata, condensada, varejo",
				"Sopa, peru com macarrão, lata, condensada, varejo",
				"Sopa, carne com macarrão, desidratado, fórmula seca",
				"Sopa, galinha e macarrão, desidratado, fórmula seca",
				"Sopa, carne com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, tomate carne com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, peru com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, carne com macarrão, desidratado, preparo com água",
				"Sopa, galinha com macarrão, desidratado, preparo com água",
				"Molho, macarrão, espaguete/marinara, pronto para consumo",
				"Macarrão, chinês, celofane, desidratado",
				"Arroz, branco, com macarrão, seco",
				"Arroz, branco, com macarrão, cozido",
				"Macarrão, milho, seco",
				"Macarrão, milho, cozido",
				"Macarrão, massa fresca, natural, AS PURCHASED",
				"Macarrão, massa fresca, natural, cozido",
				"Macarrão, massa fresca, Espinafre, AS PURCHASED",
				"Macarrão, massa fresca, Espinafre, cozido",
				"Macarrão, caseiro, feito com ovos, cozido",
				"Macarrão, caseiro, feito sem ovos, cozido",
				"Macarrão, seco, enriquecido",
				"Macarrão, cozido, enriquecido",
				"Macarrão, proteína adicional, seco, enriquecido, N X 5.70",
				"Macarrão, proteína adicional, cozido, enriquecido, N X 5.70",
				"Macarrão, vegetal, seco, enriquecido",
				"Macarrão, vegetal, cozido, enriquecido",
				"Macarrão, trigo integral, seco",
				"Macarrão, trigo integral, cozido",
				"Macarrão, ovo, seco, enriquecido",
				"Macarrão, ovo, cozido, enriquecido",
				"Macarrão, ovo, espinafre, seco, enriquecido",
				"Macarrão, ovo, espinafre, cozido, enriquecido",
				"Macarrão, chinês, chow mein",
				"Macarrão, japonês, soba, seco",
				"Macarrão, japonês, soba, cozido",
				"Macarrão, japonês, somen, seco",
				"Macarrão, japonês, somen, cozido",
				"Macarrão, de arroz, seco",
				"Macarrão, de arroz, cozido",
				"Macarrão, proteína adicional, seco, enriquecido, N X 6.25",
				"Macarrão, proteína adicional, cozido, enriquecido, N X 6.25",
				"Macarrão, ovo, cozido, enriquecido, com sal",
				"Macarrão, cozido, não enriquecido",
				"Macarrão, ovo, seco, não enriquecido",
				"Macarrão, ovo, cozido, não enriquecido, sem sal",
				"Macarrão, seco, não enriquecido",
				"Macarrão, ovo, cozido, não enriquecido, com sal",
				"Prato rápido, salada, vegetais, temperada, sem molho, com macarrão e frutos do mar",
				"Frango capão, carne; pele; miúdos e pescoço, cru",
				"Frango capão, carne; pele; miúdos e pescoço, cozido, assado",
				"Frango capão, carne e pele, cru",
				"Frango capão, carne e pele, cozido, assado",
				"Frango capão, miúdos, cru",
				"Frango capão, miúdos, cozido, fogo baixo",
				"Fruta-pão, cru",
				"Semente de fruta-pão, crua",
				"Semente de fruta-pão, cozida",
				"Semente de fruta-pão, assada",
				"Pão, banana, caseiro, feito com margarina",
				"Pão, fubá, mistura seca, enriquecido",
				"Pão, fubá, mistura seca, preparada",
				"Pão, fubá, caseiro, feito com leite desnatado 2%gordura",
				"Pão, trigo-moído",
				"Pão, ovo",
				"Pão, ovo, tostado",
				"Pão, francês ou vienense inclui fermento",
				"Pão, francês ou vienense, tostado inclui fermento",
				"Pão, italiano",
				"Pão, grãos variados",
				"Pão, grãos variados, tostado",
				"Pão, farelo de aveia",
				"Pão, farelo de aveia, tostado",
				"Pão, aveia",
				"Pão, aveia, tostado",
				"Pão, sírio, branco, enriquecido",
				"Pão, sírio, trigo integral",
				"Pão, proteína inclui glúten",
				"Pão, centeio integral",
				"Pão, centeio integral, tostado",
				"Pão, uva-passa, enriquecido",
				"Pão, uva-passa, tostado, enriquecido",
				"Pão, caloria reduzida, farelo de aveia",
				"Pão, caloria reduzida, farelo de aveia, tostado",
				"Pão, caloria reduzida, aveia",
				"Pão, caloria reduzida, centeio",
				"Pão, caloria reduzida, trigo",
				"Pão, caloria reduzida, branco",
				"Pão, farelo de arroz",
				"Pão, centeio",
				"Pão, centeio, tostado",
				"Pão, trigo",
				"Pão, trigo, tostado",
				"Pão, farelo de trigo",
				"Pão, germe de trigo",
				"Pão, de forma, varejo",
				"Pão, de forma, varejo, tostado",
				"Pão, de forma, caseiro, feito com leite em pó sem gordura",
				"Pão, de forma, caseiro, feito com leite semi-desnatado 2% gordura",
				"Pão, trigo integral, varejo",
				"Pão, trigo integral, varejo, tostado",
				"Pão, trigo integral, receita caseira",
				"Pão, trigo integral, caseiro, tostado",
				"Palitos de pão, natural",
				"Pão de minuto, queijo",
				"Pão de minuto, coberto com canela, varejo, enriquecido",
				"Pão de minuto, recheio de creme com glacê de chocolate",
				"Pão de minuto, fruta",
				"Pão de minuto, coberto com canela, mistura seca",
				"Pão de minuto, coberto com canela, mistura seca, preparada",
				"Pão-de-ló, varejo, manteiga",
				"Pão-de-ló, varejo, exceto os com manteiga, enriquecido",
				"Pãozinho, refeição, natural, varejo",
				"Pãozinho, refeição, ovo",
				"Pãozinho, refeição, farelo de aveia",
				"Pãozinho, refeição, centeio",
				"Pãozinho, refeição, trigo",
				"Pãozinho, refeição, trigo integral",
				"Pãozinho, francês",
				"Pãozinho, hambúrger ou cachorro quente, natural",
				"Pãozinho, hambúrger ou cachorro quente, grãos variados",
				"Pãozinho, hambúrger ou cachorro quente, caloria reduzida",
				"Pãozinho doce, queijo",
				"Pãozinho doce, canela, varejo com uva passa",
				"Pãozinho doce, canela, farinha refrigerada, glaceado",
				"Pãozinho doce, canela, farinha refrigerada, glaceado, assado",
				"Pão, prteína, tostado inclui gluten",
				"Pão, farelo de arroz, tostado",
				"Pão, germe de trigo, tostado",
				"Pãozinho, refeição, natural, caseiro, feito com leite desnatado 2%gordura",
				"Pão, fubá, mistura seca, não enriquecido",
				"Pão, sírio, branco, não enriquecido",
				"Pão, uva passa, não enriquecido",
				"Pão, de forma, varejo, pobre em Na",
				"Pão de minuto, coberto com canela, varejo, não enriquecido",
				"Pão-de-ló, varejo, exceto os com manteiga, não enriquecido",
				"Pão, de forma, varejo, tostado, pobre em Na",
				"Pão-de-ló, varejo, sem gordura",
				"Farinha de trigo, branca, pão, enriquecida",
				"Queijo, mozarela, leite integral",
				"Queijo, mozarela, leite integral, baixa umidade",
				"Queijo, mozarela, leite semi-desnatado",
				"Queijo, mozarela, leite semi-desnatado, baixa umidade",
				"Queijo, ricota, leite integral",
				"Queijo, ricota, leite semi-desnatado",
				"Creme de leite, half and half",
				"Creme de leite, light café ou mesa",
				"Creme de leite azedo, semi-desnatado, cultivado",
				"Creme de leite azedo, cultivado",
				"Gemada Eggnog - ovos, açucar, leite, chantilly, uísque ou rum ou licor",
				"Leite, fluido, completado, com mistura de óleos vegetais hidrogenados",
				"Leite, fluido, completado, com ácido láurico",
				"Cobertura para sobremesa, pó, 42.5 g com 120 ml de leite",
				"Creme de leite azedo, imitação, cultivado",
				"Substituto de leite, fluido, com óleo vegetal hidrogenado",
				"Substituto de leite, fluido, com ácico láurico",
				"Leite, vaca, fluido, 3.25% de gordura",
				"Leite, vaca, direto da fazenda, fluido, 3.7% de gordura",
				"Leite, vaca, semi-desnatado, fluido, 2% de gordura, com vit A",
				"Leite, vaca, semi-desnatado, fluido, 2% de gordura, reconstituído sem gordura com vit A",
				"Leite, vaca, semi-desnatado, fluido, 2% de gordura, fortificado com proteina, com vit A",
				"Leite, vaca, magro, fluido, 1% de gordura, com vit A",
				"Leite, vaca, magro, fluido, 1% de gordura, reconstituído sem gordura&vit A",
				"Leite, vaca, magro, fluido, 1% de gordura, fortificado com proteina, com vit A",
				"Leite, vaca, sem gordura, fluido, com vit A desnatado",
				"Leite, vaca, sem gordura, fluido, reconstituído sem gordura&vit A desnatado",
				"Leite, vaca, sem gordura, fluido, fortificado com proteina, com vit A desnatado",
				"Leite, leitelho, fluido, cultivado, magro",
				"Leite, vaca, hipossódico, fluido",
				"Leite, vaca, pó, integral",
				"Leite, vaca, pó, desnatado, sem vit A",
				"Leite, vaca, pó, desnatado, instantâneo, com vit A",
				"Leite, vaca, pó, desnatado, cálcio reduzido",
				"Leite, leitelho, pó",
				"Leite, vaca, lata, condensado, com açucar",
				"Leite, vaca, lata, evaporado, sem vit A",
				"Leite, vaca, lata, evaporado, sem gordura",
				"Leite, achocolatado, fluido, varejo,",
				"Leite, achocolatado, fluido, varejo, semi-desnatado",
				"Leite, achocolatado, fluido, varejo, pouca gordura",
				"Leite, chocolate, chocolate quente, caseiro",
				"Leite, cabra, fluido",
				"Leite, humano, maduro, fluido",
				"Leite, búfalo indiano, fluido",
				"Leite, ovelha, fluido",
				"Soro do leite, ácido, fluido",
				"Soro do leite, ácido, pó",
				"Soro do leite, doce, fluido",
				"Soro do leite, doce, pó",
				"Iogurte, natural, leite integral, 8 g proteína por 227 g",
				"Leite, sem gordura, fluido, sem vit A desnatado",
				"Leite, semi-desnatado, fluido, 2% gordura, reconstituído sem gordura, sem vit A",
				"Leite, lata, evaporado, com vit A",
				"Leite, pó, sem gordura, com vit A",
				"Leite, pó, sem gordura, instantâneo, sem vit A",
				"Tempero para salada, maionese, artificial, creme de leite",
				"Peru, de leite, carne; pele; miúdos e pescoço, cru",
				"Peru, de leite, carne; pele; miúdos e pescoço, cozido, assado",
				"Peru, de leite, carne e pele, cru",
				"Peru, de leite, carne e pele, cozido, assado",
				"Peru, de leite, só carne, cru",
				"Peru, de leite, só carne, cozido, assado",
				"Peru, de leite, só pele, cru",
				"Peru, de leite, só pele, cozido, assado",
				"Peru, de leite, carne branca, carne e pele, cru",
				"Peru, de leite, carne branca, carne e pele, cozido, assado",
				"Peru, de leite, carne escura, carne e pele, cru",
				"Peru, de leite, carne escura, carne e pele, cozido, assado",
				"Peru, de leite, carne branca, só carne, cru",
				"Peru, de leite, carne branca, só carne, cozido, assado",
				"Peru, de leite, carne escura, só carne, cru",
				"Peru, de leite, carne escura, só carne, cozido, assado",
				"Peru, de leite, carcaça, carne e pele, cru",
				"Peru, de leite, carcaça, carne e pele, cozido, assado",
				"Peru, de leite, carcaça, só carne, cru",
				"Peru, de leite, carcaça, só carne, cozido, assado",
				"Peru, de leite, peito, carne e pele, cru",
				"Peru, de leite, peito, carne e pele, cozido, assado",
				"Peru, de leite, peito, só carne, cru",
				"Peru, de leite, peito, só carne, cozido, assado",
				"Peru, de leite, coxa com sobrecoxa, carne e pele, cru",
				"Peru, de leite, coxa com sobrecoxa, carne e pele, cozido, assado",
				"Peru, de leite, coxa com sobrecoxa, só carne, cru",
				"Peru, de leite, coxa com sobrecoxa, só carne, cozido, assado",
				"Peru, de leite, asa, carne e pele, cru",
				"Peru, de leite, asa, carne e pele, cozido, assado",
				"Peru, de leite, asa, só carne, cru",
				"Peru, de leite, asa, só carne, cozido, assado",
				"Peru de leite, sem osso, congelado, temperado, carne branca e escura, cru",
				"Peru de leite, sem osso, congelado, temperado, carne branca e escura, assado",
				"Sopa, creme de aspargos, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de salsão, lata, preparo com igual volume de leite, varejo",
				"Sopa, queijo, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de galinha, preparo com igual volume de leite, varejo",
				"Sopa, marisco, new england, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de cogumelo, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de cebola, lata, preparo com igual volume de leite, varejo",
				"Sopa, ostra cozida, lata, preparo com igual volume de leite, varejo",
				"Sopa, ervilha verde, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de batata, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de camarão, lata, preparo com igual volume de leite, varejo",
				"Sopa, tomate, lata, preparo com igual volume de leite, varejo",
				"Bockwurst, cru, porco, vitela, leite, ovos",
				"Purê de batata, preparo caseiro, leite integral e margarina",
				"Purê de batata, desidratado, flocos sem leite, pó",
				"Purê de batata, desidratado, flocos sem leite, leite integral e manteiga",
				"Purê de batata, desidratado, granulos sem leite, pó",
				"Purê de batata, desidratado, granulos sem leite, leite integral e manteiga",
				"Purê de batata, desidratado, granulos com leite, pó",
				"Purê de batata, desidratado, granulos com leite, água e margarina",
				"Batata, gratinada, mistura seca, preparo com água, leite integral e manteiga",
				"Batata, descascada, mistura seca, preparo com água, leite integral e manteiga",
				"Purê de batata, preparo caseiro, leite integral",
				"Purê de batata, preparado granular, sem leite, leite integral e margarina",
				"Purê de batata, preparado de flocos, sem leite, leite integral e margarina",
				"Purê de batata, preparo caseiro, leite integral e manteiga",
				"Leite de coco, cru",
				"Leite de coco, lata",
				"Leite de coco, congelado",
				"Chocolate, pó, preparado com leite",
				"Xarope de chocolate, sem adição de nutrientes, preparado com leite",
				"Refresco sabor morango, pó, preparado com leite",
				"Leite de soja, fluido",
				"Biscuits, natural ou soro do leite, varejo, assado",
				"Biscuits, natural ou soro do leite, mistura seca",
				"Biscuits, natural ou soro do leite, mistura seca, preparada",
				"Biscuits, natural ou soro do leite, farinha refrigerada, gordura reduzida",
				"Biscuits, natural ou soro do leite, farinha refrigerada, gordura reduzida, assado",
				"Biscuits, natural ou soro do leite, farinha refrigerada, alto teor em gordura",
				"Biscuits, natural ou soro do leite, farinha refrigerada, alto teor em gordura, assado",
				"Biscuits, natural ou soro do leite, receita caseira",
				"Pão, fubá, caseiro, feito com leite desnatado 2%gordura",
				"Pão, de forma, caseiro, feito com leite em pó sem gordura",
				"Pão, de forma, caseiro, feito com leite semi-desnatado 2% gordura",
				"Bolacha, leite",
				"Panqueca, soro do leite, receita caseira",
				"Pãozinho, refeição, natural, caseiro, feito com leite desnatado 2%gordura",
				"Barra de granola, mole, cobertura, chocolate ao leite, pingos de chocolate",
				"Barra de granola, mole, cobertura, chocolate ao leite, creme de amendoim",
				"Doce, chocolate ao leite",
				"Doce, cremoso coberto de chocolate ao leite",
				"Doce, chocolate ao leite",
				"Sobremesas, pudim, banana, mistura seca, instantânea, preparo com leite desnatado",
				"Sobremesas, pudim, banana, mistura seca, normal, preparo com leite desnatado",
				"Sobremesas, pudim, chocolate, mistura seca, instantânea, preparo com leite desnatado",
				"Doce, amendoim coberto de chocolate ao leite",
				"Doce, uva-passa coberta de chocolate ao leite",
				"Doce, chocolate ao leite, com amêndoas",
				"Doce, M&M MARS, M&MS mini chocolate ao leite",
				"Sobremesas, pudim de ovos, mistura seca, preparo com leite integral",
				"Sobremesas, pudim, chocolate, mistura seca, normal, preparo com leite integral",
				"Sobremesas, pudim, chocolate, mistura seca, normal, preparo com leite desnatado",
				"Sobremesas, pudim, creme de coco, mistura seca, instantânea, preparo com leite desnatado",
				"Sobremesas, pudim, arroz, mistura seca, preparo com leite integral",
				"Sobremesas, pudim, tapioca, mistura seca, preparo com leite integral",
				"Sobremesas, pudim, limão, mistura seca, instantânea, preparo com leite desnatado",
				"Sobremesas, pudim de ovos, mistura seca, preparo com leite desnatado",
				"Sobremesas, pudim, baunilha, mistura seca, normal, preparo com leite integral",
				"Sobremesas, pudim, Arroz, mistura seca, preparo com leite desnatado",
				"Sobremesas, pudim, tapioca, mistura seca, preparo com leite desnatado",
				"Sobremesas, pudim, baunilha, mistura seca, normal, preparo com leite desnatado",
				"Sobremesas, pudim, creme de coco, mistura seca, normal, preparo com leite desnatado",
				"Sobremesas, flan, pudim de caramelo, mistura seca, preparo com leite desnatado",
				"Sobremesas, flan, pudim de caramelo, mistura seca, preparo com leite integral",
				"Sobremesas, pudim, banana, mistura seca, instantânea, preparo com leite integral",
				"Sobremesas, pudim, banana, mistura seca, normal, preparo com leite integral",
				"Sobremesas, pudim, creme de coco, mistura seca, instantânea, preparo com leite integral",
				"Sobremesas, pudim, creme de coco, mistura seca, normal, preparo com leite integral",
				"Sobremesas, pudim, limão, mistura seca, instantânea, preparo com leite integral",
				"Prato rápido, sorvete, leite, baunilha, de máquina, com cone",
				"Sopa, lentilha com presunto, lata, pronto para consumo",
				"Sopa, ervilha seca, com presunto, lata, encorpado, pronto para consumo",
				"Sopa, ervilha seca, com presunto, lata, concentrada, varejo",
				"Sopa, ervilha seca, com presunto, lata, preparo com igual volume de água, varejo",
				"Presunto, pedaços, lata",
				"Presunto, pedaços, não enlatado",
				"Presunto, fatiado, extra magro, aprox 5% gordura",
				"Presunto, fatiado, normal aprox 11% gordura",
				"Presunto, picado",
				"Pasta de presunto",
				"Pasta ou bastão de presunto e queijo",
				"Pasta de presunto e queijo",
				"Porco, curado, presunto, sem osso, extra magro aprox 5% gordura, assado",
				"Porco, curado, presunto, sem osso, normal aprox 11% gordura, assado",
				"Porco, curado, presunto, extra magro aprox 4% gordura, lata, sem aquecer",
				"Porco, curado, presunto, extra magro aprox 4% gordura, lata, assado",
				"Porco, curado, presunto, normal aprox 13% gordura, lata, sem aquecer",
				"Porco, curado, presunto, normal aprox 13% gordura, lata, assado",
				"Porco, curado, presunto, inteiro, carne magra e gordura, sem aquecer",
				"Porco, curado, presunto, inteiro, carne magra e gordura, assado",
				"Porco, curado, presunto, inteiro, só a parte magra, sem aquecer",
				"Porco, curado, presunto, inteiro, só a parte magra, assado",
				"Porco, curado, presunto, sem osso, extra magro e normal, sem aquecer",
				"Porco, curado, presunto, sem osso, extra magro e normal, assado",
				"Porco, curado, presunto, extra magro e normal, lata, sem aquecer",
				"Porco, curado, presunto, extra magro e normal, lata, assado",
				"Prato rápido, enroladinho, com ovos e presunto",
				"Prato rápido, enroladinho, com presunto",
				"Prato rápido, croissant, com ovo, queijo e presunto",
				"Prato rápido, salada, vegetais, temperada, sem molho, com peru, presunto e queijo",
				"Prato rápido, cheesebúrger, grande, simples, com presunto, condimentos e vegetais",
				"Prato rápido, sanduíche de presunto e queijo",
				"Prato rápido, sanduíche de presunto, ovo e queijo",
				"Tempero para salada, francês, diet, 5 cal por colher de sopa, com sal",
				"Tempero para salada, italiano, varejo, diet, 2 cal por colher de sopa, com sal",
				"Tempero para salada, thousand island, diet, 10 cal por colher de sopa, com sal",
				"Tempero para salada, francês, diet, 5 cal por colher de sopa, sem sal",
				"Tempero para salada, italiano, varejo, diet, 2 cal por colher de sopa, sem sal",
				"Frango, carne; pele; miúdos e pescoço, ensopado",
				"Frango, carne e pele, cozido, ensopado",
				"Frango, só carne, ensopado",
				"Frango, só pele, cozido, ensopado",
				"Frango, carne branca, carne e pele, cozido, ensopado",
				"Frango, carne escura, carne e pele, cozido, ensopado",
				"Frango, carne branca, só carne, cozido, ensopado",
				"Frango, carne escura, só carne, cozido, ensopado",
				"Frango, carcaça, carne e pele, cozido, ensopado",
				"Frango, carcaça, só carne, cozido, ensopado",
				"Frango, peito, carne e pele, cozido, ensopado",
				"Frango, peito, só carne, cozido, ensopado",
				"Frango, coxa, carne e pele, cozido, ensopado",
				"Frango, coxa, só carne, cozido, ensopado",
				"Frango, coxa com sobrecoxa, carne e pele, cozido, ensopado",
				"Frango, coxa com sobrecoxa, só carne, cozido, ensopado",
				"Frango, sobrecoxa, carne e pele, cozido, ensopado",
				"Frango, sobrecoxa, só carne, cozido, ensopado",
				"Frango, asa, carne e pele, cozido, ensopado",
				"Frango, asa, só carne, cozido, ensopado",
				"Galinha, carne e pele, &GIBLETS&NECK, cozido, ensopado",
				"Galinha, carne e pele, cozido, ensopado",
				"Galinha, só carne, cozido, ensopado",
				"Galinha, carne branca, só carne, cozido, ensopado",
				"Galinha, carne escura, só carne, cozido, ensopado",
				"Sopa, creme de aspargos, lata, concentrada, varejo",
				"Sopa, feijão preto, lata, concentrada, varejo",
				"Sopa, feijão com porco, lata, concentrada, varejo",
				"Sopa, feijão com salsicha, lata, concentrada, varejo",
				"Sopa, feijão com presunto, lata, encorpado, pronto para consumo, varejo",
				"Sopa, consomê de carne, lata, pronto para consumo",
				"Sopa, carne com macarrão, lata, concentrada, varejo",
				"Sopa, creme de salsão, lata, concentrada, varejo",
				"Sopa, queijo, lata, concentrada, varejo",
				"Sopa, galinha com massa, lata, concentrada, varejo",
				"Sopa, consomê de galinha, lata, concentrada, varejo",
				"Sopa, galinha, lata, encorpado, pronto para consumo, varejo",
				"Sopa, creme de galinha, lata, concentrada, varejo",
				"Sopa, galinha com macarrão, lata, encorpado, pronto para consumo",
				"Sopa, galinha com macarrão, lata, concentrada, varejo",
				"Sopa, galinha com macarrão, com almôndegas, lata, encorpado, pronto para consumo",
				"Sopa, galinha com arroz, lata, encorpado, pronto para consumo",
				"Sopa, galinha com arroz, lata, concentrada, varejo",
				"Sopa, galinha com vegetais, lata, encorpado, pronto para consumo",
				"Sopa, galinha com vegetais, lata, concentrada, varejo",
				"Sopa, carne com chili, lata, concentrada, varejo",
				"Sopa, marisco, estilo manhattan, lata, encorpado, pronto para consumo",
				"Sopa, marisco, estilo manhattan, lata, concentrada, varejo",
				"Sopa, marisco, estilo new england, lata, concentrada, varejo",
				"Sopa, Lipton, Macarrão, e feijão, seca",
				"Sopa, consomê de carne, lata, concentrada, varejo",
				"Sopa, Lipton, cebola, seca",
				"Sopa, caranguejo, lata, pronto para consumo",
				"Sopa, escarola, lata, pronto para consumo",
				"Sopa, gazpacho, lata, pronto para consumo",
				"Sopa, lentilha com presunto, lata, pronto para consumo",
				"Sopa, minestrone, lata, encorpado, pronto para consumo",
				"Sopa, minestrone, lata, concentrada, varejo",
				"Sopa, cogumelo cevada, lata, concentrada, varejo",
				"Sopa, creme de cogumelo, lata, concentrada, varejo",
				"Sopa, cogumelo com caldo de carne, lata, concentrada, varejo",
				"Sopa, cebola, lata, concentrada, varejo",
				"Sopa, creme de cebola, lata, concentrada, varejo",
				"Sopa, ostra cozida, lata, concentrada, varejo",
				"Sopa, ervilha verde, lata, concentrada, varejo",
				"Sopa, ervilha seca, com presunto, lata, encorpado, pronto para consumo",
				"Sopa, ervilha seca, com presunto, lata, concentrada, varejo",
				"Sopa, creme de batata, lata, concentrada",
				"Sopa, consomê de carne legumes e cevada, lata, condensada, varejo",
				"Sopa, creme de camarão, lata, condensada",
				"Sopa, Campbell's galinha com macarrão, lata, condensada",
				"Sopa, tomate carne com macarrão, lata, condensada, varejo",
				"Sopa, tomate e arroz, lata, condensada, varejo",
				"Sopa, peru, encorpado, pronto para consumo",
				"Sopa, peru com macarrão, lata, condensada, varejo",
				"Sopa, peru com vegetais, lata, condensada, varejo",
				"Sopa, vegetais, lata, encorpado, pronto para consumo, varejo",
				"Sopa, vegetariana, lata, condensada, varejo",
				"Sopa, carne, lata, encorpado, pronto para consumo",
				"Sopa, carne com vegetais, lata, condensada, varejo",
				"Sopa, vegetais com consomê de carne, lata, condensada, varejo",
				"Sopa, creme de aspargos, desidratado, mistura seca",
				"Sopa, feijão com bacon, desidratado, mistura seca",
				"Sopa, consomê de carne, pó, seco",
				"Sopa, consomê de carne, cubos, seco",
				"Sopa, carne com macarrão, desidratado, fórmula seca",
				"Sopa, couve-flor, desidratado, mistura seca",
				"Sopa, creme de salsão, desidratado, seco",
				"Sopa, consomê de galinha, pó, seco",
				"Sopa, consomê de galinha, cubos, desidratado, seco",
				"Sopa, creme de galinha, desidratado, seco",
				"Sopa, galinha com arroz, desidratado, fórmula seca",
				"Sopa, galinha com vegetais, desidratado, seco",
				"Sopa, marisco, estilo manhattan, desidratado, seco",
				"Sopa, marisco, estilo new england, desidratado, seco",
				"Sopa, consomê com gelatina, desidratado, seco",
				"Sopa, alho-porro, desidratado, seco",
				"Sopa, minestrone, desidratado, seco",
				"Sopa, cogumelo, desidratado, seco",
				"Sopa, cebola, desidratado, fórmula seca",
				"Sopa, rabada, desidratado, seco",
				"Sopa, ervilha verde, desidratado, fórmula seca",
				"Sopa, tomate, desidratado, seco",
				"Sopa, tomate e vegetais, desidratado, fórmula seca",
				"Sopa, vegetais e carne, desidratada, seca",
				"Sopa, creme de vegetais, desidratada, seca",
				"Sopa, galinha e macarrão, desidratado, fórmula seca",
				"Sopa, carne e cogumelo, lata, condensada, varejo",
				"Sopa, galinha e cogumelo, lata, condensada, varejo",
				"Sopa, tomate, lata, concentrada, varejo",
				"Sopa, caldo de peixe, receita caseira",
				"Sopa, barbatana de tubarão, restaurante",
				"Sopa, creme de aspargos, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de salsão, lata, preparo com igual volume de leite, varejo",
				"Sopa, queijo, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de galinha, preparo com igual volume de leite, varejo",
				"Sopa, marisco, new england, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de cogumelo, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de cebola, lata, preparo com igual volume de leite, varejo",
				"Sopa, ostra cozida, lata, preparo com igual volume de leite, varejo",
				"Sopa, ervilha verde, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de batata, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de camarão, lata, preparo com igual volume de leite, varejo",
				"Sopa, tomate, lata, preparo com igual volume de leite, varejo",
				"Sopa, creme de aspargos, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão preto, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão com porco, lata, preparo com igual volume de água, varejo",
				"Sopa, feijão com salsicha, lata, preparo com igual volume de água, varejo",
				"Sopa, carne com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de salsão, lata, preparo com igual volume de água, varejo",
				"Sopa, queijo, lata, preparo com igual volume de água, varejo",
				"Sopa, consomê de galinha, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de galinha, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com arroz, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com vegetais, lata, preparo com igual volume de água, varejo",
				"Sopa, chili com carne, lata, preparo com igual volume de água, varejo",
				"Sopa, marisco, estilo manhattan, lata, preparo com igual volume de água",
				"Sopa, marisco, estilo new england, lata, preparo com igual volume de água, varejo",
				"Sopa, consomê de carne, preparo com igual volume de água, varejo",
				"Sopa, minestrone, lata, preparo com igual volume de água, varejo",
				"Sopa, cogumelo cevada, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de cogumelo, lata, preparo com igual volume de água, varejo",
				"Sopa, cogumelo com caldo de carne, lata, preparo com igual volume de água, varejo",
				"Sopa, cebola, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de cebola, lata, preparo com igual volume de água, varejo",
				"Sopa, ostra cozida, lata, preparo com igual volume de água, varejo",
				"Sopa, ervilha verde, lata, preparo com igual volume de água, varejo",
				"Sopa, ervilha seca, com presunto, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de batata, lata, preparo com igual volume de água, varejo",
				"Sopa, consomê de carne legumes e cevada, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de camarão, lata, preparo com igual volume de água, varejo",
				"Sopa, tomate carne com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, tomate com arroz, lata, preparo com igual volume de água, varejo",
				"Sopa, peru com macarrão, lata, preparo com igual volume de água, varejo",
				"Sopa, peru com vegetais, lata, preparo com igual volume de água, varejo",
				"Sopa, vegetariana, lata, preparo com igual volume de água, varejo",
				"Sopa, vegetais com carne, preparo com igual volume de água, varejo",
				"Sopa, vegetais com consomê de carne, lata, preparo com igual volume de água, varejo",
				"Sopa, creme de aspargos, desidratado, preparo com água",
				"Sopa, feijão com bacon, desidratado, preparo com água",
				"Sopa, consomê de carne, pó, preparo com água",
				"Sopa, consomê de carne, cubos, preparo com água",
				"Sopa, carne com macarrão, desidratado, preparo com água",
				"Sopa, couve-flor, desidratado, preparo com água",
				"Sopa, creme de salsão, desidratado, preparo com água",
				"Sopa, consomê de galinha, desidratado, preparo com água",
				"Sopa, consomê de galinha, cubos, desidratado, preparo com água",
				"Sopa, creme de galinha, desidratado, preparo com água",
				"Sopa, galinha com arroz, desidratado, preparo com água",
				"Sopa, galinha com vegetais, desidratado, preparo com água",
				"Sopa, consomê com gelatina, desidratado, preparo com água",
				"Sopa, alho-porro, desidratado, preparo com água",
				"Sopa, minestrone, desidratado, preparo com água",
				"Sopa, cogumelo, desidratado, preparo com água",
				"Sopa, cebola, desidratada, preparo com água",
				"Sopa, rabada, desidratada, preparo com água",
				"Sopa, ervilha verde, desidratada, preparo com água",
				"Sopa, tomate, desidratado, preparo com água",
				"Sopa, tomate e vegetais, desidratado, preparo com água",
				"Sopa, vegetais com carne, desidratado, preparo com água",
				"Sopa, creme de vegetais, desidratado, preparo com água",
				"Sopa, galinha com macarrão, desidratado, preparo com água",
				"Sopa, carne com cogumelo, lata, preparo com igual volume de água, varejo",
				"Sopa, galinha com cogumelo, lata, preparo com igual volume de água, varejo",
				"Sopa, tomate, lata, preparo com igual volume de água, varejo",
				"Maçã, desidratada baixa umidade, sulfurada, ensopado",
				"Damasco, desidratado baixa umidade, sulfurada, ensopado",
				"Pêssego, desidratado baixa umidade, sulfurada, ensopado",
				"Tomate, vermelho, maduro, lata, ensopado",
				"Tomate, vermelho, maduro, cozido, ensopado",
				"Caça, coelho, criação, cozido, ensopado",
				"Caça, coelho, selvagem, cozido, ensopado",
				"Frango, carne; pele; miúdos e pescoço, cru",
				"Frango, carne; pele; miúdos e pescoço, frito, à milanesa",
				"Frango, carne; pele; miúdos e pescoço, frito, farinha",
				"Frango, carne; pele; miúdos e pescoço, assado",
				"Frango, carne; pele; miúdos e pescoço, ensopado",
				"Frango, carne e pele, crua",
				"Frango, carne e pele, cozido, frito, à milanesa",
				"Frango, carne e pele, cozido, frito, farinha",
				"Frango, carne e pele, cozido, assado",
				"Frango, carne e pele, cozido, ensopado",
				"Frango, só carne, crua",
				"Frango, só carne, cozido, frito",
				"Frango, só carne, assado",
				"Frango, só carne, ensopado",
				"Frango, só pele, crua",
				"Frango, só pele, cozido, frito, à milanesa",
				"Frango, só pele, cozido, frito, farinha",
				"Frango, só pele, cozido, assado",
				"Frango, só pele, cozido, ensopado",
				"Frango, miúdos, cru",
				"Frango, miúdos, cozido, frita",
				"Frango, miúdos, cozido, fogo baixo",
				"Frango, moela, todas espécies, crua",
				"Frango, carne branca, carne e pele, crua",
				"Frango, carne branca, carne e pele, cozido, frita, à milanesa",
				"Frango, carne branca, carne e pele, cozido, frita, farinha",
				"Frango, carne branca, carne e pele, cozido, assado",
				"Frango, carne branca, carne e pele, cozido, ensopado",
				"Frango, carne escura, carne e pele, crua",
				"Frango, carne escura, carne e pele, cozido, frita, à milanesa",
				"Frango, carne escura, carne e pele, cozido, frita, farinha",
				"Frango, carne escura, carne e pele, cozido, assado",
				"Frango, carne escura, carne e pele, cozido, ensopado",
				"Frango, carne branca, só carne, crua",
				"Frango, carne branca, só carne, cozido, frita",
				"Frango, carne branca, só carne, cozido, assado",
				"Frango, carne branca, só carne, cozido, ensopado",
				"Frango, carne escura, só carne, crua",
				"Frango, carne escura, só carne, cozido, frita",
				"Frango, carne escura, só carne, cozido, assado",
				"Frango, carne escura, só carne, cozido, ensopado",
				"Frango, gordura, crua",
				"Frango, carcaça, carne e pele, cru",
				"Frango, carcaça, carne e pele, cozido, frito, à milanesa",
				"Frango, carcaça, carne e pele, cozido, frito, farinha",
				"Frango, carcaça, carne e pele, cozido, assado",
				"Frango, carcaça, carne e pele, cozido, ensopado",
				"Frango, carcaça, só carne, crua",
				"Frango, carcaça, só carne, cozido, frito",
				"Frango, carcaça, só carne, cozido, assado",
				"Frango, carcaça, só carne, cozido, ensopado",
				"Frango, peito, carne e pele, cru",
				"Frango, peito, carne e pele, cozido, frito, à milanesa",
				"Frango, peito, carne e pele, cozido, frito, farinha",
				"Frango, peito, carne e pele, cozido, assado",
				"Frango, peito, carne e pele, cozido, ensopado",
				"Frango, peito, só carne, cru",
				"Frango, peito, só carne, cozido, frito",
				"Frango, peito, só carne, cozido, assado",
				"Frango, peito, só carne, cozido, ensopado",
				"Frango, coxa, carne e pele, crua",
				"Frango, coxa, carne e pele, cozido, frita, à milanesa",
				"Frango, coxa, carne e pele, cozido, frita, farinha",
				"Frango, coxa, carne e pele, cozido, assado",
				"Frango, coxa, carne e pele, cozido, ensopado",
				"Frango, coxa, só carne, crua",
				"Frango, coxa, só carne, cozido, frita",
				"Frango, coxa, só carne, cozido, assado",
				"Frango, coxa, só carne, cozido, ensopado",
				"Frango, coxa com sobrecoxa, carne e pele, cru",
				"Frango, coxa com sobrecoxa, carne e pele, cozido, frita, à milanesa",
				"Frango, coxa com sobrecoxa, carne e pele, cozido, frita, farinha",
				"Frango, coxa com sobrecoxa, carne e pele, cozido, assado",
				"Frango, coxa com sobrecoxa, carne e pele, cozido, ensopado",
				"Frango, coxa com sobrecoxa, só carne, cru",
				"Frango, coxa com sobrecoxa, só carne, cozido, frita",
				"Frango, coxa com sobrecoxa, só carne, cozido, assado",
				"Frango, coxa com sobrecoxa, só carne, cozido, ensopado",
				"Frango, pesoço, carne e pele, cru",
				"Frango, pesoço, carne e pele, cozido, frita, à milanesa",
				"Frango, pesoço, carne e pele, cozido, frita, farinha",
				"Frango, pesoço, carne e pele, cozido fogo baixo",
				"Frango, pesoço, só carne, cru",
				"Frango, pesoço, só carne, cozido, frita",
				"Frango, pesoço, só carne, cozido, fogo baixo",
				"Frango, sobrecoxa, carne e pele, cru",
				"Frango, sobrecoxa, carne e pele, cozido, frita, à milanesa",
				"Frango, sobrecoxa, carne e pele, cozido, frita, farinha",
				"Frango, sobrecoxa, carne e pele, cozido, assado",
				"Frango, sobrecoxa, carne e pele, cozido, ensopado",
				"Frango, sobrecoxa, só carne, cru",
				"Frango, sobrecoxa, só carne, cozido, frita",
				"Frango, sobrecoxa, só carne, cozido, assado",
				"Frango, sobrecoxa, só carne, cozido, ensopado",
				"Frango, asa, carne e pele, cru",
				"Frango, asa, carne e pele, cozido, frita, à milanesa",
				"Frango, asa, carne e pele, cozido, frita, farinha",
				"Frango, asa, carne e pele, cozido, assado",
				"Frango, asa, carne e pele, cozido, ensopado",
				"Frango, asa, só carne, cru",
				"Frango, asa, só carne, cozido, frita",
				"Frango, asa, só carne, cozido, assado",
				"Frango, asa, só carne, cozido, ensopado",
				"Frango capão, carne; pele; miúdos e pescoço, cru",
				"Frango capão, carne; pele; miúdos e pescoço, cozido, assado",
				"Frango capão, carne e pele, cru",
				"Frango capão, carne e pele, cozido, assado",
				"Frango capão, miúdos, cru",
				"Frango capão, miúdos, cozido, fogo baixo",
				"Salsicha, frango",
				"Pasta de frango",
				"Prato rápido, frango, empanado e frito, coxa ou sobre-coxa",
				"Prato rápido, frango, empanado e frito, peito ou asa",
				"Prato rápido, salada, vegetais, temperada, sem molho, com frango",
				"Prato rápido, filet de frango, natural",
				"Prato rápido, filet de frango, com queijo"};
		
		List<String> alimentos = new ArrayList<String>();
		
		for (int i = 0; i < strings.length; i++) {
			alimentos.add(strings[i]);
		}
		return alimentos;
	}
	
	
	
}
