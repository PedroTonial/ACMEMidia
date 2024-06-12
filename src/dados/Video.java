package dados;

import java.text.DecimalFormat;

public class Video extends Midia {

	private double valorLocacao = 0;
	private int qualidade;
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano, categoria);
		this.qualidade = qualidade;
	}

	public int getQualidade() {
		return qualidade;
	}

	public double getValorLocacao() {
		return valorLocacao;
	}

	@Override
	public double calculaLocacao() {

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
	public String toStringComLocacao() {
		return  getCodigo()
				+
				"," + getTitulo()
				+
				"," + getAno()
				+
				"," + getCategoria().getNome()
				+
				"," + qualidade  + "," + decimalFormat.format(getValorLocacao());
	}
}
