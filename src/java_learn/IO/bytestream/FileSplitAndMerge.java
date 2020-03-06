package java_learn.IO.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class FileSplitAndMerge {

	public static void main(String[] args) {
//		int size = 1024*1024*5;
//		File source = new File("jdk api 1.8_China.zip");
//		File dst_dir = new File("filesplits");
//		fileSplit(source,size,dst_dir);
		
		File s_dir = new File("filesplits");
		fileMerge(s_dir);
	}
	/**
	 * 合并切割文件
	 * 将指定目录中的切割文件合并为原始文件
	 */
	private static void fileMerge(File dir) {
		if(!dir.exists())
			throw new RuntimeException("给定目录不存在");
		if(!dir.isDirectory())
			throw new RuntimeException("给定目录非法");
		File[] files = dir.listFiles(new FileFilter() {
			/*匿名内部类实现文件过滤器。
			 * 根据文件后缀名获取目录中的文件
			 */
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".split");
			}
		});
		String filename = files[0].getName().substring(0, files[0].getName().indexOf(".split")-1); //获取合并后的文件名
		File dst_file = new File(dir,filename); //将目标文件封装成对象
		SequenceInputStream sis = null;
		BufferedOutputStream bfw = null;
		try{
			ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
			//创建结合容器存储多个分割文件流对象
			for(File f:files){
				al.add(new FileInputStream(f));
			}
			
			Enumeration<FileInputStream> en = Collections.enumeration(al); //将流容器转换为Enumeration集合对象
		
			sis = new SequenceInputStream(en); //创建序列读取流
			bfw = new BufferedOutputStream(new FileOutputStream(dst_file)); //创建输出流
			byte[] buff = new byte[1024*1024]; //创建输出缓冲区
			
			int len = 0;
			while((len = sis.read(buff))!=-1){ //读取输入并循环写入文件
				bfw.write(buff);
				bfw.flush();
			}
		}catch(IOException e){
			throw new RuntimeException("读取或写入失败");
		}finally{
			if(sis!=null){
				try{
					sis.close();
				}catch(IOException e){
					
				}
			}
			if(bfw!=null){
				try{
				bfw.close();
				}catch(IOException e){
					
				}
			}
		}
		
	}
	/**
	 * 分割文件
	 * 将给定的文件对象按照指定大小分割成多份，
	 * 并将分割后的文件保存到指定目录中。
	 * @param f
	 * @param size
	 * @param dir
	 */
	private static void fileSplit(File f,int size,File dir) {
		if(!f.exists()){
			throw new RuntimeException("给定文件不存在");
		}
		if(!dir.exists()){
			dir.mkdirs(); //给定目录不存在则创建
		}
		if(!dir.isDirectory()){
			throw new RuntimeException("给定目录非法");
		}
		byte[] buff = new byte[size];
		int len = 0;
		int times = 1;
		FileInputStream in = null;
		try{
			in = new FileInputStream(f);
			while((len = in.read(buff))!=-1){
				times = fileWrite(f, dir, buff, len, times);
			}
		}catch(FileNotFoundException e){
			throw new RuntimeException("写入文件失败");
		}
		catch(IOException e){
			throw new RuntimeException("写入文件失败");
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){
					throw new RuntimeException("文件关闭失败");
				}
			}
		}
	}
	/**
	 * 创建分割文件，并将内容写入文件中
	 * @param f
	 * @param dir
	 * @param buff
	 * @param len
	 * @param times
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static int fileWrite(File f, File dir, byte[] buff, int len, int times)
			throws FileNotFoundException, IOException {
		File sfile = new File(dir,f.getName()+times+".split"); //定义分割文件
		BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream(sfile)); //创建输出流
		bfo.write(buff,0,len); //写入文件
		bfo.flush();
		times++; //文件编号自增
		bfo.close(); //关闭输出流
		return times;
	}

}
