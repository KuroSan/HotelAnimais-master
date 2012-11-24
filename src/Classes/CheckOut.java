package Classes;

import Classes.BancoDeDados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import Controle.*;
import Classes.Acomodacao;
import Classes.Animal;
import java.awt.image.DataBuffer;
import java.text.DateFormat;
import java.util.Calendar;

public class CheckOut extends Evento {

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

	public CheckOut(ControladorCadastro controladorCadastro, BancoDeDados bd) {
		super(controladorCadastro, bd);
	}

	@Override
	public void executa() throws CadastroException, ParseException {

		BancoDeDados bd = getBd();

		animal = ProcuraEstadiaAnimal();
		porte = getControladorCadastro().classificarPorte(animal, getBd());

		System.out.println("\nAnimal: " + animal.getNome() + " - " + animal.getEspecie() + " - " + porte);
		System.out.println("Dono: " + animal.getDono().getNome());
		System.out.println("Segundo Responsavel: " + animal.getResponsavel().getNome());

		acomodacao = procuraAcomodacoes(porte);

		System.out.println("\nAcomodacao " + acomodacao.getNumero() + " disponivel para o animal.");

		//if (acomodacao != null) {
			removerAnimal();
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
					.println("Digite novamente o n�mero de dias a ser hospedadp (Maior que 1)");
		}

		// Cria a Estadia e cadastra no Banco.
		Estadia novaEstadia = new Estadia(animal, acomodacao, dataEntrada,
				duracao, calculaTaxa(acomodacao, dataEntradaNumero,
						duracao));
		getBd().getInstance().getEstadias().add(novaEstadia);

		System.out.println("Estadia Criada");
		return novaEstadia;
	}

        
        /*
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
        */

	public double calculaTaxa(Acomodacao acomodacao, Date dataEntrada,int duracao) throws ParseException {
            
            Date dataAgora = new Date();
            long duracao2 = ((long)duracao) * 86400000;
            long dt = dataEntrada.getTime() + duracao2; 
            Date dataPrev = new Date(dt);
            
            if (dataPrev.compareTo(dataAgora)==0){
                    double Taxa = duracao * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:%.2f ");
                    return Taxa;
                } else if (dataPrev.compareTo(dataAgora) <= 0) {
                    //Caso o Dono Retire o Animal depois da data prevista
                    long dataPass = dataAgora.getTime() - dataPrev.getTime();
                    Date dataPassou = new Date(dataPass);
                    long dataPassouDia = dataPassou.getTime()/86400000L;
                    double Taxa = dataPassouDia * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:  "+Taxa);
                    return Taxa;
                 } else{
                    //Caso o Dono Retire o Animal antes da data prevista
                    long dataMen = dataAgora.getTime() - dataPrev.getTime();
                    Date dataMenor = new Date(dataMen);
                    long dataMenorDia = dataMenor.getTime()/86400000L;
                    double Taxa = duracao * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:%.2f "+Taxa);
                    return Taxa;
                }
}
    
            
          /*          Integer dur = (Integer) duracao;
                    Date dataDur = df2.parse(dur.toString());
                    long dt = dataEntrada.getTime() + dataDur.getTime();
                    Date dataPrev = new Date(dt);
                    long dataLong = dataAgora.getTime() - dataDur.getTime(); 
                    Date dataEsp = new Date(dataLong);
                    if (dataEsp == dataAgora){
                    double Taxa = duracao * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:%.2f ");
                    return Taxa;
                } else if (dataEsp.compareTo(dataAgora) <= 0) {
                    //Caso o Dono Retire o Animal antes da data prevista
                    long dataPass = dataAgora.getTime() - dataEsp.getTime();
                    Date dataPassou = new Date(dataPass);
                    long dataPassouDia = dataPassou.getTime()/86400000L;
                    double Taxa = dataPassouDia * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:%.2f ");
                    return Taxa;
			} else () {
                    //Caso o Dono Retire o Animal depois da data prevista
                    double Taxa = duracao * Diaria.getValor(acomodacao.getDimensao());
                    System.out.println("O valor da Estadia é:%.2f ");
                    return Taxa;
            
        }
        }
        **/

        
        
        
	public Animal ProcuraEstadiaAnimal() throws CadastroException {
		Scanner entrada = new Scanner(System.in);
		// Pega Dados do Animal para o Check Out
		System.out.print("\nNome do número do Telefone do Dono: ");
		String telefone = entrada.next();
		System.out.print("\nDigite o nome do Animal: ");
		String nome = entrada.next();
                for (Animal an: getBd().getInstance().getAnimais()){
                    if (an.getNome().equals(nome) && an.getDono().getTelefone().equals(telefone)){
                        return animal;
                    }
                    }
        throw new CadastroException("Nenhum Animal Encontrado.");
                }
		
                
        
		// Pega Dados do Responsavel
	/*	System.out.print("\nNome do responsavel: ");
		String nomeResponsavel = entrada.next();
		System.out.print("\nTelefone do responsavel: ");
		String telefoneResponsavel = entrada.next();
		resp = new Pessoa(nomeResponsavel, telefoneResponsavel);
		Animal animal = new Animal(dono, nomeAnimal, especieAnimal,
				alturaAnimal, comprimentoAnimal, resp);
		return animal;
	}*/

	public void removerAnimal() throws CadastroException {
		Set<Animal> animais = getBd().getInstance().getAnimais();
		for (Animal animal : animais) {
			if (this.animal == animal) {
                                    for (Estadia an: getBd().getInstance().getEstadias())
                                        if (this.estadia == estadia) {
                                    
                                   
                            
                                getBd().getInstance().getEstadias().remove(animal);
                                acomodacao.setEstado() == EstadoAcomodacao.DESOCUPADA;
                                
				System.out.println("Check Out Realizado Com Sucesso!.");
				break;
			} else {
				System.out.println("Animal Nao Encontrado.");
                                return;
			}
		}
	}
        
        public void alterarAcomodacao() throws CadastroException {
                Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
                
		for (Acomodacao acomodacao : acomodacoes) {
		if (this.acomodacao == getAcomodacoes())
                    acomodacao.getEstado() == EstadoAcomodacao.DESOCUPADA
                    acomodacao.getEspecie() == animal.getEspecie()) {
                        System.out.println("Check Out Realizado Com Sucesso!.");
                        break;
                }else{
        
		return ;
    		}
    	}
        }
}
    

