package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  javax.swing.*;
import java.util.ArrayList;

class asd extends JFrame {

    static JFrame frame;
    static TextArea t1, t2, t3, t4, t5, t6, t7, t8;
    static JComboBox c;
    static JButton b;
    static JLabel l;

    String asd = null;

    void bevitel() {



        frame = new JFrame();

        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame.setLayout(gb);

        t1 = new TextArea(1, 25);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(t1, gbc);


        t2 = new TextArea(1, 25);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(t2, gbc);


        t3 = new TextArea(1, 25);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(t3, gbc);

        t4 = new TextArea(1, 25);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(t4, gbc);


        String[] lista = new String[4];

        c = new JComboBox();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        frame.add(c, gbc);


        b = new JButton("asd");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(b, gbc);


        String finalAsd = asd;
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista[0] = t1.getText();
                c.addItem(lista[0]);

                lista[1] = t2.getText();
                c.addItem(lista[1]);

                lista[2] = t3.getText();
                c.addItem(lista[2]);

                lista[3] = t4.getText();
                c.addItem(lista[3]);

            }
        });


        frame.setVisible(true);


    }

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://pg.tamado.org:5432/Hotel", "postgres", "hungaryen");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test");


            while (rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2));
                System.out.println();



            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        //new asd().bevitel();
    }


}