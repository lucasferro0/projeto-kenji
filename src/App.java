import dao.ConexaoMySQL;
import vo.*;
import bo.*;
import java.util.Scanner;
import view.Plataforma;

public class App {
    public static void main(String[] args) throws Exception {
        Plataforma plataforma = new Plataforma();

        plataforma.start();
    }
}