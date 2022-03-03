package g_oop2;

public class Time {

	
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		if(hour <= 23 && hour >= 0)
		this.hour = hour;
	}


	public int getMinute() {
		return minute;
	}


	public void setMinute(int minute) {
		if(minute < 60 && minute >= 0) {
		}
		if(minute == 60) {
				minute = 0;
				hour++;
				
		}
		this.minute = minute;
	}


	public double getSecond() {
		return second;
	}


	public void setSecond(int second) {
		if(second < 0) {
			this.second = 0;
		}else if(59 < second) {
			this.second = 59;
			this.second = second % 60;
			setMinute(this.minute + second / 60);
		}else {
			this.second = second;
		}
	}


	
	
	
	@Override
	public String toString() {
		return hour + " : " + minute + " : " + second;
	}
	
	
	void clock() {
		while(true) {
			System.out.println(toString());
			stop();
			setSecond(second + 1);
			
		}
	}
	
	private void stop()	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
