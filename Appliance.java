// -----------------------------------------------------
// Assignment 1
// This particular program creates an appliance item which will then be used and intergrated
// Written by: Daniel Torres 40101143
// -----------------------------------------------------
public class Appliance {
	
	//object attributes
	private String type;
	private String brand;
	private static long serialNum=1000000;
	private double price;
	
	
	//serial number counter
	{
		serialNum +=1;
	}
	
	//constructors
	
	//default
	Appliance(){
		this.type="Air Conditioner";
		this.brand="Samsung";
		this.price=1.00;
		
	}
	
	//accessors
	public String getType() {
		return this.type;
	}
	public String getBrand() {
		return this.brand;
	}
	public long getSerial() {
		return this.serialNum;
	}
	public double getPrice() {
		return this.price;
	}
	
	//mutators
	public void setType(String type) {
		this.type=type;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	//methods
	
	public String toString() {
		String info;
		info="Appliance Serial #: "+getSerial()+"\nBrand: "+getBrand()+"\nType: "+getType()+"\nPrice: "+getPrice();
		return info;
	}

}
