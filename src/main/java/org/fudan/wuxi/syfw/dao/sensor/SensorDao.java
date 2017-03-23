package org.fudan.wuxi.syfw.dao.sensor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.fudan.wuxi.utils.DateUtils;
import org.fudan.wuxi.utils.JdbcUtils;
import org.junit.Test;

public class SensorDao {
	 	String driveName ="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql:///sensor_demo";
		String user ="root";
		String password ="root";
	
	 public static void main(String[] args) {
			
			System.out.println("sdfd");
		}
	 @Test
	public void testName() throws Exception {
	
			try {
				Statement st = JdbcUtils.createStatement(driveName, url, user, password);
//				st.setMaxRows(10);
				 String sql = "SELECT * FROM sensor  WHERE TIME_TO_SEC(TIMEDIFF(NOW(),DATETIME)) < 1800000";
//				 String sql = "select * from sensor where 采集时间>=UNIX_TIMESTAMP('2016-12-07 00:00:00') and 采集时间<UNIX_TIMESTAMP('2016-12-07 09:24:10') ";
//				 String sql = "alter table sensor change column 采集时间   datetime";
//				st.execute(sql);
				ResultSet rs = st.executeQuery(sql);
//				//5.处理ResultSet
			      while(rs.next()){
			        //rs.get+数据库中对应的类型+(数据库中对应的列别名)
			        int id = rs.getInt("id");
			        String name = rs.getString("MAC地址");
			        String email = rs.getString("传感器类型");
			        Date birth = rs.getDate("datetime");
			         
			        System.out.println(id);
			        System.out.println(name);
			        System.out.println(email);
			        System.out.println(birth);
			        System.out.println("=========================================");
			      }
				 
				 
				 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 /**
	  * 查询count条记录
	  * @param count
	  * @return 返回json对象数组，其中包含count个对象
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	  */
	 
	 public String findPhValues2() throws SQLException, ClassNotFoundException{
		 Statement st = JdbcUtils.createStatement(driveName, url, user, password);
		
		 String sql = "SELECT * FROM sensor  WHERE  传感器类型 = 'ph' and TIME_TO_SEC(TIMEDIFF(NOW(),DATETIME)) < 1800000  ";
		 ResultSet rs = st.executeQuery(sql);
		 List<String> jsonStrs = new ArrayList<String>();
		
		 
		      while(rs.next()){
		        //rs.get+数据库中对应的类型+(数据库中对应的列别名)
		        Timestamp timestamp = rs.getTimestamp("datetime");
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		        String dateStr = sdf.format(timestamp); 
		        String sensorVal = rs.getString("传感器值");
		        //将结果封装成如下格式
		        //"[{\"data\":64,\"categories\":\"PH\"},{\"data\":45,\"categories\":\"温度\"},{\"data\":6,\"categories\":\"含氧量 \"}]";
		       String jsonStr = "{\"data\":"+sensorVal+",\"categories\":"+dateStr+"}";
		       jsonStrs.add(jsonStr);
		       
		       
		       System.out.println(jsonStr);
		        
//		        System.out.println(sensorVal);
//		        System.out.println(dateStr);
		        System.out.println("=========================================");
		      }
		      System.out.println(JSONArray.fromObject(jsonStrs));
		      
		      
		 return JSONArray.fromObject(jsonStrs).toString();
	 }
	 
	 
	 /**
	  * 查询count条记录
	  * @param count
	  * @return 返回json对象数组，其中包含count个对象
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	  */
	 @Test
	 public String findPhValues() throws SQLException, ClassNotFoundException{
		 Statement st = JdbcUtils.createStatement(driveName, url, user, password);
		
		 String sql = "SELECT * FROM sensor  WHERE  传感器类型 = 'ph' and TIME_TO_SEC(TIMEDIFF(NOW(),DATETIME)) < 1800000  ";
		 ResultSet rs = st.executeQuery(sql);
//		 List<String> jsonStrs = new ArrayList<String>();
		 StringBuffer sb = new StringBuffer();
		 sb.append("[");
		 
		      while(rs.next()){
		        //rs.get+数据库中对应的类型+(数据库中对应的列别名)
		        Timestamp timestamp = rs.getTimestamp("datetime");
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		        String dateStr = sdf.format(timestamp); 
		        String sensorVal = rs.getString("传感器值");
		        //将结果封装成如下格式
		        //"[{\"data\":64,\"categories\":\"PH\"},{\"data\":45,\"categories\":\"温度\"},{\"data\":6,\"categories\":\"含氧量 \"}]";
		       String jsonStr = "{\"data\":"+sensorVal+",\"categories\":"+"\""+dateStr+"\"}";
		       sb.append(jsonStr).append(",");
		       
		       System.out.println(jsonStr);
		        
//		        System.out.println(sensorVal);
//		        System.out.println(dateStr);
		        System.out.println("=========================================");
		      }
		      sb.deleteCharAt(sb.length() - 1);
		      sb.append("]");
		      
//		      System.out.println(sb.toString());
		      
		      return sb.toString();
		      
	 }
}
