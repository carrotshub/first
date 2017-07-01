package first;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import first.SQL;

import javax.swing.Box;
public class question extends WindowAdapter{
	int tag=1;
	SQL s=new SQL();
	Frame f=new Frame("question");
	//多行文本框
	TextArea t=new TextArea("",10,100,2);
	CheckboxGroup cbg=new CheckboxGroup();
	//定义四个单选框，包含在cbg，开始处于没有选中状态
	Checkbox c1= new Checkbox("A",cbg,false);
	Checkbox c2= new Checkbox("B",cbg,false);
	Checkbox c3= new Checkbox("C",cbg,false);
	Checkbox c4= new Checkbox("D",cbg,false);
	
	
	public void init(){
		//单选按钮

		//第一两个按钮
		Button b1=new Button("上一题");
		Button b2=new Button("下一题");
	//创建装载文本域的panel
		Panel text=new Panel();
		text.add(t);
		t.setEditable(false);	
		f.setLocation(180, 150);
		t.setFont(new Font("宋体",Font.LAYOUT_LEFT_TO_RIGHT, 18));
		f.add(text,BorderLayout.NORTH); 
	//创建装载四个选项的panel
		Panel p1=new Panel();
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(c4);
		c1.setState(true);
	//复选框添加监听事件
		
	//创建垂直装载四个选项的box
		Box choices=Box.createVerticalBox();
		choices.add(p1);
		f.add(choices,BorderLayout.CENTER);
		
	//创建装载两个按钮的panel
		Panel p2=new Panel();
		p2.add(b1);
		b1.setEnabled(false);
		p2.add(b2);
		b1.addActionListener(new mm(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	t.setText("");
            	if(tag==2)
            	{
            		b1.setEnabled(false);
            	}
            	//b1.setEnabled(true);
            	if(tag>1&tag<6){
            		tag=tag-1;
            		settext(tag);}
            	else{
            		t.setText("上面没有题了！！");
            		System.out.println("上面没有题了！！");
            	}	
            	//t.setText("测试");
                
            }});
		b2.addActionListener(new mm(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tag>=1&tag<=4){
            	b1.setEnabled(true);
            	t.setText("");
            	tag=tag+1;
            	settext(tag);
            	new inputTxt().method2("D:\\output.txt","第"+(tag-1)+"题选择了："+cbg.getSelectedCheckbox().getLabel());
            	//t.setText("测试下");
            	}
            	else{
            		new inputTxt().method2("D:\\output.txt","第"+(tag)+"题选择了："+cbg.getSelectedCheckbox().getLabel());
            		f.setVisible(false);
            		Date d=new Date(System.currentTimeMillis());
    				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);//设置日期格式
    				Timestamp goodsC_date =Timestamp.valueOf(nowTime);
    				new inputTxt().method2("D:\\output.txt","停止作答时间："+nowTime);
            	}
            }});
		f.add(p2,BorderLayout.SOUTH);
		
		f.pack();
		f.addWindowListener(this);
		f.setVisible(true);
	}
	//换文本函数
	public void settext(int tag){
		this.tag=tag;
		if(tag==1){
			for(int i=0;i<5;i++){
				t.append((String) s.a1.get(i)+"\n");
			}
		}
		else if(tag==2){
			for(int i=0;i<5;i++){
				t.append((String) s.a2.get(i)+"\n");
			}
		}
		else if(tag==3){
			for(int i=0;i<5;i++){
				t.append((String) s.a3.get(i)+"\n");
			}
		}
		else if(tag==4){
			for(int i=0;i<5;i++){
				t.append((String) s.a4.get(i)+"\n");
			}
		}
		else if(tag==5){
			for(int i=0;i<5;i++){
				t.append((String) s.a5.get(i)+"\n");
			}
		}
	}
	//创建内部鼠标事件监听
	class mm implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			
		}
	}
	class cc implements  ItemSelectable{

		@Override
		public Object[] getSelectedObjects() {
			// TODO 自动生成的方法存根
			return null;
		}

		@Override
		public void addItemListener(ItemListener l) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void removeItemListener(ItemListener l) {
			// TODO 自动生成的方法存根
			
		}
	}
	public void windowOpened(WindowEvent e) {
		// TODO 自动生成的方法存根
		s.con();
		for(int i=0;i<5;i++){
			t.append((String) (s.a1.get(i)+"\n"));
			}
		
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//new question().init();
	}

}
