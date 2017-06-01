package com.zgs.common;
/**
 * 数据校验工具类
 */
public class ValidateUtils {

	/**
	 * 校验当前字符串是否为数字类型
	 * 支持整数、浮点数字判断
	 */
	public static boolean isNumeric(String param){
		if(isEmpty(param)){
			return false;
		}else{
			return param.matches("^[-]?[0-9\\.]+$");
		}
	}
	/**
	 * 验证m-n位的数字
	 * 如果max的值为空，则验证是否为min位数字
	 * @param param
	 * @param min   最小位数
	 * @param max   最大位数
	 */
	public static boolean isNumeric(String param,String min,String max){
		if(isEmpty(param)){
			return false;
		}else{
			if(!isEmpty(min)&&!isEmpty(max)){
				return param.matches("^\\d{"+min+","+max+"}$");
			}else if(!isEmpty(min)){
				return param.matches("^\\d{"+min+"}$");
			}
			return false;
		}
	}
	/**
	 * 验证m-n位的小数
	 * 如果max的值为空，则验证是否为min位小数
	 * @param param
	 * @param min 最小位数
	 * @param max 最大位数
	 */
	public static boolean isNumericDF(String param,String min,String max){
		if(isEmpty(param)){
			return false;
		}else{
			if(!isEmpty(min)&&!isEmpty(max)){
				return param.matches("^[0-9](-)?(.[0-9]{"+min+","+max+"})?$");
			}else if(!isEmpty(min)){
				return param.matches("^[0-9](-)?(.[0-9]{"+min+"})?$");
			}
			return false;
		}
	}
	/**
	 * 判断多个变量是否全部不为空
	 */
	public static boolean isAllNotNull(Object...objects){
		boolean isAllNotNull=true;
		for(Object obj:objects){
			if(obj==null){
				isAllNotNull=false;
				break;
			}else if(isEmpty(String.valueOf(obj))){
				isAllNotNull=false;
				break;
			}
		}
		return isAllNotNull;
	}
	
	/**
	 * 判断当前字符串是否为空
	 */
	public static boolean isEmpty(String paramString){
	    return (paramString == null) || (paramString.equals(""));
	}
	/**
	 * 判断当前版本号是否处于两个版本号之间
	 * @param currentVersion  当前版本号
	 * @param startVersion    起始版本号
	 * @param endVersion      结束版本号
	 */
	public static boolean isBetweenVersion(String currentVersion,String startVersion,String endVersion) throws Exception{
		return ((compareVersion(currentVersion,startVersion)>0||compareVersion(currentVersion,startVersion)==0)
				&&(compareVersion(currentVersion,endVersion)<0||compareVersion(currentVersion,endVersion)==0))?true:false;
	}
	private static int compareVersion(String version1, String version2) throws Exception {
	    if (version1 == null || version2 == null) {
	        throw new Exception("compareVersion error:illegal params.");
	    }
	    String[] versionArray1 = version1.split("\\.");
	    String[] versionArray2 = version2.split("\\.");
	    int idx = 0;
	    int minLength = Math.min(versionArray1.length, versionArray2.length);
	    int diff = 0;
	    while (idx < minLength
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
	    	++idx;
	    }
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
	    return diff;
	}
}
