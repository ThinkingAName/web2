package com.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class testDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from test";
		testDB db = new testDB();
		//db.DBHelper(sql);
		db.doLogin(sql);
		
//		StudentDAO db1 = new StudentDAO();
//		Connection conn = db1.getConnection();
		
		
}
	
	
	
	 public void DBHelper(String sql) {    
		 
		   String url = "jdbc:mysql://localhost:3306/test";    
	       String name = "com.mysql.cj.jdbc.Driver";    
	       String user = "root";    
	       String password = "starzhang";    
	       
	       Connection conn = null;    
	       PreparedStatement pst = null;    
		 
         try {    
             Class.forName(name);//  
             conn = DriverManager.getConnection(url, user, password);// 
             System.out.println(conn);
             pst = conn.prepareStatement(sql);// 
             
         } catch (Exception e) {    
             e.printStackTrace();    
         } 
         System.out.println(pst);
     }    
     
//     public void close() {    
//         try {    
//             this.conn.close();    
//             this.pst.close();    
//         } catch (SQLException e) {    
//             e.printStackTrace();    
//         }    
//     } 
	 
	 
	 
	 public  void doLogin(String sql) throws SQLException {
		 
		 	StudentDAO db1 = new StudentDAO();
			Connection conn = db1.getConnection();        
	        PreparedStatement ps = null;  //鍚戞暟鎹簱涓彂閫佹暟鎹泦
	        ResultSet rs = null;          //鎺ュ彈杩斿洖鐨勬暟鎹泦瀵硅薄
	        StudentPO sp = null;          //灏嗕紶鍥炵殑琛屽皝瑁呬负鍒楀璞�
	        ResultSetMetaData md = null;
	        JSONArray jsonArr = new JSONArray();
	        System.out.println(conn);    
	        try {
	            ps=conn.prepareStatement(sql);    
	            rs = ps.executeQuery();
	            //閬嶅巻缁撴灉闆嗭紝灏嗘暟鎹皝瑁呭埌闆嗗悎涓�
	            System.out.println("2");    
	            while(rs.next()){
	            	md = rs.getMetaData();
	            	int cloumn = md.getColumnCount();
	            	JSONObject jsonObj = new JSONObject();
	            	for (int i = 1;i<=cloumn;i++) {
	            		jsonObj.put(md.getColumnName(i), rs.getObject(i));
	            	}
	            	jsonArr.add(jsonObj);
	            }
	            
	            System.out.println(jsonArr);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            rs.close();
	            ps.close();
	            conn.close();
	        }
	        
	      
	    }
}

        

