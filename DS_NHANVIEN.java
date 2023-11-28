package NHANVIEN;

import java.util.Scanner;

import SANPHAM.CHUCNANG;
import SANPHAM.DOCGHIFILE;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DS_NHANVIEN implements CHUCNANG, DOCGHIFILE {
	private static final int MAX_NHANVIEN = 100; 
    private NHANVIEN[] danhSachNhanVien;
    private int soLuongNhanVien;
    private Scanner sc = new Scanner(System.in);


    public DS_NHANVIEN() {
    	danhSachNhanVien = new NHANVIEN[MAX_NHANVIEN];
        soLuongNhanVien = 0;
    }

    @Override
    public void Them() {
    	if (soLuongNhanVien == danhSachNhanVien.length) {
            danhSachNhanVien = java.util.Arrays.copyOf(danhSachNhanVien, danhSachNhanVien.length * 2);
        }

        if (soLuongNhanVien < MAX_NHANVIEN) {
        	System.out.println("Chon chuc vu nhan vien:");
            System.out.println("1. Quan ly");
            System.out.println("2. Ban hang");
            System.out.println("3. Thu ngan");

            int choice = sc.nextInt();

            NHANVIEN nhanVienMoi = null;

            switch (choice) {
                case 1:
                    nhanVienMoi = new QUANLY();
                    break;
                case 2:
                    nhanVienMoi = new BANHANG();
                    break;
                case 3: 
                    nhanVienMoi = new THUNGAN();
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    return; 
            }
            nhanVienMoi.input();
            danhSachNhanVien[soLuongNhanVien++] = nhanVienMoi;
            System.out.println("Them nhan vien thanh cong.");
        } else {
            System.out.println("Danh sach nhan vien da day. Khong the them moi..");
        }
    }

    @Override
    public void Xoa() {
        System.out.println("Nhap ma nhan vien can xoa: ");
        String maNhanVien = sc.nextLine();
        int index = -1;

        for (int i = 0; i < soLuongNhanVien; i++) {
            NHANVIEN nv = danhSachNhanVien[i];
            if (nv != null && nv.getMaNhanVien().equals(maNhanVien)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            danhSachNhanVien[index] = danhSachNhanVien[soLuongNhanVien - 1];
            danhSachNhanVien[soLuongNhanVien - 1] = null;
            soLuongNhanVien--;
            System.out.println("Xoa nhan vien thanh cong.");
        } else {
            System.out.println("Khong tim thay nhan vien co ma " + maNhanVien);
        }
    }

    
    @Override
    public void Sua() {
        System.out.println("Nhap ma nhan vien can sua: ");
        String maNhanVien = sc.nextLine();
        for (NHANVIEN nv : danhSachNhanVien) {
            if (nv != null && nv.getMaNhanVien().equals(maNhanVien)) {
                nv.input();
                System.out.println("Sua nhan vien thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co ma " + maNhanVien);
    }

    @Override
    public void timKiem() {
        System.out.println("Nhap ma hoac ten nhan vien can tim: ");
        String key = sc.nextLine().toLowerCase();

        for (NHANVIEN nv : danhSachNhanVien) {
            if (nv != null && (nv.getMaNhanVien().toLowerCase().contains(key) || nv.getTenNhanVien().toLowerCase().contains(key))) {
                nv.output();
                System.out.println("--------------------");
            }
        }
    }


    @Override
    public void hienThiDanhSach() {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (this.danhSachNhanVien[i] != null) {
                NHANVIEN nv = this.danhSachNhanVien[i];
                System.out.println("Thong tin nhan vien:");
                System.out.println("Ma nhan vien: " + nv.getMaNhanVien());
                System.out.println("Ten nhan vien: " + nv.getTenNhanVien());
                System.out.println("So dien thoai: " + nv.getSDT());
                System.out.println("Dia chi: " + nv.getDiaChi());
                System.out.println("Gioi tinh: " + (nv.getGioiTinh() ? "Nam" : "Nu"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Ngay sinh: " + dateFormat.format(nv.getNgaySinh()));
                System.out.println("Ngay vao lam: " + dateFormat.format(nv.getNgayVaoLam()));
                System.out.println("Chuc vu: " + nv.getChucVu());

                if (nv instanceof QUANLY) {
                    QUANLY quanLy = (QUANLY) nv;
                    System.out.println("Ngay cong: " + quanLy.getNgayCong());
                    System.out.println("Luong thang: " + quanLy.tinhLuong());
                } else if (nv instanceof BANHANG) {
                    BANHANG banHang = (BANHANG) nv;
                    System.out.println("Ngay cong: " + banHang.getNgayCong());
                    System.out.println("Luong thang: " + banHang.tinhLuong());
                } else if (nv instanceof THUNGAN) {
                    THUNGAN thuNgan = (THUNGAN) nv;
                    System.out.println("Ngay cong: " + thuNgan.getNgayCong());
                    System.out.println("Luong thang: " + thuNgan.tinhLuong());
                }

                System.out.println("------------------");
            } else {
                System.out.println("Nhan vien tai vi tri " + i + " chua duoc khoi tao.");
            }
        }
    }
    
    public void thongKe() {
    	int nam = 0, nu = 0, qly = 0, bhg = 0, tng = 0;
    	long maxluong = 0, minluong = 999999999;
    	int indexmaxluong = -1, indexminluong = -1;
    	for (int i = 0; i < soLuongNhanVien; i++) {
    		NHANVIEN nv = danhSachNhanVien[i];
    		
    		// thong ke gioi tinh
    		if (nv.getGioiTinh())	nam ++;
    		else nu ++;

    		// thong ke chuc bvu
    		if (nv instanceof QUANLY) qly ++;
    		else if (nv instanceof THUNGAN) tng++;
    		else bhg++;
    		
    		// thong ke luong cao nhat, thap nhat
    		if (maxluong < nv.tinhLuong()) {
    			maxluong = nv.tinhLuong();
    			indexmaxluong = i;
    		}
    		if (minluong > nv.tinhLuong()) {
    			minluong = nv.tinhLuong();
    			indexminluong = i;
    		}
    	}
    	System.out.print("Co " + nam + " nhan vien nam, " + nu + " nhan vien nu.\n");
    	System.out.print("Nhan vien luong cao nhat: " + danhSachNhanVien[indexmaxluong].getTenNhanVien() + " " + maxluong + "\n");
    	System.out.print("Nhan vien luong thap nhat: " + danhSachNhanVien[indexminluong].getTenNhanVien() + " " + minluong + "\n");
    	System.out.print("Co " + qly + " nhan vien quan ly, " + bhg + " nhan vien ban hang, " + tng + " nhan vien thu ngan.\n");
    }
    
    @Override
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            soLuongNhanVien = Integer.parseInt(br.readLine());
            danhSachNhanVien = new NHANVIEN[soLuongNhanVien];

            for (int i = 0; i < soLuongNhanVien; i++) {
                String maNhanVien = br.readLine().trim();
                String tenNhanVien = br.readLine().trim();
                String sDT = br.readLine().trim();
                String diaChi = br.readLine().trim();
                boolean gioiTinh = br.readLine().trim().equalsIgnoreCase("Nam");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date ngaySinh = dateFormat.parse(br.readLine().trim());
                Date ngayVaoLam = dateFormat.parse(br.readLine().trim());
                String chucVu = br.readLine().trim();

                NHANVIEN nv = null;

                if (chucVu.equalsIgnoreCase("Quan ly")) {
                    QUANLY quanLy = new QUANLY();
                    quanLy.setNgayCong(Integer.parseInt(br.readLine().trim()));
                    quanLy.tinhLuong();
                    nv = quanLy;
                } else if (chucVu.equalsIgnoreCase("Ban hang")) {
                    BANHANG banhang = new BANHANG();
                    banhang.setNgayCong(Integer.parseInt(br.readLine().trim()));
                    banhang.tinhLuong();
                    nv = banhang;
                } else if (chucVu.equalsIgnoreCase("Thu ngan")) {
                    THUNGAN thungan = new THUNGAN();
                    thungan.setNgayCong(Integer.parseInt(br.readLine().trim()));
                    thungan.tinhLuong();
                    nv = thungan;
                }
                if (nv != null) {
                    nv.setMaNhanVien(maNhanVien);
                    nv.setTenNhanVien(tenNhanVien);
                    nv.setSDT(sDT);
                    nv.setDiaChi(diaChi);
                    nv.setGioiTinh(gioiTinh);
                    nv.setNgaySinh(ngaySinh);
                    nv.setNgayVaoLam(ngayVaoLam);
                    nv.setChucVu(chucVu);
                }
                danhSachNhanVien[i] = nv;
            }
            System.out.println("Đoc file thanh cong.");
        } catch (IOException | ParseException | NumberFormatException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

	@Override
    public void ghiFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            bw.write(Integer.toString(soLuongNhanVien));
            bw.newLine();
            for (int i = 0; i < soLuongNhanVien; i++) {
                NHANVIEN nv = danhSachNhanVien[i];
                if (nv != null) {
                    bw.write(nv.getMaNhanVien() + "\n");
                    bw.write(nv.getTenNhanVien() + "\n");
                    bw.write(nv.getSDT() + "\n");
                    bw.write(nv.getDiaChi() + "\n");
                    bw.write((nv.getGioiTinh() ? "Nam" : "Nu") + "\n");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    bw.write(dateFormat.format(nv.getNgaySinh()) + "\n");
                    bw.write(dateFormat.format(nv.getNgayVaoLam()) + "\n");
                    bw.write(nv.getChucVu() + "\n");
                    
                    if (nv instanceof QUANLY) {
                        QUANLY ql = (QUANLY) nv;
                        bw.write(String.valueOf(ql.getNgayCong()) + "\n");
                        bw.write(Integer.toString((int)ql.tinhLuong()) + "\n");
                    }
                    
                    if (nv instanceof BANHANG) {
                        BANHANG bh = (BANHANG) nv;
                        bw.write(String.valueOf(bh.getNgayCong()) + "\n");
                        bw.write(Integer.toString((int)bh.tinhLuong()) + "\n");
                    }
                    
                    if (nv instanceof THUNGAN) {
                        THUNGAN tn = (THUNGAN) nv;
                        bw.write(String.valueOf(tn.getNgayCong()) + "\n");
                        bw.write(Integer.toString((int)tn.tinhLuong()) + "\n");
                    }
                    
                }
            }
            soLuongNhanVien++;
            System.out.println("Ghi file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
}