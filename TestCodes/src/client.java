
public class client extends testAbstract {
	
	public client(int r, String n) {
		super(r, n);
		System.out.println("client class constructor");
	}

	public static void main(String[] args) {
		client c = new client(49, "Shiva");
		c.getName();
		c.defaultDisplay();
	}

	@Override
	void display(int rollNo, String name) {
		System.out.println("Roll Number: " + rollNo + " Name: " + name);
	}
	
	//not mandatory to override
//	@Override
//	public void defaultDisplay() {
//		System.out.println("Child Class: \nRoll Number: " + rollNo + " Name: " + name);
//	}

}
