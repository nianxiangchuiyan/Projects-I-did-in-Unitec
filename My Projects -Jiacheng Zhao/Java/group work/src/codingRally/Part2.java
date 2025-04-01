package codingRally;
//This part is done by Jennifer


public class Part2 {
	static void printShowSchedule (int showID) {
		switch (showID)
		{
		case 1: System.out.println("Bird show will start at 12:30 PM"); 
		break;
		case 2: System.out.println("Splash Safari will start at 2:00 PM");
		break;
		case 3: System.out.println("Animal Friends Show	will start at 12:00 PM and 2:30 PM");
		break;
		case 4: System.out.println("Lion Feeding will start at 9:00 AM and 3:00 PM");
		break;
		case 5: System.out.println("Zoo Theatre will start at 9:00 AM, 12:30 PM and 3:00 PM");
		break;
		default: System.out.println("Invalid input");
		}
	}
	static boolean isFreeIce (String day, int age) {
		boolean isfree;
		
		if (day.equals("sunday")&&age<13)
			isfree=true;
		
		else 
			isfree=false;
		return isfree;
				
	}


	}



