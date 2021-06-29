package pkgDealership;

public class Customer {
	//Customer info: Name
		private String custName;
		private int custid;
		
		public Customer() {
			this.custName = "";
			this.setCustid(0);
		}
		
		

		public Customer(int custid, String custName) {
			super();
			this.custName = custName;
			this.setCustid(custid);
		}



		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}



		public int getCustid() {
			return custid;
		}



		public void setCustid(int custid) {
			this.custid = custid;
		}
}
