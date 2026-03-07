import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

class asd extends JFrame {

    static JFrame frame;
    static JComboBox<String> c;
    static JButton b;
    static String strVendegOszlopok;
    static int iSzobaOszlopok;
    static String[] arrSzobak;

    void bevitel() {
        frame = new JFrame();

        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame.setLayout(gb);

        gbc.weightx = 0.5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int ivendegOszlopok = Integer.parseInt(strVendegOszlopok);

        ArrayList<TextArea> taLista = new ArrayList<>();

        for (int i = 0; i < ivendegOszlopok; i++){
            gbc.gridx = i;
            taLista.add(new TextArea(1, 25));
            frame.add(taLista.get(i), gbc);
        }

        c = new JComboBox<>();
        gbc.gridx += 1;
        frame.add(c, gbc);

        for (String arrSzobak1 : arrSzobak) {
            c.addItem(arrSzobak1);
        }

        b = new JButton("asd");
        gbc.gridx = 2;
        gbc.gridy = 1;
        frame.add(b, gbc);

        b.addActionListener((ActionEvent e) -> {
            System.out.println("asd");
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://pg.tamado.org:5432/Hotel", "postgres", "hungaryen");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM information_schema.columns WHERE table_name = 'vendegek'");

            while (rs.next()) {
                strVendegOszlopok = rs.getString(1);
            }

            ResultSet rs2 = st.executeQuery("SELECT COUNT(*) FROM szobak");

            while (rs2.next()) {
                iSzobaOszlopok = Integer.parseInt(rs2.getString(1));
            }

            System.out.println(iSzobaOszlopok);
            arrSzobak = new String[iSzobaOszlopok];

            ResultSet rs3 = st.executeQuery("SELECT nev FROM szobak");

            for (int i = 0; i < iSzobaOszlopok && rs3.next(); i++){
                arrSzobak[i] = rs3.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        }

        new asd().bevitel();
    }
}