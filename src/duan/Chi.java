package duan;
import java.io.Serializable;
public class Chi implements Serializable {
	private static final long serialVersionUID =	1L;
    private  int sophieuchi;
    private String giangvien,nhanvienchi,dichvuchi,ngaychi;
    private double sotienchi;
    
    public Chi() {
    }
    public Chi(int sophieuchi,String giangvien,String nhanvienchi,String dichvuchi,String ngaychi,double sotienchi) {
    	this.sophieuchi=sophieuchi;
    	this.giangvien=giangvien;
    	this.nhanvienchi=nhanvienchi;
    	this.dichvuchi=dichvuchi;
    	this.ngaychi=ngaychi;
    	this.setsotienchi(sotienchi);
    	}
    public Chi(String giangvien,String nhanvienchi,String dichvuchi,String ngaychi,double sotienchi) {
    	this.giangvien=giangvien;
    	this.nhanvienchi=nhanvienchi;
    	this.dichvuchi=dichvuchi;
    	this.ngaychi=ngaychi;
    	this.setsotienchi(sotienchi);
    }
   
    public int getsophieuchi() {
		return sophieuchi;
	}
    public void setsophieuchi(int sophieuchi) {
    	this.sophieuchi= sophieuchi;
    }
    
    public String getgiangvien() {
		return giangvien;
	}
	public void setgiangvien(String giangvien) {
		this.giangvien = giangvien;
	}
	public String getnhanvienchi() {
		return nhanvienchi;
	}
	public void setnhanvienchi(String nhanvienchi) {
		this.nhanvienchi = nhanvienchi;
	}
	public String getdichvuchi() {
		return dichvuchi;
	}
	public void setdichvuchi(String dichvuchi) {
		this.dichvuchi = dichvuchi;
	}
	public String getngaychi() {
		return ngaychi;
	}
	public void setngaychi(String ngaychi) {
		this.ngaychi = ngaychi;
	}

	public double getsotienchi() {
		return sotienchi;
	}
	public void setsotienchi(double sotienchi) {
		this.sotienchi = sotienchi;
	}
	
    
	

    
}
