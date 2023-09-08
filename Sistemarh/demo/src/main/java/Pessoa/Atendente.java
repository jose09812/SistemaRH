package Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

import Enum.Estado;
import Interface.Calculos;


public class Atendente extends Funcionario implements Calculos{
     
     String nome;
     Scanner sc = new Scanner(System.in);
   
    public Atendente(String nome2, String data_nascimento, int idade, String cargo, String ctps, double salario,
            String estado) {
    }
    public static ArrayList<Atendente> getLista_Atendente() {
          return lista_Atendente;
     }
     public static void setLista_Atendente(ArrayList<Atendente> lista_Atendente) {
          Atendente.lista_Atendente = lista_Atendente;
     }
     private static ArrayList <Atendente> lista_Atendente = new ArrayList<>();
//    static{
//      Atendente atendente = new Atendente ("jose","07/11/2001",13,"Atendente","kkk",1200);
//      Atendente.getLista_Atendente().add(atendente);
//    }

     double fgts,inss,decimo_terceiro,ferias,imposto_renda,recisao;
   
     @Override
     public void fgts(double salario) {
      fgts = salario*0.08;
          System.out.println("o valor do FGTS é R$"+fgts+", porém esse valor não e descontado do seu salario.");
      }
     @Override
     public void inss(double salario) {
     /*calculo inss até 1100 *7,5%,/ até 2305.22* 0.09 - 16.50/ 3506 * 0.12-82.60/6433*0.14-148.70 
     o valor limite é 751.97*/
     inss = salario*0.09-15.57;
     if (salario < 1100) {
          inss = salario*0.075;
          System.out.println(inss); 
     }else if (salario < 2305.22) {
          inss = salario*0.09-16.50;
          System.out.println(inss); 
     }else if (salario < 3506) {
          inss = salario*0.12-82.60;
          System.out.println(inss); 
     }else if (salario > 3506) {
          inss = salario*0.14-148.70;
          if (inss >751.97){
               System.out.println("valor limite é "+751.97);
          }else {
               System.out.println(inss);
          }
          
     }
         
     }
     @Override
     public void decimo_terceiro(double salario) {
     decimo_terceiro = salario*2;
     System.out.println("O valor a ser recebido é "+ decimo_terceiro+ ". Lembrando que esse valor representa o seu salario mais o decimo, e pode ser parcelado o pagamento em duas vezes.");
     }
     @Override
     public void ferias(double salario) {
     ferias = salario*1.33;
         System.out.println("O valor que voce irá receber é R$"+ ferias+ ", esse valor representa o seu salario mais as férias");
     }
     @Override
     public void imposto_renda(double salario) {
          int dependentes;
          double deducao,deducao_inss;
          System.out.println("quantos depentes você tem?");
          dependentes = sc.nextInt();
          deducao = dependentes*189.59;
          if(salario<1903){
               System.out.println("Você está isento de pagar o imposto de renda");
          }else if (salario < 2826.65) {
               deducao_inss = salario - inss;
               imposto_renda = deducao_inss*0.75-142.80-deducao;
          }else if (salario <3751.05) {
               deducao_inss = salario - inss;
               imposto_renda= deducao_inss*0.15-354.80-deducao;
               
          }else if (salario < 4664.68) {
               deducao_inss = salario - inss;
               imposto_renda =  deducao_inss* 22.5-636.13-deducao;
          }else if (salario > 4664.68){
               deducao_inss = salario - inss;
               imposto_renda= deducao_inss*0.275-869.36-deducao;
               System.out.println(imposto_renda);
          }
    
     }

}
