import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Employee CSV Notes:
 * The header of the CSV File is this:
 * EmployeeId[0], FirstName[1], LastName[2], illnessStatus[3], ...?
 */

/*
 * Survey CSV Notes:
 * The header of the CSV File is this:
 * 	employeeId[0], surveyDate[1], location[2], temperatureValue[3], symptoms[4], ...?
 */

public class DataStore {
	private Encryption encryption;
	private String employeeFile;
	private String surveyFile;
	// TODO: Add Survey File when Survey class has been defined
	
	public DataStore(String password, String keyFile, String employeeFile, String surveyFile) throws Exception {
		encryption = new Encryption(password, keyFile);
		this.employeeFile = employeeFile;	
		this.surveyFile = surveyFile;
	}
	
	
	public void saveEmployees(ArrayList<Employee> employeeList) throws Exception {
	
	// convert ListArray of Employees to CSV String	
	String employeeOutput = "";
	for (Employee emp: employeeList) {
		employeeOutput += emp.getEmployeeId() + ",,"; // use two commas to separate in case user enters multiple commas
		employeeOutput += emp.getFirstName() + ",,";
		employeeOutput += emp.getLastName() + ",,";
		
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
			String[] fields = line.split(",,");
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
	
	public HashMap<String, ArrayList<Survey>> loadSurveys() throws Exception {
		// read all of the data from the employee file and decrypt the data 
		byte[] fileContent = Files.readAllBytes(Paths.get(surveyFile));
		String fileString = encryption.decryptData(fileContent);
		
		// prepare for loop 
		String[] fileLines = fileString.split("\\n"); //split lines in the decrypted file using newline character
		HashMap<String, ArrayList<Survey>> surveyMap = new HashMap<String, ArrayList<Survey>>(); // create an ArrayList of surveys
		
		// loop through strings in the fileLines and create Employee objects and add them to ListArray
		for (String line: fileLines) {
			String[] fields = line.split(",,");
			String employeeId = fields[0];
			String date = fields[1];
			String location = fields[2];
			String temperature = fields[3];
			String symptoms = fields[4];
			Survey tempSurvey = new Survey(employeeId, date, location, temperature);
			tempSurvey.setSymptoms(symptoms);

			if (surveyMap.containsKey(employeeId)) {
				ArrayList<Survey> surveyList = surveyMap.get(employeeId);
				surveyList.add(tempSurvey);
				surveyMap.put(employeeId, surveyList);
			}
			else {
				ArrayList<Survey> surveyList = new ArrayList<Survey>();
				surveyList.add(tempSurvey);
				surveyMap.put(employeeId, surveyList);
			}
		}
		
		return surveyMap;		
	}
	
	public void saveSurveys(HashMap<String, ArrayList<Survey>> surveyMap) throws Exception {
		

		String surveyOutput = "";
		// loop through hash map elements to get all ArrayLists of Surveys
		for (Map.Entry<String, ArrayList<Survey>> mapElement : surveyMap.entrySet()) {
			
			// convert ListArray of Survey to CSV String	
			for (Survey survey: mapElement.getValue()) {
				surveyOutput += survey.getEmployeeId() + ",,";
				surveyOutput += survey.getSurveyDate() + ",,";
				surveyOutput += survey.getLocation() + ",,";
				surveyOutput += survey.getTemperatureValue() + ",,";
				surveyOutput += survey.getSymptoms() + ",,";
				surveyOutput += "\n";
			}
			
		}	
		// encrypt file data
		byte[] encryptedSurveys = encryption.encryptData(surveyOutput);
		
		// write data to a file
		FileOutputStream fos = new FileOutputStream(surveyFile);
		fos.write(encryptedSurveys);
		fos.close();	
		}		
		
}
