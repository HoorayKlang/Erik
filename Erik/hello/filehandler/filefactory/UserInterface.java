package filehandler.filefactory;

import model.admin.Credential;
import model.admin.User.Role;

public interface UserInterface {
	
	public Credential getCredentials();
	public String getFirstName();
	public String getLastName();
	public double getWorkHours();
	public Role getRole();
	
}
