package application;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame {
	private static final long serialVersionUID = -1005864927448485705L;

	public MovingSpriteEx() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(400, 300);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingSpriteEx ex = new MovingSpriteEx();
            ex.setVisible(true);
        });
    }
}