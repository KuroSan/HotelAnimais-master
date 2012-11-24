package Classes;


import Classes.BancoDeDados;
import Controle.CadastroException;
import Controle.ControladorCadastro;

import java.util.Scanner;
import java.util.Set;

public class Consulta extends Evento{
    

    public Consulta(ControladorCadastro controladorCadastro, BancoDeDados bd) {
		super(controladorCadastro, bd);
		// TODO Auto-generated constructor stub
	}

	private static final int CACHORRO = 1,ESPECIE = 1, PEQUENO = 1, OCUPADA = 1;
    private static final int GATO = 2,PORTE = 2, MEDIO = 2, DESOCUPADA = 2;
    private static final int PASSARO = 3, ESTADO = 3, GRANDE = 3;
    private static final int REPTIL = 4;
    private static final int ROEDOR = 5;
    private static final int PEIXE = 6;
    private static final int VOLTAR = 0;
    
    private int mostraMenuEstado(){
    	
    	System.out.println("\nEstados Acomodacao:");
    	System.out.println("1 - Ocupada");
    	System.out.println("2 - Desocupada");
    	System.out.println("0 - Voltar");
    	
    	Scanner entrada = new Scanner(System.in);
    	return entrada.nextInt();
    }
    
    private void mostraAcomodacaoEstado(EstadoAcomodacao estado){
    	Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
    	for (Acomodacao acomodacao : acomodacoes) {
    		if (acomodacao.getEstado() == estado){
    			System.out.println("\nAcomoda��o " + acomodacao.getNumero() + " " + acomodacao.getEstado());
    		}
    	}
    }
    
    private int mostraMenuPorte(){
    	
    	System.out.println("\nPortes:");
    	System.out.println("1 - Pequeno");
    	System.out.println("2 - Medio");
    	System.out.println("3 - Grande");
    	System.out.println("0 - Voltar");
    	
    	Scanner entrada = new Scanner(System.in);
    	return entrada.nextInt(); 	
    }
    
    private void mostraAcomodacaoPorte(Porte porte) {
    	Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
    	for (Acomodacao acomodacao : acomodacoes) {
    		if (acomodacao.getDimensao() == porte){
    			System.out.println("\n Acomoda��o " + acomodacao.getNumero() + " " + acomodacao.getEstado());
    		}
    	}
    }
    
    private int mostraMenuEspecie(){
    	  
        System.out.println("\nEspecies:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Passaro");
        System.out.println("4 - Reptil");
        System.out.println("5 - Roedor");
        System.out.println("6 - Peixe");
        System.out.println("0 - Voltar");
        
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
    
    private void mostraAcomodacaoEspecie(Especie especie){
    	Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
    	for (Acomodacao acomodacao : acomodacoes){
    		if (acomodacao.getEspecie() == especie){
    			System.out.println("\nAcomoda��o " + acomodacao.getNumero() + " " + acomodacao.getEstado());
    		}
    	}
    }
    
    private int mostraMenu(){
        
        System.out.println("\nConsulta Acomodacao:");
        System.out.println("1 - Por Esp�cie");
        System.out.println("2 - Por Porte");
        System.out.println("3 - Por Estado");
        System.out.println("0 - Voltar");
        
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
    
    private void realizaConsulta(){
    	
    	boolean voltar = false;
    
		while (!voltar) {
    	
			int opcao = mostraMenu();
        
			switch(opcao){
        
            	case ESPECIE:
            		int opcaoEspecie = mostraMenuEspecie();
                
            		switch (opcaoEspecie){
            		case CACHORRO:
            			mostraAcomodacaoEspecie(Especie.CACHORRO);
            			break;
            		case GATO:
            			mostraAcomodacaoEspecie(Especie.GATO);
            			break;
            		case PASSARO:
            			mostraAcomodacaoEspecie(Especie.PASSARO);
            			break;
            		case PEIXE:
            			mostraAcomodacaoEspecie(Especie.PEIXE);
            			break;
            		case REPTIL:
            			mostraAcomodacaoEspecie(Especie.REPTIL);
            			break;
            		case ROEDOR:
            			mostraAcomodacaoEspecie(Especie.ROEDOR);
            			break;
            		case VOLTAR:
            			break;
            		}
            		break;
                
            	case PORTE: 
            		int opcaoPorte = mostraMenuPorte();
            	
            		switch (opcaoPorte) {
            		case PEQUENO: 
            			mostraAcomodacaoPorte(Porte.PEQUENO);
            			break;
            		case MEDIO: 
            			mostraAcomodacaoPorte(Porte.MEDIO);
            			break;
            		case GRANDE:
            			mostraAcomodacaoPorte(Porte.GRANDE);
            			break;
            		case VOLTAR:
            			break;
            		}
            		break;
                
            	case ESTADO:
            		int opcaoEstado = mostraMenuEstado();
            	
            		switch (opcaoEstado){
            		case OCUPADA:
            			mostraAcomodacaoEstado(EstadoAcomodacao.OCUPADA);
            			break;
            		case DESOCUPADA:
            			mostraAcomodacaoEstado(EstadoAcomodacao.DESOCUPADA);
            			break;
            		}
            		break;
                
            	case VOLTAR:
            		voltar = true;
            		break;
				}
			}
        
    }

    public void executa() throws CadastroException{
        BancoDeDados bd = getBd();
        
        realizaConsulta();
        
    }
}
