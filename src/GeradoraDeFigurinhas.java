import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream,String nomeArquivo) throws Exception {
//		leitura da imagem
//		InputStream inputStream = new FileInputStream("Filme1.jpg");
//		InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
//		Está na classe Cliente HTTP
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
//		cria nova imagem em memória com transparencia e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
//		copiar a imagem original pra nova imagem em memória
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
//		Configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.RED);
		graphics.setFont(fonte);
		
//		Escrever uma frase na nova imagem
		graphics.drawString("Bacana", 100, novaAltura - 100);
//		Escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}
	
}
