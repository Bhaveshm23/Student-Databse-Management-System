import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame
{
Container c;
JTextArea taData;
JScrollPane spData;
JButton btnBack;
JPanel p1,p2;


ViewFrame()
{
	
c=getContentPane();
p1=new JPanel();
taData=new JTextArea(4,20);
spData=new JScrollPane(taData);
p1.add(spData);
c.add(p1);


DbHandler db=new DbHandler();
String data =db.viewStudent();
taData .setText(data);


p2=new JPanel();
btnBack=new JButton("Back");
p2.add(btnBack);
c.add("South",p2);
//c.setBackground(Color.orange);

btnBack.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
	JOptionPane.showMessageDialog(new JDialog(),"Taking you to Home Page"+"\n   Press Ok to continue" );
HomeFrame a=new HomeFrame();
dispose();
}
});

setSize(400,150);
setTitle("Add Student");
setLocationRelativeTo(null);//Frame at center of screen
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}