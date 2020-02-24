// Daniel Oh
// CSCI 165
// Show min and max in a grid of a Matrix

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

class ShowMinMax extends JPanel {
	
	public static int findIndexInRow(int[][] matrix, int row, int num) {
		for(int i = 0; i < matrix[row].length; i++) {
			if(num == matrix[row][i])
				return i;
		} // end of for loop
		
		return -1;
		
	}

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public ShowMinMax() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("ShowMinMax");
        window.setSize(330, 800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

	// add your own drawing instructions in this method
    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;

        //<====> ADD YOUR DRAWING CODE HERE <==========>//
        
        //draw grid
        int[][] matrix = new int[50][20];
        
        // fill the array
        MatrixStuff.fillArrayRowMajor(matrix);
        
       
        int x = 10, y = 10;
        int width = 10;
        int height = 10;
        int max = 0;
        int min = 0;
        
        for(int i = 0; i < 50; i++) { //the row
        	for(int f = 0; f < 20; f++) { // the column
        		
        		max = MatrixStuff.findMaxOfRow(matrix ,i);
        		min = MatrixStuff.findMinOfRow(matrix ,i);
        		
        		if (findIndexInRow(matrix, i, max) == f) {
        			g2d.setColor(Color.RED);
        			g2d.fillRect(x, y, width, height);
        			x += 15;
        			
        		} else if ((findIndexInRow(matrix, i, min) == f)) {
        			
        			g2d.setColor(Color.GREEN);
        			g2d.fillRect(x, y, width, height);
        			x += 15;
        			
        		} else {
        			
        			g2d.setColor(new Color (128, 128, 128));
	        		g2d.fillRect(x, y, width, height);
	        		x += 15;
        		
        		} // end of if and else block
        		
        	} // end of nested loop 
        	x = 10;
        	y += 15;
 
     	
        } // end of for loop
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                ShowMinMax ex = new ShowMinMax();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
