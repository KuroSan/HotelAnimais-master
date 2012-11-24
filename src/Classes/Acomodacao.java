/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Raul San
 */
public class Acomodacao {
    private int numero;
    private Especie especie;
    private Porte dimensao;
    private EstadoAcomodacao estado;
    
    public Acomodacao(int numero, Especie especie, Porte dimensao, EstadoAcomodacao estado) {
        this.numero = numero;
        this.especie = especie;
        this.dimensao = dimensao;
        this.estado = estado;
    }

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
	 * @return the dimensao
	 */
	public Porte getDimensao() {
		return dimensao;
	}

	/**
	 * @param dimensao the dimensao to set
	 */
	public void setDimensao(Porte dimensao) {
		this.dimensao = dimensao;
	}

	/**
	 * @return the estado
	 */
	public EstadoAcomodacao getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoAcomodacao estado) {
		this.estado = estado;
	}
	
	
}
