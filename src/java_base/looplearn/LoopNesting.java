package java_base.looplearn;

public class LoopNesting {

	public static void main(String[] args) {
		int n = 5,m = 5;
		//示例：在控制台输出一个N行M列的以*号组成的矩形。
		for(int x=0;x<n;x++){ //外循环控制行数
		    for(int y=0;y<m;y++){ //内循环控制列数
		        System.out.print("*");
		    }
		    System.out.println(); //在每行最后输出回车符
		}
		System.out.println("-------------");
		/*
		在控制台输出正和倒直角三角形如下图：
		*****
		****
		***
		**
		*
		*
		**
		***
		****
		*****
		**/

		System.out.println("-------------");
		for(int x=0;x<m;x++){ //正三角形输出(m变量时行数)
		    for(int y=0;y<=x;y++){
		        System.out.print("*");
		    }
		    System.out.println();
		}

		System.out.println("-------------");
		for(int x=m;x>0;x--){//倒三角形输出(m变量时行数)
		    for(int y=0;y<x;y++){
		        System.out.print("*");
		    }
		    System.out.println();
		}

		System.out.println("-------------");
		/*
		54321
		5432
		543
		54
		5
		*/
		for(int x=m;x>0;x--){//倒三角形输出(m变量时行数)
		    for(int y=0;y<x;y++){
		        System.out.print(m-y); //每次输出内容是行减去循环次数
		    }
		    System.out.println();
		}
		System.out.println("-------------");
		/*
		5
		54
		543
		5432
		54321
		*/
		for(int x=0;x<m;x++){ //x以自增方式并以小于行数变量为条件控制行数
		    for(int y=0;y<=x;y++){ //y以小于等于x为条件控制行内循次数
		        System.out.print(m-y);//行内每次输出m-y的值
		    }
		    System.out.println();
		}
		System.out.println("-------------");
		/*输出九九乘法表
		思路：
		1.九九乘法表的样式可以归纳为正三角形
		2.为便于输出时方便调整内外循环变量初始化为1，同时控制循环的条件使用<=以保证不发生错误
		3.只要控制好输出内容格式即可完成此练习
		*/
		for(int x=1;x<=9;x++){ 
		    for(int y=1;y<=x;y++){
		        System.out.print(y+"*"+x+"="+x*y+"\t");
		    }
		    System.out.println();
		}
		
		System.out.println("-------------");
		for(int x=0;x<6;x++){ 
		    for(int y=0;y<6*2-(x);y++){ //内循环每次循环的次数根据x的值而变化
		        if(y<x){
		           System.out.print(" "); 
		        }else{
		            if((y-x)%2==0){
		                System.out.print("*");
		            }else{
		                System.out.print(" ");
		            }
		        }
		    }
		    System.out.println();
		}
		System.out.println("-------------");
		for(int x=1;x<=6;x++){ //正三角形输出(m变量时行数)
		    for(int y=1;y<x;y++){ //先输出直角三角形
		        System.out.print(" ");
		    }
		    for(int z=x;z<6;z++){
		        System.out.print("* ");
		    }
		    System.out.println();
		}

	}

}
