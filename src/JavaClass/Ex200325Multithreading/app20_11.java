package JavaClass.Ex200325Multithreading;

import java.awt.*;
class BallSy extends Thread{
	public static Frame f;
	public static int width,height;
	public static int delay_ms=20,step_seed=5,loop_seed=50;
	private int x,y,x_buf,y_buf;
	private int r,g,b,size;
	private int loop_cnt;
	public BallSy(){
		x = (int)((width+1) * Math.random());
		y = (int)((height+1) * Math.random());
		r = (int)(256 * Math.random());
		g = (int)(256 * Math.random());
		b = (int)(256 * Math.random());
		size = (int)(30 * Math.random())+20;
	}
	public void run(){		
		while(true){
			loop_cnt = (int)(loop_seed*Math.random())+1;
			x_buf = (int)((step_seed*2+1)*Math.random())- step_seed;
			y_buf = (int)((step_seed*2+1)*Math.random())- step_seed;
			for(int i = 0; i<loop_cnt; i++){
				x += x_buf;
				y += y_buf;
				f.repaint();
				try{
				sleep(delay_ms);
				}
				catch(InterruptedException e){
				}
			}
		}
	}
	public void draw(Graphics g){		
		g.setColor(new Color(r, this.g, b));
		g.fillOval((x > 0 ? x%width : width+(x%width)), (y > 0 ? y%height : height+(y%height)), size, size);
	}
}

public class app20_11 extends Frame{
	public static app20_11 f = new app20_11();
	private static int width = 500, height = 500, ball_num = 10;
	public  static BallSy[] ob_balls = new BallSy[ball_num];
	public static void main(String args[]){
		f.setTitle("draw");
		f.setSize(width, height);
		f.setVisible(true);
		BallSy.width = width;
		BallSy.height = height;
		BallSy.f = f;
		for(int i = 0; i < ball_num; i++)
			ob_balls[i] = new BallSy();
		for(int i = 0; i < ball_num; i++)
			ob_balls[i].start();
	} 
	public void paint(Graphics g){
		for(int i = 0; i < ball_num; i++)
			ob_balls[i].draw(g);
	}
}