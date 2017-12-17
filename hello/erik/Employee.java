package erik;

/**
 * @author Klang
 *
 */
public class Employee extends User {

	private int salary = 0;
	
	public Employee(int age, String name, int salary) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	
	@Override
	public void greet() {
		System.out.println("Hello my name is " + this.name + "!");
	}

	@Override
	public String sayName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getSalary() {
		return salary;
	}


	@Override
	public void ding() {
		this.age += 1;
	}

	@Override
	public int sayAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

}
