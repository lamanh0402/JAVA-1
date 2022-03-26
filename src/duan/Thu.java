package duan;
import java.io.Serializable;
public class Thu implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sophieu;
    private String hocvien,nhanvien,dichvu,trangthaithu,ngaythu,diachi;
    private double sotien,thutruoc;
	
    public Thu() {
		
	}
    public Thu(int  sophieu, String hocvien, String nhanvien,String dichvu,String ngaythu, double sotien,double thutruoc,String trangthaithu,String diachi){
		this.sophieu= sophieu;
		this.hocvien=hocvien;
		this.nhanvien=nhanvien;
		this.dichvu=dichvu;
		this.ngaythu=ngaythu;
		this.sotien=sotien;
		this.thutruoc=thutruoc;
		this.trangthaithu=trangthaithu;
		this.diachi=diachi;

	}
	public Thu(String hocvien, String nhanvien,String dichvu,String ngaythu, double sotien,double thutruoc,String trangthaithu,String diachi){
		this.hocvien=hocvien;
		this.nhanvien=nhanvien;
		this.dichvu=dichvu;
		this.ngaythu=ngaythu;
		this.sotien=sotien;
		this.thutruoc=thutruoc;
		this.trangthaithu=trangthaithu;
		this.diachi=diachi;
	}
	
    
    
	
	public int getsophieu() {
		return sophieu;
	}
	public void setsophieu(int sophieu) {
		this.sophieu=sophieu;
	}


	public String gethocvien() {
		return hocvien;
	}
	public void sethocvien(String hocvien) {
		this.hocvien = hocvien;
	}
	public String getnhanvien() {
		return nhanvien;
	}
	public void setnhanvien(String nhanvien) {
		this.nhanvien = nhanvien;
	}
	public String getdichvu() {
		return dichvu;
	}
	public void setdichvu(String dichvu) {
		this.dichvu = dichvu;
	}
	
	public String getngaythu() {
		return ngaythu;
	}
	public void setngaythu(String ngaythu) {
		this.ngaythu = ngaythu;
	}
	public double getsotien() {
			return sotien;
	}
	public void setsotien(double sotien) {
		this.sotien = sotien;
	}
	public double getthutruoc() {
		return thutruoc;
	}
	public void setthutruoc(double thutruoc) {
		this.thutruoc = thutruoc;
	}
	public String gettrangthaithu() {
		return trangthaithu;
	}
	public void settrangthaithu(String trangthaithu) {
		this.trangthaithu = trangthaithu;
	
	}
	public String getdiachi() {
		return diachi;
	}
	public void setdiachi(String diachi) {
		this.diachi = diachi;
	
	}
	
		
	
	
}

	

