import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * Employee CSV Notes:
 * The header of the CSV File is this:
 * EmployeeId[0], FirstName[1], LastName[2], illnessStatus[3], ...?
 */

public class DataStore {
	private Encryption encryption;
	private String employeeFile;
	
	
	public DataStore(String password, String keyFile, String employeeFile) throws Exception {
		encryption = new Encryption(password, keyFile);
		this.employeeFile = employeeFile;	
	}
	
	public void saveEmployees(ArrayList<Employee> employeeList) throws Exception {
	
	// convert ListArray of Employees to CSV String	
	String employeeOutput = "";
	for (Employee emp: employeeList) {
		employeeOutput += emp.getEmployeeId() + ",";
		employeeOutput += emp.getFirstName() + ",";
		employeeOutput += emp.getLastName() + ",";
		
		if (emp.getIllnessStatus()) {
			employeeOutput +=  "true,";
		}
		else {
			employeeOutput +=  "false,";
		}
		
		employeeOutput += "\n";
		
	}	
	// encrypt file data
	byte[] encryptedEmployees = encryption.encryptData(employeeOutput);
	
	// write data to a file
	FileOutputStream fos = new FileOutputStream(employeeFile);
	fos.write(encryptedEmployees);
	fos.close();
	
	}
	
	public ArrayList<Employee> loadEmployees() throws Exception {
		// read all of the data from the employee file and decrypt the data 
		byte[] fileContent = Files.readAllBytes(Paths.get(employeeFile));
		String fileString = encryption.decryptData(fileContent);
		
		// prepare for loop 
		String[] fileLines = fileString.split("\\n"); //split lines in the decrypted file using newline character
		ArrayList<Employee> employeeList = new ArrayList<Employee>(); // create an ArrayList of employees
		
		// loop through strings in the fileLines and create Employee objects and add them to ListArray
		for (String line: fileLines) {
			String[] fields = line.split(",");
			Employee tempEmployee = new Employee(fields[0]);
			tempEmployee.setFirstName(fields[1]);
			tempEmployee.setLastName(fields[2]);
			if (fields[3].equals("true")) {
				tempEmployee.setIllnessStatus(true);
			}
			else {
				tempEmployee.setIllnessStatus(false);
			}
			
			employeeList.add(tempEmployee);
		}
		
		return employeeList;		
	}
}

