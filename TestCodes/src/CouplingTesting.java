
// parent or base class  
class A {

	protected int x=5, y=10;
// a parameterized constructor  
	A(int x, int y){
		System.out.println("A called");
		System.out.println("this values: " + this.x +" "+ this.y);
		System.out.println("local values: " + x + " "+y);
		this.x = x;
		this.y = y;
	}
	
	public static A setA(int x, int y) {
		return new A(x,y);
	}

	void foo() {
		System.out.println("Inside the foo method of base class.");
	}
}

// child or derived class  
class B extends A {
	//constructor is required as defined in the parent class.
	int sum;
	
	public B(int x, int y, int z){
		super(x,y);
		System.out.println("B with param called");
//		super(x,y);
		sum = x+y+z;
	}
	public void foo() {
		System.out.println("Inside the foo method of derived class.");
	}
}

public class CouplingTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = A.setA(1,2);
		A a1 = a;
		System.out.println(a.x);
		a1.x = 10;
		System.out.println(a.x);
//		B b = new B(1,2,3);
//		System.out.println(b.sum);
//		System.out.println(b.x);
	}

}
