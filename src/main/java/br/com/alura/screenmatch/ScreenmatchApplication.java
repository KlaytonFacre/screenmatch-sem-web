package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O Sprint terminou o bootstrap... Iniciando o código da aplicação");

		String serie = "Gilmore Girls";
		String endereco = "https://www.omdbapi.com/?t=" + java.net.URLEncoder.encode(serie, java.nio.charset.StandardCharsets.UTF_8) + "&apikey=22ed2015";

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
