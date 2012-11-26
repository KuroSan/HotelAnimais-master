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
	private Estadia estadia;
	private Diaria diaria;

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

		pegaInfoAnimal();
		porte = getControladorCadastro().classificarPorte(animal, getBd());

		System.out.println("\nAnimal: " + animal.getNome() + " - " + animal.getEspecie() + " - " + porte);
		System.out.println("\nDono: " + animal.getDono().getNome());
		System.out.println("\nSegundo Responsavel: " + animal.getResponsavel().getNome());
		
		estadia = buscaEstadiaAnimal();

		if (estadia != null) {
			
			calculaTaxa(estadia.getDuracao());
			
			removerEstadia();
			System.out.println("\nCheckOut do animal " + estadia.getAnimal().getNome() + " realizado.");
			mudaEstadoDesocupada();
			
		}
	}

	public Estadia buscaEstadiaAnimal(){
		Set<Estadia> estadias = getBd().getInstance().getEstadias();		
		
		for (Estadia estadia : estadias) {
			if (estadia.getAnimal() == this.animal){
				return estadia;
			} else {
				return null;
			}
		}
		return null;
	}
	
        public Diaria pegaDiaria(){
            Porte porteAnimal = acomodacao.getDimensao();
            switch (porteAnimal){
            case PEQUENO:
            return Diaria.PEQUENO;
            case MEDIO:
            return Diaria.MEDIO;
            case GRANDE:
            return Diaria.GRANDE;
                }
            return null;
        }
        
	public void mudaEstadoDesocupada() {
		Set<Acomodacao> acomodacoes = getBd().getInstance().getAcomodacoes();
		
		for (Acomodacao acomodacao : acomodacoes) {
			if (acomodacao == this.acomodacao){
				acomodacao.setEstado(EstadoAcomodacao.DESOCUPADA);
				this.acomodacao.setEstado(EstadoAcomodacao.DESOCUPADA);
			}
		}
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
   

	public double calculaTaxa(int duracao) throws ParseException {
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
            Date dataAgora = new Date();
            long duracao2 = ((long)duracao) * 86400000;
            long DataEntradaNumero = Integer.parseInt(sdf2.format(estadia.getEntrada()));
            long dt = DataEntradaNumero + duracao2; 
            Date dataPrev = new Date(dt);
            
         
            
            if (dataPrev.compareTo(dataAgora)==0){

                    double Taxa = duracao * diaria.getValor(diaria.getDiaria(porte));
                    System.out.println("O valor da Estadia é:%.2f "+Taxa);
                    return Taxa;
                    
                } else if (dataPrev.compareTo(dataAgora) <= 0) {
                    //Caso o Dono Retire o Animal depois da data prevista
                    long dataPass = dataAgora.getTime() - dataPrev.getTime();
                    Date dataPassou = new Date(dataPass);
                    long dataPassouDia = dataPassou.getTime()/86400000L;
                    long dataPrevistaDia = Integer.parseInt(sdf2.format(dataPrev));
                    double Taxa = ((dataPassouDia - dataPrevistaDia) * 1.1);
                    System.out.println("O valor da Estadia é:  "+Taxa);
                    return Taxa;
                 } else {
                    
                    //Caso o Dono Retire o Animal antes da data prevista
                    long dataEntradaDia = Integer.parseInt(sdf2.format(estadia.getEntrada()));
                    long dataMen = dataAgora.getTime() - dataEntradaDia;
                    Date dataMenor = new Date(dataMen);
                    long dataMenorDia = dataMenor.getTime()/86400000L;
                    long dataAgoraDia = Integer.parseInt(sdf2.format(dataAgora));
                    double Taxa = ((dataAgoraDia - dataEntradaDia) * diaria.getValor(diaria.getDiaria(porte)));
                    System.out.println("O valor da Estadia é:%.2f "+Taxa);
                    return Taxa;
                }
}

     
	public void pegaInfoAnimal() {
		Scanner entrada = new Scanner(System.in);
		boolean achou = false;
		
		// Pegar Dados do Animal
		while (!achou) {
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

			boolean especieCerta = false;
			
			while (!especieCerta) {
				switch (especie) {
				case CACHORRO:
					especieAnimal = Especie.CACHORRO;
					especieCerta = true;
					break;
				case GATO:
					especieAnimal = Especie.GATO;
					especieCerta = true;
					break;
				case PASSARO:
					especieAnimal = Especie.PASSARO;
					especieCerta = true;
					break;
				case PEIXE:
					especieAnimal = Especie.PEIXE;
					especieCerta = true;
					break;
				case REPTIL:
					especieAnimal = Especie.REPTIL;
					especieCerta = true;
					break;
				case ROEDOR:
					especieAnimal = Especie.ROEDOR;
					especieCerta = true;
					break;
				default:
					System.out.println("\nOp��o inv�lida. Selecione a Especie novamente.");
				break;
				}
			}
			
		System.out.print("\nAltura do Animal: ");
		Double alturaAnimal = entrada.nextDouble();
		
		System.out.print("\nComprimento do Animal: ");
		Double comprimentoAnimal = entrada.nextDouble();
		
			for (Animal an: getBd().getInstance().getAnimais()){
				if (an.getNome() == nomeAnimal
						&& an.getEspecie() == especieAnimal
						&& an.getAltura() == alturaAnimal
						&& an.getComprimento() == comprimentoAnimal){
					achou = true;
					this.animal = an;
                } else {
                	System.out.println("Animal n�o encontrado, coloque as informa��es do animal denovo.");
                }
			}
		}
	}   
   

	public void removerEstadia() throws CadastroException {
		Set<Estadia> estadias = getBd().getInstance().getEstadias();
			for (Estadia estadia : estadias) {
				if (this.estadia == estadia) {
					getBd().getInstance().getEstadias().remove(estadia);                               
					break;
		}
	}
}
}
       