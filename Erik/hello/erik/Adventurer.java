package erik;

import filehandler.FileHandler;

public class Adventurer extends User {


	private String[] choice;

	public Adventurer(int age, String name) {
		this.name = name;
		this.age = age;
		this.choice = new String[4];
	}
	
	public void choice(String data, int l){
	
			this.choice[l] = data;
			FileHandler fh = new FileHandler("choices.txt");
			
			fh.addLine("Player " + this.name + " Choice " + l + ": " + data);
			
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
