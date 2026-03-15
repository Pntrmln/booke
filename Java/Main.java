import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

class gui extends JFrame {

    static JFrame frame;
    static JComboBox<String> c;
    static JButton b;
    static String strVendegOszlopok;
    static int iSzobaOszlopok;
    static String[] arrSzobak;

    void bevitel() {
        frame = new JFrame();

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        BorderLayout bl = new BorderLayout();
    
        JPanel BevitelTab = new JPanel();

        JPanel bevitelMezoPanel = new JPanel(gb);
        JPanel bevitelGombPanel = new JPanel();

        BevitelTab.setLayout(bl);

        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int ivendegOszlopok = Integer.parseInt(strVendegOszlopok);

        ArrayList<TextArea> taLista = new ArrayList<>();
        ArrayList<Component> comp = new ArrayList<>();
        
        for (int i = 0; i < ivendegOszlopok; i++){
            gbc.gridy = i;
            TextArea ta = new TextArea(1, 25);
            taLista.add(ta);
            comp.add(ta);
            bevitelMezoPanel.add(ta,gbc);
        }

        c = new JComboBox<>();
        c.addItem("");
        comp.add(c);

        gbc.gridy += 1;
        bevitelMezoPanel.add(c, gbc);

        for (int i = 0; i < comp.size(); i++) {
            gbc.gridx = 1;
            gbc.gridy = i;
            bevitelMezoPanel.add(new Label(String.valueOf(i)), gbc);
        }
    
        BevitelTab.add(bevitelMezoPanel, BorderLayout.PAGE_START);

        for (String arrSzobak1 : arrSzobak) {
            c.addItem(arrSzobak1);
        }

        b = new JButton("Foglalás rögzítése");
        b.setBackground(Color.GREEN);
        
        bevitelGombPanel.add(b, gbc);
        BevitelTab.add(bevitelGombPanel, BorderLayout.PAGE_END);

        frame.add(BevitelTab);
        tabs.addTab("Bevitel", BevitelTab);

        JPanel foglalasok = new JPanel();
        foglalasok.add(new Label("Még nincs itt semmi!"));
        tabs.addTab("Foglalások", foglalasok);

        frame.add(tabs);
        frame.setVisible(true);
        
        ArrayList<String> adatok = new ArrayList<>();
        
        b.addActionListener((ActionEvent e) -> {
            for(int i = 0; i < taLista.size() ; i++) {
                String adat = taLista.get(i).getText() + "";
                adatok.add(adat);
                
            }
            adatok.add(c.getSelectedItem()+ "");

            boolean missingData = false;
            
            for(int i = 0; i < adatok.size(); i++) {
                if(adatok.get(i).isEmpty()) {
                    missingData = true;
                    break;
                }
            }

            if(!missingData) {
                for(int i = 0; i < taLista.size(); i++) {
                    taLista.get(i).setText("");
                }
                c.setSelectedIndex(0);
                System.out.println(adatok);
            
            }
            adatok.clear();
        });

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
            arrSzobak = new String[iSzobaOszlopok];

            ResultSet rs3 = st.executeQuery("SELECT nev FROM szobak");

            for (int i = 0; i < iSzobaOszlopok && rs3.next(); i++){
                arrSzobak[i] = rs3.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Hiba: " + e.getMessage());
        }

        new gui().bevitel();
    }
}