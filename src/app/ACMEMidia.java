package app;

import dados.Midiateca;

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

	private final String nomeArquivoEntrada = "dadosin.txt";

	private final String nomeArquivoSaida = "dadosout.txt";

	private Midiateca midiateca;

	public ACMEMidia() {
		this.midiateca = new Midiateca();
	}

	public void executa() {

	}

	private void cadastraVideo (){
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
