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
	//�����ı���
	TextArea t=new TextArea("",10,100,2);
	CheckboxGroup cbg=new CheckboxGroup();
	//�����ĸ���ѡ�򣬰�����cbg����ʼ����û��ѡ��״̬
	Checkbox c1= new Checkbox("A",cbg,false);
	Checkbox c2= new Checkbox("B",cbg,false);
	Checkbox c3= new Checkbox("C",cbg,false);
	Checkbox c4= new Checkbox("D",cbg,false);
	
	
	public void init(){
		//��ѡ��ť

		//��һ������ť
		Button b1=new Button("��һ��");
		Button b2=new Button("��һ��");
	//����װ���ı����panel
		Panel text=new Panel();
		text.add(t);
		t.setEditable(false);	
		f.setLocation(180, 150);
		t.setFont(new Font("����",Font.LAYOUT_LEFT_TO_RIGHT, 18));
		f.add(text,BorderLayout.NORTH); 
	//����װ���ĸ�ѡ���panel
		Panel p1=new Panel();
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(c4);
		c1.setState(true);
	//��ѡ����Ӽ����¼�
		
	//������ֱװ���ĸ�ѡ���box
		Box choices=Box.createVerticalBox();
		choices.add(p1);
		f.add(choices,BorderLayout.CENTER);
		
	//����װ��������ť��panel
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
            		t.setText("����û�����ˣ���");
            		System.out.println("����û�����ˣ���");
            	}	
            	//t.setText("����");
                
            }});
		b2.addActionListener(new mm(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tag>=1&tag<=4){
            	b1.setEnabled(true);
            	t.setText("");
            	tag=tag+1;
            	settext(tag);
            	new inputTxt().method2("D:\\output.txt","��"+(tag-1)+"��ѡ���ˣ�"+cbg.getSelectedCheckbox().getLabel());
            	//t.setText("������");
            	}
            	else{
            		new inputTxt().method2("D:\\output.txt","��"+(tag)+"��ѡ���ˣ�"+cbg.getSelectedCheckbox().getLabel());
            		f.setVisible(false);
            		Date d=new Date(System.currentTimeMillis());
    				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);//�������ڸ�ʽ
    				Timestamp goodsC_date =Timestamp.valueOf(nowTime);
    				new inputTxt().method2("D:\\output.txt","ֹͣ����ʱ�䣺"+nowTime);
            	}
            }});
		f.add(p2,BorderLayout.SOUTH);
		
		f.pack();
		f.addWindowListener(this);
		f.setVisible(true);
	}
	//���ı�����
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
	//�����ڲ�����¼�����
	class mm implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			
		}
	}
	class cc implements  ItemSelectable{

		@Override
		public Object[] getSelectedObjects() {
			// TODO �Զ����ɵķ������
			return null;
		}

		@Override
		public void addItemListener(ItemListener l) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void removeItemListener(ItemListener l) {
			// TODO �Զ����ɵķ������
			
		}
	}
	public void windowOpened(WindowEvent e) {
		// TODO �Զ����ɵķ������
		s.con();
		for(int i=0;i<5;i++){
			t.append((String) (s.a1.get(i)+"\n"));
			}
		
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//new question().init();
	}

}
