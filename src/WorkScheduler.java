import java.util.Collection;

public class WorkScheduler {
    public static void main(String[] args) throws Exception {
    	EmployeeManager employeeManager = new EmployeeManager();
    	Collection<Employee> sortedEmployees = employeeManager.getOrderedEmployees();
    	
    	for(Employee employee: sortedEmployees) {
    		System.out.println("Name: " + employee.getName() + " Order: " + employee.getOrderPosition());
    	}
    }
}