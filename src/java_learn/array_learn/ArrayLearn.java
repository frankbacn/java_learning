package java_learn.array_learn;

public class ArrayLearn {

	public static void main(String[] args) {
		int[] arr={6,1,87,95,33,22,77};
		//System.out.println(getMax(arr));
		//System.out.println(getMax_2(arr));
		
		//printArray(arr);
		//System.out.println("--------------");
		//selectStor_2(arr);
		//bubbleSort(arr);
		//printArray(arr);
		//System.out.println(insertArray(arr,99));
		//System.out.println(' ' == ' ');
		getHex(60);
	}
	
	/**
	 * ��ȡ���������е����ֵ
	 * @param arr
	 * @return
	 */
	public static int getMax(int[] arr){
	    int max = arr[0];
	    for(int x = 1;x < arr.length; x++){
	        max = max>arr[x]?max:arr[x];
	    }
	    return max;
	}
	
	/**
	 * ʹ�ýǱ귽ʽ��ȡ�����е����ֵ
	 * @param arr
	 * @return
	 */
	public static int getMax_2(int[] arr){
		int max = 0;
		for(int x = 1;x < arr.length; x++){
		    max = arr[max]>arr[x]?max:x;
		}
		return arr[max];
	}
	
	/**
	 * �����ѡ������
	 * ����С��������
	 * @param arr
	 */
	public static void selectStor(int[] arr){
	    for(int x=0;x<arr.length-1;x++){
	        for(int y=x+1;y<arr.length;y++){
	            if(arr[x] < arr[y]){
	                swap(arr,x,y);
	                //System.out.println(arr[x]+arr[y]);
	            }
	        }
	    }
	}
	//ѡ�����������Ż���
	public static void selectStor_2(int[] arr){
	    int maxtmp,maxindex;
	    for(int x=0;x<arr.length-1;x++){
	        maxtmp = arr[x];
	        maxindex = x;
	        for(int y=x+1;y<arr.length;y++){
	            if(maxtmp>arr[y]){
	                maxtmp = arr[y];
	                maxindex = y;
	            }
	        }
	        if(maxindex!=x)
	        	swap(arr,maxindex,x);
	    }
	}
	/**
	 * ð������
	 */
	public static void bubbleSort(int[] arr){
	    for(int x = 1; x < arr.length; x++){
	        for(int y = 0; y < arr.length-1; y++){
	            if(arr[y]<arr[y+1]){
	                swap(arr,y,y+1);
	            }
	        }
	    }
	}

	/**
	 * ��������������Ԫ�ص�λ��
	 * @param arr
	 * @param x
	 * @param y
	 */
	public static void swap(int[] arr,int x,int y){
	    int temp;
	    temp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = temp;
	}
	
	
	public static void printArray(int[] arr){
		for(int x=0;x<arr.length;x++){
			if(x==0){
				System.out.print("[ "+arr[x]+" ,");
			}else if(x==arr.length-1){
				System.out.println(arr[x]+" ]");
			}else
				System.out.print(arr[x]+" ,");
		}
	}
	/**
	 * ����Ĳ��ң�����λ��
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int search(int[] arr,int key){
		for(int x = 0; x<arr.length; x++){
			if(arr[x]==key){
				return x;
			}
		}
		return -1;
	}
	
	//���ֲ��ҷ�
	public static int binarySearch(int[] arr, int key){
		int start = 0;
	    int end = arr.length;
	    int mid = (end+start)/2;
	    while(start <= end){
	        if(arr[mid] == key){
	            return mid;
	        }else{
	            if(arr[mid] > key){
	                end = mid - 1;
	            }else{
	                start = mid + 1;
	            }
	        }
	        mid = (end+start)/2;
	        System.out.println(start+" "+mid+" "+end);
	    }
	    return -1;
	}
	
	/*
	�����⣺
	����һ����������飬����������д洢һ��Ԫ�أ�����֤������黹������ģ���ô���Ԫ�ش洢�ĽǱ���λ�ȡ

	˼·��
	1.����ȷ�������������
	2.������������в���һ��Ԫ�صĲ���λ�ÿ���ʹ�ö��ֲ��ҷ�
	3.�����Ԫ���ǲ��ڱ������еģ���ֵ�п����������е�ĳ��ֵ��ͬҲ���ܲ�ͬ
	4.�������Ԫ�ص�ֵ�������е�ĳ��ֵ��ͬ����ô����λ��Ӧ�������и�Ԫ��֮���λ��
	5.�������Ԫ�ز������������У������λ��ӦΪ����ָ���غ�ʱ��λ�á�
	*/
	public static int insertArray(int[] arr,int key){
	    int start = 0;
	    int end = arr.length;
	    int mid = (end+start)/2; //(end+start)>>1 ����һλҲ�ǳ�2
	    while(start <= end){
	        if(arr[mid] == key){
	            return mid;
	        }else{
	            if(arr[mid] > key){
	                end = mid - 1;
	            }else{
	                start = mid + 1;
	            }
	        }
	        mid = (end+start)/2;
	        System.out.println(start+" "+mid+" "+end);
	        if(mid == start && mid == end)
	        	break;
	    }
	    return mid;
	}
	
	/*
	 * ��ȡ������ʮ�����Ʊ�����ʽ
	 * */
	public static void getHex_2(int num) {
		char[] arr = new char[8];
		char[] hexchar = {'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		int index = 7;
		while(num!=0) {
			arr[index--] = hexchar[num&15];
			num = num >>> 4;
			//index--;
		}
		for(int x = index+1; x<arr.length; x++) {
			if(x==arr.length-1)
				System.out.println(arr[x]);
			else
				System.out.print(arr[x]);
		}
	}
	
	//ʮ����ת��ʮ������
	public static void getHex(int num) {
		trans(num, 4, 15);
	}
	//ʮ����ת��������
	public static void getBin(int num) {
		trans(num, 1, 1);
	}
	//ʮ����ת���˽���
	public static void getOtc(int num) {
		trans(num, 3, 7);
	}
	
	
	//����ת������
	public static void trans(int num,int offset,int base) {
		char[] arr = new char[32];
		char[] hexchar = {'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		int index = arr.length;
		while(num!=0) {
			arr[index--] = hexchar[num&base];
			num = num >>> offset;
			//index--;
		}
		for(int x = index+1; x<arr.length; x++) {
			if(x==arr.length-1)
				System.out.println(arr[x]);
			else
				System.out.print(arr[x]);
		}
	}
}
