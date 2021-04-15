import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	protected Object message;
	protected List<Observer> observers;
	
	public abstract void attachObserver(Observer observer);
	public abstract void detachObserver(Observer observer);
	
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	
	public Object getMessage() {
		return this.message;
	}
	
	public void changeMessage(Object message) {
		this.message = message;
		this.notifyObservers();
	}
	
	protected void notifyObservers() {
		for(Observer obs: this.observers) {
			obs.update();
		}
	}
}
