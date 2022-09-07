package uyen.oop.exc;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean option = true;
		while (option) {
			studentManagement();
			int n = sc.nextInt();
			switch (n) {
			case 1:
				StudentManagement.addStudent(Student.listStudent);
				break;
			case 2:
				StudentManagement.xuatDanhSachHocSinh(Student.listStudent);
				break;
			case 3:
				System.out.println("Danh sach hoc sinh yeu");
				StudentManagement.listYeu(Student.listStudent);
				break;
			case 4:
				System.out.println("Danh sach hoc sinh co diem trung binh cao nhat");
				for (int i = 0; i < Student.listStudent.size(); i++) {
					if (Student.listStudent.get(i).getGPA() == StudentManagement.svMax(Student.listStudent).getGPA()) {
						Student.listStudent.get(i).display();
					}
				}
				break;
			case 5:
				StudentManagement.danhSachTheoTen(Student.listStudent);
				break;
			case 6:
				StudentManagement.danhSachTheoMa(Student.listStudent);
				break;
			case 7:
				StudentManagement.xoaHocSinh(Student.listStudent);
				break;
			default:
				System.out.println("Exit");
				option = false;
				break;
			}

		}
	}

	public static void studentManagement() {
		System.out.println("1. Nhap thong tin hoc sinh");
		System.out.println("2. In ra danh sach hoc sinh");
		System.out.println("3. In ra danh sach hoc sinh yeu");
		System.out.println("4. In ra danh sach hoc sinh co diem TB cao nhat");
		System.out.println("5. Tim sinh vien theo ten");
		System.out.println("6. Tim sinh vien theo ma");
		System.out.println("7. Xoa sinh vien theo ma");
		System.out.println("so bat ki: Exit");
		System.out.print("Nhap vao so: ");
	}

}
