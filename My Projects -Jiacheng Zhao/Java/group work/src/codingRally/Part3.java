package codingRally;
//This part is done by Jiacheng
public class Part3 {
	public static void printreceipt (int Adult, int Child, float discount, float totalprice, int ice, String month) {
		String A = Adult+"";
		String C = Child+"";
		int AQ = A.length()+" X 25NZD".length();
		int CQ = C.length()+" X 18NZD".length();
		String AT = Adult*25+"";
		String CT = Child*18+"";
		int ATC=AT.length();
		int CTC=CT.length();
		String DC = discount*(Adult*25+Child*18)/100+"";
		int DCT = DC.length();
		String T= totalprice+"";
		int TC =T.length();
		String DIS = discount+"";
		int DISC = DIS.length();
		System.out.print(""
				+ "|"+"*".repeat(50)+"|\n"
				+ "|"+" ".repeat(15)+"Iteam|"+" ".repeat(11)+"Quantity|"+" ".repeat(9)+"|\n"
				+ "|"+"*".repeat(50)+"|\n"
				+ "|Adult"+" ".repeat(15)+"|"+" ".repeat(19-AQ)+Adult+" X 25NZD|"+Adult*25+""+" ".repeat(6-ATC)+"NZD|\n"
				+ "|Child"+" ".repeat(15)+"|"+" ".repeat(19-CQ)+Child+" X 18NZD|"+Child*18+""+" ".repeat(6-CTC)+"NZD|\n"
				+ "|Discount"+" ".repeat(12)+"|"+" ".repeat(18-DISC)+discount+"%|-"+DC+" ".repeat(6-DCT-1)+"NZD|\n"
				+ "|"+"*".repeat(50)+"|\n"
				+ "|"+" ".repeat(50-21)+"Total price|"+totalprice+" ".repeat(6-TC)+"NZD|\n"
				+ "|"+"*".repeat(50)+"|\n"
				+ "Ticket bought in "+month+".\n"
);
		if (ice>0)
			System.out.println("You may get "+ice+" free icecream!");

	}
}