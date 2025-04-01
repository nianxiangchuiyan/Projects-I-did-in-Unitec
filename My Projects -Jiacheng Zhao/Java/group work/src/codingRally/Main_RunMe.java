package codingRally;
//This part is done by Jiacheng
import java.util.*;
public class Main_RunMe {
	Part1 discountCalculate = new Part1();
	Part2 printShowScheduleIce = new Part2();
	Part3 printRecepits = new Part3();
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Which month is today?(e.g. January,October)");
		String month = input.nextLine().toUpperCase();
		System.out.print("Which day is today?(e.g. Sunday,monday)");
		String day = input.nextLine().toLowerCase();
		float discount = Part1.getDiscount(month);
		// get discount
		int adult;
		int children;
		do {
		System.out.print("How many adult?");
		adult = input.nextInt();
		System.out.print("How many children?");
		children = input.nextInt();
		if ((adult <0 ||children<0)||(adult == 0 && children==0)) 
			System.out.print("invaild input! Try again!");
		// get number of adult or children
		}while ((adult <0 ||children<0)||(adult == 0 && children==0)) ;
		int temp2 = children;
		int ice = 0;
		boolean icecream;
		for (	int temp = 1;temp <= temp2;temp++) {
			System.out.print("what's child "+ temp +"'s age?");
			int age = input.nextInt();
			if (age >= 18) {
				adult++;
				children--;
				System.out.println("Too old for a child ticket, you need another adult ticket\n"
						+ "Currently,you need to buy "+adult+" adult tickets and "+children+" children tickets.(numbers are not confirmed yet, the numbers still may change. )");
			}
			else {
				icecream = Part2.isFreeIce(day, age);
				if (icecream) 
					ice++;
			}	
			
		}
		float total = Part1.calculatePrice(children, adult ,month);
		if (discount!=0)
		System.out.print("You have "+discount+"% discount and you will be charged for "+total +"NZD.\n");
		else
			System.out.print("You will be charged for "+total +"NZD.\n");
		//Do payment method here:{}
		boolean paid;
		boolean checker = false;
		do {
		System.out.print("Paid sucessfully?(true/false)");
		paid = input.nextBoolean();
		if (paid) {
			System.out.println("Payment Approved!");
			checker = true;}
		else {
			System.out.print("Payment Declined. Do you wish to try again?(true/false)");
			boolean again = input.nextBoolean();
			if (again)
				checker = false;
			else if (!again)
				checker = true;
			
		}
			
		}while (!checker);
		if (paid) {
			if (ice>0)
				System.out.print("Congralations,for your kids below 13 years old, they will get a free icecream, you can take "+ ice +" icecream for free!\n");
		System.out.print("Do you want a receipt?(true/false)");
		boolean isreceipt = input.nextBoolean();
		if (isreceipt)
			Part3.printreceipt(adult, children, discount,total , ice, month);
		int checkshow;
		boolean checkshowboo = false;
		
		do {
			System.out.print("Do you wish to check time for any shows?\n"
				+ "1 for	Bird show\n"
				+ "2 for	Splash Safari\n"
				+ "3 for	Animal Friends Show\n"
				+ "4 for 	Lion Feeding\n"
				+ "5 for	Zoo Theatre\n"
				+ "Any other number to exit.");
		checkshow = input.nextInt();
		if ((checkshow == 1)||(checkshow == 2)||(checkshow == 3)||(checkshow == 4)||(checkshow == 5)) {
		checkshowboo = true;
		Part2.printShowSchedule(checkshow);
		}
		else
			checkshowboo = false;
		}while (checkshowboo);}
	System.out.print("Have a nice day.");
	}
	
}
