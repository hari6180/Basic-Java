public class Shape {
	
	int width;
	int height;
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getArea() {
		return 0;
	}
	
	public int getRound() {
		return 0;
	}
	
	public int getArea(int x, int y) {
		return 0;
	}
	
	public int getRound(int x, int y) {
		return 0;
	}

	@Override
	public String toString() {
		return "Shape [width=" + width + ", height=" + height + "]";
	}


}