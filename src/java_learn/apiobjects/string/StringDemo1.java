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
		char[] arr = str.toCharArray(); //�ַ���תΪ����
		int count=1,start=0; //�����������ָ��
		for(int x=0;x<arr.length;x++) { //�������ݼ�¼��ʼλ�ú���ЧԪ�ظ���
			if(arr[x]==' '&&count==1) {
				start++;
			}else if(arr[x]!=' ')
				count++;
		}
		
		str = new String(arr,start,count); //�����µ��ַ���
		return str;
	}

	public static String maxSubString(String str1, String str2) {
		String str = str1.length() > str2.length() ? str1 : str2; // ��ȡ����
		String substr = str1.length() < str2.length() ? str1 : str2; // ��ȡ�϶̵��ַ�����Ϊ�Ӵ�

		if (str.contains(substr)) { // ������ַ�����������Ӵ���ֱ�ӷ��ض̴�
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
		int count = 0; // ���������
		int pt = 0; // ����ָ��
		while (pt < str.length()) { // ָ�ҪС��ַ�������һ���Ř�
			pt = str.indexOf(substr, pt); // �����ַ������Kӛ��ַ����״γ��F��λ��
			if (pt < 0) { // �o���ҵ��ַ���ֱ�ӷ���-1
				return -1;
			} else {
				pt += substr.length(); // ����Ƅ�ָ�
				count++; // Ӌ��������
			}
		}
		return count;
	}

	// ��ʦ�Ĵ���
	public static int subStringCount_2(String str, String substr) {
		int count = 0; // ���������
		int pt = 0; // ����ָ��
		while ((pt = str.indexOf(substr, pt)) != -1) { // δ�ҵ��˳�ѭ��
			pt += substr.length(); // ����Ƅ�ָ�
			count++; // Ӌ��������
		}
		return count;
	}

}
