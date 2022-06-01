package java_study_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BulletGameFrame extends JFrame{
	public BulletGameFrame() {
		setTitle("사격 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(400,400);
		setResizable(false);		
		setVisible(true);
		p.startGame();
	}
	
	public static void main(String [] args) {
		new BulletGameFrame();
	}
}
class GamePanel extends JPanel {
	private TargetThread targetThread=null;
	private TargetThread1 targetThread1=null;
	private JLabel baseLabel = new JLabel();
	private JLabel bulletLabel = new JLabel();
	private JLabel targetLabel;
	private JLabel baseLabel1 = new JLabel();
	private JLabel bulletLabel1 = new JLabel();
	private JLabel targetLabel1;
	
	
	public GamePanel() {
		setLayout(null);
	
		baseLabel.setSize(40,40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		ImageIcon img = new ImageIcon("C:\\Users\\Dongwon\\Desktop\\Temp/chicken.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(),img.getIconWidth());
		
		ImageIcon img1 = new ImageIcon("C:\\Users\\Dongwon\\Desktop\\Temp/chicken.jpg");
		targetLabel1 = new JLabel(img);
		targetLabel1.setSize(img.getIconWidth(),img.getIconWidth());

		bulletLabel.setSize(10,10);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);
		add(baseLabel);
		add(targetLabel);
		add(targetLabel1);
		add(bulletLabel);
		
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				baseLabel.setFocusable(true);
				baseLabel.requestFocus(); // 키보드 입력을 받도록 포커스 강제 지정			
			}
		});
	}
	
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);
		bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50);			
		targetLabel.setLocation(0, 0);
		targetLabel1.setLocation(300, 0);
		//------------------------------------------------------------------------------------------------- 여기까지 완료
		targetThread = new TargetThread(targetLabel);
		targetThread1 = new TargetThread1(targetLabel1);
	
		targetThread.start();
		targetThread1.start();
		
		
		baseLabel.setFocusable(true);
		baseLabel.requestFocus(); 			
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread  bulletThread = null;
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					if(bulletThread==null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread1);
						bulletThread.start();
					}
				}
			}
		});
	}
	
	class TargetThread extends Thread {
		private JComponent target;
		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
			target.getParent().repaint();
		}	
		
		@Override
		public void run() {
			while(true) {
				int x = target.getX()+((int)(Math.random() * 14)-5);
				int y = target.getY()+((int)(Math.random() * 14)-5);
				if(x > GamePanel.this.getWidth()) 
					target.setLocation(0,0);
				else 
					target.setLocation(x, y);

				target.getParent().repaint();
				try {
					sleep(20);
				}
				catch(InterruptedException e) {
					
					target.setLocation(0, 0);
					target.getParent().repaint();
					try {
						sleep(500); 
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	
	class TargetThread1 extends Thread {
		private JComponent target1;
		public TargetThread1(JComponent target1) {
			this.target1 = target1;
			target1.setLocation(0, 0);
			target1.getParent().repaint();
		}	
		
		@Override
		public void run() {
			while(true) {
				int x = target1.getX()+((int)(Math.random() * 30)-9);
				int y = target1.getY()+((int)(Math.random() * 30)-9);
				if(x > GamePanel.this.getWidth()) 
					target1.setLocation(0,0);
				else 
					target1.setLocation(x, y);

				target1.getParent().repaint();
				try {
					sleep(20);
				}
				catch(InterruptedException e) {
					
					target1.setLocation(0, 0);
					target1.getParent().repaint();
					try {
						sleep(500); 
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	
	class BulletThread extends Thread {
		private JComponent bullet, target;
		private Thread targetThread;
		private Thread targetThread1;
		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;				
		}
		
		@Override
		public void run() {
			while(true) {
				
				if(hit()) {
					targetThread.interrupt();
					bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);						
					return;
				}
				else {
					int x = bullet.getX() ;
					int y = bullet.getY() - 5;
					if(y < 0) {
						bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);
						bullet.getParent().repaint();
						return;
					}
					bullet.setLocation(x, y);
					bullet.getParent().repaint();
				}
				try {
					sleep(20);
				}
				catch(InterruptedException e) {}
			}
		}
		
		private boolean hit() {
			if(targetContains(bullet.getX(), bullet.getY()) || 
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()) ||
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()+bullet.getHeight() - 1) ||
					targetContains(bullet.getX(), bullet.getY()+bullet.getHeight() - 1))
				return true;
			else
				return false;					
		}
		
		private boolean targetContains(int x, int y) {
			if(((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) &&
					((target.getY() <= y)&& (target.getY() + target.getHeight() - 1 >= y))) {
				return true;
			}
			else
				return false;
			
		}
	}	
}
