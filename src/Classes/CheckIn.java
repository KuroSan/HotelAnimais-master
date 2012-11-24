package Classes;

import Classes.BancoDeDados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import Controle.*;

public class CheckIn extends Evento {

	private Animal animal = null;
	private Pessoa resp, dono;
	private Acomodacao acomodacao;
	private Porte porte = null;

	private final static int CACHORRO = 1;
	private final static int GATO = 2;
	private final static int PASSARO = 3;
	private final static int PEIXE = 4;
	private final static int REPTIL = 5;
	private final static int ROEDOR = 6;

	public CheckIn(ControladorCadastro controladorCadastro, BancoDeDados bd) {
		super(controladorCadastro, bd);
	}

	@Override
	public void executa() throws CadastroException, ParseException {

		BancoDeDados bd = getBd();

		animal = pegaInfoAnimal();
		porte = getControladorCadastro().classificarPorte(animal, getBd());

		System.out.println("\nAnimal: " + animal.getNome() + " - " + animal.getEspecie() + " - " + porte);
		System.out.println("Dono: " + animal.getDono().getNome());
		System.out.println("Segundo Respons�vel: " + animal.getResponsavel().getNome());

		acomodacao = procuraAcomodacoes(porte);

		System.out.println("\nAcomodacao " + acomodacao.getNumero() + " disponivel para o animal.");

		//if (acomodacao != null) {
			cadastraAnimal();
			System.out.println("\nAnimal Cadastrado com sucesso.");
		//}
	}

	public Estadia cadastraEstadia(Animal animal, Acomodacao acomodacao)
			throws ParseException, CadastroException {
		Scanner entrada = new Scanner(System.in);

		// Pegando dados da estadia
		System.out.println("Data de entrada (dd/MM/yyyy)?");

		String x = entrada.next();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		Date dataEntrada = sdf1.parse(x);
		int dataEntradaNumero = Integer.parseInt(sdf2.format(sdf2));

		System.out.println("Numero de dias a ser hospedado?");
		int duracao = entrada.nextInt();

		if (duracao < 1) {
			System.out
					.println("Digite novamente o numero de dias a ser hospedadp (Maior que 1)");
		}

		// Cria a Estadia e cadastra no Banco.
		Estadia novaEstadia = new Estadia(animal, acomodacao, dataEntrada,
				duracao, calculaTaxaHospedagem(acomodacao, dataEntradaNumero,
						duracao));
		getBd().getInstance().getEstadias().add(novaEstadia);

		System.out.println("Estadia Criada");
		return novaEstadia;
	}

	public Acomodacao procuraAcomodacoes(Porte porte) throws CadastroException, ParseException {
		try {
			Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
			for (Acomodacao acomodacao : acomodacoes) {
				if (acomodacao.getDimensao() == porte
						&& acomodacao.getEstado() == EstadoAcomodacao.DESOCUPADA
						&& acomodacao.getEspecie() == animal.getEspecie()) {
					return acomodacao;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public double calculaTaxaHospedagem(Acomodacao acomodacao, int dataEntrada,
			int duracao) throws ParseException {
		double Taxa = duracao * Diaria.getValor(acomodacao.getDimensao());
		return Taxa;
	}

	public Animal pegaInfoAnimal() {
		Scanner entrada = new Scanner(System.in);

		// Pega Dados do Dono
		System.out.print("\nNome do dono: ");
		String nome = entrada.next();
		System.out.print("\nTelefone do dono: ");
		String telefone = entrada.next();
		dono = new Pessoa(nome, telefone);

		// Pega Dados do Responsavel
		System.out.print("\nNome do responsavel: ");
		String nomeResponsavel = entrada.next();
		System.out.print("\nTelefone do responsavel: ");
		String telefoneResponsavel = entrada.next();
		resp = new Pessoa(nomeResponsavel, telefoneResponsavel);

		// Pegar Dados do Animal
		System.out.print("\nNome do Animal: ");
		String nomeAnimal = entrada.next();
		System.out.println("\nEspecie do animal?");
		System.out.println("1 - Cachorro");
		System.out.println("2 - Gato");
		System.out.println("3 - Passaro");
		System.out.println("4 - Peixe");
		System.out.println("5 - Reptil");
		System.out.println("6 - Roedor");
		System.out.print("Especie: ");
		int especie = entrada.nextInt();
		Especie especieAnimal = null;

		switch (especie) {
		case CACHORRO:
			especieAnimal = Especie.CACHORRO;
			break;
		case GATO:
			especieAnimal = Especie.GATO;
			break;
		case PASSARO:
			especieAnimal = Especie.PASSARO;
			break;
		case PEIXE:
			especieAnimal = Especie.PEIXE;
			break;
		case REPTIL:
			especieAnimal = Especie.REPTIL;
			break;
		case ROEDOR:
			especieAnimal = Especie.ROEDOR;
			break;
		default:
			System.out
					.println("\nOp��o inv�lida. Cadastre o Animal Novamente.");
		}

		System.out.print("\nAltura do Animal: ");
		Double alturaAnimal = entrada.nextDouble();

		System.out.print("\nComprimento do Animal: ");
		Double comprimentoAnimal = entrada.nextDouble();
		Animal animal = new Animal(dono, nomeAnimal, especieAnimal,
				alturaAnimal, comprimentoAnimal, resp);
		return animal;
	}

	public void cadastraAnimal() throws CadastroException {
		Set<Animal> animais = getBd().getInstance().getAnimais();
		
		for (Animal animal : animais) {
			if (this.animal == animal) {
				System.out.println("O animal ja est� cadastrado e ser� utilizado.");
				break;
			} else {
				getBd().getInstance().getAnimais().add(this.animal);
				System.out.println("Animal Cadastrado.");
			}
		}
	}

}
