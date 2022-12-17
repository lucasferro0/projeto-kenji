package view;

import java.util.Scanner;

import javax.swing.InputMap;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import bo.*;
import vo.*;

public class Plataforma {

    public void start(){
        System.out.println("Bem vindo ao Fórum !");

        System.out.println("Aqui você pode se cadastrar e realizar publicações.");
        System.out.println("\n");

        this.escolherOpcoesInicias();

    }

    private void mostrarOpcoesInicias(){
        System.out.println("Escolha a opção desejada.");
        System.out.println("\n");
        System.out.println("[1] - Realizar cadastro.");
        System.out.println("[2] - Realizar login");
        System.out.println("[3] - Sair");
    }

    private void escolherOpcoesInicias(){
        this.mostrarOpcoesInicias();

        System.out.println("\n");

        String escolha = this.input();

        if (escolha.equals("1")){
            this.realizarCadastro();

            this.realizarLogin();

            this.escolherOpcoesToLogado();
            // vai poder postar publicações e ver os usuários

        }else if (escolha.equals("2")){
            this.realizarLogin();

            this.escolherOpcoesToLogado();

            // vai poder postar publicações e ver usuários

        }else if (escolha.equals("3")){
            this.sair();

        }else{
            System.out.println("Opção inválida. Escolha novamente uma opção.");
            this.escolherOpcoesInicias();
        }
    }

    private void mostrarOpcoesToLogado(){
        System.out.println("Agora que você está logado, você pode postar artigos e ver os usuários do fórum.");
        System.out.println("Escolha o a opção desejada.");
        System.out.println("\n");
        System.out.println("[1] - Ver todos os usuários do fórum");
        System.out.println("[2] - Ver todas as publicações");
        System.out.println("[3] - Realizar publicação");
    }

    private void escolherOpcoesToLogado(){
        this.mostrarOpcoesToLogado();
        
        String escolhaLogado = this.input();

        if (escolhaLogado.equals("1")){
            try{
                UsuarioBO usuarioBO = new UsuarioBO();

                usuarioBO.mostrar();
            }catch(Exception e){
                System.out.println("");
            }
        }else if (escolhaLogado.equals("2")){
            try{
                PerguntaBO perguntaBO = new PerguntaBO();

                //
            }catch(Exception e){
                System.out.println("");
            }
        }else if(escolhaLogado.equals("3")){
            // Realizar publicação
        }else{
            System.out.println("Opção inválida. Escolha novamente uma opção.");
            this.escolherOpcoesToLogado();
        }

        System.out.println("Deseja realizar mais coisas ?");
        System.out.println("Para sim digite s. Para não digite n.");
        String escolhaSimNao = this.input();

        if (escolhaSimNao.equalsIgnoreCase("s")){
            this.escolherOpcoesToLogado();
        }
    }

    private void realizarCadastro(){
        System.out.println("\n");

        System.out.println("Digite seu username:");
        String username = this.input();

        System.out.println("Digite seu e-mail:");
        String email = this.input();

        System.out.println("Digite sua senha:");
        String senha = this.input();

        try{
            Usuario usuario = new Usuario();

            usuario.setUsername(username).setSenha(senha).setEmail(email);

            UsuarioBO usuarioBO = new UsuarioBO();

            Boolean wasInserted = usuarioBO.salvar(usuario);

            if (wasInserted){
                System.out.println("Usuário cadastrado com sucesso.");
            }else{
                System.out.println("O usuário não foi cadastrado. Tente novamente");
                this.realizarCadastro();
            }
        }catch(Exception e){
            System.out.println("Erro ao cadastrar usuário - " + e.getMessage() + "\n");
            System.out.println("Tente novamente.");
            this.realizarCadastro();
        }

    }

    private void realizarLogin(){
        System.out.println("\n");
        System.out.println("Bem vindo ao fórum !");
        System.out.println("Entre na sua conta.");
        System.out.println("\n\n");

        System.out.println("Digite seu username:");
        String username = this.input();

        System.out.println("Digite seu senha:");
        String senha = this.input();

        try{
            Usuario usuario = new Usuario();

            usuario.setUsername(username).setSenha(senha);

            AuthBO auth = new AuthBO();
            
            Boolean logou = auth.login(usuario);

            if (logou){
                System.out.println("Usuário logado com sucesso.");
            }
        }catch(Exception e){
            System.out.println("Erro ao realizar login - " + e.getMessage() + "\n");
            System.out.println("Tente novamente.");
            this.realizarLogin();
        }
    }

    private void sair(){
        System.out.println("Programa encerrado com sucesso. Até a próxima !");
    }

    private String input(){
        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }
}
