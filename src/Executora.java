import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Executora {

	public static void main(String[] args) throws Exception {

//		Fazer uma conexão http e buscar os top 250 filmes
		String url = "https://saulo-linguagens-api.herokuapp.com/linguagens";
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
//		Extrair (parsear) os dados importantes ( titulo, nota e poster)
//		Está nas extratoras
//		exbir e manipular os dados 
		var extrator = new ExtratorDeConteudoDoIMDB();
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();
		
		for (int i = 0; i < 3; i++) {
			Conteudo conteudo = conteudos.get(i);
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = conteudo.getTitulo().replace(":","") + ".png";
			geradora.cria(inputStream, nomeArquivo);
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
		
		
		
		
		
	}

}
