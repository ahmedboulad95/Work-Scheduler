
public class WorkStationAssignment {
	private WorkStation workStation;
	private Employee employee;
	private Week.Weekdays weekday;
	
	public WorkStationAssignment(WorkStation workStation, Employee employee, Week.Weekdays weekday) {
		this.workStation = workStation;
		this.employee = employee;
		this.weekday = weekday;
	}
	
	public WorkStation getWorkStation() {
		return this.workStation;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public Week.Weekdays getWeekday() {
		return this.weekday;
	}
}
