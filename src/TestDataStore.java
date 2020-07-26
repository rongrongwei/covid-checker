import java.util.ArrayList;

public class TestDataStore {

	public static void main(String[] args) throws Exception {
		DataStore datastore = new DataStore("mypassword ", "keyfile", "employeefile"); // maybe set up to auto-load employees???
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

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
		
	}

}
