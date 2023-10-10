package teste.teste;


import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
		Scanner sc = new Scanner(System.in);
		String data_inicial,data_final;


		System.out.println("Digite a data incial do periodo");
		data_inicial = sc.nextLine();
		LocalDate data_1 = LocalDate.parse(data_inicial);//local.parse vai pegar a data que é uma string e transfomar em um local date
		System.out.println("Digite a data final do periodo");
		data_final = sc.nextLine();
		LocalDate data_2 = LocalDate.parse(data_final);

		for (int i = 0; i < Produto.getLista_produto().size(); i++) {
		//linha 28 vou comparar as datas que eu transformei em local date e pedir para imprimir
		//essa classe não tem comparativos maior ou menor ela usa ifAfter para data superior e isBefore para inferior
		 if (Produto.getLista_produto().get(i).getDataInput().isAfter(data_1) && Produto.getLista_produto().get(i).getDataInput().isBefore(data_2) ) {
			
			 System.out.println("Produto:"+Produto.getLista_produto().get(i).getNome()+ " valor:"+ Produto.getLista_produto().get(i).getValor()+" data:"+Produto.getLista_produto().get(i).getDataInput());
		 }
		}

	}

}
