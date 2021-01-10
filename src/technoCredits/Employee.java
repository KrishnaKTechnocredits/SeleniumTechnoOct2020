package technoCredits;

public class Employee implements Cloneable{
	int id;
	String name;
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee(1,"Raghav");
		Employee e2 = (Employee)e1.clone();
		
		System.out.println(e2.id + ":" + e2.name);
		System.out.println(e1);
		System.out.println(e2);
	}
}
