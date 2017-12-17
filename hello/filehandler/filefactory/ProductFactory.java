package filehandler.filefactory;

import filehandler.FileHandler;
import model.admin.User;
import model.register.Category;
import model.register.Product;

//ProductFactory is a class to abstract away the creation of objects. 
//Maybe it should be of prototype pattern instead, idk - it works
/**
 * @author mb
 * <p>
 * The ProductFactory class has a goal of hiding away the the creation of product objects.
 * This so we can easily create Product objects, with the help of the FileHandler class to get the necessary information.
 * </p>
 */
public class ProductFactory implements FileFactory {
	
	//Fields to save data from text file in
	private String ID = null;
	private String productName = null;
	private double price = 0.0;
	private String category = null;
	//Field to count lines in text file
	
	//Return line size is needed if you want to make loop the object creation.
	
	/**
	 * <p>
	 * This method is used to create a Product object, information required to pass in to create a Product is the index, which corresponds to a line in the productsTest.txt file.
	 * </p>
	 * @param index Takes in an integer which represents a line of a text file.
	 * @return When called returns a Product object.
	 */
	@Override //Main object creation method returns a object created in from the text files.
	//Takes an index which corresponds to a line in the textfile
	public Product createProduct(int index/*String userType, String firstName, String lastName, Credential cred*/) {
	
		FileHandler fh = new FileHandler("productsTest.txt");

		fh.arrayChop(fh.fileArray(), 0);
		
//		for(int i = 0; i < fh.getFileLines(); i++) {
			String[] s = fh.arrayChop(fh.fileArray(), index);
			this.ID = s[0];
			this.productName = s[1];
			this.price = Double.parseDouble(s[2]);
			this.category = s[3];
//		}
	
	//Returns an object to the callar, om 
	
		return new Product(ID, productName, price, category);
	
	}
	
	@Override
	public User createUser(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category createCategory(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
