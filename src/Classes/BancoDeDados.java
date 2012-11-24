
package Classes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import sun.util.calendar.BaseCalendar;

public class BancoDeDados { 
    private Set<Acomodacao> acomodacoes; 
    private Set<Animal> animais; 
    private Set<Diaria> diarias; 
    private Set<Pessoa> pessoas; 
    private Set<Porte> portes;
    private Set<Especie> especies; 
    private Set<Estadia> estadias; 
    private Set<PorteFaixa> porteFaixas; 
    
    private static BancoDeDados instance; 

        
    public BancoDeDados() { 
        acomodacoes = new HashSet<Acomodacao>(); 
        acomodacoes.add(new Acomodacao(1, Especie.CACHORRO, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(2, Especie.CACHORRO, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(3, Especie.CACHORRO, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(4, Especie.GATO, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(5, Especie.GATO, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(6, Especie.GATO, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(7, Especie.PASSARO, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(8, Especie.PASSARO, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(9, Especie.PASSARO, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(10, Especie.PEIXE, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(11, Especie.PEIXE, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(12, Especie.PEIXE, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(13, Especie.REPTIL, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(14, Especie.REPTIL, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(15, Especie.REPTIL, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(16, Especie.ROEDOR, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(17, Especie.ROEDOR, Porte.MEDIO, EstadoAcomodacao.DESOCUPADA));
        acomodacoes.add(new Acomodacao(18, Especie.ROEDOR, Porte.GRANDE, EstadoAcomodacao.DESOCUPADA));
        
        animais = new HashSet<Animal>(); 
        diarias = new HashSet<Diaria>(); 
        pessoas = new HashSet<Pessoa>(); 
        portes = new HashSet<Porte>();
        especies = new HashSet<Especie>(); 
        estadias = new HashSet<Estadia>(); 
        
        porteFaixas = new HashSet<PorteFaixa>(); 
        porteFaixas.add(new PorteFaixa(0d, 20d, 0d, 30d, Especie.CACHORRO, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(21d, 40d, 31d, 60d, Especie.CACHORRO, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(41d, 60d, 61d, 80d, Especie.CACHORRO, Porte.GRANDE));
		
        porteFaixas.add(new PorteFaixa(0d, 20d, 0d, 30d, Especie.GATO, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(21d, 40d, 31d, 60d, Especie.GATO, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(41d, 60d, 61d, 80d, Especie.GATO, Porte.GRANDE));
		
        porteFaixas.add(new PorteFaixa(0d, 20d, 0d, 30d, Especie.PASSARO, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(21d, 40d, 31d, 60d, Especie.PASSARO, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(41d, 60d, 61d, 80d, Especie.PASSARO, Porte.GRANDE));
		
        porteFaixas.add(new PorteFaixa(0d, 20d, 0d, 30d, Especie.PEIXE, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(21d, 40d, 31d, 60d, Especie.PEIXE, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(41d, 60d, 61d, 80d, Especie.PEIXE, Porte.GRANDE));
		
        porteFaixas.add(new PorteFaixa(0d, 20d, 0d, 30d, Especie.REPTIL, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(21d, 40d, 31d, 60d, Especie.REPTIL, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(41d, 60d, 61d, 80d, Especie.REPTIL, Porte.GRANDE));
		
        porteFaixas.add(new PorteFaixa(0d, 5d, 0d, 7d, Especie.ROEDOR, Porte.PEQUENO));
        porteFaixas.add(new PorteFaixa(6d, 12d, 8d, 15d, Especie.ROEDOR, Porte.MEDIO));
        porteFaixas.add(new PorteFaixa(13d, 25d, 15d, 30d, Especie.ROEDOR, Porte.GRANDE));
 } 
    
public void cadastrar(Object entidade) {
	if (entidade instanceof Acomodacao) {
		acomodacoes.add((Acomodacao) entidade);
	} else if (entidade instanceof Animal) {
		animais.add((Animal) entidade);
	} else if (entidade instanceof Diaria) {
		diarias.add((Diaria) entidade);
	} else if (entidade instanceof Pessoa) {
		pessoas.add((Pessoa) entidade);
	} else if (entidade instanceof Porte) {
		portes.add((Porte) entidade);
	} else if (entidade instanceof Especie) {
		especies.add((Especie) entidade);
	} else if (entidade instanceof Estadia) {
		estadias.add((Estadia) entidade);
	} else if (entidade instanceof PorteFaixa) {
		porteFaixas.add((PorteFaixa) entidade);
	}
}
    
 public BancoDeDados getInstance() { 
  if (instance == null) { 
   instance = new BancoDeDados(); 
    } 
  return instance;
 } 
 public Set<Acomodacao> getAcomodacoes() { 
  return acomodacoes; 
 } 
 public Set<Animal> getAnimais() { 
  return animais;     
} 
 public Set<Diaria> getDiarias() { 
  return diarias; 
} 
 public Set<Pessoa> getPessoas() { 
  return pessoas; 
} 
 public Set<Porte> getPortes(){
	 return portes;
 }
 public Set<Especie> getEspecies() { 
  return especies; 
} 
 public Set<Estadia> getEstadias() { 
  return estadias; 
} 
 public Set<PorteFaixa> getPorteFaixas() { 
  return porteFaixas; 
 } 
} 
