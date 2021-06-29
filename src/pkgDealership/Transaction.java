package pkgDealership;

public class Transaction {
	private int vin;
	private int salesid;
	private int custid;
	private float totalprice;
	private String salesdate;
	
	public Transaction() {
		this.vin = 0;
		this.salesid = 0;
		this.custid = 0;
		this.totalprice = 0.0f;
		this.salesdate = "";
	}
	
	public Transaction(int vin, int salesid, int custid, float totalprice, String salesdate) {
		super();
		this.vin = vin;
		this.salesid = salesid;
		this.custid = custid;
		this.totalprice = totalprice;
		this.salesdate = salesdate;
	}
	
	public int getVin() {
		return vin;
	}
	
	public void setVin(int vin) {
		this.vin = vin;
	}
	
	public int getSalesid() {
		return salesid;
	}
	
	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}
	
	public int getCustid() {
		return custid;
	}
	
	public void setCustid(int custid) {
		this.custid = custid;
	}
	
	public float getTotalprice() {
		return totalprice;
	}
	
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	
	public String getSalesdate() {
		return salesdate;
	}
	
	public void setSalesdate(String salesdate) {
		this.salesdate = salesdate;
	}
	
}
