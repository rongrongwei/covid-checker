import java.util.ArrayList;

public class TestDataStore {

	public static void main(String[] args) throws Exception {
		DataStore datastore = new DataStore("mypassword ", "keyfile", "employeefile", "surveyfile"); // maybe set up to auto-load employees???
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

		// test employees
		Employee testEmployee = new Employee("abc123");
		testEmployee.setFirstName("Rongrong");
		testEmployee.setLastName("Wei");
		employeeList.add(testEmployee);
		
		Employee testEmployee2 = new Employee("bbb111");
		testEmployee2.setFirstName("John");
		testEmployee2.setLastName("Smith");
		employeeList.add(testEmployee2);
		
		
		datastore.saveEmployees(employeeList);
		
		ArrayList<Employee> employeeList2 = new ArrayList<Employee>();
		employeeList2 = datastore.loadEmployees();
		Employee me = employeeList2.get(1);
		System.out.println(me.getFirstName());
		
		// test surveys
		Survey testSurvey = new Survey("abc123", "07/28/2020", "San Antonio", "98.6", true, true, true);
		Survey testSurvey2 = new Survey("abc123", "07/27/2020", "San Antonio", "98.4", false, true, true);

		
		ArrayList<Survey> surveyList = new ArrayList<Survey>();
		surveyList.add(testSurvey);
		surveyList.add(testSurvey2);
		datastore.saveSurveysList(surveyList);
		
		ArrayList<Survey> surveyList2 = datastore.loadSurveysList();
		Survey mySurvey = surveyList2.get(0);
		System.out.println(mySurvey.getTravel14Days());
		
		Survey mySurvey2 = surveyList2.get(1);
		System.out.println(mySurvey2.getTravel14Days());

	}

}
