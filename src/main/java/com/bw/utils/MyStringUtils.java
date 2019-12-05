package com.bw.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtils {
	//鍒ゆ柇鏄惁涓虹┖瀛楃涓�
	public static boolean isNull(String str){
		if(str == null || str.length() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	//鍒ゆ柇瀛楃涓叉槸鍚︿负绌烘垨鑰呯┖鐧藉瓧绗︿覆
	public static boolean isBlank(String str){
		if(str == null || str.length() == 0 || str.trim().length() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	//鍒ゆ柇鏄惁涓烘墜鏈哄彿
	public static boolean isPhoneNumber(String str){
		boolean blank = isBlank(str);
		if(blank){
			Pattern pattern = Pattern.compile("^1[3|5|7|8|9]\\d{9}$");
			
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	//鍒ゆ柇鏄惁涓洪偖绠�
	public static boolean isEmail(String str){
		boolean blank = isBlank(str);
		if(blank){
			Pattern pattern = Pattern.compile("^\\w+@\\w+\\.(\\w)+$");
			
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//鍒ゆ柇瀛楃涓叉槸鍚﹀叏閮ㄩ兘鏄瓧姣�
	public static boolean isEnglish(String str){
		boolean blank = MyStringUtils.isBlank(str);
		if(blank){
			Pattern pattern = Pattern.compile("^[A-z]*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//鑾峰彇n浣嶉殢鏈鸿嫳鏂囧瓧姣�
	public static String getString(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(26);
			String word = words[index] + "";
			int bigorsmall = random.nextInt();
			if(bigorsmall % 2 == 0){
				word = word.toLowerCase();
			}
			result.append(word);
		}
		
		return result.toString();
	}
	//鍒ゆ柇涓�涓瓧绗︿覆鏄惁鏄函鏁板瓧
	public static boolean isNumber(String str){
		boolean blank = MyStringUtils.isBlank(str);
		if(blank){
			Pattern pattern = Pattern.compile("^\\d*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//鑾峰彇n浣嶉殢鏈烘暟瀛楀拰鑻辨枃瀛楁瘝
	public static String getStringAndNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(36);
			String word = words[index] + "";
			if(!MyStringUtils.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String aChinese = getAChinese();
		System.out.println(aChinese);
	}
	//鐢熸垚闅忔満姹夊瓧瀛楃涓�
	public static String getAChinese() {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < 100 ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
}
