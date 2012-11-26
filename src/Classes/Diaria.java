/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Raul San
 */
public enum Diaria {
	PEQUENO, MEDIO, GRANDE;
	
	public static double getValor(Diaria diaria){
		switch(diaria){
		case GRANDE:
			return 100;
		case MEDIO:
			return 60;
		case PEQUENO:
			return 40;
		}
		return 0d;
	}
	
	public static Diaria getDiaria(Porte porte){
		switch (porte){
		case GRANDE:
			return GRANDE;
		case MEDIO:
			return MEDIO;
		case PEQUENO:
			return PEQUENO;
		}
		return null;
	}
    
}
