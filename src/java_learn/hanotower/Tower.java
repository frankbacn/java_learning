package java_learn.hanotower;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tower {
	private LinkedList<Pics> lefttower;
	private LinkedList<Pics> midtower;
	private LinkedList<Pics> righttower;
	//定义三个容器，作为三个塔，内部采用栈方式维护数据
	
	private int level; //定义塔的层数
	
	private ArrayList<LinkedList<Pics>> towers; 

	public Tower(int level) {
		/*
		 * 初始化对象
		 * 创建所有内部的塔对象
		 * 根据给定的层数，初始化左塔中的元素
		 */
		super();
		this.level = level;
		init();
	}

	public void init() {
		//根据给定的层数，初始化左塔中的元素
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
		//初始化左塔中的元素
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
		//重新设置层数并初始化各塔内元素
		this.level = level;
		init();
	}
	
	public void reset(){
		//对象内容重置
		init();
	}
	
	public boolean moveElement(int from){
		/*
		 * 将一个元素从一个塔移动到零一个塔
		 * 符合游戏规则返回真，否则假
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
		 * 如果索引所在柱子不为空
			    如果第三个柱子中第一个元素的值+柱子中元素个数-1=层数
			        如果第三个柱子中第一个元素的值是1
			            程序结束
			        索引变更为第一个元素的下一个位置
			        重新运算
			    如果有空柱子
			           索引所在柱子上的第一个元素移动到元素指定位置，移动后保持柱子索引不变
			    如果没有空柱子
			           索引所在柱子的元素不唯一
			                  索引所在柱子的第一个元素可移动
			                         移动
			                         移动后保持柱子索引不变
			                  索引所在柱子的第一个元素不可移动
			                         变更索引为元素目标柱子索引
			                         重新运算
			           索引所在柱子的元素唯一
			                  索引所在柱子的第一个元素可移动
			                         移动后保持柱子索引不变
			                  索引所在柱子的第一个元素不可移动
			                         变更索引为元素目标柱子索引
			                         重新运算
			如果索引所在柱子为空
			  如果第三个柱子中第一个元素的值+柱子中元素个数-1=层数
			        如果第三个柱子中第一个元素的值是1
			            程序结束
			  如果索引指向第一根柱子
			    索引变更为下一个柱子
			    重新运算
			  如果索引指向第二根柱子
			    索引变更为前一个柱子
			    重新运算
		 */
		System.out.println(towers);
		if(towers.get(runindex).size()!=0){ //如果索引所在柱子不为空
			if(towers.get(runindex)==righttower&&righttower.size()>0){ 
				if((righttower.getFirst().getSize()+righttower.size()-1)==level){ //如果第三个柱子上的元素放置正确
					if(righttower.getFirst().getSize()==1) //如果最后一个元素也防止正确
						return; // 程序结束
				}
				if(!catMove(runindex)){ //如果塔上元素不能移动
					autoMove(0); //索引变更为第一个元素的下一个位置
					return;
				}
			}
			if(hasEmptyTower()){ //如果有空柱子
				moveElement(runindex); //移动柱子上的第一个元素到指定位置
				autoMove(runindex); //移动后保持柱子索引不变
				return;
			}else{ //如果没有空柱子
				if(towers.get(runindex).size()>1){ //柱子的元素不唯一
					if(catMove(runindex)){ //柱子的第一个元素可移动
						moveElement(runindex); //移动柱子上的第一个元素到指定位置
						autoMove(runindex);
						return;
					}else{ //柱子的第一个元素不可移动
						autoMove(towers.get(runindex).getFirst().getNextTower());
						return;
					}
				}else{ //柱子的元素唯一
					if(catMove(runindex)){ //柱子的第一个元素可移动
						moveElement(runindex); //移动柱子上的第一个元素到指定位置
						autoMove(runindex);
						return;
					}else{ //柱子的第一个元素不可移动
						autoMove(towers.get(runindex).getFirst().getNextTower());
						return;
					}
				}
			}
		}else{ //如果索引所在柱子为空
			if(righttower.size()>0){
				if((righttower.getFirst().getSize()+righttower.size()-1)==level){ //如果第三个柱子中第一个元素的值+柱子中元素个数-1=层数
					if(righttower.getFirst().getSize()==1) //如果第三个柱子中第一个元素的值是1
						return; // 程序结束
				}
				
			}
			if(runindex==0){ //如果索引指向第一根柱子
				autoMove(runindex+1); // 索引变更为下一个柱子
				return;
			}
			if(runindex==1){ //如果索引指向第二根柱子
				autoMove(runindex-1); // 索引变更为前一个柱子
				return;
			}
			if(runindex==2){ //如果索引指向第三个柱子
				autoMove(0); //索引变更为第一个柱子
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
