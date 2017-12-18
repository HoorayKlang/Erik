package erik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import filehandler.FileHandler;

public class runMan {
	
	private boolean running = true;
	private List<Adventurer> playerList = new ArrayList();
	private List<String> sidetrack = new ArrayList();
	public runMan() {

		
		FileHandler fh = new FileHandler("story.txt");
		fh.clearFile();
		
		fh.addLine("Hej erik");
		
		Adventurer player = null;
		
		
		Scanner scanner = new Scanner(System.in);
		int numberOfPlayers = 0;
		String[] data = new String[2];

		System.out.println("Hur många deltagare?");
		numberOfPlayers = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Spelare " + i + " namn: ");
			data[0] = scanner.nextLine();

			System.out.println("Spelare " + i + " ålder: ");
			data[1] = scanner.nextLine();

			player = new Adventurer(Integer.parseInt(data[1]), data[0]);
			fh.addLine("Player 1: " + player.sayName() + " is " + player.sayAge() + "Years old");
			playerList.add(player);
		}
		
		fh.addLine("");
		
		
		int choose = 0 + (int)(Math.random() * (((numberOfPlayers-1) - 0) + 1));
		System.out.println(playerList.get(choose).sayName() + ", are you legally blind? ");
		
		String test = scanner.nextLine();
		if("yes".equals(test)) {
			playerList.get(choose).ding();
			fh.addLine(playerList.get(choose).sayName() + " is now legally blind.");

			fh.addLine(playerList.get(choose).sayName() + " is now " + playerList.get(choose).sayAge() + " years old.");
		}
		System.out.println(playerList.get(choose).sayAge());
		
		fh = new FileHandler("Spelare.txt");		
		for(int i = 0; i < numberOfPlayers; i++) {
			fh.addLine("Spelare"  + i + " : " + playerList.get(i).sayName() + "Age: " + playerList.get(i).age);
		}
		//Babbys first commit
	}
	
	public String printPlayers() {
		String data = null;
		for(int i = 0; i < playerList.size(); i++) {
			data += playerList.get(i).sayAge() + playerList.get(i).sayName();
		}	
		
		return data;
	}

	public static void main(String[] args) {

		runMan r = new runMan();
		
	}
	

}


