package dao;
//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySQL
{
    private Connection connection = null;
    public boolean status = false;
 
    //Método Construtor da Classe//
    public ConexaoMySQL(){

    }

    //Método de Conexão//
    public java.sql.Connection getConexaoMySQL()
    {
        try{
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost"; //caminho do servidor do BD
            String mydatabase ="bd_developmenthelp"; //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root"; //nome de um usuário de seu BD
            String password = "123456"; //sua senha de acesso

            this.connection = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//
            if (connection != null) {
                this.status = true;
            } else {
                this.status = false;
            }

        }catch(ClassNotFoundException e){  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");

        }catch(SQLException e){
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }

        return this.connection;
    }

    //Método que retorna o status da sua conexão//
    public boolean statusConexao()
    {
        return this.status;
    }

    //Método que fecha sua conexão//
    public boolean fecharConexao()
    {
        try{
            this.connection.close();

            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    //Método que reinicia sua conexão//
    public java.sql.Connection reiniciarConexao()
    {
        this.fecharConexao();

        return this.getConexaoMySQL();
    }
}