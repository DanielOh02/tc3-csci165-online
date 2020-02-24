// Daniel Oh
// CSCI 165 
// Checker board

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


class ChessBoard extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public ChessBoard() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("ChessBoard");
        window.setSize(416, 439);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

	// add your own drawing intructions in this method
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
        
        //draw squares
        
        
        int x = 0, y = 0;
        int width = 50;
        int height = 50;
        
        
        for(int i = 0; i < 4; i++) {
        	for(int f = 0; f < 4; f++) {
        		g2d.setColor(Color.BLACK);
        		g2d.fillRect(x, y, width, height);
        		y += 50;
        		g2d.setColor(Color.RED);
        		g2d.fillRect(x, y, width, height);
        		y += 50;		 
        	} // end of nested loop 
        	y = 0;
        	x += 50;
        	
        	for(int f = 0; f < 4; f++) {
        		g2d.setColor(Color.RED);
        		g2d.fillRect(x, y, width, height);
        		y += 50;
        		g2d.setColor(Color.BLACK);
        		g2d.fillRect(x, y, width, height);
       		 	y += 50;		 
        		} // end of nested loop 
        	y = 0;
        	x += 50;
       	
  
        	
        	
        } // end of for loop
        
 
     	
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                ChessBoard ex = new ChessBoard();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
