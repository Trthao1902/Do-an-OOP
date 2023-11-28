package NHANVIEN;

import java.util.Scanner;

import SANPHAM.DOCGHIFILE;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NHANVIEN implements DOCGHIFILE {
	private String chucVu, maNhanVien, tenNhanVien, SDT, diaChi;
	private Boolean gioiTinh;
	private long luongCoBan = 4000000;
	private Date ngaySinh, ngayVaoLam;
	Scanner sc = new Scanner(System.in);

	public NHANVIEN() {
	}
	
	public NHANVIEN(String chucVu, String maNhanVien, String tenNhanVien, String sDT, String diaChi, Boolean gioiTinh,
			long luongCoBan, Date ngaySinh, Date ngayVaoLam) {
		this.chucVu = chucVu;
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.SDT = sDT;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.luongCoBan = luongCoBan;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
	}
	
	public NHANVIEN(NHANVIEN nv) {
		this.chucVu = nv.chucVu;
		this.maNhanVien = nv.maNhanVien;
		this.tenNhanVien = nv.tenNhanVien;
		this.SDT = nv.SDT;
		this.diaChi = nv.diaChi;
		this.gioiTinh = nv.gioiTinh;
		this.luongCoBan = nv.luongCoBan;
		this.ngaySinh = nv.ngaySinh;
		this.ngayVaoLam = nv.ngayVaoLam;
	}
	
	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public long getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(long luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	public abstract long tinhLuong();
	
	public void input() {
        do {
            System.out.println("Nhap ma nhan vien: ");
            setMaNhanVien(sc.nextLine());
        } while (getMaNhanVien() == null || getMaNhanVien().isEmpty());

        do {
            System.out.println("Nhap ten nhan vien: ");
            setTenNhanVien(sc.nextLine());
        } while (getTenNhanVien() == null || getTenNhanVien().isEmpty());

        do {
            System.out.println("Nhap so dien thoai: ");
            setSDT(sc.nextLine());
        } while (getSDT() == null || !getSDT().matches("\\d{10}"));

        System.out.println("Nhap dia chi: ");
        setDiaChi(sc.nextLine());

        System.out.println("Nhap gioi tinh (true/false): ");
        setGioiTinh(sc.nextBoolean());

        do {
            System.out.println("Nhap ngay sinh (dd-MM-yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                setNgaySinh(dateFormat.parse(sc.next()));
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le!");
            }
        } while (getNgaySinh() == null || getNgaySinh().after(new Date()));

        do {
            System.out.println("Nhap ngay vao lam (dd-MM-yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                setNgayVaoLam(dateFormat.parse(sc.next()));
            } catch (Exception e) {
                System.out.println("Ngay vao lam khong hop le!");
            }
        } while (getNgayVaoLam() == null || getNgayVaoLam().after(new Date()));
        
        System.out.println("Chon chuc vu: ");
		System.out.println("  1. Quan ly");
		System.out.println("  2. Ban hang");
		System.out.println("  3. Thu ngan");
		System.out.println("Moi ban chon: ");
		boolean r = false;
		while (!r) {
			int luaChon = sc.nextInt();
			switch (luaChon) {
			case 1: {
				setChucVu("Quan ly");
				System.out.println("Quan ly");
				r = true;
				break;
			}
			case 2: {
				setChucVu("Ban hang");
				System.out.println("Ban hang");
				r = true;
				break;
			}
			case 3: {
				setChucVu("Thu ngan");
				System.out.println("Thu ngan");
				r = true;
				break;
			}
			default:
				System.out.println("Lua chon khong dung yeu cau ! Vui long chon lai");
			}
		}
    }		
	
	public void output() {
        System.out.println("Thong tin nhan vien:");
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ten nhan vien: " + tenNhanVien);
        System.out.println("So dien thoai: " + SDT);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Gioi tinh: " + (gioiTinh ? "Nam" : "Nu"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Ngay sinh: " + dateFormat.format(getNgaySinh()));
        System.out.println("Ngay vao lam: " + dateFormat.format(getNgayVaoLam()));
        System.out.println("Chuc vu: " + (chucVu != null ? chucVu : "Chua xac dinh"));
    }
}
