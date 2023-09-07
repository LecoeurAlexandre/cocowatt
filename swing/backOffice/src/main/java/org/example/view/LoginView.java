package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JFrame frame;
    private JPanel titlePanel, formPanel;
    private JLabel title, mailLabel, passwordLabel;
    private JTextField mailText, passwordText;
    private JButton validButton;
    public LoginView() {
        // création et paramétrage du frame
        BorderLayout borderLayout = new BorderLayout(10,10);
        frame = new JFrame("Connexion");
        frame.setLayout(borderLayout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        titlePanel = new JPanel();

        // Titre
        title = new JLabel("Se connecter");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(title);
        frame.add(titlePanel, BorderLayout.NORTH);

        //Formulaire
        formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(3,3,3,3);
        mailLabel = new JLabel("Email");
        formPanel.add(mailLabel, c);

        c.gridy = 0;
        c.gridx = 1;
        mailText = new JTextField(15);
        formPanel.add(mailText);

        c.gridy = 1;
        c.gridx = 0;
        passwordLabel = new JLabel("Mot de passe");
        formPanel.add(passwordLabel, c);

        c.gridy = 1;
        c.gridx = 1;
        passwordText = new JTextField(15);
        formPanel.add(passwordText, c);

        c.gridy = 2;
        c.gridx = 1;
        validButton = new JButton("Valider");
        validButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView menuView = new MenuView();
                menuView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                menuView.setVisible(true);
                frame.dispose();
            }
        });
        formPanel.add(validButton, c);


        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }
}

