package app;

import dados.Categoria;
import dados.Midia;
import dados.Midiateca;
import dados.Video;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMEMidia {
	private Scanner entrada = new Scanner(System.in);

	private PrintStream saidaPadrao = System.out;

	private final String nomeArquivoEntrada = "entrada.txt";

	private final String nomeArquivoSaida = "saida.txt";

	private Midiateca midiateca;

	public ACMEMidia() {
		this.midiateca = new Midiateca();
		redirecionaES();
	}

	public void executa() {
			cadastraVideo();
	}

	private void cadastraVideo (){ //1
		while (true) {
			int codigo = Integer.parseInt(entrada.nextLine());
			if (codigo == -1) {
				break;
			}
			if (midiateca.consultaPorCodigo(codigo) != null) {
				System.out.println("1:Erro-video com codigo repetido:" + codigo);
				break;
			}
			String titulo = entrada.nextLine();
			int ano = Integer.parseInt(entrada.nextLine());
			Categoria categoria = Categoria.valueOf(entrada.nextLine().toUpperCase());
			int qualidade = Integer.parseInt(entrada.nextLine());

			Midia novaMidia = new  Video(codigo, titulo,  ano,  categoria, qualidade);
			midiateca.cadastraMidia(novaMidia);
			System.out.println("1: " + novaMidia);
		}
	}


	/*********************************************************************************
	 //METODO PRONTO PRA REDIRECIONAR ENTRADA E SAIDA DE DADOS
	 ********************************************************************************/
	private void redirecionaES() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
			entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
			PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
			System.setOut(streamSaida);             // Usa como saida um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
		entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
	}
}
