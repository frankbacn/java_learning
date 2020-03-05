package java_learn.IO.bytestream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOTotalTest {

	/*
	 * ��ϰ�� ��ȡָ��Ŀ¼�£�������Ŀ¼����ָ����չ�����ļ�������Щ�ļ��ľ���·����¼��һ���ı��ļ��С�
	 * ˼·�� 
	 * 1. ���õݹ鷽ʽ����ָ��Ŀ¼�µ��ļ�
	 * 2. ʹ���ļ��������Ա��������ļ����й��ˣ���¼����Ҫ����ļ�����·����Ϣ 
	 * 3. ��Ҫ��¼���ļ���ϢҪ��ʱ�洢��һ�������� 
	 * 4. ����ȡ�����ļ���Ϣ����д�뵽�ı��ļ���
	 * 5. ��ָ��Ŀ¼��װ�ɶ����Ա��ڲ���
	 */

	public static void main(String[] args) {
		listAllFile(".", "filelist.txt", ".jpg");
	}
	/**
	 * ������Ŀ¼�е�ָ����׺�����ļ�����·��д�뵽ָ���ļ���
	 * @param dir
	 * @param savefile
	 */
	public static void listAllFile(String dir,String savefile,String suffix){
		
		File ddir = new File(dir); //�������·����װ�ɶ���
		BufferedWriter bfw = null; //���建����������
		if(ddir.exists()){//�ж�·���Ƿ����
			if(ddir.isDirectory()){//�ж��Ƿ���·��
				File dfile = new File(ddir,savefile); //�ڸ���·����װ�����ļ�����
				ArrayList<File> innerdirs = new ArrayList<File>(); //������Ŀ¼��ʱ����
				innerdirs.add(ddir); //������Ŀ¼��ӵ���ʱ����
				getDirs(ddir, innerdirs); //������ȡ������Ŀ¼
				ArrayList<String> allfiles = new ArrayList<String>(); //���������������ʱ����
				for(File f : innerdirs){
					getFiles(f, allfiles,suffix); //������Ŀ¼�еķ����������ļ���ӵ���ʱ������
				}
				//׼������ȡ���ļ��б�д�뵽�ı��ļ���
				try{
					bfw = new BufferedWriter(new FileWriter(dfile));
					for(String filename: allfiles){
						bfw.write(filename);
						bfw.newLine();
						bfw.flush();
					}
				}catch(IOException e){
					throw new RuntimeException("д���ļ�ʧ��");
				}finally{
					try{
						bfw.close();
					}catch(IOException e){
						throw new RuntimeException("д���ļ�ʧ��");
					}
				}
			}else{
				throw new RuntimeException("������Ŀ¼����ȷ");
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
	 * ʹ�ù�������ȡĿ¼��ָ����׺�����ļ�
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
 * ������
 * �����ļ���Ϊָ����׺���ļ�
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
