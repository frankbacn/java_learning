package java_learn.apiobjects.string;

public class StringDemo1 {

	public static void main(String[] args) {
//		String str = "nbaernbatynbauinbaopnba";
//		int count = subStringCount(str, "nba");
//		System.out.println(count);

//		String str1 = "rnbatyntrebauinba";
//		String str2 = "tynbatreetuinba";
//
//		String massubstr = maxSubString(str1, str2);
//		System.out.println("Maxmin Sub String :" + massubstr);

		String str = "    abc  22   ";
		
		String s = myTrim(str);
		System.out.println("-"+s+"-");
		
	}

	public static String myTrim(String str) {
		char[] arr = str.toCharArray(); //字符串转为数组
		int count=1,start=0; //定义计数器和指针
		for(int x=0;x<arr.length;x++) { //遍历数据记录起始位置和有效元素个数
			if(arr[x]==' '&&count==1) {
				start++;
			}else if(arr[x]!=' ')
				count++;
		}
		
		str = new String(arr,start,count); //生成新的字符串
		return str;
	}

	public static String maxSubString(String str1, String str2) {
		String str = str1.length() > str2.length() ? str1 : str2; // 获取长串
		String substr = str1.length() < str2.length() ? str1 : str2; // 获取较短的字符串作为子串

		if (str.contains(substr)) { // 如果短字符串就是最大子串则直接返回短串
			return substr;
		}

		for (int x = 0; x < substr.length(); x++) {
			for (int start = 0, end = substr.length() - x; end != substr.length() + 1; start++, end++) {
				if (str.contains(substr.substring(start, end))) {
					return substr.substring(start, end);
				}
			}
		}
		return "";
	}

	public static int subStringCount(String str, String substr) {
		int count = 0; // 定义计数器
		int pt = 0; // 定义指针
		while (pt < str.length()) { // 指針要小於字符串最後一個脚標
			pt = str.indexOf(substr, pt); // 查找字符串，並記錄字符串首次出現的位置
			if (pt < 0) { // 無法找到字符串直接返回-1
				return -1;
			} else {
				pt += substr.length(); // 向后移動指針
				count++; // 計數器自增
			}
		}
		return count;
	}

	// 老师的代码
	public static int subStringCount_2(String str, String substr) {
		int count = 0; // 定义计数器
		int pt = 0; // 定义指针
		while ((pt = str.indexOf(substr, pt)) != -1) { // 未找到退出循环
			pt += substr.length(); // 向后移動指針
			count++; // 計數器自增
		}
		return count;
	}

}
