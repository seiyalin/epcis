package org.oliot.util;
import static java.lang.System.out;
//静态导包，可以简化写法，但只能使用静态成员
public class DebugUtils {
	/**
	 * 打印一条String类型debugMessage，并换行
	 * @param debugMessage
	 */
	public static void print(String debugMessage){
		out.println(debugMessage);
	}

//	public static void print(String debugMessage){
//		System.out.println(debugMessage);
//	}
}
