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
	 * �ϲ��и��ļ�
	 * ��ָ��Ŀ¼�е��и��ļ��ϲ�Ϊԭʼ�ļ�
	 */
	private static void fileMerge(File dir) {
		if(!dir.exists())
			throw new RuntimeException("����Ŀ¼������");
		if(!dir.isDirectory())
			throw new RuntimeException("����Ŀ¼�Ƿ�");
		File config_file = new File(dir,"parts.properties");
		if(!config_file.exists())
			throw new RuntimeException("�����ļ�������");
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
						throw new RuntimeException("��Ƭ�ļ�"+p.getProperty(key)+"������");
					al.add(new FileInputStream(partfile));
				}
			}
			
			File dst_file = new File(dir,filename); //��Ŀ���ļ���װ�ɶ���
			
			
			Enumeration<FileInputStream> en = Collections.enumeration(al); //��������ת��ΪEnumeration���϶���
		
			sis = new SequenceInputStream(en); //�������ж�ȡ��
			bfw = new BufferedOutputStream(new FileOutputStream(dst_file)); //���������
			byte[] buff = new byte[1024*1024]; //�������������
			
			int len = 0;
			while((len = sis.read(buff))!=-1){ //��ȡ���벢ѭ��д���ļ�
				bfw.write(buff,0,len);
				bfw.flush();
			}
		}catch(IOException e){
			throw new RuntimeException("��ȡ��д��ʧ��");
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
//			/*�����ڲ���ʵ���ļ���������
//			 * �����ļ���׺����ȡĿ¼�е��ļ�
//			 */
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".split");
//			}
//		});
//	}
	/**
	 * �ָ��ļ�
	 * ���������ļ�������ָ����С�ָ�ɶ�ݣ�
	 * �����ָ����ļ����浽ָ��Ŀ¼�С�
	 * @param f
	 * @param size
	 * @param dir
	 */
	private static void fileSplit(File f,int size,File dir) {
		if(!f.exists()){
			throw new RuntimeException("�����ļ�������");
		}
		if(!dir.exists()){
			dir.mkdirs(); //����Ŀ¼�������򴴽�
		}
		if(!dir.isDirectory()){
			throw new RuntimeException("����Ŀ¼�Ƿ�");
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
			throw new RuntimeException("д���ļ�ʧ��");
		}
		catch(IOException e){
			throw new RuntimeException("д���ļ�ʧ��");
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){
					throw new RuntimeException("�ļ��ر�ʧ��");
				}
			}
		}
	}
	/**
	 * �����ָ��ļ�����������д���ļ���
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
		File sfile = new File(dir,f.getName()+times+".split"); //����ָ��ļ�
		String sfilename = sfile.getName();
		BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream(sfile)); //���������
		bfo.write(buff,0,len); //д���ļ�
		bfo.flush();
		times++; //�ļ��������
		bfo.close(); //�ر������
		return sfilename;
	}

}
