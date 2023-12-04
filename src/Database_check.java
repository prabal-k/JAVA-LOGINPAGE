import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Database_check  implements ActionListener {
    String userName[] = new String[3];
    String password[] = new String[3];
    int i = 0;
    String t_username, t_password;
    JTextField username_textfield = new JTextField();
    JTextField pass_textfield = new JTextField();
    JButton button = new JButton("continue");
    JButton loginbutt = new JButton();
    JButton signbutt = new JButton();
    JButton signInSubmitButton = new JButton("Submit");
    JButton loginSignupButton = new JButton("log in ");

    JButton loginSubmitButton = new JButton("Sign in ");



    JTextField susernameTextField = new JTextField();
    JTextField spasswordTextField = new JTextField();
    JTextField lusernameTextField = new JTextField();
    JTextField lpasswordTextField = new JTextField();
    Connection con;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "@prabal9869");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    void openAdminPanel(Frameclass frame) {
        // Code to create and display the admin panel in the provided frame
        // You can add components, set layout, etc.
        // Example:
        frame.frame.setTitle("Admin Panel");

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
        // Add your admin panel components here
        frame.frame.setVisible(true);
    }

    void openUserPanel(Frameclass frame) {
        frame.frame.setTitle("User Panel");
        //user login button
        loginbutt.setText("Login");
        loginbutt.setBounds(350, 200, 80, 60);
        frame.frame.add(loginbutt);
        loginbutt.addActionListener(e -> openUserLoginPanel(frame));

        //user signin button
        signbutt.setText("sign in");
        signbutt.setBounds(350, 30, 80, 60);
        frame.frame.add(signbutt);
        signbutt.addActionListener(e -> {
            try {
                openUserSignInPanel(frame);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        loginbutt.addActionListener(e -> {
            openUserLoginPanel(frame);
        });
        frame.frame.setVisible(true);
    }

    void getdata() throws ClassNotFoundException, SQLException, InterruptedException {
        SwingUtilities.invokeLater(() -> {
                    //DATABASE PART
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");                                              //com.mysql.cj.jdbc.Driver which is a path to load Driver

                        String query = "select * from login";
                        Statement st = con.createStatement();


                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                            userName[i] = (rs.getString("user_name"));
                            password[i] = rs.getString("password");
                            i++;
                        }
                        for (int k = 0; k < 2; k++) {
                            System.out.println(userName[k]);
                            System.out.println(password[k]);
                        }
                        button.addActionListener(this);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }


    void openUserLoginPanel(Frameclass frame) {
        frame.frame.setTitle("User Login Panel");

        // Set visibility of components in User Sign-In Panel to false
        loginbutt.setVisible(false);
        signbutt.setVisible(false);
        susernameTextField.setVisible(false);
        spasswordTextField.setVisible(false);
        signInSubmitButton.setVisible(false);
        loginSignupButton.setVisible(false);

        lusernameTextField.setBounds(300, 50, 80, 30);
        frame.frame.add(lusernameTextField);

        lpasswordTextField.setBounds(300, 100, 80, 30);
        frame.frame.add(lpasswordTextField);

        loginSubmitButton.setBounds(300, 150, 80, 30);
        frame.frame.add(loginSubmitButton);

        // Set visibility of components in User Sign-In Panel to true
        lusernameTextField.setVisible(true);
        lpasswordTextField.setVisible(true);
        loginSubmitButton.setVisible(true);

        // Add ActionListener for loginSubmitButton
        loginSubmitButton.addActionListener(this);

        // frame.frame.revalidate(); // Ensure the frame updates
        frame.frame.setVisible(true);
    }


    void openUserSignInPanel(Frameclass frame) throws SQLException {
        frame.frame.setTitle("User Sign-In Panel");
        loginbutt.setVisible(false);
        signbutt.setVisible(false);


        susernameTextField.setBounds(300, 50, 80, 30);
        frame.frame.add(susernameTextField);

        spasswordTextField.setBounds(300, 100, 80, 30);
        frame.frame.add(spasswordTextField);

        signInSubmitButton.setBounds(300, 150, 80, 30);
        frame.frame.add(signInSubmitButton);
        signInSubmitButton.addActionListener(this);

        loginSignupButton.setBounds(300, 250, 80, 30);
        frame.frame.add(loginSignupButton);

        // Add ActionListener for loginSignupButton
        loginSignupButton.addActionListener(e -> {
            // Call a method to handle switching to the User Login Panel
            openUserLoginPanel(frame);
        });

        frame.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            t_username = username_textfield.getText();
            t_password = pass_textfield.getText();
            boolean credentialsMatch = false;

            for (int z = 0; z < i; z++) {
                if (userName[z].equals(t_username) && password[z].equals(t_password)) {
                    credentialsMatch = true;
                    break;
                }
            }

            if (credentialsMatch) {
                JOptionPane.showMessageDialog(null, "Correct");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect");
                username_textfield.setText("");
                pass_textfield.setText("");
            }
        }
        if (e.getSource() == signInSubmitButton) {
            String newUsername = susernameTextField.getText();
            String newPassword = spasswordTextField.getText();

            // Check if the username and password already exist
            if (userExists(newUsername, newPassword)) {
                JOptionPane.showMessageDialog(null, "Account already exists");
                return;
            }



            String insertQuery = "INSERT INTO userlogin(username, password) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                ps.setString(1, newUsername);
                ps.setString(2, newPassword);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Signup successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Signup unsuccessful");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
       if(e.getSource()==loginSubmitButton)
       {
           String loginUsername = lusernameTextField.getText();
           String loginPassword = lpasswordTextField.getText();
           boolean credentialsMatch = false;

           try {
               String query = "SELECT * FROM userlogin WHERE username=? AND password=?";
               PreparedStatement pst = con.prepareStatement(query);
               pst.setString(1, loginUsername);
               pst.setString(2, loginPassword);

               ResultSet rs = pst.executeQuery();

               if (rs.next()) {
                   // Username and password match
                   credentialsMatch = true;
               }

               pst.close();
               rs.close();
           } catch (SQLException ex) {
               throw new RuntimeException(ex);
           }

           if (credentialsMatch) {
               JOptionPane.showMessageDialog(null, "Welcome!");
           } else {
               JOptionPane.showMessageDialog(null, "Incorrect username or password");
               lusernameTextField.setText("");
               lpasswordTextField.setText("");
           }
           // Clear the text fields after checking credentials
           lusernameTextField.setText("");
           lpasswordTextField.setText("");
       }
    }
    // Method to check if the username and password already exist
    private boolean userExists(String username, String password)
    {
        try
        {
            String query = "SELECT * FROM userlogin WHERE username=? AND password=?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                return rs.next(); // If there is a next, the username and password already exist
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
