package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {
	ArrayList a1=new ArrayList();
	ArrayList a2=new ArrayList();
	ArrayList a3=new ArrayList();
	ArrayList a4=new ArrayList();
	ArrayList a5=new ArrayList();

	public void save(String sql){
		//����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://localhost:3306/first";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "******";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            statement.execute(sql);
           //sql = "select * from question";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ�д�룡��");
        }
    }
    
	
     public void con(){
    	 //����Connection����
         Connection con;
         //����������
         String driver = "com.mysql.jdbc.Driver";
         //URLָ��Ҫ���ʵ����ݿ���mydata
         String url = "jdbc:mysql://localhost:3306/first";
         //MySQL����ʱ���û���
         String user = "root";
         //MySQL����ʱ������
         String password = "123456";
         //������ѯ�����
         try {
             //������������
             Class.forName(driver);
             //1.getConnection()����������MySQL���ݿ⣡��
             con = DriverManager.getConnection(url,user,password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             //2.����statement���������ִ��SQL��䣡��
             Statement statement = con.createStatement();
             //Ҫִ�е�SQL���
             String sql = "select * from questiony2";
             //3.ResultSet�࣬������Ż�ȡ�Ľ��������
             ResultSet rs = statement.executeQuery(sql);
             System.out.println(rs);
             String g1 = null;
             String g2 = null;
             String g3 = null;
             String g4 = null;
             String g5 = null;
             while(rs.next()){
                 //��ȡstuname��������
                 g1 = rs.getString("n1");
                 a1.add(g1);
                 //System.out.println(g1);
                 //��ȡstuid��������
                 g2 = rs.getString("n2");
                 a2.add(g2);
                 //System.out.println(g2);
                 g3 = rs.getString("n3");
                 a3.add(g3);
                 g4 = rs.getString("n4");
                 a4.add(g4);
                 g5 = rs.getString("n5");
                 a5.add(g5);
                 //������
             }
             System.out.println(a1);
             rs.close();
             con.close();
         } catch(ClassNotFoundException e) {   
             //���ݿ��������쳣����
             System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
             } catch(SQLException e) {
             //���ݿ�����ʧ���쳣����
             e.printStackTrace();  
             }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }finally{
             System.out.println("���ݿ����ݳɹ���ȡ����");
         }
     }
     

     
    public static void main(String[] args) {
       new SQL().con();
    }
}