package computer_programming_hw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Quiz_602 extends JFrame {
	public Quiz_602() {
		setTitle("»ç°Ý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);
		setResizable(false);		
		setVisible(true);
		p.startGame();
	}
	
	public static void main(String [] args) {
		new Quiz_602();
	}
}
class GamePanel extends JPanel {
	private TargetThread targetThread=null;
	private TargetThread2 targetThread2=null;
	private JLabel baseLabel = new JLabel();
	private JLabel bulletLabel = new JLabel();
	private JLabel targetLabel;
	private JLabel targetLabel2;
	
	public GamePanel() {
		setLayout(null);
	
		baseLabel.setSize(40,40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		ImageIcon img = new ImageIcon("C:\\Users\\Dongwon\\Desktop\\Temp/chicken.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(),img.getIconWidth());
		
		ImageIcon img2 = new ImageIcon("C:\\Users\\Dongwon\\Desktop\\Temp/chicken.jpg");
		targetLabel2 = new JLabel(img2);
		targetLabel2.setSize(img2.getIconWidth(),img2.getIconWidth());

		bulletLabel.setSize(10,10);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);
		add(baseLabel);
		add(targetLabel2);
		add(targetLabel);
		add(bulletLabel);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				baseLabel.setFocusable(true);
				baseLabel.requestFocus();	
			}
		});
	}
	
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);
		bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50);			
		targetLabel.setLocation(0, 0);
		targetLabel2.setLocation(200, 300);
		
		targetThread = new TargetThread(targetLabel,targetLabel2);
		targetThread.start();
		//targetThread2 = new TargetThread2(targetLabel2);
		//targetThread2.start();
		
		baseLabel.setFocusable(true);
		baseLabel.requestFocus(); 	
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread  bulletThread = null;
			
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					if(bulletThread==null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetLabel2, targetThread);//targetThread2
						bulletThread.start();
					}
				}
			}
		});
	}
	
	class TargetThread extends Thread {
		private JComponent target;
		private JComponent target1;
		public TargetThread(JComponent target,JComponent target1) {
			this.target = target;
			this.target1 = target1;
			target.setLocation(0, 0);
			target.getParent().repaint();
			
		}	
		
		public void run() {
			int xn = 0;
			int yn = 0;
			int rand = (int)(Math.random()*20 + 1);
			int rand2 = (int)(Math.random()*20 + 1);
			while(true) {
				int x = target.getX();
				int y = target.getY();
				
				if((xn%2) ==  0) {
					x = target.getX()+rand;
				}
				else
					x = target.getX()-rand;
				if((yn%2) ==  0) {
					y = target.getY()+rand2;
				}
				else
					y = target.getY()-rand2;
				if(x > GamePanel.this.getWidth()-target.getWidth()) {
					target.setLocation(GamePanel.this.getWidth()-target.getWidth(), y);
					rand = (int)(Math.random()*20 + 1);
					xn++;}
				else if(x < 0) {
					target.setLocation(0, y);
					rand = (int)(Math.random()*20 + 1);
					xn++;
				}
				else if(y > GamePanel.this.getHeight()-target.getHeight()) {
					target.setLocation(x, GamePanel.this.getHeight()-target.getHeight());
					rand2 = (int)(Math.random()*20 + 1);
					yn++;}
				else if(y < 0) {
					target.setLocation(x, 0);
					rand2 = (int)(Math.random()*20 + 1);
					yn++;}
				else 
					target.setLocation(x, y);
				target.getParent().repaint();
				try {
					sleep(50);
				}
				catch(InterruptedException e) {
					;
					
					targetThread2 = new TargetThread2(targetLabel2);
					targetThread2.start();
					target1.setLocation(x, y);
					//target.setLocation(x, y);
					
				
					try {
						sleep(500); 
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	class TargetThread2 extends Thread {
		private JComponent target2;
		public TargetThread2(JComponent target2) {
			this.target2 = target2;
			//target2.setLocation(0, 0);
			//target2.getParent().repaint();
		}	
		
		public void run() {
			int xn = 0;
			int yn = 0;
			int rand = (int)(Math.random()*20 + 1);
			int rand2 = (int)(Math.random()*20 + 1);
			while(true) {
				int x = target2.getX();
				int y = target2.getY();
				
				if((xn%2) ==  0) {
					x = target2.getX()+rand;
				}
				else
					x = target2.getX()-rand;
				if((yn%2) ==  0) {
					y = target2.getY()+rand2;
				}
				else
					y = target2.getY()-rand2;
				if(x > GamePanel.this.getWidth()-target2.getWidth()) {
					target2.setLocation(GamePanel.this.getWidth()-target2.getWidth(), y);
					rand = (int)(Math.random()*20 + 1);
					xn++;}
				else if(x < 0) {
					target2.setLocation(0, y);
					rand = (int)(Math.random()*20 + 1);
					xn++;
				}
				else if(y > GamePanel.this.getHeight()-target2.getHeight()) {
					target2.setLocation(x, GamePanel.this.getHeight()-target2.getHeight());
					rand2 = (int)(Math.random()*20 + 1);
					yn++;}
				else if(y < 0) {
					target2.setLocation(x, 0);
					rand2 = (int)(Math.random()*20 + 1);
					yn++;}
				else 
					target2.setLocation(x, y);
				target2.getParent().repaint();
				try {
					sleep(50);
				}
				catch(InterruptedException e) {
					//target2.setLocation(0, 0);
					//target2.getParent().repaint();
					try {
						sleep(500); 
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	
	class BulletThread extends Thread {
		private JComponent bullet, target, target2;
		private Thread targetThread, targetThread2;
		public BulletThread(JComponent bullet, JComponent target, JComponent target2, Thread targetThread) {//, Thread targetThread2
			this.bullet = bullet;
			this.target = target;
			this.target2 = target2;
			this.targetThread = targetThread;
			//this.targetThread2 = targetThread2;
		}
		
		public void run() {
			while(true) {
				if(hit()) {
					targetThread.interrupt();
					//targetThread2.interrupt();
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
			if((((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) && ((target.getY() <= y)&& (target.getY() + target.getHeight() - 1 >= y))) 
					|| (((target2.getX() <= x) && (target2.getX() + target2.getWidth() - 1 >= x)) && ((target2.getY() <= y)&& (target2.getY() + target2.getHeight() - 1 >= y)))) 
			{
				return true;
			}
			else
				return false;
			
		}
	}	
}

