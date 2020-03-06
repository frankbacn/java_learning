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
	 * �ϲ��и��ļ�
	 * ��ָ��Ŀ¼�е��и��ļ��ϲ�Ϊԭʼ�ļ�
	 */
	private static void fileMerge(File dir) {
		if(!dir.exists())
			throw new RuntimeException("����Ŀ¼������");
		if(!dir.isDirectory())
			throw new RuntimeException("����Ŀ¼�Ƿ�");
		File[] files = dir.listFiles(new FileFilter() {
			/*�����ڲ���ʵ���ļ���������
			 * �����ļ���׺����ȡĿ¼�е��ļ�
			 */
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".split");
			}
		});
		String filename = files[0].getName().substring(0, files[0].getName().indexOf(".split")-1); //��ȡ�ϲ�����ļ���
		File dst_file = new File(dir,filename); //��Ŀ���ļ���װ�ɶ���
		SequenceInputStream sis = null;
		BufferedOutputStream bfw = null;
		try{
			ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
			//������������洢����ָ��ļ�������
			for(File f:files){
				al.add(new FileInputStream(f));
			}
			
			Enumeration<FileInputStream> en = Collections.enumeration(al); //��������ת��ΪEnumeration���϶���
		
			sis = new SequenceInputStream(en); //�������ж�ȡ��
			bfw = new BufferedOutputStream(new FileOutputStream(dst_file)); //���������
			byte[] buff = new byte[1024*1024]; //�������������
			
			int len = 0;
			while((len = sis.read(buff))!=-1){ //��ȡ���벢ѭ��д���ļ�
				bfw.write(buff);
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
	private static int fileWrite(File f, File dir, byte[] buff, int len, int times)
			throws FileNotFoundException, IOException {
		File sfile = new File(dir,f.getName()+times+".split"); //����ָ��ļ�
		BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream(sfile)); //���������
		bfo.write(buff,0,len); //д���ļ�
		bfo.flush();
		times++; //�ļ��������
		bfo.close(); //�ر������
		return times;
	}

}
