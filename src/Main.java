import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {

       Database_check db=new Database_check();
       boolean ch=db.getdata();
       System.out.println(ch);
       

    }
}