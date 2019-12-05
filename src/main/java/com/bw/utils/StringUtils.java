package com.bw.utils;

import java.util.HashMap;

/**
		判断源字符串是否有值，空引号也算没值	String 源字符串	boolean	null = false
		"" = false
		判断源字符串是否有值，空引号和空格也算没值	String 源字符串	boolean	null = false
		"" = false
		" " = false
		判断是否为手机号码	String 源字符串	boolean	null = false
		" " = false
		"13800138000" = true
		"19203604281" = false
 */
public class StringUtils {
	
	/**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
    
    
    /**
	 * 功能说明：判断字符串的值是不是数字<br>
	 * @param validString
	 * @return
	 * boolean
	 */
	public static boolean isNumber(String validString){
		if(!hasText(validString)){
			return false;
		}
		byte[] tempbyte = validString.getBytes();
		for(int i = 0; i < validString.length(); i++){
			if( ( tempbyte[i] == 45 ) && ( i == 0 ) ){
				continue;
			}
			if((tempbyte[i] < 48) || (tempbyte[i] > 57)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "* Because TreeNodes are about twice the size of regular nodes, we"+
     "* use them only when bins contain enough nodes to warrant use"+
     "* (see TREEIFY_THRESHOLD). And when they become too small (due to"+
     "* removal or resizing) they are converted back to plain bins.  In"+
     "* usages with well-distributed user hashCodes, tree bins are"+
     "* rarely used.  Ideally, under random hashCodes, the frequency of"+
    " * nodes in bins follows a Poisson distribution"+
    " * (http://en.wikipedia.org/wiki/Poisson_distribution) with a"+
     "* parameter of about 0.5 on average for the default resizing"+
    " * threshold of 0.75, although with a large variance because of"+
    " * resizing granularity. Ignoring variance, the expected"+
    " * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /"+
    " * factorial(k)). The first values are";
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = str.toCharArray();
		 for (char c : arr) {
			 map.put(c, !map.containsKey(c)?1:(map.get(c)+1));
		 }
		 for (Character c : map.keySet()) {
			 System.out.println(c+":"+map.get(c));
		 }
		 
	}
	
	/**
	 * 功能说明：判断字符串是否有值，空白字符串和空格也不算<br>
	 * @param src
	 * @return
	 * boolean
	 */
	public static boolean hasText(String src){
		return src != null && src.trim().length() > 0;
	}
	

	/**
	 * 手机号验证
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		
		String reg = "1[3|5|6|7|8|9]\\d{9}";
		
		return str.matches(reg);
		
	}
	
	/**
	 * 邮箱验证
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String reg = "\\w+@\\w+(.com|.cn)";
		return str.matches(reg);
	}
	
	
	
}
