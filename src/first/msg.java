package first;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import first.inputTxt;

import first.countTime;


public class msg extends ComponentAdapter{
	
	 long l1,l2;
	 long sum;
	 int i;
	//public  int counts=0;
	public static Frame f1=new Frame("relative msg");
	TextArea t1=new TextArea("",5,10,3);
	//TextArea t2=new TextArea("",5,10,3);

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO �Զ����ɵķ������		
		l1=System.currentTimeMillis();
		System.out.println("������ʾ"+l1);
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO �Զ����ɵķ������
		l2=System.currentTimeMillis();
		sum=l2-l1;
		new inputTxt().method2("D:\\output.txt","��Ϣ�����ʱ�䣺"+sum);
		System.out.println(sum+"sum=====");
		System.out.println("wo������"+l2);
				
	}
	public  void receiving(int cou){
		//st=System.currentTimeMillis();
		f1.setSize(500, 200);
		f1.setLocation(350, 250);
		
		t1.setEditable(false);
		t1.setFont(new Font("����",Font.LAYOUT_LEFT_TO_RIGHT, 18));
		apending(t1,cou);
		f1.add(t1, BorderLayout.NORTH);
		
		Button b1=new Button("ȷ��");
		b1.addMouseListener(new MouseListener1());
		f1.add(b1,BorderLayout.SOUTH);
		f1.addWindowListener(new mywindowListerning());
		f1.addComponentListener(this);
		
		f1.setVisible(true);
		
	}
	public static ArrayList<String> reading(){
		ArrayList<String> a =new ArrayList<String>();		
		String filePath="../first/sourtxt/6.txt";
		//��ȡ�ļ�
				try {
					 File file=new File(filePath);
				     String encoding="GBK";
				          if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
				        	  InputStreamReader read = new InputStreamReader(
				              new FileInputStream(file),encoding);//���ǵ������ʽ
				              BufferedReader bufferedReader = new BufferedReader(read);
				              String lineTxt = null;
				              while((lineTxt = bufferedReader.readLine()) != null){	  
				            		  a.add(lineTxt);  
				            	
//				            	  t.append("\n");
//				                  t.append(lineTxt);
				             }
				                  read.close();
				                  
		       }else{
		           System.out.println("�Ҳ���ָ�����ļ�");
		       }
		       } catch (Exception e) {
		           System.out.println("��ȡ�ļ����ݳ���");
		           e.printStackTrace();
		       }
				return a;
	}
	public  void apending(TextArea c,int counts){
		ArrayList f=reading();	
		if(counts==0){
			c.append((String) f.get(0));}
			//c.setText("");}
			
			else if(counts==1)
			{	c.setText("");
				c.append((String) f.get(1));
		}
			else if(counts==2)
			{c.setText("");
				c.append((String) f.get(2));
		}
			else if(counts==3)
			{c.setText("");
				c.append((String) f.get(3));
		}
			else if(counts==4)
			{	c.setText("");
				c.append((String) f.get(4));
		}

		//System.out.println(f.get(0));		
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//msg m=new msg();
		

	}
}
class MouseListener1 implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//long peroid=new msg().ed-new msg().st;
//		System.out.println("hshshshh"+peroid);
		//new countTime(1).st();
		new msg().t1.setText("");
		new msg().f1.setVisible(false);
		
		System.out.println("lllllllllllllllll");
		
		//new msg().counts=1;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
} 
class mywindowListerning extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
	}	
	public void windowOpened(WindowEvent e) {
		// TODO �Զ����ɵķ������
	}	
}

