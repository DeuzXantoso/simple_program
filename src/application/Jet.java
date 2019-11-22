package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jet extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;
    private List<Asteroid> asteroids;

    public Jet(int x, int y) {
        super(x, y);
        
        initSpaceJet();
    }

    private void initSpaceJet() {

        missiles = new ArrayList<>();
        asteroids = new ArrayList<>();
        
        loadImage(80, 80, "src/fighter-jet.png"); 
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }
    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -3;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 3;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -3;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 3;
        }
    }

    public void fire() {
        missiles.add(new Missile(x + 34, y-10));
        Random rand = new Random();
        asteroids.add(new Asteroid(rand.nextInt(400) + 8, 0));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}