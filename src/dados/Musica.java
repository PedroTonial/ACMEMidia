package dados;

import java.text.DecimalFormat;

public class Musica extends Midia {
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");
	private double duracao;
	private double valorLocacao;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
		super(codigo, titulo, ano,categoria);
		this.duracao = duracao;
	}

	public double getValorLocacao() {
		return this.valorLocacao;
	}

	@Override
	public double calculaLocacao() {
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
	public String toString() {
		return  getCodigo()
				+
				"," + getTitulo()
				+
				"," + getAno()
				+
				"," + getCategoria().getNome()
				+
				"," + duracao;
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
				"," + decimalFormat.format(duracao) + "," + getValorLocacao();
	}

}
