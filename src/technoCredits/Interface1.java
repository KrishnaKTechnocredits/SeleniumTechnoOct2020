package technoCredits;

public interface Interface1 {
	void m1();
	default void m2() {
		
	}
	
	static void m3() {
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("HI");
		m3();
	}
}
