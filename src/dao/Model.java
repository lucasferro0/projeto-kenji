package dao;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public abstract class Model 
{
    String table;

    String primaryKey;

    public ArrayList<HashMap<String, String>> get(HashMap<String, String> data)
    {
        ConexaoMySQL conMySql = new ConexaoMySQL();

        Connection con = conMySql.getConexaoMySQL();

        try{
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(
                "SELECT * FROM " + this.table
            );

            con.close();

            ResultSetMetaData metaRS = result.getMetaData();
            int columnCount = metaRS.getColumnCount();

            ArrayList<HashMap<String, String>> registros = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> keysValues = new HashMap<String, String>();

            while (result.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = result.getObject(i);
                    keysValues.put(metaRS.getColumnName(i), value.toString());
                }

                registros.add(keysValues);
            }

            return registros;

        }catch (SQLException e){
            // handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

            return null;
        }catch(Exception e){
            // handle any errors
            System.out.println("Exception: " + e.getMessage());

            return null;
        }
    }

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
            System.out.println("Exception: " + e.getMessage());

            return null;
        }
    }
}
