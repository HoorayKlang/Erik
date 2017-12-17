package filehandler.filefactory;

import model.admin.User;
import model.register.Category;
import model.register.Product;


/**
 * @author mb
 * <p>
 * This interface defines the function used the implementing classes
 * Classes of similar behaviour, with the intent to create objects of different types.
 * </p>
 */
public interface FileFactory {
	
	public User createUser(int index);
	public Product createProduct(int index);
	public Category createCategory (int index);
	
}
