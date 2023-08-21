package com.poo.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poo.poo.classes.Veiculo;

@SpringBootApplication
public class PooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);
		Veiculo carrrodoJosé = new Veiculo();
		carrrodoJosé.proprietario = "José";
		carrrodoJosé.renavam = "bla";
		carrrodoJosé.marca = "Porsche";
		carrrodoJosé.modelo = "Cayene";
		carrrodoJosé.ano = 2020;
		carrrodoJosé.cor = "preto";
		carrrodoJosé.quilometragem = 5000;
		carrrodoJosé.imprime();

	}

}
