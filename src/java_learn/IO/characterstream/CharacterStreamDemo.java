package java_learn.IO.characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {

	public static void main(String[] args) {

		/*
		 * 复制C盘文本文件至D盘
		 * 
		 */
		FileReader fr = null;
		FileWriter fw = null;
		//声明两个字符流对象
		char[] buf = new char[8192];
		//创建读取流缓冲区
		int len = 0;
		//创建读取流每次的计数器
		try {
			fw = new FileWriter("F:\\java learn\\mutex.txt");
			fr = new FileReader("F:\\java learn\\java_base_learn\\mutex.log");
			//初始化两个字符流对象，并关联文件
			while((len = fr.read(buf))!=-1) {
				//循环读取文件内容到缓冲区
				fw.write(new String(buf,0,len));
				//将缓冲区中的内容转为字符串通过字符输出流写入文件缓冲区
				fw.flush();
				//刷新缓冲区
			}
		}catch(IOException e){
			System.out.println(e);
		}finally {
			//关闭资源
			if(fr!=null)
				try {
					fr.close();
				}catch(IOException e){
					
				}
			if(fw!=null)
				try {
					fw.close();
				}catch(IOException e){
					
				}
		}
	}

}
