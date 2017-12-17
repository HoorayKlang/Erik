package filehandler.filefactory;

import filehandler.FileHandler;
import model.admin.User;
import model.register.Category;
import model.register.Product;


/**
 * @author mb
 * <p>
 * The ProductFactory class has a goal of hiding away the the creation of product objects.
 * This so we can easily create Product objects, with the help of the FileHandler class to get the necessary information.
 * </p>
 */
public class CategoryFactory implements FileFactory {
	
	//Fields to save data from text file in
	   private double Moms;
	   private String Name;
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
	public Category createCategory(int index/*String Category, double Moms*/) {
	
		FileHandler fh = new FileHandler("Category.txt");

		fh.arrayChop(fh.fileArray(), 0);
		
//		for(int i = 0; i < fh.getFileLines(); i++) {
			String[] s = fh.arrayChop(fh.fileArray(), index);
			this.Name = s[0];
			this.Moms = Double.parseDouble(s[1]);
//		}
	
	
		return new Category(Name, Moms);
	
	}
	
	@Override
	public User createUser(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
