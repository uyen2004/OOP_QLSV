package uyen.oop.exc;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
	public static Scanner sc = new Scanner(System.in);

	public static void addStudent(List<Student> listStudent) {
		System.out.print("Nhap vao so luong hoc sinh: ");
		int n = sc.nextInt();
		int quantity = listStudent.size() + n;
		for (int i = listStudent.size(); i < quantity; i++) {
			System.out.println("Nhap vao hoc sinh thu " + (i + 1));
			Student student = new Student();
			Student.input(student);
			listStudent.add(student);
			double toan = listStudent.get(i).getToan();
			double ly = listStudent.get(i).getLy();
			double hoa = listStudent.get(i).getHoa();
			System.out.println(toan + " " + ly + " " + hoa);
			listStudent.get(i).setGPA(Student.tinhDiemTB(toan, ly, hoa));
			listStudent.get(i).setClassify(Student.classify(listStudent.get(i).getGPA()));
			System.out.print("---------------------" + "\n");
		}
	}

	public static void xuatDanhSachHocSinh(List<Student> listStudent) {
		for (int i = 0; i < listStudent.size(); i++) {
			listStudent.get(i).display();
		}
		System.out.println();
	}

	public static void listYeu(List<Student> listStudent) {
		int count = 0;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getClassify() == "Yeu") {
				listStudent.get(i).display();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Khong co hoc sinh yeu");
		}
	}

	public static Student svMax(List<Student> listStudent) {
		Student svMax = listStudent.get(0);
		for (int i = 0; i < listStudent.size(); i++) {
			if (svMax.getGPA() < listStudent.get(i).getGPA()) {
				svMax = listStudent.get(i);
				System.out.println();
			}
		}
		return svMax;
	}

	public static void danhSachTheoTen(List<Student> listStudent) {
		System.out.print("Nhap vao ten muon tim: ");
		String s = sc.next();
		boolean found = false;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getName().equals(s)) {
				listStudent.get(i).display();
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Khong co hoc sinh ten " + s);
		}

	}

	public static void danhSachTheoMa(List<Student> listStudent) {
		System.out.print("Nhap vao ma SV muon tim: ");
		int n = sc.nextInt();
		boolean isFound = false;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId() == n) {
				listStudent.get(i).display();
				isFound = true;
			}
		}
		if (isFound == false) {
			System.out.println("Khong co hoc sinh co ID " + n);
		}
	}

	public static void xoaHocSinh(List<Student> listStudent) {
		System.out.println("Nhap vao ID muon xoa: ");
		int id = sc.nextInt();
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId() == id) {
				listStudent.remove(i);
			}
		}
	}

	public static int checkID(List<Student> listStudent, int id) {
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId() == id) {
				System.out.print("Ma da ton tai,nhap lai ma hoc sinh: ");
				id = sc.nextInt();
				id = checkID(listStudent, id);
			}
		}
		return id;
	}

	public static double checkDiem(double score) {
		if (score > 10 || score < 0) {
			System.out.print("Diem khong hop le, nhap lai: ");
			score = sc.nextInt();
			score = checkDiem(score);
		}
		return score;
	}
}
