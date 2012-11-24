package Classes;

import java.text.ParseException;
import Controle.CadastroException;
import Controle.ControladorCadastro;


public abstract class Evento {
	
	private ControladorCadastro controladorCadastro;
	private BancoDeDados bd;
	
	public Evento(ControladorCadastro controladorCadastro, BancoDeDados bd){
		this.controladorCadastro = controladorCadastro;
		this.bd = bd;
	}
	
	public ControladorCadastro getControladorCadastro(){
		return this.controladorCadastro;
	}
	
	public BancoDeDados getBd(){
		return this.bd;
	}
	
	public abstract void executa() throws CadastroException, ParseException;

}
