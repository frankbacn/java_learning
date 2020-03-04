package java_learn.IO.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ByteStreamDemo {

	public static void main(String[] args) throws IOException {
		
		//copyFile();
//		cppyFileBuffered();
//		keybroadRead();
//		keybroadRead2();
		keybroadReadByLine();
	}

	private static void keybroadReadByLine() throws IOException {
		BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		while((str = bri.readLine())!=null){
			if(str.equals("over")){
				break;
			}
			System.out.println(str.toUpperCase());
		}
	}

	private static void keybroadRead2() throws IOException {
		char[] buf = new char[1024];
		int len = 0;
		int ch = 0;
		String str = null;
		while((ch = System.in.read())!=-1) {
			if((char)ch=='\r')
				continue;
			if((char)ch=='\n') {
				str = new String(buf,0,len);
				System.out.println(str);
				len=0;
				if(str.equals("over")){
					break;
				}
			}else {
				buf[len] = (char)ch;
				len++;
			}			
		}
	}

	public static void keybroadRead() throws IOException {
		InputStream in = System.in;
		
		int ch = in.read();
		System.out.println(ch);
	}

	public static void cppyFileBuffered() throws IOException {
		FileInputStream fis = new FileInputStream("F:\\java learn\\abc.zip");
		FileOutputStream fos = new FileOutputStream("F:\\java learn\\copytest2.rar");
		BufferedInputStream bif = new BufferedInputStream(fis);
		BufferedOutputStream bof = new BufferedOutputStream(fos);
		//使用缓冲区
		
		int ch = 0;
		
		while((ch = bif.read())!=-1) {
			bof.write(ch);
		}
		
		bif.close();
		bof.close();
	}

	public static void copyFile() throws IOException {
		FileInputStream fis = new FileInputStream("F:\\java learn\\abc.zip");
		FileOutputStream fos = new FileOutputStream("F:\\java learn\\copytest.rar");
		/*创建输入和输出字节流对象并关联文件*/
		int len = 0;
		byte[] buf = new byte[4096];
		/*创建缓冲区和存储字节个数的变量*/
		while((len = fis.read(buf))!=-1) {
			/*循环读取源并写入目标*/
			fos.write(buf, 0, len);
		}
		//关闭资源
		fis.close();
		fos.close();
	}

}
