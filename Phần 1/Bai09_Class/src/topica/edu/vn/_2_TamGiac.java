package topica.edu.vn;

// Mọi lớp sinh ra mặc định kế thừa từ lớp Object
public class _2_TamGiac {
	private int canhA;
	private int canhB;
	private int canhC;
	public int getCanhA() {
		return canhA;
	}
	public void setCanhA(int canhA) {
		this.canhA = canhA;
	}
	public int getCanhB() {
		return canhB;
	}
	public void setCanhB(int canhB) {
		this.canhB = canhB;
	}
	public int getCanhC() {
		return canhC;
	}
	public void setCanhC(int canhC) {
		this.canhC = canhC;
	}
	// Source -> Generate Constructor using Fields : Tạo Constructor
	public _2_TamGiac(int canhA, int canhB, int canhC) {
		super(); // Constructor của lớp cha
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}
	public _2_TamGiac() {
		super();
	}
	public String toString() {
		String s = "TamGiac [canhA=" + canhA + ", canhB=" + canhB + ", canhC="
				+ canhC + "]";
		
		if(kiemTraHopLe()==false){
			return s + "=> Tam giác không đúng";
		}
		else{
			return s + "\nChu vi = "+chuVi()+" ;Diện tích = "+dienTich();
		}
	}
	
	private boolean kiemTraHopLe(){ // support method
		boolean kt=this.canhA>0&&this.canhB>0&&this.canhC>0&&
				(this.canhA+this.canhB)>this.canhC &&
				(this.canhA+this.canhC)>this.canhB &&
				(this.canhB+this.canhC)>this.canhA;
				return kt;
	}
	public double chuVi(){ // service method
		return this.canhA+this.canhB+this.canhC;
	}
	public double dienTich(){
		double p=chuVi()/2;
		double dt=Math.sqrt(p*(p-this.canhA)*(p-this.canhB)*(p-this.canhC));
		return dt;
	}
}
