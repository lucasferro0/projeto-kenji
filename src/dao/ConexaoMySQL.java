package dao;
//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySQL
{
    public Connection connection = null;
    public boolean status = false;
 
    //Método Construtor da Classe//
    public ConexaoMySQL(){

    }

    //Método de Conexão//
    public java.sql.Connection getCon()
    {
        try{
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost"; //caminho do servidor do BD
            String mydatabase ="forum"; //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "admin"; //nome de um usuário de seu BD
            String password = ""; //sua senha de acesso

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
    public boolean status()
    {
        return this.status;
    }

    //Método que fecha sua conexão//
    public boolean fechar()
    {
        try{
            this.connection.close();

            this.status = false;

            return true;
        }catch(SQLException e){
            this.status = true;

            return false;
        }
    }
    
    //Método que reinicia sua conexão//
    public java.sql.Connection reiniciarConexao()
    {
        this.fechar();

        return this.getCon();
    }

    public void beginTransaction()
    {
        try{
            this.connection.setAutoCommit(false);
        }catch(SQLException e){
            System.out.println("Nao foi possivel iniciar a transação no banco de dados.");
        }
    }

    public void commit()
    {
        try{
            this.connection.commit();
        }catch(SQLException e){
            System.out.println("Nao foi possivel realizar commit da transação no banco de dados.");
        }
    }
}