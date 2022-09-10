package uyen.oop.exc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements Serializable {
	public static Scanner sc = new Scanner(System.in);
	private String id;
	private String name;
	private String email;
	private String phone;
	private double toan;
	private double ly;
	private double hoa;
	private double GPA;
	private String classify;
	static List<Student> listStudent = new ArrayList<Student>();
	StudentManagement studentManagement = new StudentManagement();

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		this.toan = toan;
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		this.ly = ly;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public void input(Student student) {
		System.out.print("Nhap vao ma hoc sinh: ");
		student.setId(studentManagement.checkID(listStudent, sc.nextLine()));
		System.out.println("Nhap vao ten hoc sinh: ");
		student.setName(sc.nextLine());
		System.out.print("Nhap vao so dien thoai: ");
		student.setPhone(sc.nextLine());
		System.out.print("Nhap vao diem toan: ");
		student.setToan(studentManagement.checkDiem(Integer.parseInt(sc.nextLine())));
		System.out.print("Nhap vao diem ly: ");
		student.setLy(studentManagement.checkDiem(Integer.parseInt(sc.nextLine())));
		System.out.print("Nhap vao diem Hoa: ");
		student.setHoa(studentManagement.checkDiem(Integer.parseInt(sc.nextLine())));

	}

	public double tinhDiemTB(double toan, double ly, double hoa) {
		double GPA = (toan + ly + hoa) / 3;
		return GPA;
	}

	public String classify(double GPA) {
		String classification = "";
		if (GPA > 9) {
			classification = "Xuat Sac";
		} else if (GPA >= 8 && GPA <= 9) {
			classification = "Gioi";
		} else if (GPA >= 7 && GPA <= 8) {
			classification = "Kha";
		} else if (GPA >= 6 && GPA < 7) {
			classification = "Trung Binh Kha";
		} else if (GPA >= 5 && GPA < 6) {
			classification = "Trung Binh";
		} else {
			classification = "Yeu";
		}
		return classification;
	}

	public void display() {
		System.out.format("Ma SV: %-5s |", this.id);
		System.out.format("Ten SV: %-15s |", this.name);
		System.out.format("So dien thoai: %-12s |", this.phone);
		System.out.format("Diem trung binh: %-5.1f |", this.GPA);
		System.out.format("Xep loai: %-5s ", this.classify);
		System.out.println();
	}

}
