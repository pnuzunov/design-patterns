
public interface Observable {
	
	public void attachObserver(Observer observer);
	public void detachObserver(Observer observer);
	public Object getMessage();
	public void changeMessage(Object message);
}
