package NHANVIEN;

import java.util.Scanner;

public class Menu {
    private DS_NHANVIEN danhSachNhanVien;
    private Scanner scanner;

    public Menu() {
        danhSachNhanVien = new DS_NHANVIEN();
        scanner = new Scanner(System.in);
    }

    public void run() {
        danhSachNhanVien.docFile("DSNV.txt");

        int luaChon;
        do {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); 

            switch (luaChon) {
                case 1:
                    danhSachNhanVien.Them();
                    break;
                case 2:
                    danhSachNhanVien.Xoa();
                    break;
                case 3:
                    danhSachNhanVien.Sua();
                    break;
                case 4:
                    System.out.println("Danh sach nhan vien:");
                    danhSachNhanVien.hienThiDanhSach();
                    break;
                case 5:
                    danhSachNhanVien.timKiem();
                    break;
                case 6:
                    danhSachNhanVien.ghiFile("DSNV.txt");
                    break;
                case 7:
                    danhSachNhanVien.thongKe();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
            }
        } while (luaChon != 0);
    }

    private void hienThiMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Xoa nhan vien");
        System.out.println("3. Sua thong tin nhan vien");
        System.out.println("4. Hien thi danh sach nhan vien");
        System.out.println("5. Tim kiem nhan vien");
        System.out.println("6. Ghi vao file");
        System.out.println("7. Thong ke");
        System.out.println("0. Thoat");
    }
}

