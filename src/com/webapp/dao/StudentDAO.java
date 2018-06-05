package com.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class StudentDAO {
    //闁剧偓甯撮弫鐗堝祦鎼达拷
    public Connection getConnection(){
            Connection conn = null;
            String driverName="com.mysql.cj.jdbc.Driver";
            String connectionString="jdbc:mysql://localhost:3306/test?"+"user=root&password=starzhang&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Hongkong";
            System.out.println(connectionString);
            
            try{
                Class.forName(driverName);
                conn=DriverManager.getConnection(connectionString);
                //conn.close();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("4");
            return conn;
    }
    //閻€劍鍩涢惂璇茬秿
    public StudentPO doLogin(String username,String userpwd) throws SQLException{
        String sql="select * from test where loginname=? and loginpwd=?";
        Connection conn = getConnection();
        
        PreparedStatement ps = null;  //閸氭垶鏆熼幑顔肩氨娑擃厼褰傞柅浣规殶閹诡噣娉�
        ResultSet rs = null;          //閹恒儱褰堟潻鏂挎礀閻ㄥ嫭鏆熼幑顕�娉︾�电钖�
        StudentPO sp = null;          //鐏忓棔绱堕崶鐐垫畱鐞涘苯鐨濈憗鍛礋閸掓顕挒锟�
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, userpwd);
            
            rs = ps.executeQuery();
            //闁秴宸荤紒鎾寸亯闂嗗棴绱濈亸鍡樻殶閹诡喖鐨濈憗鍛煂闂嗗棗鎮庢稉锟�
            System.out.println("2");
            while(rs.next()){
                sp = new StudentPO();
                sp.setUserName(rs.getString("loginname"));/*********/
                sp.setUserPwd(rs.getString("loginpwd"));    
                sp.setuserPower(rs.getInt("power"));
                sp.setUserId(rs.getInt("id"));
                sp.setRealName(rs.getString("name"));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            rs.close();
            ps.close();
            conn.close();
        }
        
        return sp;
    }
    
    public int executeNonQuery(String sql,Object[]args) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps = conn.prepareStatement(sql);
            
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1, args[i]);
                }
            }
            result=ps.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ps.close();
            conn.close();
        }
        return result;
    }
    //閻€劍鍩涘▔銊ュ斀
    public int add(int id,String name,String loginpwd,int userage,String realname,int userpower) throws SQLException{
        String sql="insert into test(id,loginname,loginpwd,age,name,power)"
            +"values(?,?,?,?,?,?)";
        
        Object[] args={id,name,loginpwd,userage,realname,userpower};
        
        int result=executeNonQuery(sql, args);
        
        return result;
    }
    //閸掗攱鏌婇悽銊﹀煕(閸︺劌鎽㈢拫鍐暏)
    public int update(int id,String name,String loginpwd,int age) throws SQLException{
        
        String sql="update test set loginname=? ,loginpwd=? ,age=?"
            +" where id=?";
        Object[] args={name,loginpwd,id,age};
        
        int result = executeNonQuery(sql, args);
        
        return result;
    }
    //閸掔娀娅庨悽銊﹀煕娣団剝浼�
    public int delete(int id) throws SQLException{
        String sql="delete from test where id="+id;
        
        int result=executeNonQuery(sql, null);
        
        return result;
        
    }
    
    //
    public List<StudentPO> queryAllStudent() throws SQLException{
        String sql="select * from test";
        Connection conn = getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentPO> list = new ArrayList<StudentPO>();
        try {
            ps=conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            //闁秴宸荤紒鎾寸亯闂嗗棴绱濈亸鍡樻殶閹诡喖鐨濈憗鍛煂闂嗗棗鎮庢稉锟�
            
            while(rs.next()){
                int userid=rs.getInt("id");//***********
                int userage=rs.getInt("age");
                int userpower=rs.getInt("power");
                String username = rs.getString("loginname");
                String userpwd = rs.getString("loginpwd");
                String realname=rs.getString("name");
            
                
                StudentPO sp = new StudentPO();
                sp.setUserId(userid);
                sp.setUserName(username);
                sp.setRealName(realname);
                sp.setUserPwd(userpwd);
                sp.setUserAge(userage);
                sp.setuserPower(userpower);
                
                list.add(sp);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            rs.close();
            ps.close();
            conn.close();
        }
        
        return list;
    }
    //濞夈劌鍞藉Λ锟界槐锟�
    public List<StudentPO> queryStudentById(int id) throws SQLException{
        String sql="select * from test where id="+id;
        Connection conn = getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentPO> list = new ArrayList<StudentPO>();
        try {
            ps=conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            //闁秴宸荤紒鎾寸亯闂嗗棴绱濈亸鍡樻殶閹诡喖鐨濈憗鍛煂闂嗗棗鎮庢稉锟�
            
            while(rs.next()){
                int userid=rs.getInt("id");//**************/
                int userage=rs.getInt("age");
                int userpower=rs.getInt("power");
                String username = rs.getString("loginname");
                String userpwd = rs.getString("loginpwd");
                String realname=rs.getString("name");
                
                StudentPO sp = new StudentPO();
                sp.setUserId(userid);
                sp.setUserName(username);
                sp.setUserPwd(userpwd);
                sp.setUserAge(userage);
                sp.setRealName(realname);
                sp.setuserPower(userpower);
                
                list.add(sp);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            rs.close();
            ps.close();
            conn.close();
        }
        return list;
    }
}
