package java_learn.hanotower;

public class Pics {
	private int size; //��ŵ���п��ƶ��Ŀ�ĳ���
	private int nexttower; //����������λ��
	public Pics(int size) {
		super();
		this.size = size;
		initNextTower();
	}
	public int getSize() {
		return size;
	}
	public void nextTower() {
		if(size%2==1){
			if(nexttower!=0){
				nexttower--;
			}
			else{
				nexttower = 2;
			}
		}else{
			if(nexttower!=2){
				nexttower++;
			}
			else{
				nexttower = 0;
			}
		}
	}
	private void initNextTower() {
		if(size%2==1)
			nexttower = 2;
		else
			nexttower = 1;
	}
	public int getNextTower() {
		
		return nexttower;
	}
	@Override
	public String toString() {
		return size+"";
	}
}
