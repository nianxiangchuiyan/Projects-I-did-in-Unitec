
public class Explore {
	private String name;
	private int batteryLife = 100 ;
	private float xPos = 0;
	private float yPos = 0;
	Explore(){
		this.name = name;
	}
	public String Explore(String aName) {
		this.name = aName;
		return name;
	}
	public void  moveleft( float distance) {
		if (batteryLife < distance)
			System.out.println("Insufficient battery life."+"Current battery life "+batteryLife+"%");
		else {
		xPos -= distance;
		batteryLife -= distance;}
	}
	public void  moveright( float distance) {
		if (batteryLife < distance)
			System.out.println("Insufficient battery life."+"Current battery life "+batteryLife+"%");
		else {
		xPos += distance; 
		batteryLife -= distance;}
	}
	public void  charge() {
		while(batteryLife<100){
			System.out.println("Charging battery... "+batteryLife+"%");
			batteryLife++;	
			
		} 
		System.out.println("Battery life "+batteryLife+"%");
	}
	public String getName() {
		return name;
	}
	public float getXPos() {
		return xPos;
		}
	public float getYPos() {
		return yPos;
		}
	public int getBatteryLife() {
		return batteryLife;
	}
	public  void outputDetails() {
		System.out.print("Name: "+name
				+ "\nBattery life: "+batteryLife
				+ "\nx Position: "+xPos
				+ "\ny Position: "+yPos+"\n");
	}
	public  void BatteryAndPositiion() {
		System.out.print("Battery life: "+batteryLife
				+ "\nx Position: "+xPos
				+ "\ny Position: "+yPos+"\n");
	}
	class scientific{
		public String Scienific(String aName) {
			name = aName;
			return name;
		}
	public String  checkSubstance(float Volume, float Weight) {
		return "";
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Explore Explore  = new Explore();
		Explore.Explore("TR-1");
		Explore.outputDetails();
		Explore.moveright(40);
		Explore.moveleft(60);
		Explore.moveright(5);
		Explore.charge();
	}	

}
