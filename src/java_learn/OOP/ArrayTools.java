package java_learn.OOP;

/**
 * 这是一个自己创建的针对数组操作的工具类，其中的方法可用于对数组进行排序，获取最值等操作
 * 这个类不能创建对象，其中方法都是静态的，可直接使用
 * @author zm
 *
 */

public class ArrayTools {
	
	private ArrayTools() {
		//私有化空参数构造函数，用于控制对象的创建
	}
	
	/**
	 * getMax方法用于获取一个整型数组中元素的最大值
	 * @param arr 一个给定的int型数组
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
	 * getMaxIndex方法用于获取一个整型数组中元素的最大值所在位置
	 * @param arr 一个给定的int型数组
	 * @return
	 */
	public static int getMaxIndex(int[] arr){
		int max = 0;
		for(int x = 1;x < arr.length; x++){
		    max = arr[max]>arr[x]?max:x;
		}
		return max;
	}
	
	/*
	 * swap方法用于置换给定数组的两个角标位置的值
	 */
	private static void swap(int[] arr,int x,int y){
	    int temp;
	    temp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = temp;
	}
	
	/**
	 * selectSort方法用于为一个给定的int型数组进行排序
	 * 排序算法为选择排序，
	 * @param arr 一个给定的int型数组
	 */
	public static void selectSort(int[] arr){
	    int maxtmp,maxindex;
	    for(int x=0;x<arr.length-1;x++){
	        maxtmp = arr[x];
	        maxindex = x;
	        for(int y=x+1;y<arr.length;y++){
	            if(maxtmp<arr[y]){
	                maxtmp = arr[y];
	                maxindex = y;
	            }
	        }
	        if(maxindex!=x)
	            swap(arr,maxindex,x);
	    }
	}
	
	/**
	 * bubbleSort方法用于为一个给定的int型数组进行排序
	 * 排序算法为冒泡排序
	 * @param arr 一个给定的int型数组
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
	 * arr2Str方法用于返回给定数组的字符串表现形式
	 * @param arr 一个给定的int型数组
	 * @return str 返回一个字符串，其结果是给定数组的字符串表现形式  [e1,e2,...]
	 */
	public static String arr2Str(int[] arr){
		String str = "[ ";
		for(int x=0;x<arr.length;x++){
			if(x<arr.length-1){
				str = str + arr[x]+" ,";
			}else
				str = str + arr[x]+" ]";
		}
		return str;
	}
	
	/**
	 * search方法用于在数组中查找给定的元素是否存在，如果存在则返回元素所在的角标，如果不存在则返回-1
	 * @param arr arr 一个给定的int型数组
	 * @param key 要查找的元素
	 * @return x 元素所在的位置，如果不存在则返回-1
	 */
	public static int search(int[] arr,int key){
		for(int x = 0; x<arr.length; x++){
			if(arr[x]==key){
				return x;
			}
		}
		return -1;
	}
	
	/**
	 * insertArray方法用于返回某个元素在数组中插入的位置
	 * 算法使用二分查找法，
	 * @param arr arr 一个给定的int型数组，给定的数组必须是有序的
	 * @param key 要查找的元素
	 * @return 返回元素的插入点
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

}
