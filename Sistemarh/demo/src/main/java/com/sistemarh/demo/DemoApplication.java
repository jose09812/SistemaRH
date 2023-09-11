package com.sistemarh.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Enum.Estado;
import Pessoa.Atendente;
import Pessoa.Gerente;
import Pessoa.Supervisor;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String nome,data_nascimento,cargo,ctps;
		int opcao,idade;
		String estado,estado_digitado;
		double salario;
		idade = 13;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Seja bem-vindo\n");
		System.out.println("Digite o nome do funcionario:");
		nome = sc1.nextLine();
		System.out.println("Digite a sua data de nascimento: ");
		data_nascimento =sc1.nextLine();
		System.out.println("Digite o seu cargo: ");
		cargo = sc1.nextLine();
		System.out.println("digite sua CTPS");
		ctps = sc1.nextLine();
		System.out.println("digite o seu salario: ");
		salario = sc.nextDouble();
		System.out.println("Digite a sigla do seu estado: ");
		estado_digitado = sc.nextLine();
		estado = estado_digitado;
		System.out.println("\ncliente cadastrado\n");
		boolean indo = true;
		
		// Atendente atendente = new Atendente(nome, data_nascimento, idade, cargo, ctps, salario);
		// Atendente.getLista_Atendente().add(atendente);
		while(indo){
			if (cargo.equalsIgnoreCase("atendente")) {
				Atendente atendente = new Atendente(nome, data_nascimento, idade, cargo, ctps, salario,estado);
				Atendente.getLista_Atendente().add(atendente);
				System.out.println("Escolha uma opção:\n1. para calcular o FGTS\n2. para calcular o INSS\n3. para Calcular o decimo terceiro\n"+
				"4. para calcular as férias.\n5. para calcular o imposto de renda.\n6. Sair");
				opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					atendente.fgts(salario);
					break;
				case 2:
					atendente.inss(salario);
				break;
				case 3:
					atendente.decimo_terceiro(salario);
				break;
				case 4:
					atendente.ferias(salario);
				break;
				case 5:
					atendente.imposto_renda(salario);
				break;
				case 6: 
					indo = false;
				default:
					break;
					
			}
			}else if (cargo.equalsIgnoreCase("supervisor")) {
				Supervisor Supervisor = new Supervisor(nome, data_nascimento, idade, cargo, ctps, salario,estado);
				Supervisor.getLista_Supervisor().add(Supervisor);
				System.out.println("Escolha uma opção:\n1. para calcular o FGTS\n2. para calcular o INSS\n3. para Calcular o decimo terceiro\n4. para calcular as férias.\n5. para calcular o imposto de renda.\n6. Sair");
				opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					Supervisor.fgts(salario);
					break;
				case 2:
					Supervisor.inss(salario);
				break;
				case 3:
					Supervisor.decimo_terceiro(salario);
				break;
				case 4:
					Supervisor.ferias(salario);
				break;
				case 5:
					Supervisor.imposto_renda(salario);
				break;
				default:
					break;
			}

			
		}else if (cargo.equalsIgnoreCase("Gerente")) {
			
			Gerente Gerente = new Gerente(nome, data_nascimento, idade, cargo, ctps, salario,estado );
				Pessoa.Gerente.getLista_Gerente().add(Gerente);
				System.out.println("Escolha uma opção:\n1. para calcular o FGTS\n2. para calcular o INSS\n3. para Calcular o decimo terceiro\n4. para calcular as férias.\n5. para calcular o imposto de renda.\n6. Sair");
				opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					Gerente.fgts(salario);
					break;
				case 2:
					Gerente.inss(salario);
				break;
				case 3:
					Gerente.decimo_terceiro(salario);
				break;
				case 4:
					Gerente.ferias(salario);
				break;
				case 5:
					Gerente.imposto_renda(salario);
				break;
				default:
					break;
			
		}
}
}
}
}