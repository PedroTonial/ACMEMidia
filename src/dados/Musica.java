package dados;

public class Musica extends Midia {

	private double duracao;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
		super(codigo, titulo, ano);
		this.duracao = duracao;
	}


	@Override
	public double calculaLocacao() {
		return 0;
	}

	public double getDuracao() {
		return duracao;
	}
}
