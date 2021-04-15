import java.util.ArrayList;
import java.util.Date;

public class Alarm extends Observable {
	
	public static final String ALARM_ACTIVE = "Active";
	public static final String ALARM_NOTIFYING = "Ring ring!";
	public static final String ALARM_DISABLED = "Disabled";
	private Date date;

	private String name;
	
	public Alarm(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
		this.changeMessage(ALARM_ACTIVE);	
	}
	
	@Override
	public void attachObserver(Observer observer) {
		this.observers.add(observer);
		observer.setObservable(this);
	}
	
	@Override
	public void detachObserver(Observer observer) {
		this.observers.remove(observer);
		observer.setObservable(null);
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getName() {
		return this.name;
	}
}

