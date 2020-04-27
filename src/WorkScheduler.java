import java.util.ArrayList;

public class WorkScheduler {
    public static void main(String[] args) throws Exception {
    	EmployeeManager employeeManager = new EmployeeManager();
    	//ArrayList<Employee> sortedEmployees = employeeManager.getOrderedEmployees();
    	
    	WorkStationManager workStationManager = new WorkStationManager();
    	ArrayList<WorkStation> workStations = workStationManager.getWorkStationListByPriority();
    	
    	ArrayList<WorkStationAssignment> workStationAssignments = new ArrayList<WorkStationAssignment>();
    	for(Week.Weekdays day: Week.Weekdays.values()) {
    		employeeManager.setWorkingEmployees(day);
    		
    		for(WorkStation wStation: workStations) {
    			long numEmployees = wStation.getNumEmployees();
    			
    			if(numEmployees == -1) {
    				Employee nextEmployee = employeeManager.getNextAvailableEmployee();
    				
    				while(nextEmployee != null) {
    					workStationAssignments.add(new WorkStationAssignment(wStation, nextEmployee, day));
    					nextEmployee = employeeManager.getNextAvailableEmployee();
    				}
    			} else {
    				for(int i = 0; i < numEmployees; i++) {
    					Employee employee = employeeManager.getNextAvailableEmployee();
    					if(employee == null)
    						break;
    					
            			workStationAssignments.add(new WorkStationAssignment(wStation, employee, day));
            		}
    			}
        	}
    	}

    	for(WorkStationAssignment wsa: workStationAssignments) {
    		System.out.println(wsa.getWorkStation().getName() + " : " + wsa.getEmployee().getName() + " : " + wsa.getWeekday());
    	}
    }
}