package interfaces;

import entities.Cliente;
import entities.Funcionario;

import java.util.ArrayList;

import static entities.Cliente.getLista_cliente;
import static entities.Funcionario.getLista_funcionario;

public interface Login {
    static String login(String username, String senha, ArrayList<Funcionario> lista_funcionario, ArrayList<Cliente> lista_cliente){
        for (int i = 0; i < getLista_funcionario().size(); i++){
            if ( username.equalsIgnoreCase(getLista_funcionario().get(i).getNome()) && senha.equals(getLista_funcionario().get(i).getSenha())){
                return "funcionario";
            }
        }
        for (int i = 0; i < getLista_cliente().size(); i++) {
            if (username.equalsIgnoreCase(getLista_cliente().get(i).getNome()) && senha.equals(getLista_cliente().get(i).getSenha())) {
                return "cliente";
            }

        }
        return "jose";
    }
}
