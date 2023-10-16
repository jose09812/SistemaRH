package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



import interfaces.Cadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Cadastro {

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    
    private static ArrayList<Cliente> lista_cliente = new ArrayList<>();
    private double saldo;
    private String tipoConta;
    private static Random rand = new Random();
    private static double numeroConta = rand.nextDouble();
    private String gerente;
    private ArrayList<Double> historico = new ArrayList<>();//add uma string ao inves de uma tabela nova e criar classe historico

    public Cliente(String nome, String cpf, String data_nasc, String login, String senha,
            Endereco endereco, double saldo, String tipoConta, String gerente, boolean ativo,
            ArrayList<Double> historico) {
        super(nome, cpf, data_nasc, login, senha, endereco, ativo);
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.gerente = gerente;

    }

    public ArrayList<Double> getHistorico() {
        return historico;
    }

    public void setHistorico(double valor) {
        historico.add(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public static double getNumeroConta() {
        return numeroConta;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public static ArrayList<Cliente> getLista_cliente() {
        return lista_cliente;
    }

    public static void setLista_cliente(ArrayList<Cliente> lista_cliente) {
        Cliente.lista_cliente = lista_cliente;
    }

    @Override
    public void criar() {
        // faz nada
    }

    @Override
    public void atualizar() {
        // atualiza proprias infos
    }

    @Override
    public void excluir() {
        // faz nada
    }

    @Override
    public void ver() {
        for (int i = 0; i < getLista_cliente().size(); i++) {
            if (this.getNome().equals(getLista_cliente().get(i).getNome())) {
                System.out.println("Nome: " + getLista_cliente().get(i).getNome() + "\n" +
                        "CPF: " + getLista_cliente().get(i).getCpf() + "\n" +
                        "Data de Nascimento: " + getLista_cliente().get(i).getData_nasc() + "\n" +
                        "Login: " + getLista_cliente().get(i).getLogin() + "\n" +
                        // ver o get endereço
                        "Saldo: " + getLista_cliente().get(i).getSaldo() + "\n" +
                        "Tipo de conta: " + getLista_cliente().get(i).getTipoConta() + "\n" +
                        "Gerente Responsável: " + getLista_cliente().get(i).getGerente());
            }
        }
    }

    @Override
    public void saldo() {
        System.out.println("R$" + saldo);
    }

    @Override
    public void deposito() {
        double valor;
        String cpf;
        System.out.println("Para qual cpf você deseja depositar? ");
        cpf = sc.nextLine();
        System.out.println("Digite o valor: ");

        valor = sc2.nextDouble(); // fazer um try catch
        for (int i = 0; i < getLista_cliente().size(); i++) {
            if (cpf.equals(getLista_cliente().get(i).getCpf())) {
                getLista_cliente().get(i).setSaldo((getLista_cliente().get(i).getSaldo()) + valor);
                String nome = getLista_cliente().get(i).getNome();
                LocalDate data = LocalDate.now();
                this.setHistorico(valor);
                Extrato.setExtrato_geral(nome, cpf, valor, data);
                System.out.println("\nDeposito realizado com sucesso:");
                return;
            } 
                System.out.println("\nConta inexistente.");

        }

    }

    @Override
    public void saque() {
        // criar saque e jogar dentro do historico
        double valor;
        System.out.println("Digite o valor: ");
        valor = sc.nextDouble();
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("saque realizado com sucesso: ");
            String nome = this.getNome();
            LocalDate data = LocalDate.now();
            this.setHistorico(-valor);
            Extrato.setExtrato_geral(nome, this.getCpf(), -valor, data);

        } else {
            System.out.println("Saldo insuficiente.");
        }

    }

    @Override
    public void extrato(String cpf) { 
                int contador = 0;
        // falta adicionar o saldo final da pessoa 09.10.2023
        // if (historico.size() > 0) {
        //     for (int i = 0; i < historico.size(); i++) {
        //         System.out.println("R$" + historico.get(i));            
        //     }
        //     System.out.println("Saldo R$:" + this.saldo);
        // } else {
        //     System.out.println("Sem operações ainda");
        // }
        for (int i = 0; i < Extrato.getExtrato_geral().size(); i++) {
            if (cpf.equals(Extrato.getExtrato_geral().get(i).getCpf())) {
                System.out.println(Extrato.getExtrato_geral().get(i).getData()+" R$:"+ Extrato.getExtrato_geral().get(i).getValor() );
                contador += 1;
            }
            
        }if (contador == 0){
            System.out.println("\nSem operações");
        }
    }

    @Override
    public void transferencia() {
        String recebedor_cpf;
        double valor;
        System.out.println("Para qual CPF você deseja enviar ?");
        recebedor_cpf = sc.nextLine();
        System.out.println("Qual o valor?");
        valor = sc2.nextDouble();
        if (valor <= this.saldo) {
            for (int i = 0; i < getLista_cliente().size(); i++) {
                if (recebedor_cpf.equals(getLista_cliente().get(i).getCpf())) {
                    this.saldo -= valor;
                    this.setHistorico(-valor);
                    getLista_cliente().get(i).setSaldo((getLista_cliente().get(i).getSaldo()) + valor);
                    getLista_cliente().get(i).setHistorico(valor);
                    System.out.println("Operação realizado com sucesso");
                    return;
                } 
            }
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
