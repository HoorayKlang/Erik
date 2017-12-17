package filehandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import filehandler.filefactory.UserFactory;

/**
 * 
 * @author mb
 * <p>
	 *The {@link filehandler.FileHandler Filehandler} class has turned out to be a class of many purposes.
	 *It current responsibility lies in reading and writing to the text file {@link "/resourse/user.txt"}
	 *Its usage is: create an Object of this class, send the name of the file you wish to modify, as a parameter to the constructor.
	 *This class currently acts an interface to our "database", our text files containing data for users and products..
 *</p>
 */

public class FileHandler{
	// path for files
	private String path = "hello/resource/";
	private String readData = null;
	private int fileLines = 0;
	
	/**
	 * <p>
	 * Method for getting the number of lines in the text file, used by all(?) methods.
	 * @return When called returns an {@link java.lang.Integer Integer} which represents the total number of lines in the text file
	 * </p>
	 */
	public synchronized int getFileLines() {
		return fileLines;
	}
	
	/**
	 * <p>
	 * Class constructor {@link #FileHandler(String)}
	 * Takes in a String which is then used to specify what file we are currently reading/writing from.
	 * </p>
	 * @param file String which represents the file you wish to manipulate.
	 */
	public FileHandler(String file) {
		this.path += file;
		readData = read();
	}

	/**
	 * <p>
	 * Reads the file specified at the Constructor parameter.
	 * Returns the contents of specifed .txt file as a String object.
	 * @return When called returns a String which contains the contents of the {@link #path path} file.
	 * </p>
	 */
	public String read() {
		//  throws IOException 
		  {
		    byte[] encoded = null;
			try {
				encoded = Files.readAllBytes(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String data = new String(encoded, StandardCharsets.UTF_8);
			String[] lines = data.split(System.getProperty("line.separator"));
			
			for(int i=0;i<lines.length;i++){
			    if(lines[i].startsWith("#")){
			        lines[i] = "";
			    }
			}

			StringBuilder finalStringBuilder = new StringBuilder();
			for(String s:lines){
			   if(!s.equals("")){
			       finalStringBuilder.append(s).append(System.getProperty("line.separator"));
			    }
			}
			data = finalStringBuilder.toString();
		//	System.out.println("data:\n" + data);
			return data;
		  }

	}

	/**
	 * <p>
	 * Basic function to add new String and endline to the file specified
	 * by the class constructor parameter.
	 * This method appends a String object to the end of the file.
	 * @param line When calling must send a String to add.
	 * </p>
	 */
	public void addLine(String line) {
		boolean append = true;
		Writer output;
		
		try {
			output = new BufferedWriter(new FileWriter(path, append));
		
			output.append(System.getProperty("line.separator") + line);
			output.close();
		} catch (IOException e) {
				e.printStackTrace();
		}  
	}
	
	public void clearFile() {	
		boolean append = false;
		Writer output;
		
		try {
			output = new BufferedWriter(new FileWriter(path, append));
		
			output.write("");
			output.close();
		} catch (IOException e) {
				e.printStackTrace();
		}  
	}

	
	/**<p>
	 * To have functionality to remove a specified line from the file.
	 * </p>
	 */
	public void removeLine(String toUpdate) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(path));
        String line;
        String input = "";

        while ((line = file.readLine()) != null)
            input += line + System.lineSeparator();

        input = input.replace(toUpdate, "");
        FileOutputStream os = new FileOutputStream(path);
        os.write(input.getBytes());
        
        file.close();
        os.close();
		
	}

	/**
	 * <p>
	 * Splits the output of {@link #read()} into a String[] for further manipulation by {@link #arrayChop(String[], int)} method.
	 * @return When called returns String[] of the output from the {@link #read()} method.
	 * </p>
	 */
	public String[] fileArray() {
		String userFile = read();
		//FileHandler class reads text file into a string
		//System.getProperty("line.separator"); funkade med products.txt, men inte productsTest.txt
		/*
		 * If you don’t want empty lines:
		 * String.split("[\\r\\n]+") tänk på detta max :)
		 *///userFile split on the new lines into a String []
		String[] lines = userFile.split("\\r?\\n");
		//set linesSize so that we know the size of the string, for looping and creational purposes
		fileLines = lines.length;
		
		return lines;
	}
	
	/**
	 * <p>
	 * Chops the an index of the output of {@link #fileArray()} into a 5 length string array.
	 * The method splits the target array index on the " " characters in each index.
	 * @param lines The target array. {@link #fileArray()} is used to send as a parameter.
	 * @param index The index used to subdivide the target array.
	 * @return When called returns a 
	 * </p>
	 */
	public String[] arrayChop(String[] lines, int index) {
		String[] test = new String[5];
		test = lines[index].split("\\s+");
		return test;
	}
	
	/**
	 * <p>
	 * This method returns the line number in the text file it has found a match.
	 * The output of this method can be used in conjunction with the Userfactory.createUser() method.
	 * To create a User object from an ID.
	 * @param id When called takes in an Integer variable {@link #id} to check if exists in file.
	 * @return Returns and Integer representing which line the method has found a match on. If the method returns -1 as a value. It has found no match for the parameter.
	 * </p>
	 */
	public int checkUsername(int id) {
		arrayChop(fileArray(), 0);
		
		for(int i = 0; i < fileLines; i++) {
			String[] data = arrayChop(fileArray(), i);	
			if(id == Integer.parseInt(data[0])) {
				return i;
			}
		}
		return -1;
	}
	

	/**
	 * Duplicate function of checkUserName. unclear situation..
	 * @param id
	 * @return
	 */
	public int checkId(String id) {
		arrayChop(fileArray(), 0);
		
		for(int i = 0; i < fileLines; i++) {
			String[] data = arrayChop(fileArray(), i);	
			if(id.equals(data[0])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Updates a selected line in the text file. takes old line and the new, updated line as parameters.
	 * @param toUpdate the old String
	 * @param updated The string which contains updated information to be written to the textfile.
	 * @throws IOException throws an IOException
	 */
	public void updateLine(String toUpdate, String updated) throws IOException{ 
        BufferedReader file = new BufferedReader(new FileReader(path));
        String line;
        String input = "";

        while ((line = file.readLine()) != null)
            input += line + System.lineSeparator();

        input = input.replace(toUpdate, updated);
        FileOutputStream os = new FileOutputStream(path);
        os.write(input.getBytes());
        
        file.close();
        os.close();
    }
}
	
