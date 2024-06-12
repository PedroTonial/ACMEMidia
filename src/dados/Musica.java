package dados;

public class Musica extends Midia {

	private double duracao;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
		super(codigo, titulo, ano,categoria);
		this.duracao = duracao;
	}


	@Override
	public double calculaLocacao() {
		double valorLocacao = 0;
		switch (getCategoria()){
			case ACA:  valorLocacao = getDuracao() * 0.90;
			break;
			case DRA: valorLocacao = getDuracao() * 0.70;
			break;
			case FIC: valorLocacao = getDuracao()* 0.50;
			break;
			case ROM: valorLocacao = getDuracao() * 0.30;
			break;
			default: valorLocacao = 0;
		}
		return valorLocacao;
	}

	public double getDuracao() {
		return duracao;
	}
}
