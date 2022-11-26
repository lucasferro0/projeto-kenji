package models;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Model 
{
    String table;

    String primaryKey;

    public HashMap<String, String> create(HashMap<String, String> data)
    {
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
        
        for (String e : data.keySet()) {
            keys.add(e);
        }

        for (String e : data.values()) {
            values.add(e);
        }

        ConexaoMySQL conMySql = new ConexaoMySQL();

        Connection con = conMySql.getConexaoMySQL();

        try{
            String nameColumns = "";
            for (String e : keys) {
                nameColumns = nameColumns + e + ", ";
            }

            String nameValues = "";
            for (String e : values) {
                nameValues = nameValues + e + ", ";
            }

            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(
                "INSERT INTO " + this.table + " (" + nameColumns + ") " + "VALUES " + "(" + nameValues + ")"
            );

            con.close();

            HashMap<String, String> registroCriado = new HashMap<String, String>();
            for (String e : keys) {
                registroCriado.put(e, result.getString(e));
            }

            return registroCriado;

        }catch (SQLException e){
            // handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

            return null;
        }catch(Exception e){
            // handle any errors
            System.out.println("SQLException: " + e.getMessage());

            return null;
        }
    }
}
