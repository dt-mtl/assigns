// -----------------------------------------------------
// Assignment 1
// This particular program creates an appliance item which will then be used and intergrated
// Written by: Daniel Torres 40101143
// -----------------------------------------------------
import java.util.Scanner;
public class Assign1 {
	final String pass="c249"; //password 
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in); 
		//required variables
		int numAppli; // number of appliances the store can hold
		int option;
		int attempts=0;
		
		//welcome message
		welcome();
		System.out.print("How many appliances will your store hold? ");
		numAppli=input.nextInt();
		Appliance[] inventory= new Appliance[numAppli]; //appliance inventory array
		System.out.println();
		
		do {
		
			prompt(); // first prompt
			option=input.nextInt();
			System.out.println();
			switch(option) {
				case 1:
					System.out.println("\noption 1");
					System.out.println();
					break;
				case 2:
					System.out.println("prompt for password\n\ncheck serial number\n\nthen update information of the appliance addressed "
							+"display info prompt and change accordingly.");
					System.out.println();
					break;
				case 3:
					System.out.println("All appliances of this exact same brand");
					System.out.println();
					break;
				case 4:
					System.out.println("Find a cheaper appliance than this price");
					System.out.println();
					break;
				case 5:
					System.out.println("Thank you for using the appliance directory, Have a great day :D");
					System.out.println();
					break;
				default:
					System.out.println("Please enter a valid option between 1-5");
					System.out.println();
			}
			
		}while(attempts<=12 && option!= 5);
		
		
	
	}
	
	//banner display message program
	public static void welcome() {
		System.out.println("************************************************************************************************************"
						 + "\n*                                WELCOME TO THE APPLIANCE DIRECTORY                                        *" 
				         + "\n************************************************************************************************************");
	}
	//options prompt
	public static void prompt() {
		System.out.print("What do you want to do?\r\n" + 
				"\t1. Enter new appliances (password required)\r\n" + 
				"\t2. Change information of an appliance (password required)\r\n" + 
				"\t3. Display all appliances by a specific brand\r\n" + 
				"\t4. Display all appliances under a certain a price.\r\n" + 
				"\t5. Quit\r\n" + 
				"Please enter your choice > ");
	}
	//information menu
	public static void appliInfo() {
		System.out.print("What information would you like to change?\r\n" + 
				"\t1. brand\r\n" + 
				"\t2. type\r\n" + 
				"\t3. price\r\n" + 
				"\t4. Quit\r\n" + 
				"Enter your choice > ");
	}
	//password validity check
	public boolean passCheck(String word ) {
		if (word.equals(pass))
			return true;
		else
			return false;
	}
}
