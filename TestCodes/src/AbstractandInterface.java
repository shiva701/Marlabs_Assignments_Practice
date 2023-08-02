//interface A12 {
//	void a();
//
//	void b();
//
//	default void c() {
//		System.out.println("default C");
//	}
//
////	void d();
//}
//
//abstract class B12 implements A12 {
////	public void c() {
////		System.out.println("I am C");
////	}
//}
//
//class M extends B12 {
//	public void a() {
//		System.out.println("I am a");
//	}
//
//	public void b() {
//		System.out.println("I am b");
//	}
//
////	public void d() {
////		System.out.println("I am d");
////	}
//}
//
//class AbstractandInterface {
//	public static void main(String args[]) {
//		A12 a = new M(); 
//		System.out.println(a.hashCode() + " "+a.toString());
//		a.a();
//		a.b();
//		a.c();
////		a.d();
//	}
//}

class Student18 implements Cloneable {
	int rollno;
	String name;
	//constructor
	Student18(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	//overriding clone method of the Cloneable interface
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String args[]) {
		try {
			Student18 s1 = new Student18(101, "amit");

			Student18 s2 = (Student18) s1.clone();

			System.out.println(s1.rollno + " " + s1.name);
			System.out.println(s2.rollno + " " + s2.name);

		} catch (CloneNotSupportedException c) {
		}
	}
}