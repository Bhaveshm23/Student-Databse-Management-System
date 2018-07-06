import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DeleteFrame extends JFrame{

Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;
JPanel p1,p2;

DeleteFrame()
{
c=getContentPane();
p1=new JPanel();
p1.setBackground(Color.green);
lblRno=new JLabel("Rno");
txtRno=new JTextField(5);

p1.add(lblRno);
p1.add(txtRno);

c.add(p1);


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

if(rno.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"rno is empty");
txtRno.requestFocus();
return;
}


DbHandler db=new DbHandler();

db.deleteStudent(Integer.parseInt(rno));//Converting String rno to Int rno
txtRno.setText("");
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
setTitle("Delete Student");
setLocationRelativeTo(null);//Frame at center of screen
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}


