/**
 * 
 */
package com.fz.util;

//import java.util.HashMap;
import java.util.Locale;
//import java.util.Map;
import java.util.ResourceBundle;

/**
 * 工具类
 * @author fansy
 * @date 2015-6-8
 */
public class Utils {

	// hadoop 常量
//	private static Map<String,String> HADOOPCONSTANTS=new HashMap<String,String>();
	private static ResourceBundle resb = null;
	
	public static String  getKey(String key){
		if(resb==null){
			Locale locale = new Locale("zh", "CN"); 
            resb = ResourceBundle.getBundle("util", locale); 
		}
        return resb.getString(key);
	}
	
	
	
}
