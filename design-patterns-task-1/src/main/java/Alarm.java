import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Alarm implements Observable {
	
	public static final String ALARM_ACTIVE = "Active";
	public static final String ALARM_NOTIFYING = "Ring ring!";
	public static final String ALARM_DISABLED = "Disabled";
	private Date date;

	private String name;
	private Object message;
	private List<Observer> observers;
	
	public Alarm(String name, Date date) {
		this.name = name;
		this.date = date;
		this.observers = new ArrayList<Observer>();
		this.changeMessage(ALARM_ACTIVE);	
	}
	
	public void attachObserver(Observer observer) {
		this.observers.add(observer);
		observer.setObservable(this);
	}
	
	public void detachObserver(Observer observer) {
		this.observers.remove(observer);
		observer.setObservable(null);
	}
	
	public Object getMessage() {
		return this.message;
	}
	
	public void changeMessage(Object message) {
		this.message = message;
		for(Observer obs: this.observers) {
			obs.update();
		}
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getName() {
		return this.name;
	}
}

