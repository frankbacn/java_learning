package java_base.looplearn;

public class LoopNesting {

	public static void main(String[] args) {
		int n = 5,m = 5;
		//ʾ�����ڿ���̨���һ��N��M�е���*����ɵľ��Ρ�
		for(int x=0;x<n;x++){ //��ѭ����������
		    for(int y=0;y<m;y++){ //��ѭ����������
		        System.out.print("*");
		    }
		    System.out.println(); //��ÿ���������س���
		}
		System.out.println("-------------");
		/*
		�ڿ���̨������͵�ֱ������������ͼ��
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
		for(int x=0;x<m;x++){ //�����������(m����ʱ����)
		    for(int y=0;y<=x;y++){
		        System.out.print("*");
		    }
		    System.out.println();
		}

		System.out.println("-------------");
		for(int x=m;x>0;x--){//�����������(m����ʱ����)
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
		for(int x=m;x>0;x--){//�����������(m����ʱ����)
		    for(int y=0;y<x;y++){
		        System.out.print(m-y); //ÿ������������м�ȥѭ������
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
		for(int x=0;x<m;x++){ //x��������ʽ����С����������Ϊ������������
		    for(int y=0;y<=x;y++){ //y��С�ڵ���xΪ������������ѭ����
		        System.out.print(m-y);//����ÿ�����m-y��ֵ
		    }
		    System.out.println();
		}
		System.out.println("-------------");
		/*����žų˷���
		˼·��
		1.�žų˷������ʽ���Թ���Ϊ��������
		2.Ϊ�������ʱ�����������ѭ��������ʼ��Ϊ1��ͬʱ����ѭ��������ʹ��<=�Ա�֤����������
		3.ֻҪ���ƺ�������ݸ�ʽ������ɴ���ϰ
		*/
		for(int x=1;x<=9;x++){ 
		    for(int y=1;y<=x;y++){
		        System.out.print(y+"*"+x+"="+x*y+"\t");
		    }
		    System.out.println();
		}
		
		System.out.println("-------------");
		for(int x=0;x<6;x++){ 
		    for(int y=0;y<6*2-(x);y++){ //��ѭ��ÿ��ѭ���Ĵ�������x��ֵ���仯
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
		for(int x=1;x<=6;x++){ //�����������(m����ʱ����)
		    for(int y=1;y<x;y++){ //�����ֱ��������
		        System.out.print(" ");
		    }
		    for(int z=x;z<6;z++){
		        System.out.print("* ");
		    }
		    System.out.println();
		}

	}

}
