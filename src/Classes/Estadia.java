/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Raul San
 */
public class Estadia {
    private Animal animal;
    private Acomodacao acomodacao;
    private Date entrada;
    private int duracao;
    private double taxa;
    
    public Estadia(Animal animal, Acomodacao acomodacao, Date entrada, int duracao, double taxa) {
        this.acomodacao = acomodacao;
        this.animal = animal;
        this.entrada = entrada;
        this.duracao = duracao;
        this.taxa = taxa;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

	/**
	 * @return the taxa
	 */
	public double getTaxa() {
		return taxa;
	}

	/**
	 * @param taxa the taxa to set
	 */
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
    
    
}
