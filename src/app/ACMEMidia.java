package app;

import dados.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        cadastraMusica();
        consultaMidiaPorCodigo();
		consultaMidiaPorCategoria();
		consultaVideoPorQualidade();
    }



	private void cadastraVideo() { //1
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

            Midia novaMidia = new Video(codigo, titulo, ano, categoria, qualidade);
            midiateca.cadastraMidia(novaMidia);
            System.out.println("1:" + novaMidia);
        }
    }

    private void cadastraMusica() { //2
        while (true) {
            int codigo = Integer.parseInt(entrada.nextLine());
            if (codigo == -1) {
                break;
            }
            if (midiateca.consultaPorCodigo(codigo) != null) {
                System.out.println("2:Erro-musica com codigo repetido:" + codigo);
                break;
            }
            String titulo = entrada.nextLine();
            int ano = Integer.parseInt(entrada.nextLine());
            Categoria categoria = Categoria.valueOf(entrada.nextLine().toUpperCase());
            double duracao = Double.parseDouble(entrada.nextLine());

            Midia novaMidia = new Musica(codigo, titulo, ano, categoria, duracao);
            midiateca.cadastraMidia(novaMidia);
            System.out.println("2:" + novaMidia);
        }
    }

    private void consultaMidiaPorCodigo() { //3
        int codigoConsultado = entrada.nextInt();
        Midia midiaConsultada = midiateca.consultaPorCodigo(codigoConsultado);
        if (midiaConsultada != null) {
            if (midiaConsultada instanceof Video) {
                Video videoConsultado = (Video) midiaConsultada;
                videoConsultado.calculaLocacao();
                System.out.println("4:" + videoConsultado.toStringComLocacao());
            } else if (midiaConsultada instanceof Musica) {
                Musica musicaConsultada = (Musica) midiaConsultada;
                musicaConsultada.calculaLocacao();
                System.out.println("3:" + musicaConsultada.toStringComLocacao());
            }
        } else {
            System.out.println("3:Codigo inexistente.");
        }
    }

	private void consultaMidiaPorCategoria() { //4
		entrada.nextLine();
		String categoriaConsultada = entrada.nextLine();
		ArrayList<Midia> midiasEncontradas = midiateca. consultaPorCategoria(Categoria.valueOf(categoriaConsultada));
		if (midiasEncontradas.isEmpty()) {
			System.out.println("4:Nenhuma midia encontrada.");
		} else {
			for (Midia m : midiasEncontradas) {
				if (m instanceof Video) {
					Video videoConsultado = (Video) m;
					videoConsultado.calculaLocacao();
					System.out.println("4:" + videoConsultado.toStringComLocacao());
				} else {
					Musica musicaConsultada = (Musica) m;
					musicaConsultada.calculaLocacao();
					System.out.println("3:" + musicaConsultada.toStringComLocacao());
				}
			}
		}
	}

	private void consultaVideoPorQualidade() { //5
		int qualidadeConsultada = Integer.parseInt(entrada.nextLine());
		ArrayList<Video> videosEncontrados = midiateca.consultaPorQualidade(qualidadeConsultada);
		if (videosEncontrados.isEmpty()) {
			System.out.println("5:Qualidade inexistente.");
		} else {
			for (Video video : videosEncontrados) {
				video.calculaLocacao();
				System.out.println("5:" + video.toStringComLocacao());
			}
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
