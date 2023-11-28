package NHANVIEN;

import java.util.Date;
import java.io.*;

public class THUNGAN extends NHANVIEN{
	private int ngayCong;
	private float heSoThuong = 0.05f;
	
	public THUNGAN() {
		super();
	}
	
	public THUNGAN(NHANVIEN nv) {
		super(nv);
	}
	
	public THUNGAN(String chucVu, String maNhanVien, String tenNhanVien, String sDT, String diaChi, Boolean gioiTinh,
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
        System.out.println("Nhap so ngay cong (25-31): ");
        while (true) {
            try {
                ngayCong = Integer.parseInt(sc.nextLine());
                if (ngayCong >= 25 && ngayCong <= 31) {
                    break;
                } else {
                    System.out.println("So ngay cong khong hop le. Hãy nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen.");
            }
        }
    }

    @Override
    public void output() {
        super.output();
        if (getChucVu().equalsIgnoreCase("Thu ngan")) {
            System.out.println("So ngay cong: " + getNgayCong());
            System.out.println("Luong thang: " + tinhLuong());
        }
    }
    
    @Override
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            // Read data from the file and set values accordingly
            String chucVu = br.readLine();
            String maNhanVien = br.readLine();

            this.setChucVu(chucVu);
            this.setMaNhanVien(maNhanVien);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            // Write data to the file
            bw.write(this.getChucVu());
            bw.newLine();
            bw.write(this.getMaNhanVien());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

