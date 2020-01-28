// -----------------------------------------------------
// Assignment 1
// This particular program creates an appliance item which will then be used and intergrated
// Written by: Daniel Torres 40101143
// -----------------------------------------------------
import java.util.Scanner;
public class Assign1 {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		
		Appliance holla= new Appliance();
		welcome();
	}
	
	//banner display message program
	public static void welcome() {
		System.out.println("************************************************************************************************************"
						 + "\n*                                WELCOME TO THE APPLIANCE DIRECTORY                                        *" 
				         + "\n************************************************************************************************************");
	}
}
