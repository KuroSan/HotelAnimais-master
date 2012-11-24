/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Raul San
 */
public class Animal {
    private Dono dono;
    private String nome; 
    private Especie especie; 
    private Double altura; 
    private Double comprimento; 
    private Pessoa responsavel;
    
    public Animal(Dono dono, String nome, Especie especie, Double altura, Double comprimento, Pessoa responsavel) {    
        super(); 
        this.dono = dono; 
        this.nome = nome; 
        this.especie = especie; 
        this.altura = altura; 
        this.comprimento = comprimento; 
        this.responsavel = responsavel;
 } 
    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }
	/**
	 * @return the responsavel
	 */
	public Pessoa getResponsavel() {
		return responsavel;
	}
	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}
    
    
                    
 
}

