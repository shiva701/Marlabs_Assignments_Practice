class parentA{
	parentA(){
		
	}
	static void details() {
		System.out.println("parent class");
	}
}

public class TestPolymorphism extends parentA{

	static void details() {
		System.out.println("child class");
	}
	static void downcasting(parentA a) {
			TestPolymorphism t = (TestPolymorphism)a;
			System.out.println("downcasted: "+ t);
	}
	public static void main(String[] args) {
		parentA a = new parentA();
		parentA t = new TestPolymorphism();
		downcasting(t);
	}

}
