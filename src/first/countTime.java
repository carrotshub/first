package first;


public class countTime extends Thread{
	int count;
	msg m=new msg();
	public countTime(int count){
		this.count=count;
	}
	@Override
	public void  run(){
		//msg k=new msg();
		//int cc=0;
		while(true){
			System.out.println(count++);
			if(count==15){
				m.receiving(0);
			}
			else if(count==(32+(m.sum)/1000)){
				System.out.println(m.sum);
				m.receiving(1);
			}
			else if(count==(52+(m.sum)/1000)){
				System.out.println(m.sum);
				m.receiving(2);
			}
			else if(count==(78+(m.sum)/1000)){
				System.out.println("---------"+m.sum);
				m.receiving(3);
			}
			else if(count==(107+(m.sum)/1000)){
				System.out.println(m.sum);
				m.receiving(4);
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){
			System.out.println(e.getMessage());
			}
		}
	}
	
	public void st(){
		//this.setDaemon(true);
		//System.out.println("cc现在是：：："+cc);
		this.start();
	}
	public void st1(){
		//this.setDaemon(true);
		//System.out.println("cc现在是：：："+cc);
		if(count==1000*1000){
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//new countTime().st();
	}

}
