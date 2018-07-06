import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomeFrame extends JFrame
{

Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

HomeFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");


c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.setBackground(Color.blue);


btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
AddFrame a=new AddFrame();
dispose();}
});


btnView.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
ViewFrame a =new ViewFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a =new UpdateFrame();
dispose();
}
});
btnDelete.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a =new DeleteFrame();
dispose();
}
});


setSize(400,150);
setTitle("SMS");
setLocationRelativeTo(null);//Frame at center of screen
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

public static void main(String args[])
{
HomeFrame h=new HomeFrame();
}

}


class DbHandler
{
static Connection c;
public static void getConn()
{
 try
{

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());//Load the Driver
c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");//Get cOnnection

}

catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}

}

public void addStudent(int rno,String name)
{
getConn();

try{

String sql="insert into student values(?,?)";//Dynamic adding of data
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);

int r=pst.executeUpdate();

JOptionPane.showMessageDialog(new JDialog(),r+"records inserted");
}

catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"insert issue"+se);
}
}

public void deleteStudent(int rno)
{
getConn();

try{

String sql="delete  from student where rno=?";//Dynamic adding of data
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(1,rno);


int r=pst.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(),r+"records deleted");
}

catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"insert issue"+se);
}
}
public void updateStudent(int rno,String name)
{
getConn();

try{

String sql="update student set name=? where rno=?";//Dynamic adding of data
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(2,rno);
pst.setString(1,name);

int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records updated");
}

catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"insert issue"+se);
}
}


public String viewStudent()
{
getConn();

StringBuffer sb=new StringBuffer();

try{

String sql="select * from student order by rno";
Statement stmt=c.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
int rno=rs.getInt(1);
String name=rs.getString(2);
sb.append(rno+"---"+name+"\n");

}
rs.close();
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}

return sb.toString();


}
}









