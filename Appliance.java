
import java.util.Scanner;
// -----------------------------------------------------
// Assignment 1
// This particular program creates an appliance item which will then be used and intergrated
// Written by: Daniel Torres 40101143
// -----------------------------------------------------
public class Appliance {

	//object attributes

	private String type;
	private String brand;
	private static int numAppliances=0;
	private long serialNum=1000000;
	//private static long serialNum=1000000+(long)numAppliances;
	private double price;
	private final String[] types= {"Microwave","Fridge","Washer","Dryer","Freezer","Stove",
			"Dishwasher","Water Heaters","Air Conditioner"};

	//serial number counter
	{
		//serialNum++;
		numAppliances +=1;
	}


	//constructors

	//default
	Appliance(){
		this.type=types[0];
		this.brand="Samsung";
		this.price=1.00;
		serialNum+=(long)numAppliances;
	}
	//copy Constructor
	Appliance(Appliance copy){
		serialNum+=(long) numAppliances;
		this.type=copy.getType();
		this.brand=copy.getBrand();
		this.price=copy.getPrice();
	}

	//accessors
	public String getType() {
		return this.type;
	}
	public String getBrand() {
		return this.brand;
	}
	public long getSerial() {
		return serialNum;
	}
	public double getPrice() {
		return this.price;
	}

	//mutators
	public void setType(String given) {
		int c=0;
		boolean isit=false;

		Scanner input=new Scanner(System.in);

		//check the type is correct
		do{

			for (int w = 0; w < types.length; w++) {
				if (given.equals(types[w])) {
					System.out.println(types[w]);
					isit = true;
				}
			}

			if(!isit) {
				System.out.print("Give an appropriate Appliance type otherwise type q to leave the default Appliance type ");
				given=input.nextLine();
				c++;
				System.out.println(c);

			}
		}while(!isit && !given.equals("q"));

		this.type=given;

	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setPrice(double price) {
		this.price=price;
	}

	//methods

	//method that tells how many appliances have been created
	public static int findNumberOfCreatedAppliances(){
		return numAppliances;
	}

	//method that overrides the to string method
	public String toString() {
		String info;
		info="\n\tAppliance Serial #: "+getSerial()+"\n\tBrand: "+getBrand()+"\n\tType: "+getType()+"\n\tPrice: "+getPrice();
		return info;
	}
	//method that overrides the equals method and checks for equality
	public boolean equals(Appliance other){
		if(other.getBrand().equals(this.brand) && other.getPrice()==this.price && other.getType().equals(this.type))
			return true;
		else
			return false;
	}

	//Find appliances by serial number
	public static void findApplianceBy(){

	}
	// find cheaper than the other appliances
	public static void findCheaperThan(double expensive){

	}

}
