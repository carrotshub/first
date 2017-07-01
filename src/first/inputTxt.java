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
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
		File f=new File("D:\\output.txt");
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println("操作数据，开始结束时间");
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
		// 打开一个随机访问文件流，按读写方式
		RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
		// 文件长度，字节数
		long fileLength = randomFile.length();
		// 将写文件指针移到文件尾。
		randomFile.seek(fileLength);
		randomFile.writeBytes(content+"\r\n");
		randomFile.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

		
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		inputTxt a = new inputTxt();
//		a.method1();
//		a.method2("E:\\dd.txt", "222222222222222");
//		a.method3("E:\\dd.txt", "33333333333");
		}
	}


