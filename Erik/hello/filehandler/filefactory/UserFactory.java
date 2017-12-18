package filehandler.filefactory;

import filehandler.FileHandler;
import model.admin.Administrator;
import model.admin.Credential;
import model.admin.Employee;
import model.admin.Manager;
import model.admin.User;
import model.admin.User.Role;
import model.register.Category;
import model.register.Product;

/**
 * @author mb
 * <p>
 * The UserFactory class has a goal of hiding away the the creation of product objects.
 * This so we can easily create User objects, with the help of the FileHandler class to get the necessary information.
 * </p>
 */
public class UserFactory implements FileFactory{
	
	private Credential userName = null;
	private String firstName = null;
	private String lastName = null;
	private String userType = null;
	private String workHours = null;
	
	/**
	 * <p>
	 * This method is used to create a User object, information required to pass in, to create a User is the index, which corresponds to a line in the users.txt file.
	 * </p>
	 * @param index Takes in an integer which represents a line of a text file.
	 * @return When called returns a Product object.
	 */
	@Override
	public User createUser(int index/*String userType, String firstName, String lastName, Credential cred*/) {
	
		FileHandler fh = new FileHandler("users.txt");

		fh.arrayChop(fh.fileArray(), 0);
		
//		for(int i = 0; i < fh.getFileLines(); i++) {
			String[] s = fh.arrayChop(fh.fileArray(), index);
			this.userName = new Credential(Integer.parseInt(s[0]));
			this.firstName = s[1];
			this.lastName = s[2];
			this.userType = s[3];
			this.workHours = s[4];
//		}
		
		if(userType == null) {
			return null;
		}
		if(userType.equalsIgnoreCase("ADMIN")) {
			return new Administrator(firstName, lastName, userName, Role.ADMIN, Double.parseDouble(workHours));
		}
		else if(userType.equalsIgnoreCase("MANAGER")) {
			return new Manager(firstName, lastName, userName, Role.MANAGER, Double.parseDouble(workHours));
		}
		else if(userType.equalsIgnoreCase("EMPLOYEE")) {
			return new Employee(firstName, lastName, userName, Role.EMPLOYEE, Double.parseDouble(workHours));
		}
		return null;
	}
	/*
	@Override
	public String[] fileArray() {
		FileHandler uh = new FileHandler();
		String userFile = uh.read("users.txt");
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		
		return lines;
	}
	
	@Override
	public String[] arrayChop(String[] lines, int index) {
		
		String[] test = new String[4];
		
		test = lines[index].split("\\s+");
		
		userName = null;
		firstName = null;
		lastName = null;
		userType = null;
		
		for(int j = 0; j < test.length; j++) {

			if(j == 0) {
				userName = new Credential(Integer.parseInt(test[j]));
			}else if(j == 1) {
				firstName = test[j];
			}else if(j == 2) {
				lastName = test[j];
			}else if(j == 3) {
				userType = test[j];
			}
		}
		return test;
	}
*/
	@Override
	public Product createProduct(int index) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public int getLinesSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	*/
	@Override
	public Category createCategory(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
