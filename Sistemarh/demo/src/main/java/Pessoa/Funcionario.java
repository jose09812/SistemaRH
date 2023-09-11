package Pessoa;

import Enum.Estado;

public abstract class Funcionario extends Pessoa  {
   protected String cargo,CTPS;
   protected double salario;
   Estado uf;
   public String getCargo() {
      return cargo;
   }
   public void setCargo(String cargo) {
      this.cargo = cargo;
   }
   public String getCTPS() {
      return CTPS;
   }
   public void setCTPS(String cTPS) {
      CTPS = cTPS;
   }
   public double getSalario() {
      return salario;
   }
   public void setSalario(double salario) {
      this.salario = salario;
   }
   public Estado getUf() {
      return uf;
   }
   public void setUf(Estado uf) {
      this.uf = uf;
   }
   
}
