/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Raul San
 */
public class PorteFaixa {
	private Double alturaInicial;
	private Double alturaFinal;
	private Double comprimentoInicial;
	private Double comprimentoFinal;
	private Especie especie;
	private Porte porte;
	
	public PorteFaixa(Double alturaInicial, Double alturaFinal, Double comprimentoInicial, Double comprimentoFinal, Especie especie, Porte porte) {
		super();
		this.alturaInicial = alturaInicial;
		this.alturaFinal = alturaFinal;
		this.comprimentoInicial = comprimentoInicial;
		this.comprimentoFinal = comprimentoFinal;
		this.especie = especie;
		this.porte = porte;
	}

	/**
	 * @return the alturaInicial
	 */
	public Double getAlturaInicial() {
		return alturaInicial;
	}

	/**
	 * @param alturaInicial the alturaInicial to set
	 */
	public void setAlturaInicial(Double alturaInicial) {
		this.alturaInicial = alturaInicial;
	}

	/**
	 * @return the alturaFinal
	 */
	public Double getAlturaFinal() {
		return alturaFinal;
	}

	/**
	 * @param alturaFinal the alturaFinal to set
	 */
	public void setAlturaFinal(Double alturaFinal) {
		this.alturaFinal = alturaFinal;
	}

	/**
	 * @return the comprimentoInicial
	 */
	public Double getComprimentoInicial() {
		return comprimentoInicial;
	}

	/**
	 * @param comprimentoInicial the comprimentoInicial to set
	 */
	public void setComprimentoInicial(Double comprimentoInicial) {
		this.comprimentoInicial = comprimentoInicial;
	}

	/**
	 * @return the comprimentoFinal
	 */
	public Double getComprimentoFinal() {
		return comprimentoFinal;
	}

	/**
	 * @param comprimentoFinal the comprimentoFinal to set
	 */
	public void setComprimentoFinal(Double comprimentoFinal) {
		this.comprimentoFinal = comprimentoFinal;
	}

	/**
	 * @return the especie
	 */
	public Especie getEspecie() {
		return especie;
	}

	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	/**
	 * @return the porte
	 */
	public Porte getPorte() {
		return porte;
	}

	/**
	 * @param porte the porte to set
	 */
	public void setPorte(Porte porte) {
		this.porte = porte;
	}	
	
	public boolean isAnimalDessePorte(Animal animal) {
		if (animal.getAltura() >= alturaInicial
		&& animal.getAltura() < alturaFinal) {
		return true;
		} else if (animal.getComprimento() >= comprimentoInicial && animal.getComprimento() < comprimentoFinal) {
			return true;
		} else {
			return false;
		}
	}	

}
