package pkgDealership;

public class Customer {
	//Customer info: Name
		private String custName;
		
		public Customer() {
			this.custName = "";
		}
		
		

		public Customer(String custName) {
			super();
			this.custName = custName;
		}



		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}
}
