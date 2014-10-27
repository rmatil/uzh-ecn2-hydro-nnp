import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawBoxes extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	
	final static int GRID_LENGTH = 1000;
	final static int GRID_WIDTH = 1000;
	final static int PIXEL_SIZE = 3;
	
	final static int XCORD = 175;
	final static int YCORD = 10;
	
	final static int NUMBER_OF_PARTICLES = 100;
	
	public static LinkedList<Cell> cellsList = new LinkedList<Cell>();
	public static Particle[] particles;

	public static void main(String[] args) {
		JFrame top = new JFrame("Cells");
		top.setBounds(XCORD, YCORD, GRID_LENGTH, GRID_WIDTH + 22);
			
		top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		top.setResizable(true);
		
		DrawBoxes drawBoxes= new DrawBoxes();
		top.getContentPane().add(drawBoxes);
		
		DrawBoxesTask task1 = drawBoxes.new DrawBoxesTask(); 
		task1.start();
		
		top.setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < cellsList.size(); i++){
			g.drawLine((int) (cellsList.get(i).getXMin() * GRID_LENGTH), (int) (cellsList.get(i).getYMin() * GRID_WIDTH), (int) (cellsList.get(i).getXMax() * GRID_LENGTH), (int) (cellsList.get(i).getYMin() * GRID_WIDTH));
			g.drawLine((int) (cellsList.get(i).getXMax() * GRID_LENGTH), (int) (cellsList.get(i).getYMin() * GRID_WIDTH), (int) (cellsList.get(i).getXMax() * GRID_LENGTH), (int) (cellsList.get(i).getYMax() * GRID_WIDTH));
			g.drawLine((int) (cellsList.get(i).getXMax() * GRID_LENGTH), (int) (cellsList.get(i).getYMax() * GRID_WIDTH), (int) (cellsList.get(i).getXMin() * GRID_LENGTH), (int) (cellsList.get(i).getYMax() * GRID_WIDTH));
			g.drawLine((int) (cellsList.get(i).getXMin() * GRID_LENGTH), (int) (cellsList.get(i).getYMax() * GRID_WIDTH), (int) (cellsList.get(i).getXMin() * GRID_LENGTH), (int) (cellsList.get(i).getYMin() * GRID_WIDTH));
		}
		
		g.setColor(Color.RED);
		
		for(Particle p : particles){
			g.fillOval((int) (p.getXPos() * GRID_LENGTH), (int) (p.getYPos() * GRID_WIDTH), PIXEL_SIZE, PIXEL_SIZE);
		}
	}

	private class DrawBoxesTask extends Thread {
		
		public DrawBoxesTask(){
			
		}
		
		public void run() {
			particles = ParticleBuilder.generateParticles(NUMBER_OF_PARTICLES);

			Cell root = new Cell(0d, 1d, 0d, 1d, 0, particles.length);

			TreeBuilder.build(root, particles);
			parseTree(root);
			
			repaint();

		}
		
		private void parseTree(Cell pCell){
			if(pCell.getLeftChild() != null){
				parseTree(pCell.getLeftChild());
			} else {
				cellsList.add(pCell);
			}
			
			if(pCell.getRightChild() != null){
				parseTree(pCell.getRightChild());
			} else {
				cellsList.add(pCell);
			}
		}
	}
}
