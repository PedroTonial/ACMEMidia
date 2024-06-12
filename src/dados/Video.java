package dados;

public class Video extends Midia {

	private int qualidade;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano);
		this.qualidade = qualidade;
	}

	public int getQualidade() {
		return qualidade;
	}

	@Override
	public double calculaLocacao() {
		return 0;
	}
}
