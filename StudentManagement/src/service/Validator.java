package service;

import java.time.LocalDate;
import java.time.Period;

public class Validator {

    // kiểm tra mã sinh viên
    public static boolean validStudentID(String id){

        if(id == null) return false;

        return id.matches("^45510(5|9)\\d{4}$");
    }

    // kiểm tra ngành
    public static boolean validMajor(String major){

        if(major == null) return false;

        return major.equalsIgnoreCase("CNTT") || major.equalsIgnoreCase("KTPM");
    }

    // kiểm tra GPA
    public static boolean validGPA(double gpa){

        return gpa >= 0 && gpa <= 10;
    }

    // kiểm tra ngày sinh hợp lệ
    public static boolean validBirth(LocalDate birth){

        if(birth == null) return false;

        LocalDate today = LocalDate.now();

        return birth.isBefore(today);
    }

    // kiểm tra tuổi 15 - 110
    public static boolean validAge(LocalDate birth){

        if(birth == null) return false;

        LocalDate today = LocalDate.now();

        int age = Period.between(birth, today).getYears();

        return age >= 15 && age <= 110;
    }

    // chuẩn hóa họ tên
    public static String normalizeName(String name){

        if(name == null) return "";

        name = name.trim().toLowerCase();

        String[] words = name.split("\\s+");

        StringBuilder result = new StringBuilder();

        for(String w : words){

            result.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1))
                  .append(" ");
        }

        return result.toString().trim();
    }
    public static boolean validStudentID(String id, String major){

        if(id == null || major == null) return false;

        // phải là 10 chữ số
        if(!id.matches("\\d{10}")) return false;

        if(major.equalsIgnoreCase("CNTT") && id.startsWith("455105"))
            return true;

        if(major.equalsIgnoreCase("KTPM") && id.startsWith("455109"))
            return true;

        return false;
    }

}