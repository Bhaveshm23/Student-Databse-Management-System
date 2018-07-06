import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpdateFrame extends JFrame{

Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

UpdateFrame()
{
c=getContentPane();
p1=new JPanel();
lblRno=new JLabel("Rno");
txtRno=new JTextField(5);
lblName=new JLabel("Name");
txtName=new JTextField(10);

p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);

c.add(p1);
p1.setBackground(Color.orange);


p2=new JPanel();
btnSave=new JButton("Save");
btnBack=new JButton("Back");
p2.add(btnSave);

p2.add(btnBack);

c.add("South",p2);
btnSave.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
String rno=txtRno.getText();
String name=txtName.getText();


if(rno.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"rno is empty");
txtRno.requestFocus();
return;
}

if(name.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"name is empty");
txtName.requestFocus();
return;
}

DbHandler db=new DbHandler();
db.updateStudent(Integer.parseInt(rno),name);//Converting String rno to Int rno
txtRno.setText("");
txtName.setText("");

txtRno.requestFocus();
}
});
btnBack.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
	JOptionPane.showMessageDialog(new JDialog(),"Taking you to Home Page"+"\n   Press Ok to continue" );

HomeFrame a= new HomeFrame();
dispose();
}
});

setSize(400,150);
setTitle("Update Student");
setLocationRelativeTo(null);//Frame at center of screen
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}


