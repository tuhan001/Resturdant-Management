import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;

public class EnterFood{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel contorlPanel;
    private JLabel id,name,price,quantity;
    private static int count = 0;
    GridLayout experimntLayout = new GridLayout(0, 2);
    RusultSet rs;
    EnterFood(){
        prepareGUI();
    }

    public static void main(String[] args) {
        EnterFood swingControlDemo = new EnterFood();
        swingControlDemo.showButtonDemo();


    }

    private void prepareGUI(){
        mainFrame = new JFrame("Insert a new food item!");
        mainFrame.setSize(700,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.getContentPane().setBackground(Color.pink);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.setVisible(false);
                            }
        });
        headerLabel=new JLabel("",JLabel.CENTER);
        contorlPanel=new JPanel();
        contorlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(contorlPanel);
        mainFrame.setVisible(true);
    }


    public void showButtonDemo(){
        headerLabel.setText("Restaurant Management System");
        headerLabel.setFont(new Font(null,Font.BOLD,27));

        name=new JLabel("Enter Name");
        JTextField tf2 = new JTextField();
        tf2.setSize(100,40);

        price= new JLabel("Enter Price");
        JTextField tf3 = new JTextField();
        tf3.setSize(100,40);

        quantity =new JLabel("Enter Quantity");
        JTextField tf4 = new JTextField();
        tf4.setSize(100,40);

        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst =con.mkDataBase().prepareStatement("Inser into fooditem.food(f_name,f_prize,f_quantity)values(?,?,?)");
                    pst.setString(1,tf2.getText());
                    pst.setDouble(2,Double.parseDouble(tf3.getText()));
                    pst.setInt(3,Integer.parseInt(tf4.getText()));
                    pst.execute();

                    JOptionPane.showMessageDialog(null,"Done Inserting"+tf2.getText());
                    mainFrame.setVisible(false);
                }
                catch (Exception ex){
                    System.out.println(ex);
                    System.out.println("EEEE");
                    JOptionPane.showMessageDialog(null,"Inserting Error:"+tf2.getText());


                }
                finally {

                }
            }
        });
        JPanel jp = new JPanel(null);
        jp.add(name);
        jp.add(tf2);
        jp.add(price);
        jp.add(tf3);
        jp.add(quantity);
        jp.add(tf4);
        jp.setSize(500,500);
        jp.setLayout(experimntLayout);
        contorlPanel.add(jp);
        jp.add(okButton);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

}