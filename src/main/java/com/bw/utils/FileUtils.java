package com.bw.utils;

import java.io.File;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class FileUtils {
	/***
	 * 鑾峰彇鏂囦欢鎵╁睍鍚� 鍚庣紑鍚�
	 * @return
	 * D:/test/test.txt
	 */
	public static String getSuffixName(String path) {
		File file = new File(path);
		boolean file2 = file.isFile();
		if(file2) {
			int indexOf = path.indexOf(".");
			String substring = path.substring(indexOf,path.length());
			return substring;
		}else {
			return "璇ヨ矾寰勪笉瀵规垨鑰呬笉鏄櫘閫氭枃浠�";
		}
	}
	/***
	 * 鍒犻櫎鏂囦欢锛屽鏋滄槸鐩綍锛屽垯涓嬮潰鐨勬枃浠跺拰鎵�鏈夊瓙鐩綍涓殑鏂囦欢閮借鍒犻櫎
	 */
	public static void deleteFiles(String path) {
		File file = new File(path);
		if(file.isFile()) {
			file.delete();
		}else if(file.isDirectory()){
			//鑾峰彇鐩綍涓嬬殑鎵�鏈夋枃浠� 鍖呮嫭鐩綍
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				String path2 = file2.getPath();
				//d閫掑綊鍒犻櫎鏂囦欢
				deleteFiles(path2);
			}
		}
		//鍒犻櫎绌烘枃浠跺す
		file.delete();
	}

	/***
	 * 鑾峰彇鎿嶄綔绯荤粺鐢ㄦ埛鐩綍
	 */
	public static String getHomeDirectory() {
		String property = System.getProperty("user.home");
		return property;
	}
	public static String getWorkDirectory() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public static String getFileSize(String path,String unit) {
		File file = new File(path);
		long leng = file.length();
		double length = leng;
		double size = 0;

		switch (unit) {
		case "K":
			size = length/1024;
			break;
		case "M":
			size = length/1024/1024;
			break;
		case "G":
			size = length/1024/1024/1024;
			break;
		default:
			size = length;
			break;
		}
		NumberFormat data=NumberFormat.getNumberInstance();
		//淇濈暀涓や綅灏忔暟
		data.setMaximumFractionDigits(4);
		// 濡傛灉涓嶉渶瑕佸洓鑸嶄簲鍏ワ紝鍙互浣跨敤RoundingMode.DOWN
		data.setRoundingMode(RoundingMode.UP);

		String format = data.format(size);
		return format + unit;
	}

}
