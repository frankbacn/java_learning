package java_learn.IO.bytestream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class RunTimesCountDemo {
	/**
	 * 程序运行次数计数功能
	 * 当程序运行次数达到限定后就不在允许程序启动
	 * @param args
	 */
	private static File CONFIG_FILE = new File("count.conf"); //定义一个配置文件常量
	private int count; //定义计数器
	private Properties p = new Properties(); //定义配置属性集合
	public static void main(String[] args) {
		RunTimesCountDemo rd = new RunTimesCountDemo();
		//创建运行对象
		rd.readCount();//调用读取方法获取程序运行次数
		if(rd.count<5){ //判断程序运行次数
			System.out.println("成语已运行..."+rd.count+"次");
			rd.addCount(); //调用方法增加程序运行次数
		}else{ //程序运行次数已满则提示
			throw new RuntimeException("程序运行次数已满");
		}
	}
	
	/**
	 * 增加计数器值并将值写入配置文件
	 */
	private void addCount() {
		count++; //计数器自增
		p.setProperty("RunTimes", Integer.toString(count)); //将计数器值保存到集合中
		FileWriter fw = null;
		try{ //创建写入流并保存集合中信息
			fw = new FileWriter(CONFIG_FILE);
			p.store(fw, "");
		}catch(IOException e){
			throw new RuntimeException("配置文件写入失败");
		}finally{
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("配置文件写入失败");
				}
		}
	}
	
	/**
	 * 读取计数器信息
	 */
	private void readCount(){
		if(!CONFIG_FILE.exists()){ //判断配置文件是否存在
			try{ //配置文件不存在就创建配置文件并对其进行初始化
				CONFIG_FILE.createNewFile();
				initConfigFile(); //执行配置文件初始化
			}catch(IOException e){
				throw new RuntimeException("配置文件创建失败");
			}
		}
		FileReader fr = null;
		try{ //读取配置文件
			fr = new FileReader(CONFIG_FILE);
			p.load(fr);
			count = Integer.parseInt(p.getProperty("RunTimes")); //将程序运行次数保存到对象变量中
		}catch(IOException e){
			throw new RuntimeException("配置文件读取失败");
		}finally{
			if(fr != null)
				try{
					fr.close();
				}catch(IOException e){
					throw new RuntimeException("配置文件读取失败");
				}				
		}
		
		
	}
	/**
	 * 初始化配置文件
	 * @throws IOException
	 */
	private void initConfigFile() throws IOException {
		
		
		FileWriter fw = null;
		try{ //创建流对象并将初始化配置写入到配置文件中
			fw = new FileWriter(CONFIG_FILE);
			p.setProperty("RunTimes", "0"); //在集合中增加配置信息
			p.store(fw, "First time run"); //保存配置到配置文件中
		}catch(IOException e){
			throw new IOException("配置文件写入失败");
		}finally{
			if(fw != null)
				fw.close();
		}
	}
	

}
