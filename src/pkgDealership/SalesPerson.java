package pkgDealership;

public class SalesPerson {
	//Salesman info: Name, ID, commission earned
		private String name;
		private int salesID;
		private float commision;
		
		//Default contrusctor values.
		public SalesPerson() {
			this.name = "";
			this.salesID = 0;
			this.commision = 0;
		}
		
		
		public SalesPerson(String name, int salesID, float commision) {
			super();
			this.name = name;
			this.salesID = salesID;
			this.commision = commision;
		}


		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSalesID() {
			return salesID;
		}
		public void setSalesID(int salesID) {
			this.salesID = salesID;
		}
		public float getCommision() {
			return commision;
		}
		public void setCommision(float commision) {
			this.commision = commision;
		}
}
