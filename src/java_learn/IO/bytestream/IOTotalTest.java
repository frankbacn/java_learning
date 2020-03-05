package java_learn.IO.bytestream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOTotalTest {

	/*
	 * 练习： 获取指定目录下（包含子目录），指定扩展名的文件。将这些文件的绝对路径记录到一个文本文件中。
	 * 思路： 
	 * 1. 采用递归方式遍历指定目录下的文件
	 * 2. 使用文件过滤器对遍历到的文件进行过滤，记录符合要求的文件绝对路径信息 
	 * 3. 需要记录的文件信息要临时存储在一个容器中 
	 * 4. 将获取到的文件信息逐行写入到文本文件中
	 * 5. 将指定目录封装成对象以便于操作
	 */

	public static void main(String[] args) {
		listAllFile(".", "filelist.txt", ".jpg");
	}
	/**
	 * 将给定目录中的指定后缀名的文件绝对路径写入到指定文件中
	 * @param dir
	 * @param savefile
	 */
	public static void listAllFile(String dir,String savefile,String suffix){
		
		File ddir = new File(dir); //将传入的路径封装成对象
		BufferedWriter bfw = null; //定义缓冲区流对象
		if(ddir.exists()){//判断路径是否存在
			if(ddir.isDirectory()){//判断是否是路径
				File dfile = new File(ddir,savefile); //在给定路径封装保存文件对象
				ArrayList<File> innerdirs = new ArrayList<File>(); //创建子目录临时容器
				innerdirs.add(ddir); //将本级目录添加到临时容器
				getDirs(ddir, innerdirs); //遍历获取所有子目录
				ArrayList<String> allfiles = new ArrayList<String>(); //定义符合条件的临时容器
				for(File f : innerdirs){
					getFiles(f, allfiles,suffix); //将所有目录中的符合条件的文件添加到临时容器中
				}
				//准备将获取的文件列表写入到文本文件中
				try{
					bfw = new BufferedWriter(new FileWriter(dfile));
					for(String filename: allfiles){
						bfw.write(filename);
						bfw.newLine();
						bfw.flush();
					}
				}catch(IOException e){
					throw new RuntimeException("写入文件失败");
				}finally{
					try{
						bfw.close();
					}catch(IOException e){
						throw new RuntimeException("写入文件失败");
					}
				}
			}else{
				throw new RuntimeException("给定的目录不正确");
			}
		}
	}
	/**
	 * 
	 * @param dir
	 * @param dirs
	 * @return
	 */
	private static void getDirs(File dir,ArrayList<File> dirs){
		File[] ldirs = dir.listFiles(new FileFilterByDir());
		if(ldirs!=null){
			for(File d:ldirs){
				dirs.add(d);
				getDirs(d,dirs);
			}
			
		}
	}
	
	/**
	 * 使用过滤器获取目录中指定后缀名的文件
	 * @param dir
	 */
	private static void getFiles(File dir, ArrayList<String> files,String suffix) {
		
		File[] fs = dir.listFiles(new FileSuffixFilter(suffix));
		for (File f : fs) {
			files.add(f.getAbsolutePath());
		}
	}

}
/**
 * 过滤器
 * 过滤文件名为指定后缀的文件
 * @author zhongming
 *
 */
class FileSuffixFilter implements FileFilter{
	private String suffix = null;
	
	public FileSuffixFilter(String suffix) {
		super();
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File pathname) {
		
		return pathname.isFile()&&pathname.getName().endsWith(suffix);
	}
	
}
