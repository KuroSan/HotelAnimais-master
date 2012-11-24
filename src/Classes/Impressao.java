package Classes;

import Controle.CadastroException;
import Controle.ControladorCadastro;

public class Impressao extends Evento {

	public Impressao(ControladorCadastro controladorCadastro, BancoDeDados bd) {
		super(controladorCadastro, bd);

	}

	@Override
	public void executa() throws CadastroException {


	}

}
