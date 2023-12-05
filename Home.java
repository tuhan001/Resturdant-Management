import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home {
    private JFrame mainFrame;
    private JLabel headerLabel;

    private JLabel statusLabel;
    private JPanel controlPanel;


    public Home(){
        preepareGUI();
    }

    public static void main(String[] args) {
        Frame2new swingControlDemo = new Frame2new();
        swingControlDemo.showButtonDemo();
    }

    private void preepareGUI(){
        mainFrame=new JFrame("Restaurant Manegement System");
        mainFrame.setBounds(100,100,700,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.getContentPane().setBackground(Color.pink);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        headerLabel=new JLabel("",JLabel.CENTER);
        statusLabel=new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,300);
        controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(1,5));


        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public void showButtonDemo(){
        headerLabel.setText("Restaurant Management System");
        this.headerLabel.setFont(new Font(null,Font.BOLD,27));
        headerLabel.setForeground(Color.white);
        JButton fkButton =new JButton("Food Info");
        JButton billButton = new JButton("Billing Info");
        JButton afButton = new JButton("Insert Item");
        JButton ufButton = new JButton("Update Item");

        //delete
        JButton dlButton = new JButton("Delete Item");
        fkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ItemInfo ii = new ItemInfo();
               try {
                   ii.showButtonDemo();
               }
               catch (SQLException ex){
                   Logger.getLogger(Frame2new.class.getName()).log(Level.SEVERE,null,ex);

               }
            }
        });
        billButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateBill gb = new GenerateBill();
            }
        });
        afButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnterFood ef = new EnterFood();
                ef.showButtonDemo();
            }
        });
        ufButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpadateFood uf = new UpdateFood();
                uf.showButtonDemo();
            }
        });
        dlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFood dl = new DeleteFood();
                dl.showButtonDemo();
            }
        });
        controlPanel.add(ufButton);
        controlPanel.add(afButton);
        controlPanel.add(billButton);
        controlPanel.add(fkButton);
        controlPanel.add(dlButton);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }

}
