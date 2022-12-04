package dao;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class Usuario 
{
    protected String table = "usuarios";

    protected String primaryKey = "usu_codigo";

    private String nome = null;
    private String login = null;
    private String senha = null;

    public Usuario setNome(String nome)
    {
        this.nome = nome;

        return this;
    }

    public Usuario setLogin(String login)
    {
        this.login = login;

        return this;
    }

    public Usuario setSenha(String senha)
    {
        this.senha = senha;

        return this;
    }

    public Boolean inserir()
    {
        try{
            ConexaoMySQL conMySql = new ConexaoMySQL();

            Connection con = conMySql.getCon();

            String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, this.nome);
            preparedStatement.setString(2, this.login);
            preparedStatement.setString(3, this.senha);


            con.setAutoCommit(false);

            Integer linhasAfetadas = preparedStatement.executeUpdate();

            con.commit();

            con.close();

            return true;

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());

            return false;
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());

            return false;
        }
    }

    public Boolean atualizar(Integer id)
    {
        try{
            ConexaoMySQL conMySql = new ConexaoMySQL();

            Connection con = conMySql.getCon();

            String sql = "UPDATE usuarios SET usu_nome=IFNULL(?, usu_nome), usu_login=IFNULL(?, usu_login), senha=IFNULL(?, usu_senha) WHERE usu_codigo=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, this.nome);
            preparedStatement.setString(2, this.login);
            preparedStatement.setString(3, this.senha);
            preparedStatement.setInt(4, id);

            con.setAutoCommit(false);

            Integer linhasAfetadas = preparedStatement.executeUpdate();

            con.commit();

            con.close();

            return true;

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());

            return false;
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());

            return false;
        }
    }
    
    public ArrayList<HashMap<String, String>> recuperarTodos(Integer id)
    {
        try{
            ConexaoMySQL conMySql = new ConexaoMySQL();

            Connection con = conMySql.getCon();

            PreparedStatement preparedStatement = con.prepareStatement(
                "SELECT * FROM usuarios"
            );


            ResultSet resultSet = preparedStatement.executeQuery();

            con.close();

            ArrayList<HashMap<String, String>> registros = new ArrayList<HashMap<String, String>>();

            while (resultSet.next()){
                HashMap<String, String> registro = new HashMap<String, String>();
                registro.put("usu_nome", resultSet.getString("usu_nome"));
                registro.put("usu_login", resultSet.getString("usu_login"));
                registro.put("usu_senha", resultSet.getString("usu_senha"));

                registros.add(registro);
            }

            return registros;

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());

            return null;
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());

            return null;
        }
    }
}
