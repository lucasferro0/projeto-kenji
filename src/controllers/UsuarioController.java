package controllers;

import dao.Usuario;
import helpers.Crypt;

public class UsuarioController {
    
    public Boolean store(String nome, String login, String senha)
    {
        try{
            Usuario usuario = new Usuario();
            Crypt crypt = new Crypt();

		    String senhaHashed = crypt.codificar(senha);

            usuario
            .setNome(nome)
            .setLogin(login)
            .setSenha(senhaHashed)
            .inserir();

            return true;
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());

            return false;
        }
    }
}
