package codingRally;
// This part is done by Don
public class Part1 {

    public static float getDiscount(String month) {
    	float discount = 0;    // state the variable to 0

        switch (month.toLowerCase()) {     //switch statement with no case sensitive
            case "january":
            case "march":
            case "may":
            case "july":
            case "august":
            case "october":
            case "december":
                discount = 10;     // month with 31days
                break;
            case "february":
                discount = 15;
                break;
            default:
                System.out.print("");   // other months with no discount
        }

        return discount;   // finish the switch statement
    }
    public static float calculatePrice(int ct, int at, String month) {  //variable= calculatePrice
        float ctp = 18;   //child ticket price
        float atp = 25;   // adult ticket price
        float totalChildPrice = ct * ctp;
        float totalAdultPrice = at * atp;

        float discount = getDiscount(month);
        float totalPrice = totalChildPrice + totalAdultPrice;
        
        if (discount > 0) {
            totalPrice *= (1 - discount / 100); // Apply and calculate discount
        }

        return totalPrice;
    }
}

