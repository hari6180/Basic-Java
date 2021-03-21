public class Square {
	int width;
	int height;
	
	public Square(int width, int height) {
		this.width = width;
		this.height = height;
	}

	int getArea() { 
		return width * height;
	}
	
	int getRound() {
		return (width + height) * 2;
 	}

}