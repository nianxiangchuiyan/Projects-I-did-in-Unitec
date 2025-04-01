
public class Scientific {
		public String substance(float weight, float volume) {
			float density = weight*100  / volume;
			int in = Math.round(density);
			switch (in){
			case 270:
				return "Aluminum";
			case 894:
				return "Copper";
			case 1930:
				return "Gold";
			case 786:
				return "Iron";
			case 1134:
				return "Lead";
			case 174:
				return "Magnesium";
			case 1050:
				return "Silver";
			case 575:
				return "Tin";
			case 714:
				return "Zinc";
			default:
				System.out.print("Can not identify");
				return "Out of database";
			
						}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Explore Explore  = new Explore();
		Explore.Explore("TR-2");
		Explore.outputDetails();
		Explore.moveright(50);
		Explore.moveleft(25);
		Explore.BatteryAndPositiion();
		Explore.charge();
		Scientific S = new Scientific();
		String SUB = S.substance(21, 2);
		System.out.print(SUB);
	}

}
