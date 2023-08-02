
public abstract class testAbstract {
	int rollNo;
	String name;
	
//	public testAbstract() {
//		System.out.println("default abstract class constructor");
//	}
	public testAbstract(int r, String n) {
		System.out.println("abstract class constructor");
		rollNo = r;
		name = n;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	abstract void display(int rollNo, String name);
	
	public void defaultDisplay() {
		System.out.println("Abstract parent class: Roll Number: " + rollNo + " Name: " + name);
	}
}
