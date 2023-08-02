public class Leetcode {
	int val;
	public static void testPassbyValue(int o1) {
		o1=99;
	}
	
	public static void testPassbyValueArray(int[] o1) {
		o1[0] = 99001;
	}
	public static void main(String[] args) {
		short a = 20;
		a = (short)(a*20l);
		System.out.println(Integer.MAX_VALUE+1);
		int b = 016;
		System.out.println(b);
		Leetcode o = new Leetcode();
		o.val = 15410;
		System.out.println("check pass by value before passing: " + o.val);
		testPassbyValue(o.val);
		System.out.println("check pass by value: " + o.val);
		
		//checking for the array
		int a1[] = {1,2,3,4};
		testPassbyValueArray(a1);
		System.out.println("checking pass by value for araay:");
		for(int x: a1) {
			System.out.println(x);
		}
		
		String str1 = "Interviewbit".replace('e','s');
		System.out.println("thr string is: " + str1);
		
	}
}
