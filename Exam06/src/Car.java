public abstract class Car {
	
	int speed;
	
	public Car(int speed) {
		super();
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void speedUp() {
		this.setSpeed(speed);
	}


}