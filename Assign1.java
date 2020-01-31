// -----------------------------------------------------
// Assignment 1
// This particular program creates an appliance item which will then be used and intergrated
// Written by: Daniel Torres 40101143
// -----------------------------------------------------
import java.util.Scanner;
public class Assign1 {
	final static String pass="c249"; //password

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		//required variables
		int maxAppliances; // max number of appliances the store can hold
		int numAppli;
		int option;
		int attempts=0; //Variable that check for 12 consecutive attempts at password entry
		int tries=0; 	//variable that resets after three incorrect tries
		String text;
		double cheap;  //this variable will hold the price value of we would like to find appliances to be cheaper than

		int found=0; // this variable keeps track of all the items found of the same brand
		int s=0;	//this variable will be used to check for items of the same brand

		//welcome message
		welcome();

		System.out.println("Currently there are "+Appliance.findNumberOfCreatedAppliances()+" Appliances");
		System.out.print("How many appliances will your store hold? ");
		maxAppliances=input.nextInt();

		Appliance[] inventory = new Appliance[maxAppliances]; //appliance inventory array
		for(int i =0; i< inventory.length; i++) {     //must create appliances otherwise this will give null error
			inventory[i] = new Appliance();
		}
		System.out.println("You have created "+Appliance.findNumberOfCreatedAppliances() +" Appliances: ");



		do {

			prompt(); // first prompt

			option=input.nextInt();


			switch(option) {
				case 1:
					if(attempts<=12){
						System.out.println("\noption 1");

						while(tries<3){
							System.out.println("Please enter your Password");
							text=input.next();

							if(text.equals(pass)){
								if(Appliance.findNumberOfCreatedAppliances()<1000000){
									System.out.println("how many appliances do you wish to enter? ");
									numAppli=input.nextInt();
									if(numAppli>1000000-Appliance.findNumberOfCreatedAppliances()) {
										System.out.println("There is currently " + (1000000 - Appliance.findNumberOfCreatedAppliances()) + " Appliances that may " +
												"still be added to this inventory, retry this option again");
									}else{
										System.out.println("original length of inventory: "+inventory.length);
										Appliance[] duplicate=new Appliance[maxAppliances];
										for(int r=0;r<inventory.length;r++){
											duplicate[r]=inventory[r];
											System.out.println(duplicate[r]);
										}
										maxAppliances=numAppli+maxAppliances;
										inventory=new Appliance[maxAppliances];
										System.out.println("new length of inventory: "+inventory.length);
										for(int r=0;r<duplicate.length;r++){
											inventory[r]=duplicate[r];
											//System.out.println(inventory[r]);
										}
										for(int r=duplicate.length;r<inventory.length;r++){
											inventory[r] = new Appliance();
										}
										for(int r=0;r<inventory.length;r++){
											System.out.println(inventory[r]);
										}
										break;
									}
								}else{
									System.out.println("The directory is at maximum capacity for appliances");
								}
							}else{
								System.out.println("you have entered the wrong password");
								tries++;
								attempts++;
							}
						}
						tries=0;
					}

					System.out.println();
					break;
				case 2:
					if(attempts>0) // this ensures that attempts is only counted if password is incorrect on option one only, 12 consecutive times
						attempts=0;
					System.out.print("option 2");
					System.out.println("prompt for password\n\ncheck serial number\n\nthen update information of the appliance addressed "
							+"display info prompt and change accordingly.");
					System.out.print("Change the type of your appliance, type the appliance number: ");
					option=input.nextInt();
					input.nextLine();
					System.out.print("\nType the Appliance type you wish to input: ");
					text=input.nextLine();
					input.next();
					System.out.println("why is this?");
					inventory[option].setType(text);

					break;
				case 3:
					if(attempts>0) // this ensures that attempts is only counted if password is incorrect on option one only, 12 consecutive times
						attempts=0;
					found=0;
					System.out.println("Please enter a brand name: ");
					input.nextLine(); //This is a necessity given the way the system reads lines
					String search = input.nextLine(); //this variable will hold the necessary brand for option 3


					System.out.println("Searching for \""+search+"\"" );
					//
					while(!search.equals("q")){
						for(s=0;s<Appliance.findNumberOfCreatedAppliances();s++) {
							if (inventory[s].getBrand().equals(search)) {
								System.out.println(inventory[s]);
								found++;
							}
						}
						if(found != 0) {
							search = "q";
						}else {
							System.out.print("The system found no appliances of this brand either retry the brand type or simply press 'q' to return to main menu: ");
							search = input.nextLine();

						}
					}
					System.out.println();
					break;
				case 4:
					if(attempts>0) // this ensures that attempts is only counted if password is incorrect on option one only, 12 consecutive times
						attempts=0;
					found=0;
					System.out.println("Find a cheaper appliance than this price");
					cheap=input.nextDouble();

					while(cheap!=0.0){
					for(s=0;s<=Appliance.findNumberOfCreatedAppliances();s++) {
						if (inventory[s].getPrice()<cheap) {
							System.out.println(inventory[s]);
							found++;
						}
					}
					if(found != 0) {
						cheap = 0.0;
					}else {
						System.out.print("The system found no appliances cheaper than $"+cheap+" Try a new price or simply type '0.0' to return to main menu: ");
						cheap = input.nextDouble();
						System.out.println();
					}
				}
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

		}while(attempts!=12 && option!= 5);
		if (attempts==12)
			System.out.println("Program detected suspicious activities and will terminate immediately!");
		input.close();

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
	//Find appliances by serial number
	public static void findApplianceBy(String finder){

	}
}
