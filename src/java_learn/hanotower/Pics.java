package java_learn.hanotower;

public class Pics {
	private int size; //汉诺塔中可移动的块的长度
	private int nexttower; //块所在塔的位置
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
