import java.util.ArrayList;
import java.util.HashMap;

public class WorkStation {
    private String name;
    private Integer numEmployees;
    private HashMap<String, Employee> employeeAssignmentMap;

    public WorkStation() {

    }

    public String getName() {
        return this.name;
    }

    public Integer getNumEmployees() {
        return this.numEmployees;
    }

    public HashMap<String, Employee> getEmployeeAssignmentMap() {
        return this.employeeAssignmentMap;
    }

    public static ArrayList<WorkStation> generateWorkStations() {
        return new ArrayList<WorkStation>();
    }

    public void assignEmployee(Employee emp) {
        
    }
}