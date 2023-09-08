package Interface;

public interface Calculos {
    abstract void fgts(double salario);
    abstract void inss(double salario);
    abstract void decimo_terceiro(double salario);
    abstract void ferias(double salario);
    abstract void imposto_renda(double salario);
    
}
