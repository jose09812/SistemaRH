package teste.teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Produto {
    String nome;
    double valor;
    LocalDate dataInput;
    Scanner sc = new Scanner(System.in);
    private static ArrayList<Produto> lista_produto = new ArrayList<>();
    
    public Produto(String nome, double valor, LocalDate dataInput) {
        this.nome = nome;
        this.valor = valor;
        this.dataInput = dataInput;
    }
	public static ArrayList<Produto> getLista_produto() {
        return lista_produto;
    }
  
    static{
        Produto bola = new Produto("bola",100.00,LocalDate.parse("2023-01-11")); 
        Produto chuteira = new Produto("chuteira",200.00,LocalDate.parse("2023-01-08")); 
        Produto camisa = new Produto("camisa",50.00,LocalDate.parse("2023-01-01")); 
        Produto shorts = new Produto("shorts",30.00,LocalDate.parse("2023-01-21")); 
        Produto meia = new Produto("meia",10.50,LocalDate.parse("2023-01-12")); 
        Produto caneleira = new Produto("caneleira",35.00,LocalDate.parse("2023-01-13")); 
        getLista_produto().add(bola);
        getLista_produto().add(chuteira);
        getLista_produto().add(camisa);
        getLista_produto().add(shorts);
        getLista_produto().add(meia);
        getLista_produto().add(caneleira);
    }
    
    

		
}
/*System.out.println("digite uma data:");// 2023-10-08 formato
		dataInput = sc.nextLine();
		LocalDate data_digitada = LocalDate.parse(dataInput);//colocar a data digitada dentro de um local date
		System.out.println(data_digitada);*/