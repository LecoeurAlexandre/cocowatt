package org.example.view;

import org.example.dto.StatDTO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsView extends JDialog {
    private JPanel titlePanel, contentPanel, buttonPanel, userPanel, userStatPanel, driverPanel, travellerPanel, totalUserPanel, carPanel, tripPanel, statsTripPanel, bookPanel;
    private JLabel title, driverLabel, driverNumberLabel, travellerLabel, travellerNumberLabel, totalLabel, totalNumberLabel, doneTripsLabel, notDoneTripsLabel, kmLabel, electricPercentageLabel, numberBookLabel;
    private JButton returnButton;
    private StatDTO data;
    private Border userBorder, userStatBorder, carBorder, tripBorder, bookBorder, userNumberBorder;
    public StatsView() {
        data = getDatas();
        setTitle("Statistiques");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //partie titre
        titlePanel = new JPanel();
        title = new JLabel("Statistiques");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        //partie stats
        contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        userPanel = new JPanel();
        userBorder = BorderFactory.createTitledBorder("Utilisateurs");
        userPanel.setBorder(userBorder);
        userStatPanel = new JPanel(new GridBagLayout());
        userStatBorder = BorderFactory.createLineBorder(Color.WHITE, 3);
        userStatPanel.setBorder(userStatBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        driverPanel = new JPanel(new BorderLayout());
        userNumberBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
        driverPanel.setBorder(userNumberBorder);
        driverLabel = new JLabel("Conducteurs");
        driverLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        driverNumberLabel = new JLabel(String.valueOf(data.getDrivers()));
        driverNumberLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        driverPanel.add(driverLabel, BorderLayout.NORTH);
        driverPanel.add(driverNumberLabel, BorderLayout.CENTER);
        userStatPanel.add(driverPanel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        travellerPanel = new JPanel(new BorderLayout());
        travellerPanel.setBorder(userNumberBorder);
        travellerLabel = new JLabel("Voyageurs");
        travellerLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        travellerNumberLabel = new JLabel(String.valueOf(data.getTravellers()));
        travellerNumberLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        travellerPanel.add(travellerLabel, BorderLayout.NORTH);
        travellerPanel.add(travellerNumberLabel, BorderLayout.CENTER);
        userStatPanel.add(travellerPanel, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridheight = 2;
        totalUserPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Total");
        totalLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        totalNumberLabel = new JLabel(String.valueOf(calcAllUsers()));
        totalNumberLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        totalUserPanel.add(totalLabel, BorderLayout.NORTH);
        totalUserPanel.add(totalNumberLabel, BorderLayout.CENTER);
        userStatPanel.add(totalUserPanel, gbc);

        userPanel.add(userStatPanel);
        contentPanel.add(userPanel, c);

        c.gridy = 0;
        c.gridx = 1;

        tripPanel = new JPanel(new BorderLayout());
        tripBorder = BorderFactory.createTitledBorder("Trajets");
        tripPanel.setBorder(tripBorder);
        statsTripPanel = new JPanel(new BorderLayout());
        notDoneTripsLabel = new JLabel("Proposés : " + data.getNotDoneTrips());
        doneTripsLabel = new JLabel("Effectués : " + data.getDoneTrips());
        kmLabel = new JLabel("Kilomètres parcourus : " + data.getKm());
        statsTripPanel.add(notDoneTripsLabel, BorderLayout.NORTH);
        statsTripPanel.add(doneTripsLabel, BorderLayout.CENTER);
        statsTripPanel.add(kmLabel, BorderLayout.SOUTH);
        tripPanel.add(statsTripPanel, BorderLayout.CENTER);
        contentPanel.add(tripPanel, c);

        c.gridy = 1;
        c.gridx = 0;
        carPanel = new JPanel();
        carBorder = BorderFactory.createTitledBorder("Voitures électriques");
        carPanel.setBorder(carBorder);
        electricPercentageLabel = new JLabel(data.getElectricPercentage() + " %");
        carPanel.add(electricPercentageLabel);
        contentPanel.add(carPanel, c);

        c.gridy = 1;
        c.gridx = 1;
        bookPanel = new JPanel();
        bookBorder = BorderFactory.createTitledBorder("Nombre de réservations");
        bookPanel.setBorder(bookBorder);
        numberBookLabel = new JLabel(String.valueOf(data.getBooks()));
        bookPanel.add(numberBookLabel);
        contentPanel.add(bookPanel, c);

        add(contentPanel, BorderLayout.CENTER);

        // Bouton retour
        buttonPanel = new JPanel();
        returnButton = new JButton("Retour");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView menu = new MenuView();
                menu.setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(returnButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        pack();
    }
    private int calcAllUsers() {
        return Integer.parseInt(driverNumberLabel.getText()) + Integer.parseInt(travellerNumberLabel.getText());
    }
    private StatDTO getDatas() {
        //A modifier
        StatDTO data = new StatDTO(18, 55, 45.28, 255, 300, 2763.45, 155);
        return data;
    }
}
