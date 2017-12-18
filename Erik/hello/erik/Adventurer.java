package erik;

public class Adventurer extends User {

	
	public Adventurer(int age, String name) {
		this.name = name;
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
