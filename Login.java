import javax.swing.*;
import java.awt.*;

public class Frame1 extends JFrame{
    JLabel idLabel;
    JLabel passLabel;
    JLabel background;
    JLabel headerLabel;
    JLabel devinfo;
    JTextField id;
    JPasswordField pass;
    JButton submit;


    public Frame1(){
        setTitle("Restaurant Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

      add(background);
      background.setVisible(true);
        setSize(700,400);
      setBackground(Color.red);

    }

    public void init(){
        headerLabel =new JLabel();
        this.headerLabel.setText("Restaurant Management System");
        this.headerLabel.setBounds(270,1,200,100);
        this.headerLabel.setFont(new Font("Geomanist",Font.BOLD,25));
        headerLabel.setForeground(Color.black);
        add(headerLabel);
        idLabel = new JLabel();

        this.idLabel.setText("username");
        this.idLabel.setBounds(190,110,100,50);
        this.idLabel.setFont(new Font(null, Font.BOLD,20));
        idLabel.setForeground(Color.black);
        add(idLabel);

        passLabel = new JLabel("Password");
        this.passLabel.setBounds(190,165,100,50);
        this.passLabel.setFont(new Font(null,Font.BOLD,20));
        passLabel.setForeground(Color.white);
        add(passLabel);


       devinfo = new JLabel();
       this.devinfo.setBounds(130,300,100,30);
       this.devinfo.setFont(new Font("Geomanist",Font.PLAIN,15));
       devinfo.setForeground(Color.white);
       add(devinfo);

       id = new JTextField();
       this.id.setBounds(300,125,200,30);
       add(id);



       pass = new JPasswordField();
       this.add(pass);
       this.pass.setBounds(300,175,200,30);
       this.id.setVisible(true);

       this.submit=new JButton("Login");
       this.submit.setBounds(400,230,100,25);
       add(submit);
       submit.addActionListener(this::submitActionPerformed);




    }


    public void submitActionPerformed(java.awt.event.ActionEvent evt){
      if (id.getText().equals("admin")&&pass.getText().equals("admin")){
          this.hide();
          Frame2new fn=new Frame2new();
          fn.showBottonDemo();
      }
      else {
          JOptionPane.showMessageDialog(null,"invalid password");
      }
    }
}


public class Login {
    public static void main(String[] args) {
        Frame1 f = new Frame1();
        f.setVisible(true);
    }

    @Override
    public String toString() {
      return "Login []";
    }
}
