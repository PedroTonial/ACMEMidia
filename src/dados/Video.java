package dados;

public class Video extends Midia {

	private int qualidade;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano, categoria);
		this.qualidade = qualidade;
	}

	public int getQualidade() {
		return qualidade;
	}

	@Override
	public double calculaLocacao() {
		int valorLocacao = 0;

		if (getAno() == 2024) valorLocacao = 20;
		if (getAno() >= 2000 && getAno() <= 2023 ) valorLocacao = 15;
		if (getAno() < 2000) valorLocacao = 10;

		return valorLocacao;
	}

	@Override
	public String toString() {
		return  getCodigo()
				+
				"," + getTitulo()
				+
				"," + getAno()
				+
				"," + getCategoria().getNome()
				+
				"," + qualidade;
	}
}
