import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Database_check  implements ActionListener{
    String userName[] = new String[3];
    String password[] = new String[3];
    boolean status;

    int i = 0,flag=0;
    String t_username, t_password;
    JLabel username_label = new JLabel();
    JLabel pass_label = new JLabel();
    JTextField username_textfield = new JTextField();
    JTextField pass_textfield = new JTextField();
    JButton button = new JButton("continue");
    Frameclass frame;
   // Database_check databaseCheck;

    boolean getdata() throws ClassNotFoundException, SQLException  {


        frame = new Frameclass();
        frame.cretaeFrameclass();
        //for username label;
        username_label.setBounds(250, 100, 110, 50);
        username_label.setText("username");
        username_label.setForeground(Color.GREEN);
        username_label.setFont(new Font("Ink free", Font.BOLD, 25));
        frame.frame.add(username_label);

        //for password label;
        pass_label.setBounds(250, 180, 110, 50);
        pass_label.setForeground(Color.GREEN);
        pass_label.setFont(new Font("Ink free", Font.BOLD, 25));
        pass_label.setText("password");
        frame.frame.add(pass_label);

        //for username textfield
        username_textfield.setBounds(420, 100, 160, 40);
        username_textfield.setForeground(Color.black);
        username_textfield.setFont(new Font("Ink free", Font.CENTER_BASELINE, 25));
        frame.frame.add(username_textfield);

        //for password textfield
        pass_textfield.setBounds(420, 180, 160, 40);
        pass_textfield.setForeground(Color.black);
        pass_textfield.setFont(new Font("Ink free", Font.CENTER_BASELINE, 25));
        frame.frame.add(pass_textfield);

        //for verify button
        button.setBounds(380, 310, 110, 30);
        frame.frame.add(button);


        //DATABASE PART

        Class.forName("com.mysql.cj.jdbc.Driver");                                              //com.mysql.cj.jdbc.Driver which is a path to load Driver

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "@prabal9869");
        String query = "select * from login";
        Statement st = con.createStatement();


        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            userName[i] = (rs.getString("user_name"));
            password[i] = rs.getString("password");
            i++;
        }
        for (int k=0;k<2;k++)
        {
            System.out.println(userName[k]);
            System.out.println(password[k]);

        }
        button.addActionListener(this);
        return status;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int l = 1;
        int count = 0;
       // int k=count+1;
        while (l<3)
        {
        t_username = username_textfield.getText();
        t_password = pass_textfield.getText();
        for(int z=0;z<i;z++)
        {
            if (userName[z].equals(t_username) && password[z].equals(t_password))
            {
              flag=1;
            }
        }
        if(flag==1)
        {
            JOptionPane.showMessageDialog(null,"Correct");
            status=true;
            break;
        }
        else if(flag==0)
        {
            JOptionPane.showMessageDialog(null,"Incorrect");
            status=false;
            username_textfield.setText("");
            pass_textfield.setText("");
            break;
        }
        }

    }
}
