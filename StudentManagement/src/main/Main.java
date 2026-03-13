package main;

import dao.StudentDAO;
import model.Student;
import service.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true){

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Danh sach tat ca");
            System.out.println("5. Danh sach theo lop");
            System.out.println("6. Danh sach theo nganh");
            System.out.println("7. Sap xep theo GPA");
            System.out.println("8. Sinh vien theo thang sinh");
            System.out.println("0. Thoat");

            System.out.print("Chon: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                	System.out.print("Nhap MSSV: ");
                	String id = sc.nextLine();

                	System.out.print("Nhap ten: ");
                	String name = sc.nextLine();
                	name = Validator.normalizeName(name);

                	System.out.print("Nhap ngay sinh (yyyy-mm-dd): ");
                	LocalDate birthLocal = LocalDate.parse(sc.nextLine());

                	if(!Validator.validAge(birthLocal)){
                	    System.out.println("Tuoi khong hop le!");
                	    break;
                	}

                	Date birth = Date.valueOf(birthLocal);

                	System.out.print("Nhap nganh (CNTT/KTPM): ");
                	String major = sc.nextLine();

                	if(!Validator.validStudentID(id, major)){
                	    System.out.println("MSSV khong dung voi nganh!");
                	    break;
                	}

                	System.out.print("Nhap GPA: ");
                	double gpa = sc.nextDouble();
                	sc.nextLine();

                	if(!Validator.validGPA(gpa)){
                	    System.out.println("GPA khong hop le!");
                	    break;
                	}

                	System.out.print("Nhap lop: ");
                	String className = sc.nextLine();

                	Student s = new Student(id, name, birth, major, gpa, className);

                	dao.addStudent(s);

                	break;

                case 2:

                    System.out.print("Nhap MSSV can xoa: ");
                    String deleteID = sc.nextLine();

                    dao.deleteStudent(deleteID);

                    break;

                case 3:

                    System.out.print("Nhap MSSV can sua: ");
                    String updateID = sc.nextLine();

                    System.out.print("Nhap ten moi: ");
                    String newName = sc.nextLine();

                    System.out.print("Nhap ngay sinh (yyyy-mm-dd): ");
                    Date newBirth = Date.valueOf(sc.nextLine());

                    System.out.print("Nhap nganh: ");
                    String newMajor = sc.nextLine();

                    System.out.print("Nhap GPA: ");
                    double newGPA = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nhap lop: ");
                    String newClass = sc.nextLine();

                    Student updateStudent = new Student(updateID,newName,newBirth,newMajor,newGPA,newClass);

                    dao.updateStudent(updateStudent);

                    break;

                case 4:

                    dao.showStudent();

                    break;

                case 5:

                    System.out.print("Nhap lop: ");
                    String classSearch = sc.nextLine();

                    dao.getStudentByClass(classSearch);

                    break;

                case 6:

                    System.out.print("Nhap nganh: ");
                    String majorSearch = sc.nextLine();

                    dao.getStudentByMajor(majorSearch);

                    break;

                case 7:

                    dao.sortByGPA();

                    break;

                case 8:

                    System.out.print("Nhap thang (1-12): ");
                    int month = sc.nextInt();

                    dao.getStudentByMonth(month);

                    break;

                case 0:

                    System.out.println("Thoat chuong trinh");
                    System.exit(0);

                default:

                    System.out.println("Lua chon khong hop le");

            }
        }
    }
}
