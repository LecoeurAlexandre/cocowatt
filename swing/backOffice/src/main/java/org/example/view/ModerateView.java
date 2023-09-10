package org.example.view;

import org.example.dto.CommentDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ModerateView extends JDialog {
    JPanel titlePanel, tablePanel, returnPanel;
    JLabel title;
    JTable table;
    JButton deleteButton, returnButton;
    public ModerateView() {
        setTitle("Modération");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titlePanel = new JPanel();
        title = new JLabel("Modérer les commentaires");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        tablePanel = new JPanel();
        String[] columns = new String[] {"Id", "Contenu", "Auteur"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table = new JTable(model);
        // A RENDRE DYNAMIQUE
        List<CommentDTO> comments = new ArrayList<>();
        comments.add(new CommentDTO(1254, "Sale conducteur, conduite déplorable", 25));
        for (CommentDTO comment: comments) {
            model.addRow(new Object[] {
                    comment.getId(),
                    comment.getContent(),
                    comment.getAuthorId(),
            });
        }
        table.setBounds(30, 40, 100, 100);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

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
        add(returnPanel, BorderLayout.SOUTH);
        deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idValue = (int) table.getValueAt(table.getSelectedRow(), 0);
                // A CONTINUER
            }
        });
        returnPanel.add(deleteButton);

        setVisible(true);
        pack();
    }
}
