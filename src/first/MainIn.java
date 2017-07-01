package first;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import first.countTime;
import first.msg;
import first.question;
import first.SQL;
import first.inputTxt;
public class MainIn{
	public static int count=0;
	
	public static void paints(){
		String filePath = "../first/sourtxt/5.txt";
		//"res/";
		String s="";
		Frame f=new Frame("ReadingWindows");
		
		f.setSize(1200,700);
		f.setLocation(90,10);
		f.setResizable(false);			
		Panel p1=new Panel();
		Panel p2=new Panel();
		f.add(p1,BorderLayout.NORTH);
		f.add(p2,BorderLayout.SOUTH); 
		
		//p1.setLayout(new FlowLayout());
		p1.setSize(1200, 630);
		p1.setLocation(0, 20);
		//p1.setLayout(mgr);
		p1.setBackground(Color.white);
		
		p2.setLayout(new  FlowLayout());
		p2.setSize(1200,70);
		p2.setBackground(Color.gray);

		//button
		String str="完成上文阅读后点击按钮开始作答";
		Button button1=new Button("进入作答");
		Label tf=new Label(str);
		p2.add(tf,BorderLayout.EAST);
		tf.setFont(new Font("",1,20));
		p2.add(button1,BorderLayout.WEST);
		button1.setBackground(Color.red);
		button1.addActionListener(new bb(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				Date d=new Date(System.currentTimeMillis());
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);//设置日期格式
				Timestamp goodsC_date =Timestamp.valueOf(nowTime);
				new inputTxt().method2("D:\\output.txt","开始作答时间："+nowTime);
//				String sql="insert into readingdata(StopTime) values ('"+goodsC_date+"')";
//				new SQL().save(sql);
				new question().init();
				//f.setVisible(false);
			}
		});
		button1.setSize(50, 35);
		//button1.setEnabled(true);
		//button1.setVisible(true);
				
		TextArea t=new TextArea(s,25,107,1);
		p1.add(t,BorderLayout.CENTER);
		t.setFont(new Font("宋体",Font.LAYOUT_LEFT_TO_RIGHT, 20));  
		t.setEditable(false);
		t.setSize(1200,630);
		t.setBackground(new Color(240,240,240));
		t.setLocation(0, 0);
		//读取文件
		try {
		     String encoding="GBK";
		     File file=new File(filePath);
		          if(file.isFile() && file.exists()){ //判断文件是否存在
		        	  InputStreamReader read = new InputStreamReader(
		              new FileInputStream(file),encoding);//考虑到编码格式
		              BufferedReader bufferedReader = new BufferedReader(read);
		              String lineTxt = null;
		              while((lineTxt = bufferedReader.readLine()) != null){
		            	  t.append("\n");
		                  t.append(lineTxt);
		             }
		                  read.close();
       }else{
           System.out.println("找不到指定的文件");
       }
       } catch (Exception e) {
           System.out.println("读取文件内容出错");
           e.printStackTrace();
       }
		f.addWindowListener(new MyWindowsListerner());
		f.setVisible(true);
	}
	
	public static void main(String args[]){
		paints();
	}
}
class MyWindowsListerner extends WindowAdapter {
		public void windowOpened(WindowEvent w) {
		// TODO 自动生成的方法存根
			Date d=new Date(System.currentTimeMillis());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);//设置日期格式
			Timestamp goodsC_date =Timestamp.valueOf(nowTime);
			new inputTxt().method1();//准备写入txt
			new inputTxt().method2("D:\\output.txt","开始阅读时间："+nowTime);
//			String sql="insert into readingdata(StartTime) values ('"+goodsC_date+"')";
//			new SQL().save(sql);
//			System.out.println(goodsC_date);
			new countTime(1).st();	
		}
		public void windowClosing(WindowEvent e) {
			// TODO 自动生成的方法存根
			Date d=new Date(System.currentTimeMillis());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);//设置日期格式
			Timestamp goodsC_date =Timestamp.valueOf(nowTime);
			new inputTxt().method2("D:\\output.txt","停止阅读时间："+nowTime);
			System.out.println("closing");
	        System.exit(0);
		}	

	}
class bb implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}
