public class TestFinal {
	final int id;
	static final String schoolId;
	
	public TestFinal(int inputId) {
		id = inputId; //final field can only be assigned inside the constructor.
//		schoolId = "GMU";static fields can only be assigned in the static block.
	}
	
	/*
	 * static fields can only be assigned in the static block.
	 */
	static {
		schoolId = "GMU";
	}
	
	void changeFinalField() {
//		this.id = 10; we cannot do this, since the field is final which cannot be modified.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
