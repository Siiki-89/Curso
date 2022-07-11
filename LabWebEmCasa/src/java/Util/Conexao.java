package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public static Connection conectar() throws ClassNotFoundException{
    Connection con= null;
    String url ="jdbc:mysql://localhost:3306/lab?&useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false&user=root&password=Paradoxo725";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco "+ ex);
        }
    return con;
    }
}
