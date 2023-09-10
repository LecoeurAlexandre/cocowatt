package org.example.view;

import org.example.dto.UserManagementDTO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserManagementView extends JDialog {
    JPanel titlePanel, searchPanel, searchNamePanel, searchIdPanel, tablePanel, returnPanel;
    JLabel titleLabel, nameSearchLabel, idSearchLabel;
    JTextField nameSearchText, idSearchText;
    JButton searchNameButton, searchIdButton, returnButton, deleteButton;
    JTable table;

    public UserManagementView() {
        setTitle("Gestion utilisateurs");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(5,30,5,30);
        titlePanel = new JPanel();
        titleLabel = new JLabel("Supprimer un utilisateur");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, c);

        c.gridy = 1;
        c.gridx = 0;
        searchPanel = new JPanel(new BorderLayout());

        searchNamePanel = new JPanel(new FlowLayout());
        nameSearchText = new JTextField(15);
        searchNamePanel.add(nameSearchText);
        nameSearchLabel = new JLabel("Rechercher par nom");
        searchNamePanel.add(nameSearchLabel);
        searchNameButton = new JButton("OK");
        searchNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchNamePanel.add(searchNameButton);
        searchPanel.add(searchNamePanel, BorderLayout.NORTH);

        searchIdPanel = new JPanel(new FlowLayout());
        idSearchText = new JTextField(15);
        searchIdPanel.add(idSearchText);
        idSearchLabel = new JLabel("Rechercher par id");
        searchIdPanel.add(idSearchLabel);
        searchIdButton = new JButton("OK");
        searchIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchIdPanel.add(searchIdButton);
        searchPanel.add(searchIdPanel);
        add(searchPanel, c);

        c.gridy = 2;
        c.gridx = 0;
        tablePanel = new JPanel();
        String[] columns = new String[] {"Id", "Prénom", "Nom", "Téléphone", "Email", "Admin"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table = new JTable(model);
        // A RENDRE DYNAMIQUE
        List<UserManagementDTO> users = new ArrayList<>();
        users.add(new UserManagementDTO(1, "Alex", "Lecoeur", "06", "alex@gmail.com", true));
        users.add(new UserManagementDTO(2, "Lucas", "Langowski", "0625", "lucas@gmail.com", true));
        for (UserManagementDTO user : users) {
            model.addRow(new Object[] {
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.isAdmin()
            });
        }
        table.setBounds(30, 40, 100, 100);
        JScrollPane sp = new JScrollPane(table);
        add(sp, c);

        c.gridy = 3;
        c.gridx = 0;
        returnPanel = new JPanel();
        returnButton = new JButton("Retour");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView menu = new MenuView();
                menu.setVisible(true);
                dispose();
            }
        });
        returnPanel.add(returnButton);

        deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idValue = (int) table.getValueAt(table.getSelectedRow(), 0);
                // A CONTINUER
            }
        });
        returnPanel.add(deleteButton);
        add(returnPanel, c);

        setVisible(true);
        pack();
    }

}
