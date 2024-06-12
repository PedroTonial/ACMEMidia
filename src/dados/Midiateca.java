package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Midiateca implements Iterador {

	private int contador = 0;

	private List<Midia> midia;

	public Midiateca() {
		this.midia  = new ArrayList<>();
	}

	public boolean cadastraMidia(Midia midia) {
		return this.midia.add(midia);
	}

	public Midia consultaPorCodigo(int codigo) {
		return midia.stream()
				.filter(m -> m.getCodigo() == codigo)
				.findFirst()
				.orElse(null);
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {
		return midia.stream()
				.filter(m -> m.getCategoria().equals(categoria))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<Video> consultaPorQualidade(int qualidade) {
		return midia.stream()
				.filter(m -> m instanceof Video && ((Video) m).getQualidade() == qualidade)
				.map(m -> (Video) m)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public boolean removeMidia(int codigo) {
		return midia.removeIf(m -> m.getCodigo() == codigo);
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {
		contador = 0;
	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		if(contador < midia.size()){
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		Midia p = midia.get(contador);
		contador++;
		return p;
	}

}
