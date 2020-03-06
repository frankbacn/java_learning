package java_learn.IO.bytestream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

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
		File config_file = new File(dir,"parts.properties");
		if(!config_file.exists())
			throw new RuntimeException("配置文件不存在");
		Properties p = new Properties();
		SequenceInputStream sis = null;
		BufferedOutputStream bfw = null;
		try{
			p.load(new FileInputStream(config_file));
			Set<String> keys = p.stringPropertyNames();
			ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
			String filename = null;
			
			for(String key:keys){
				if(key.equals("sourcefile")){
					filename=p.getProperty(key);
				}else{
					File partfile = new File(dir,p.getProperty(key));
					if(!partfile.exists())
						throw new RuntimeException("分片文件"+p.getProperty(key)+"不存在");
					al.add(new FileInputStream(partfile));
				}
			}
			
			File dst_file = new File(dir,filename); //将目标文件封装成对象
			
			
			Enumeration<FileInputStream> en = Collections.enumeration(al); //将流容器转换为Enumeration集合对象
		
			sis = new SequenceInputStream(en); //创建序列读取流
			bfw = new BufferedOutputStream(new FileOutputStream(dst_file)); //创建输出流
			byte[] buff = new byte[1024*1024]; //创建输出缓冲区
			
			int len = 0;
			while((len = sis.read(buff))!=-1){ //读取输入并循环写入文件
				bfw.write(buff,0,len);
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
//	public static void fileFilter(File dir) {
//		File[] files = dir.listFiles(new FileFilter() {
//			/*匿名内部类实现文件过滤器。
//			 * 根据文件后缀名获取目录中的文件
//			 */
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".split");
//			}
//		});
//	}
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
		Properties p = new Properties();
		p.setProperty("sourcefile", f.getName());
		byte[] buff = new byte[size];
		int len = 0;
		int times = 1;
		FileInputStream in = null;
		try{
			in = new FileInputStream(f);
			while((len = in.read(buff))!=-1){
				String filename = fileWrite(f, dir, buff, len, times);
				p.setProperty("part"+times, filename);
				times++;
			}
			p.store(new FileOutputStream(new File(dir,"parts.properties")), "");
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
	private static String fileWrite(File f, File dir, byte[] buff, int len, int times)
			throws FileNotFoundException, IOException {
		File sfile = new File(dir,f.getName()+times+".split"); //定义分割文件
		String sfilename = sfile.getName();
		BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream(sfile)); //创建输出流
		bfo.write(buff,0,len); //写入文件
		bfo.flush();
		times++; //文件编号自增
		bfo.close(); //关闭输出流
		return sfilename;
	}

}
