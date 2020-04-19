import java.util.Stack;

public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String name;
    private Long orderPosition;      // Keeps track of what station employee is at on what day
    
    public Employee(String id, String employeeName, Long orderPosition) {
        this.employeeId = id;
        this.name = employeeName;
        this.orderPosition = orderPosition;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public Long getOrderPosition() {
        return this.orderPosition;
    }

    public void setOrderPosition(Long newPosition) {
        if(newPosition != this.orderPosition) {
            this.orderPosition = newPosition;
        }
    }

    public int compareTo(Employee compareEmployee) {
    	Long otherOrderPosition = compareEmployee.getOrderPosition();
    	if(this.orderPosition < otherOrderPosition) {
    		return 1;
    	} else if(this.orderPosition > otherOrderPosition) {
    		return -1;
    	} else {
    		return 0;
    	}
    }
    
}