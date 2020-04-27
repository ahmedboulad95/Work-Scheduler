import java.util.HashMap;
import java.util.Stack;

public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String name;
    private Long orderPosition;      // Keeps track of what station employee is at on what day
    private HashMap<Week.Weekdays, Boolean> workingDaysMap;
    
    public Employee(String id, String employeeName, Long orderPosition, HashMap<Week.Weekdays, Boolean> workingDaysMap) {
        this.employeeId = id;
        this.name = employeeName;
        this.orderPosition = orderPosition;
        this.workingDaysMap = workingDaysMap;
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
    
    public Boolean isWorkingOn(Week.Weekdays day) {
    	return workingDaysMap.get(day);
    }

    public int compareTo(Employee compareEmployee) {
    	Long otherOrderPosition = compareEmployee.getOrderPosition();
    	if(this.orderPosition < otherOrderPosition) {
    		return -1;
    	} else if(this.orderPosition > otherOrderPosition) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
    
}