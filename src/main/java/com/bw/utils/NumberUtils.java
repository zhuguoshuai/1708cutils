package com.bw.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
	
	/*
	* 鐧惧垎姣旇绠楁柟娉曪紝杩斿洖鍊煎彧瑕佹暣鏁颁笉闇�瑕佸皬鏁般��
	* 缁欎竴涓綋鍓嶆暟锛屽拰涓�涓�绘暟锛岃绠楀綋鍓嶆暟鐧惧垎鍗犳瘮锛屼緥濡傚弬鏁颁负5鍜�10锛屾柟娉曞唴閮�
	* 5闄や互10寰�0.5锛屽啀涔樹互100锛岃繑鍥�50锛屾敞鎰忓洓鑸嶄簲鍏ャ�傞〉闈㈠氨鍙互鏄剧ず50%
	*/
	
	public static int getPercent(int sum, int num){
		BigDecimal b1 = BigDecimal.valueOf(sum);
		BigDecimal b2 = BigDecimal.valueOf(num);
		BigDecimal result = b2.divide(b1,5,RoundingMode.HALF_UP);
		return result.multiply(BigDecimal.valueOf(100)).intValue();
	}
}
