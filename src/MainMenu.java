import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainMenu implements ActionListener {
    Frameclass frame;
    JButton adminbutt = new JButton();
    JButton userbutt = new JButton();
    public void setup()
    {
        frame = new Frameclass();
        frame.cretaeFrameclass();
        adminbutt.setBounds(300,300,80,40);
        adminbutt.setText("Admin");
        frame.frame.add(adminbutt);
        adminbutt.addActionListener( this);

        //user
        userbutt.setBounds(300,400,80,40);
        userbutt.setText("user");
        frame.frame.add(userbutt);
        userbutt.addActionListener( this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==adminbutt)
        {
            // Close the previous frame
            frame.frame.setVisible(false);
            Database_check db=new Database_check();
            db.openAdminPanel(frame);
            adminbutt.setVisible(false);
            userbutt.setVisible(false);
            try {
                db.getdata();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource()==userbutt) {
// Close the previous frame
            frame.frame.setVisible(false);
            Database_check db = new Database_check();
            db.openUserPanel(frame);
            adminbutt.setVisible(false);
            userbutt.setVisible(false);

        }


    }
}
