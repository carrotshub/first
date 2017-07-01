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
		//声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/first";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "******";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            statement.execute(sql);
           //sql = "select * from question";
            //3.ResultSet类，用来存放获取的结果集！！
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功写入！！");
        }
    }
    
	
     public void con(){
    	 //声明Connection对象
         Connection con;
         //驱动程序名
         String driver = "com.mysql.jdbc.Driver";
         //URL指向要访问的数据库名mydata
         String url = "jdbc:mysql://localhost:3306/first";
         //MySQL配置时的用户名
         String user = "root";
         //MySQL配置时的密码
         String password = "123456";
         //遍历查询结果集
         try {
             //加载驱动程序
             Class.forName(driver);
             //1.getConnection()方法，连接MySQL数据库！！
             con = DriverManager.getConnection(url,user,password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             //2.创建statement类对象，用来执行SQL语句！！
             Statement statement = con.createStatement();
             //要执行的SQL语句
             String sql = "select * from questiony2";
             //3.ResultSet类，用来存放获取的结果集！！
             ResultSet rs = statement.executeQuery(sql);
             System.out.println(rs);
             String g1 = null;
             String g2 = null;
             String g3 = null;
             String g4 = null;
             String g5 = null;
             while(rs.next()){
                 //获取stuname这列数据
                 g1 = rs.getString("n1");
                 a1.add(g1);
                 //System.out.println(g1);
                 //获取stuid这列数据
                 g2 = rs.getString("n2");
                 a2.add(g2);
                 //System.out.println(g2);
                 g3 = rs.getString("n3");
                 a3.add(g3);
                 g4 = rs.getString("n4");
                 a4.add(g4);
                 g5 = rs.getString("n5");
                 a5.add(g5);
                 //输出结果
             }
             System.out.println(a1);
             rs.close();
             con.close();
         } catch(ClassNotFoundException e) {   
             //数据库驱动类异常处理
             System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
             } catch(SQLException e) {
             //数据库连接失败异常处理
             e.printStackTrace();  
             }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }finally{
             System.out.println("数据库数据成功获取！！");
         }
     }
     

     
    public static void main(String[] args) {
       new SQL().con();
    }
}