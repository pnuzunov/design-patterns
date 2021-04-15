import java.util.ArrayList;
import java.util.List;

public class AlarmRunner implements Runnable {

	private List<Alarm> alarms;
	private boolean interrupted;
	private static final long duration = 3000;
	
	public AlarmRunner() {
		this.alarms = new ArrayList<Alarm>();
		this.interrupted = false;
	}
	
	public void addAlarm(Alarm alarm) {
		this.alarms.add(alarm);
	}
	
	public boolean hasActiveAlarms() {
		for(Alarm alarm : this.alarms) {
			if(alarm.getMessage() != Alarm.ALARM_DISABLED)
				return true;
		}
		return false;
	}
	
	public void terminate() {
		this.interrupted = true;
	}
	
	public void run() {
		while(!this.interrupted) {
						
			try {
				Thread.sleep(1000);
				
				for(Alarm alarm : this.alarms) {
					long alarmTime = alarm.getDate().getTime();
					
					if(alarmTime <= System.currentTimeMillis() && alarm.getMessage() != Alarm.ALARM_DISABLED) {
						if(System.currentTimeMillis() - alarmTime < duration) {
							alarm.changeMessage(Alarm.ALARM_NOTIFYING);	
						}
						else {
							alarm.changeMessage(Alarm.ALARM_DISABLED);
						}
					}
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
