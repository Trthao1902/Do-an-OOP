package DOANOOP;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NHANVIEN {
	private String chucVu, maNhanVien, tenNhanVien, SDT, diaChi;
	private Boolean gioiTinh;
	private long luongCoBan = 4000000;
	private Date ngaySinh, ngayVaoLam;

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
	
	public String getngaySinhFormat() {
		if (ngaySinh == null) {
			return "Ngay sinh khong hop le!";
		}
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(ngaySinh);
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public String getngayVaoLamFormat() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(ngayVaoLam);
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	public abstract long tinhLuong();
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		// Nhập và kiểm tra mã nhân viên
        do {
            System.out.println("Nhap ma nhan vien: ");
            setMaNhanVien(sc.nextLine());
        } while (getMaNhanVien() == null || getMaNhanVien().isEmpty());

        // Nhập và kiểm tra tên nhân viên
        do {
            System.out.println("Nhap ten nhan vien: ");
            setTenNhanVien(sc.nextLine());
        } while (getTenNhanVien() == null || getTenNhanVien().isEmpty());

        // Nhập và kiểm tra số điện thoại
        do {
            System.out.println("Nhap so dien thoai: ");
            setSDT(sc.nextLine());
        } while (getSDT() == null || !getSDT().matches("\\d{10}"));

        // Nhập và kiểm tra địa chỉ
        System.out.println("Nhap dia chi: ");
        setDiaChi(sc.nextLine());

        // Nhập và kiểm tra giới tính
        System.out.println("Nhap gioi tinh (true/false): ");
        setGioiTinh(sc.nextBoolean());

        // Nhập và kiểm tra ngày sinh
        do {
            System.out.println("Nhap ngay sinh (dd-MM-yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                setNgaySinh(dateFormat.parse(sc.next()));
            } catch (Exception e) {
                System.out.println("Ngay sinh khong hop le!");
            }
        } while (getNgaySinh() == null || getNgaySinh().after(new Date()));

        // Nhập và kiểm tra ngày vào làm
        do {
            System.out.println("Nhap ngay vao lam (dd-MM-yyyy): ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                setNgayVaoLam(dateFormat.parse(sc.next()));
            } catch (Exception e) {
                System.out.println("Ngay vao lam khong hop le!");
            }
        } while (getNgayVaoLam() == null || getNgayVaoLam().after(new Date()));
        
        //Nhập và kiểm tra chức vụ
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
        System.out.println("Ma nhan vien: " + getMaNhanVien());
        System.out.println("Ten nhan vien: " + getTenNhanVien());
        System.out.println("So dien thoai: " + getSDT());
        System.out.println("Dia chi: " + getDiaChi());
        System.out.println("Gioi tinh: " + (getGioiTinh() ? "Nam" : "Nu"));
        System.out.println("Luong co ban: " + getLuongCoBan());
        System.out.println("Ngay sinh: " + getngaySinhFormat());
        System.out.println("Ngay vao lam: " + getngayVaoLamFormat());
        System.out.println("Chuc vu: " + (getChucVu() != null ? getChucVu() : "Chua xac dinh"));
    }
	
	public static void main(String[] args) {
        QUANLY ql = new QUANLY();
        ql.input();
        ql.output();
        
        BANHANG bh = new BANHANG();
        bh.input();
        bh.output();
    }
}
	

