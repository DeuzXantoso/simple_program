package application;

public class Asteroid extends Sprite{
	
	private final int BOARD_HEIGHT = 500;
    private final int ASTEROID_SPEED = 2;
    
    public Asteroid(int x, int y) {
		super(x, y);
		
		initAsteroid();
	}
    private void initAsteroid() {
        
        loadImage(80,80,"src/asteroid.png");
        getImageDimensions();
    }

    public void move() {
        
        y += ASTEROID_SPEED;
        
        if (y > BOARD_HEIGHT) {
            visible = false;
        }
    }
}
