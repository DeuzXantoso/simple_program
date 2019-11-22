package application;


public class Missile extends Sprite {

    private final int MISSILE_SPEED = 6;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage(12,17,"src/missile.png");
        getImageDimensions();
    }

    public void move() {
        
        y -= MISSILE_SPEED;
        
        if (y < 0) {
            visible = false;
        }
    }
}
