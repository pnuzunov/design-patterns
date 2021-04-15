
public class AlarmListener implements Observer {

	private Observable alarm;
	
	public void update() {
		if(null != alarm && null != alarm.getMessage()) {
			String updateMessage = String.format("Message from %s: %s", ((Alarm)alarm).getName(), alarm.getMessage());
			System.out.println(updateMessage);
		}
			
	}

	public void setObservable(Observable observable) {
		this.alarm = observable;
	}

}
