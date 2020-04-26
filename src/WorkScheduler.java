import java.util.ArrayList;

public class WorkScheduler {
    public static void main(String[] args) throws Exception {
    	EmployeeManager employeeManager = new EmployeeManager();
    	ArrayList<Employee> sortedEmployees = employeeManager.getOrderedEmployees();
    	
    	WorkStationManager workStationManager = new WorkStationManager();
    	ArrayList<WorkStation> workStations = workStationManager.getWorkStationListByPriority();
    	
    	ArrayList<WorkStationAssignment> workStationAssignments = new ArrayList<WorkStationAssignment>();
    	for(Week.Weekdays day: Week.Weekdays.values()) {
    		for(WorkStation wStation: workStations) {
        		for(int i = 0; i < wStation.getNumEmployees(); i++) {
        			workStationAssignments.add(new WorkStationAssignment(wStation, employeeManager.getNextAvailableEmployee(), day));
        		}
        	}
    	}

    	for(WorkStationAssignment wsa: workStationAssignments) {
    		System.out.println(wsa.getWorkStation().getName() + " : " + wsa.getEmployee().getName() + " : " + wsa.getWeekday());
    	}
    }
}