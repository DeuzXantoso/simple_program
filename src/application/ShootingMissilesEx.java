package application;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ShootingMissilesEx extends JFrame {
	private static final long serialVersionUID = -5259028153231792751L;

	public ShootingMissilesEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(500, 800);
        setResizable(false);
        
        setTitle("Iron Blood!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            ShootingMissilesEx ex = new ShootingMissilesEx();
            ex.setVisible(true);
        });
    }
}