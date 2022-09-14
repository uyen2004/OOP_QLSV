
package uyen.oop.exc;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
	public static Scanner sc = new Scanner(System.in);

	public static void addStudent(List<Student> listStudent) {
		System.out.print("Nhap vao so luong hoc sinh: ");
		int n = Integer.parseInt(sc.nextLine());
		int quantity = listStudent.size() + n;
		for (int i = listStudent.size(); i < quantity; i++) {
			System.out.println("Nhap vao hoc sinh thu " + (i + 1));
			Student student = new Student();
			student.input(student);
			listStudent.add(student);
			double toan = listStudent.get(i).getToan();
			double ly = listStudent.get(i).getLy();
			double hoa = listStudent.get(i).getHoa();
			listStudent.get(i).setGPA(student.tinhDiemTB(toan, ly, hoa));
			listStudent.get(i).setClassify(student.classify(listStudent.get(i).getGPA()));
			inDauGach();
			System.out.println();
		}
	}

	public void xuatDanhSachHocSinh(List<Student> listStudent) {
		System.out.println("-----------------------------Danh sach hoc sinh--------------------------------");
		for (int i = 0; i < listStudent.size(); i++) {
			listStudent.get(i).display();
			inDauGach();
		}
	}

	public void listYeu(List<Student> listStudent) {
		int count = 0;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getClassify() == "Yeu") {
				listStudent.get(i).display();
				count++;
				inDauGach();
			}
		}
		if (count == 0) {
			System.out.println("	Khong co hoc sinh yeu");
		}
	}

	public Student svMax(List<Student> listStudent) {
		Student svMax = listStudent.get(0);
		for (int i = 0; i < listStudent.size(); i++) {
			if (svMax.getGPA() < listStudent.get(i).getGPA()) {
				svMax = listStudent.get(i);
				System.out.println();
			}
		}
		return svMax;
	}

	public void danhSachTheoTen(List<Student> listStudent) {
		System.out.print("Nhap vao ten muon tim: ");
		String s = sc.nextLine();
		boolean found = false;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getName().compareToIgnoreCase(s) == 0) {
				listStudent.get(i).display();
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Khong co hoc sinh ten " + s);
		}

	}

	public void danhSachTheoMa(List<Student> listStudent) {
		System.out.print("Nhap vao ma SV muon tim: ");
		String id = sc.next();
		boolean isFound = false;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId().equals(id)) {
				listStudent.get(i).display();
				isFound = true;
			}
		}
		if (isFound == false) {
			System.out.println("Khong co hoc sinh co ID " + id);
		}
	}

	public void xoaHocSinh(List<Student> listStudent) {
		System.out.println("Nhap vao ID muon xoa: ");
		String id = sc.next();
		boolean deleted = false;
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId().equals(id)) {
				listStudent.remove(i);
				deleted = true;
			}
		}
		if (deleted == true) {
			System.out.println("Da xoa thanh cong");
		} else {
			System.out.println("ID khong ton tai");
		}
	}

	public String checkID(List<Student> listStudent, String id) {
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId().equals(id)) {
				System.out.print("Ma da ton tai,nhap lai ma hoc sinh: ");
				id = sc.next();
				id = checkID(listStudent, id);
			}
		}
		return id;
	}

	public double checkDiem(double score) {
		if (score > 10 || score < 0) {
			System.out.print("Diem khong hop le, nhap lai: ");
			score = sc.nextInt();
			score = checkDiem(score);
		}
		return score;
	}

	public static void inDauGach() {
		for (int i = 0; i < 120; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
