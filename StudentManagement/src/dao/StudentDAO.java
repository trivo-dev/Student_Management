package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Student;


public class StudentDAO {
    public void addStudent(Student s) {
    	try {
    		Connection conn = DBConnection.getConnection();
    		
    		String sql= "INSERT INTO students VALUES(?,?,?,?,?,?)";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    		ps.setString(1, s.getStudent_id());
    		ps.setString(2, s.getName());
    		ps.setDate(3, s.getBirth());
    		ps.setString(4, s.getMajor());
    		ps.setDouble(5, s.getGpa());
    		ps.setString(6, s.getClass_name());
    		
    		ps.executeUpdate(); 
    		
    		System.out.println("Added student.");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    
    }
    public void showStudent() {
    	try {
    		Connection conn= DBConnection.getConnection();
    		
    		String sql = "SELECT * FROM students";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ResultSet rs= ps.executeQuery();
    		
    		while(rs.next()) {
    			System.out.println(
    					rs.getString("student_id")+"|"+
    					rs.getString("name")+"|"+
    					rs.getDate("birth")+"|"+
    					rs.getString("major")+"|"+
    					rs.getDouble("gpa")+"|"+
    					rs.getString("class_name")
    					);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }	
    public void deleteStudent(String id) {
    	try {
    		Connection conn =DBConnection.getConnection();
    		
    		String sql ="DELETE  FROM students WHERE student_id=?";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    		ps.setString(1, id);
    		
    		ps.executeUpdate();
    		
    		System.out.println("Deleted student");
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void updateStudent(Student s) {
    try {
	Connection conn = DBConnection.getConnection();
    	
    	String sql ="UPDATE students SET name=?,birth=?,major=?,gpa=?,class_name=? WHERE student_id=?";
    	
    	PreparedStatement ps= conn.prepareStatement(sql);
    	

        ps.setString(1, s.getName());
        ps.setDate(2, s.getBirth());
        ps.setString(3, s.getMajor());
        ps.setDouble(4, s.getGpa());
        ps.setString(5, s.getClass_name());
        ps.setString(6, s.getStudent_id());
        
        ps.executeUpdate();
        System.out.println("Updated.");
    }catch(Exception e) {
    	e.printStackTrace();
    }
        
    }
    public void getStudentByClass(String class_name) {
    	try {
    		Connection conn= DBConnection.getConnection();
    		
    		String sql ="SELECT * FROM students WHERE class_name=?";
    		
    		PreparedStatement ps =conn.prepareStatement(sql);
    		
    		ps.setString(1, class_name);
    		
    		ResultSet rs=ps.executeQuery();
    		
    		while(rs.next()) {
    			System.out.println(
    					rs.getString("student_id")+"|"+
    					rs.getString("name")+"|"+
    					rs.getDate("birth")+"|"+
    					rs.getString("major")+"|"+
    					rs.getDouble("gpa")+"|"+
    					rs.getString("class_name")
    					);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void getStudentByMajor(String major) {
    	try {
    		Connection conn = DBConnection.getConnection();
    		
    		String sql ="SELECT * FROM students WHERE major=?";
    		
    		PreparedStatement ps =conn.prepareStatement(sql);
    		
    		ps.setString(1, major);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			System.out.println(
    					rs.getString("student_id")+"|"+
    					rs.getString("name")+"|"+
    					rs.getDate("birth")+"|"+
    					rs.getString("major")+"|"+
    					rs.getDouble("gpa")+"|"+
    					rs.getString("class_name")
    					);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
   
    public void sortByGPA() {
    	try {
    		Connection conn= DBConnection.getConnection();
    		
    		String sql="SELECT * FROM students ORDER BY gpa DESC";
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    		
    		
    		ResultSet rs= ps.executeQuery();
    		
    		while(rs.next()) {
    			System.out.println(
    					rs.getString("student_id")+"|"+
    					rs.getString("name")+"|"+
    					rs.getDate("birth")+"|"+
    					rs.getString("major")+"|"+
    					rs.getDouble("gpa")+"|"+
    					rs.getString("class_name")
    					);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    	public void getStudentByMonth(int month) {
    		try {
    			Connection conn= DBConnection.getConnection();
    			
    			  String sql = "SELECT * FROM students WHERE MONTH(birth)=?";
    			  
    			  PreparedStatement ps = conn.prepareStatement(sql);
    			  
    			  ps.setInt(1, month);

    			  ResultSet rs = ps.executeQuery();
    			  
    			  while(rs.next()) {
    	    			System.out.println(
    	    					rs.getString("student_id")+"|"+
    	    					rs.getString("name")+"|"+
    	    					rs.getDate("birth")+"|"+
    	    					rs.getString("major")+"|"+
    	    					rs.getDouble("gpa")+"|"+
    	    					rs.getString("class_name")
    	    					);
    	    		}
    			  
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    
    }

