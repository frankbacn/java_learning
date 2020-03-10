package java_learn.hanotower;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tower {
	private LinkedList<Pics> lefttower;
	private LinkedList<Pics> midtower;
	private LinkedList<Pics> righttower;
	//����������������Ϊ���������ڲ�����ջ��ʽά������
	
	private int level; //�������Ĳ���
	
	private ArrayList<LinkedList<Pics>> towers; 

	public Tower(int level) {
		/*
		 * ��ʼ������
		 * ���������ڲ���������
		 * ���ݸ����Ĳ�������ʼ�������е�Ԫ��
		 */
		super();
		this.level = level;
		init();
	}

	public void init() {
		//���ݸ����Ĳ�������ʼ�������е�Ԫ��
		if(lefttower==null)
			lefttower = new LinkedList<Pics>();
		else
			lefttower.clear();
		if(midtower==null)
			midtower = new LinkedList<Pics>();
		else
			midtower.clear();
		if(righttower==null)
			righttower = new LinkedList<Pics>();
		else
			righttower.clear();
		//��ʼ�������е�Ԫ��
		for(int i=level;i>=1;i--){
			lefttower.addFirst(new Pics(i));
		}
		towers = new ArrayList<LinkedList<Pics>>();
		towers.add(lefttower);
		towers.add(midtower);
		towers.add(righttower);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		//�������ò�������ʼ��������Ԫ��
		this.level = level;
		init();
	}
	
	public void reset(){
		//������������
		init();
	}
	
	public boolean moveElement(int from){
		/*
		 * ��һ��Ԫ�ش�һ�����ƶ�����һ����
		 * ������Ϸ���򷵻��棬�����
		 */
		LinkedList<Pics> fromt = towers.get(from);
		Pics p = fromt.getFirst();
		LinkedList<Pics> dest_t = towers.get(p.getNextTower());
		if(dest_t.size()!=0)
			if(fromt.getFirst().getSize()>dest_t.getFirst().getSize())
				return false;
		fromt.removeFirst();
		dest_t.addFirst(p);
		p.nextTower();
		return true;
	}
	
	public void autoMove(int runindex){
		/*
		 * ��������������Ӳ�Ϊ��
			    ��������������е�һ��Ԫ�ص�ֵ+������Ԫ�ظ���-1=����
			        ��������������е�һ��Ԫ�ص�ֵ��1
			            �������
			        �������Ϊ��һ��Ԫ�ص���һ��λ��
			        ��������
			    ����п�����
			           �������������ϵĵ�һ��Ԫ���ƶ���Ԫ��ָ��λ�ã��ƶ��󱣳�������������
			    ���û�п�����
			           �����������ӵ�Ԫ�ز�Ψһ
			                  �����������ӵĵ�һ��Ԫ�ؿ��ƶ�
			                         �ƶ�
			                         �ƶ��󱣳�������������
			                  �����������ӵĵ�һ��Ԫ�ز����ƶ�
			                         �������ΪԪ��Ŀ����������
			                         ��������
			           �����������ӵ�Ԫ��Ψһ
			                  �����������ӵĵ�һ��Ԫ�ؿ��ƶ�
			                         �ƶ��󱣳�������������
			                  �����������ӵĵ�һ��Ԫ�ز����ƶ�
			                         �������ΪԪ��Ŀ����������
			                         ��������
			���������������Ϊ��
			  ��������������е�һ��Ԫ�ص�ֵ+������Ԫ�ظ���-1=����
			        ��������������е�һ��Ԫ�ص�ֵ��1
			            �������
			  �������ָ���һ������
			    �������Ϊ��һ������
			    ��������
			  �������ָ��ڶ�������
			    �������Ϊǰһ������
			    ��������
		 */
		System.out.println(towers);
		if(towers.get(runindex).size()!=0){ //��������������Ӳ�Ϊ��
			if(towers.get(runindex)==righttower&&righttower.size()>0){ 
				if((righttower.getFirst().getSize()+righttower.size()-1)==level){ //��������������ϵ�Ԫ�ط�����ȷ
					if(righttower.getFirst().getSize()==1) //������һ��Ԫ��Ҳ��ֹ��ȷ
						return; // �������
				}
				if(!catMove(runindex)){ //�������Ԫ�ز����ƶ�
					autoMove(0); //�������Ϊ��һ��Ԫ�ص���һ��λ��
					return;
				}
			}
			if(hasEmptyTower()){ //����п�����
				moveElement(runindex); //�ƶ������ϵĵ�һ��Ԫ�ص�ָ��λ��
				autoMove(runindex); //�ƶ��󱣳�������������
				return;
			}else{ //���û�п�����
				if(towers.get(runindex).size()>1){ //���ӵ�Ԫ�ز�Ψһ
					if(catMove(runindex)){ //���ӵĵ�һ��Ԫ�ؿ��ƶ�
						moveElement(runindex); //�ƶ������ϵĵ�һ��Ԫ�ص�ָ��λ��
						autoMove(runindex);
						return;
					}else{ //���ӵĵ�һ��Ԫ�ز����ƶ�
						autoMove(towers.get(runindex).getFirst().getNextTower());
						return;
					}
				}else{ //���ӵ�Ԫ��Ψһ
					if(catMove(runindex)){ //���ӵĵ�һ��Ԫ�ؿ��ƶ�
						moveElement(runindex); //�ƶ������ϵĵ�һ��Ԫ�ص�ָ��λ��
						autoMove(runindex);
						return;
					}else{ //���ӵĵ�һ��Ԫ�ز����ƶ�
						autoMove(towers.get(runindex).getFirst().getNextTower());
						return;
					}
				}
			}
		}else{ //���������������Ϊ��
			if(righttower.size()>0){
				if((righttower.getFirst().getSize()+righttower.size()-1)==level){ //��������������е�һ��Ԫ�ص�ֵ+������Ԫ�ظ���-1=����
					if(righttower.getFirst().getSize()==1) //��������������е�һ��Ԫ�ص�ֵ��1
						return; // �������
				}
				
			}
			if(runindex==0){ //�������ָ���һ������
				autoMove(runindex+1); // �������Ϊ��һ������
				return;
			}
			if(runindex==1){ //�������ָ��ڶ�������
				autoMove(runindex-1); // �������Ϊǰһ������
				return;
			}
			if(runindex==2){ //�������ָ�����������
				autoMove(0); //�������Ϊ��һ������
				return;
			}
		}
		
	}
	
	private boolean catMove(int from) {
		LinkedList<Pics> fromt = towers.get(from);
		Pics p = fromt.getFirst();
		LinkedList<Pics> dest_t = towers.get(p.getNextTower());
		if(dest_t.size()!=0)
			if(fromt.getFirst().getSize()>dest_t.getFirst().getSize())
				return false;
		return true;
	}

	private boolean hasEmptyTower() {
		
		return lefttower.size()==0||midtower.size()==0||righttower.size()==0;
	}

	public ArrayList<LinkedList<Pics>> getTowers() {
		return towers;
	}

	public static void main(String[] args){
		Tower t = new Tower(5);
		t.autoMove(0);
	}
}
