package first;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
public class inputTxt {
	public void method1() {
		FileWriter fw = null;
		try {
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
		File f=new File("D:\\output.txt");
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println("�������ݣ���ʼ����ʱ��");
		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	
	public static void method2(String file, String conent) {
		BufferedWriter out = null;
		try {
		out = new BufferedWriter(new OutputStreamWriter(
		new FileOutputStream(file, true)));
		out.write(conent+"\r\n");
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		out.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		}
	
	public static void method3(String fileName, String content) {
		try {
		// ��һ����������ļ���������д��ʽ
		RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
		// �ļ����ȣ��ֽ���
		long fileLength = randomFile.length();
		// ��д�ļ�ָ���Ƶ��ļ�β��
		randomFile.seek(fileLength);
		randomFile.writeBytes(content+"\r\n");
		randomFile.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

		
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		inputTxt a = new inputTxt();
//		a.method1();
//		a.method2("E:\\dd.txt", "222222222222222");
//		a.method3("E:\\dd.txt", "33333333333");
		}
	}


