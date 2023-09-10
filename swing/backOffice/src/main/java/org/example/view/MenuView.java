package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JDialog {
    private JPanel titlePanel, buttonsPanel;
    private JLabel title;
    private JButton statButton, userButton, moderateButton;

    public MenuView() {
        setTitle("Menu");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titlePanel = new JPanel();
        title = new JLabel("Menu");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5,30,5,30);
        statButton = new JButton("Statistiques");
        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatsView statsView = new StatsView();
                statsView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                statsView.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(statButton, c);

        c.gridy = 1;
        userButton = new JButton("Gestion utilisateurs");
        userButton. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManagementView userManagementView = new UserManagementView();
                userManagementView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                userManagementView.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(userButton, c);

        c.gridy = 2;
        moderateButton = new JButton("Modérer les commentaires");
        moderateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModerateView moderateView = new ModerateView();
                moderateView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                moderateView.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(moderateButton, c);

        add(buttonsPanel, BorderLayout.CENTER);
        setVisible(true);
        pack();

    }
}
