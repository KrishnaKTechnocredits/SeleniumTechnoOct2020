package technoCredits;

public class Test1{
	interface A{
		void m1();
	}
	
	static class Test2 implements A{
		@Override
		public void m1() {
			System.out.println("M1 method");
		}
	}
	
	void m1(String msg) {
		System.out.println(msg);
	}
	
	void m1(int x) {
		System.out.println(x);
	}
}
