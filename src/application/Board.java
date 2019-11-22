package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private static final int W = 500;
	private static final int H = 800;
	
	private List<Missile> missiles;
	private List<Asteroid> asteroids;
	
    private final int DELAY = 10;
    private Timer timer;
    
    private Jet jet;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setFocusable(true);

        jet = new Jet(W - 290, H - 120);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(jet.getImage(), jet.getX(),
                jet.getY(), this);

        missiles = jet.getMissiles();
        

        for (Missile missile : missiles) {
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
        
        asteroids = jet.getAsteroids();
        for(Asteroid asteroid : asteroids) {
        	g2d.drawImage(asteroid.getImage(), asteroid.getX(), asteroid.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateMissiles();
        updateAsteroids();
        updateSpaceJet();

        repaint();
    }

    private void updateMissiles() {
        missiles = jet.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            
            if (missile.isVisible()) {
                missile.move();
            } 
            else {
                missiles.remove(i);
            }
        }
    }
    
    private void updateAsteroids() {
    	asteroids = jet.getAsteroids();
    	
    	for(int i = 0; i<asteroids.size(); i++) {
    		Asteroid asteroid = asteroids.get(i);
    		
    		if(asteroid.isVisible()) {
    			asteroid.move();
    		}
    		else {
    			asteroids.remove(i);
    		}
    	}
    }

    private void updateSpaceJet() {
        jet.move();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            jet.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            jet.keyPressed(e);
        }
    }
}