package Classes;

import java.text.ParseException;
import java.util.Scanner;

import Controle.CadastroException;
import Controle.ControladorCadastro;

public class HotelAnimal {
	
	private static BancoDeDados bd;
	private ControladorCadastro controladorCadastro;
	
	private static final int CHECKIN = 1;
	private static final int IMPRESSAO = 2;
	private static final int CHECKOUT = 3;
	private static final int CONSULTAR = 4;
	private static final int SAIR = 0;
	
	public HotelAnimal(){
        this.controladorCadastro = new ControladorCadastro();
        this.bd = new BancoDeDados();
    }
	
	public void executa() throws CadastroException, ParseException{	
			realizaEvento();
	}
	
	
	public void realizaEvento() throws CadastroException, ParseException{
		
		Evento eventoAtual = null;
		boolean sair = false;
		
		while (!sair) {
		
			int opcao = mostraMenuPrincipal();
		
			switch(opcao){
			case CHECKIN:
			case IMPRESSAO:
			case CHECKOUT:
			case CONSULTAR:
				eventoAtual = criaEvento(opcao);
				eventoAtual.executa();
				break;
			case SAIR:
				sair = true;
				System.out.println("Fechando o Programa...");
				break;
			default:
				System.out.println("Opção Invalida, tente novamente.");
			}
		}
	}

	private Evento criaEvento(int tipo){
		Evento evento = null;
		
		switch(tipo){
		case CHECKIN:
			evento = new CheckIn(this.controladorCadastro, this.bd);
			break;
		case IMPRESSAO:
			evento = new Impressao(this.controladorCadastro, this.bd);
			break;
		case CHECKOUT:
			evento = new CheckOut(this.controladorCadastro, this.bd);
			break;
		case CONSULTAR:
			evento = new Consulta(this.controladorCadastro, this.bd);
			break;
		}
		return evento;
	}
	
	
	private int mostraMenuPrincipal() {
		
		System.out.println("\nMenu Principal");
		System.out.println("1 - Check-In");
		System.out.println("2 - Impressões");
		System.out.println("3 - Check-Out");
		System.out.println("4 - Consultar Acomodações");
		System.out.println("0 - Sair");
		
		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();
		
	}	

}
