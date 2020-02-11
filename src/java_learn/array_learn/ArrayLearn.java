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
	 * 获取整数数组中的最大值
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
	 * 使用角标方式获取数组中的最大值
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
	 * 数组的选择排序
	 * 按由小到大排序
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
	//选择排序性能优化版
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
	 * 冒泡排序
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
	 * 交换数组中两个元素的位置
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
	 * 数组的查找，返回位置
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
	
	//二分查找法
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
	面试题：
	给定一个有序的数组，如果往数组中存储一个元素，并保证这个数组还是有序的，那么这个元素存储的角标如何获取

	思路：
	1.可以确定数组是有序的
	2.在有序的数组中查找一个元素的插入位置可以使用二分查找法
	3.插入的元素是不在本数组中的，期值有可能与数组中的某个值相同也可能不同
	4.如果插入元素的值和数组中的某个值相同，那么插入位置应在数组中该元素之后的位置
	5.如果插入元素不存在与数组中，其插入位置应为所有指针重合时的位置。
	*/
	public static int insertArray(int[] arr,int key){
	    int start = 0;
	    int end = arr.length;
	    int mid = (end+start)/2; //(end+start)>>1 右移一位也是除2
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
	 * 获取整数的十六进制表现形式
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
	
	//十进制转换十六进制
	public static void getHex(int num) {
		trans(num, 4, 15);
	}
	//十进制转换二进制
	public static void getBin(int num) {
		trans(num, 1, 1);
	}
	//十进制转换八进制
	public static void getOtc(int num) {
		trans(num, 3, 7);
	}
	
	
	//进制转换功能
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
