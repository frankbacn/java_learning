package java_learn.IO.bytestream;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo {

	public static void main(String[] args) {
//		filtersDemo_2();
		File f = new File(".");
		traverseDirs(f,0);
	}
	
	/**
	 * 递归遍历目录中的文件并以树型方式输出
	 */
	public static void traverseDirs(File dir,int level) {
		
		File[] fs = dir.listFiles();
		StringBuilder b = new StringBuilder();
		b.append("|");
		if(level==0){
			System.out.println(dir);			
			level += 1;
		}
		for(int x=level;x>0;x--)
			b.append("--");
		for(File f:fs){
			if(f.isDirectory()){
				System.out.println(b.toString()+f);
				traverseDirs(f, level+1);
			}else{
				System.out.println(b.toString()+f);
			}
		}
	}

	/**
	 * 使用匿名内部类实现文件名过滤
	 */
	public static void filtersDemo_2() {
		File f = new File(".");
		
		String[] strs = f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".html");
			}
		});
		
		for(String name:strs){
			System.out.println(name);
		}
		
	}
	
	/**
	 * 使用已实现的过滤器过来目录中的文件
	 */
	public static void filtersDemo_1() {
		File f = new File(".");
		
		String[] strs = f.list(new FileNameFilterByName("bin"));
		
		for(String name:strs){
			System.out.println(name);
		}
		
		File[] fs = f.listFiles(new FileFilterByDir());
		
		for(File ff:fs){
			System.out.println(ff);
		}
	}

}
