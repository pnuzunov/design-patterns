import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		
		Alarm alarm1 = new Alarm("alarm1", new Date(System.currentTimeMillis() + 1*1000));
		Alarm alarm2 = new Alarm("alarm2", new Date(System.currentTimeMillis() + 4*1000));
					
		alarm1.attachObserver(new AlarmListener());
		alarm2.attachObserver(new AlarmListener());
				
		AlarmRunner runner = new AlarmRunner();
		runner.addAlarm(alarm1);
		runner.addAlarm(alarm2);
				
		Thread runnerThread = new Thread(runner);
		runnerThread.start();
		while(runner.hasActiveAlarms());
		runner.terminate();
	}

}
