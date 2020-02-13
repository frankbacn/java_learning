package java_learn.OOP;

/**
 * ����һ���Լ������������������Ĺ����࣬���еķ��������ڶ�����������򣬻�ȡ��ֵ�Ȳ���
 * ����಻�ܴ����������з������Ǿ�̬�ģ���ֱ��ʹ��
 * @author zm
 *
 */

public class ArrayTools {
	
	private ArrayTools() {
		//˽�л��ղ������캯�������ڿ��ƶ���Ĵ���
	}
	
	/**
	 * getMax�������ڻ�ȡһ������������Ԫ�ص����ֵ
	 * @param arr һ��������int������
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
	 * getMaxIndex�������ڻ�ȡһ������������Ԫ�ص����ֵ����λ��
	 * @param arr һ��������int������
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
	 * swap���������û���������������Ǳ�λ�õ�ֵ
	 */
	private static void swap(int[] arr,int x,int y){
	    int temp;
	    temp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = temp;
	}
	
	/**
	 * selectSort��������Ϊһ��������int�������������
	 * �����㷨Ϊѡ������
	 * @param arr һ��������int������
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
	 * bubbleSort��������Ϊһ��������int�������������
	 * �����㷨Ϊð������
	 * @param arr һ��������int������
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
	 * arr2Str�������ڷ��ظ���������ַ���������ʽ
	 * @param arr һ��������int������
	 * @return str ����һ���ַ����������Ǹ���������ַ���������ʽ  [e1,e2,...]
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
	 * search���������������в��Ҹ�����Ԫ���Ƿ���ڣ���������򷵻�Ԫ�����ڵĽǱ꣬����������򷵻�-1
	 * @param arr arr һ��������int������
	 * @param key Ҫ���ҵ�Ԫ��
	 * @return x Ԫ�����ڵ�λ�ã�����������򷵻�-1
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
	 * insertArray�������ڷ���ĳ��Ԫ���������в����λ��
	 * �㷨ʹ�ö��ֲ��ҷ���
	 * @param arr arr һ��������int�����飬��������������������
	 * @param key Ҫ���ҵ�Ԫ��
	 * @return ����Ԫ�صĲ����
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

}
