package erik;

public class Adventurer extends User {

	private Scanner scan;

	private String[] choice;

	public Adventurer(int age, String name, Scanner scan) {
		this.name = name;
		this.age = age;
		this.scan = scan;
		this.choice = new String[4];
	}

public void choice(String data){

		choice[1] = data;
}

public void printFile(){

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
