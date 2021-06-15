package pkgDealership;

public class Vehicle {
	//Vehicle Info: Color, Model, Make, Year, Price mileage, hybrid, vinNum(Car ID)
		private String color;
		private String model;
		private String make;
		private int year;
		private float price;
		private float mileage;
		private Boolean hybrid;
		private int vinNum;
		
		public Vehicle() {
			this.color = "";
			this.model = "";
			this.make = "";
			this.year = 0;
			this.price = 0.0f;
			this.mileage = 0.0f;
			this.hybrid = false;
			this.vinNum = 0;
		}
		
		
		public Vehicle(String color, String model, String make, int year, float price, float mileage, boolean hybrid,
				int vinNum) {
			super();
			this.color = color;
			this.model = model;
			this.make = make;
			this.year = year;
			this.price = price;
			this.mileage = mileage;
			this.hybrid = hybrid;
			this.vinNum = vinNum;
		}


		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getMileage() {
			return mileage;
		}
		public void setMileage(float mileage) {
			this.mileage = mileage;
		}
		public Boolean getHybrid() {
			return hybrid;
		}
		public void setHybrid(Boolean hybrid) {
			this.hybrid = hybrid;
		}
		public int getVinNum() {
			return vinNum;
		}
		public void setVinNum(int vinNum) {
			this.vinNum = vinNum;
		}
	
}
