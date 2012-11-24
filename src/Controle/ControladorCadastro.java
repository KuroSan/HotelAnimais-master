/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.text.ParseException;
import java.util.Set;

import Classes.*;

/**
 *
 * @author Raul San
 */
public class ControladorCadastro {
    
    public Porte classificarPorte(Animal animal, BancoDeDados bd) throws CadastroException { 
        Set<PorteFaixa> porteFaixas = bd.getInstance().getPorteFaixas(); 
        for (PorteFaixa porteFaixa : porteFaixas) { 
        	if (porteFaixa.isAnimalDessePorte(animal)) { 
        		return porteFaixa.getPorte(); 
      } 
    } 
    throw new CadastroException("Não foi possível classificar o porte do animal."); 
    }

}