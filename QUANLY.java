package DOANOOP;

import java.util.Scanner;
import java.util.Date;

public class QUANLY extends NHANVIEN {
    private int ngayCong;
    private float heSoThuong = 0.08f;
    
	public QUANLY() {
		super();
	}

	public QUANLY(NHANVIEN nv) {
		super(nv);
	}

	public QUANLY(String chucVu, String maNhanVien, String tenNhanVien, String sDT, String diaChi, Boolean gioiTinh,
			long luongCoBan, Date ngaySinh, Date ngayVaoLam, int ngayCong, float heSoThuong) {
		super(chucVu, maNhanVien, tenNhanVien, sDT, diaChi, gioiTinh, luongCoBan, ngaySinh, ngayVaoLam);
		this.ngayCong = ngayCong;
		this.heSoThuong = heSoThuong;
	}

	public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
    		this.ngayCong = ngayCong;
    }

    public float getHeSoThuong() {
        return heSoThuong;
    }

    public void setHeSoThuong(float heSoThuong) {
        this.heSoThuong = heSoThuong;
    }
    
    @Override
    public long tinhLuong() {
        long luong = getLuongCoBan() + (long) (ngayCong * getLuongCoBan() * heSoThuong);
        return luong;
    }


    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so ngay cong: ");
        ngayCong = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        super.output();
        if (getChucVu().equalsIgnoreCase("Quan ly")) {
            System.out.println("So ngay cong: " + getNgayCong());
            System.out.println("Luong thang: " + tinhLuong());
        }
    }
}
