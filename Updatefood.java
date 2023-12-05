import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Updatefood {
    private JFrame mainFream;
    private JLabel headerLabel;
    private JLabel statusLabel;

    private JPanel controlPanel;
    private JLabel id,name,price,quantity;
    private static int count =0;
    GridLayout expimentLayout = new GridLayout(0,2);
    ResultSet rs;
    Upadatefood(){
        prepareGUI();
    }

    public static void main(String[] args) {
        Updatefood swingControlDemo=new Updatefood();
        swingControlDemo.showButtonDemo();
    }
    private void prepareGUI(){
        mainFream=new JFrame("Update!");
        mainFream.setSize(700,400);
        mainFream.setLayout(new GridLayout(3,1));
        mainFream.getContentPane().setBackground(Color.pink);
        mainFream.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                mainFream.setVisible(false);
            }
        });
        headerLabel=new JLabel("",JLabel.CENTER);
        statusLabel=new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,400);
        controlPanel=new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFream.add(headerLabel);
        mainFream.add(controlPanel);
        mainFream.add(statusLabel);
        mainFream.setVisible(true);
    }
    public void showButtonDemo(){
        headerLabel.setText("Restaurant Management System");
        headerLabel.setFont(new Font(null,Font.BOLD,27));

        name = new JLabel("Enter Name");
        JTextField tf2= new JTextField();
        tf2.setSize(100,30);

        price = new JLabel("Enter Price");
        JTextField tf3= new JTextField();
        tf3.setSize(100,30);

        quantity = new JLabel("Enter Quantity");
        JTextField tf4 = new JTextField();
        tf4.setSize(100,30);

        JButton okButton = new JButton("Update");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst=con.mkDataBase().prepareStatement("Update manu");
                    pst.setString(3,tf2.getText());
                    pst.setDouble(2,Double.parseDouble(tf3.getText()));
                    pst.setInt(1,Integer.parseInt(tf4.getText()));
                    pst.execute();

                    JOptionPane.showMessageDialog(null,"Done Updating"+tf2.getText());
                    mainFream.setVisible(false);
                }
                catch (Exception ex){
                    System.out.println(ex);
                    System.out.println("Error");
                    JOptionPane.showMessageDialog(null,"Inserting Error: "+tf2.getText());

                }
                finally {

                }
            }
        });
        JPanel jp = new JPanel();
        jp.add(name);
        jp.add(tf2);
        jp.add(price);
        jp.add(tf3);
        jp.add(quantity);
        jp.add(tf4);
        jp.setSize(200,200);
        jp.setLayout(expimentLayout);
        controlPanel.add(jp);
        jp.add(okButton);
        mainFream.setVisible(true);
        mainFream.setLocationRelativeTo(null);
    }

}
