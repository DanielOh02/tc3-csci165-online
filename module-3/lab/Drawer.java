// Daniel Oh
// CSCI 165
// 2D java drawing 

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(500, 500);
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
        
        // draw rectangle
        int x = 10, y = 10;
        
        for(int i = 0; i < 30; i++) {
        	g2d.drawRect(x, y, 10, 10);	
        	y += 15;
       
        }// end of for loop
        
        // fill rectangle 
     	g2d.setColor(new Color(0,0,0));
     	y = 10; x += 15;
     	
     	for(int i = 0; i < 30; i++) {
        	g2d.fillRect(x, y, 10, 10);	
        	y += 15;
        
      	              	  
        } // end of for loop
       
     	// draw filled ovals
     	
     	g2d.setColor(new Color(200,200,200)); // gray
     	y = 10; x += 15;
     	
     	for(int i = 0; i < 30; i++) {
        	g2d.fillOval(x, y, 10, 10);	
        	y += 15;
     	
     	} // end of for loop
     	
     	// text in the middle 
     	int width = getWidth();
     	int height = getHeight();
     	g2d.setColor(Color.RED);
     	String s = "I'm a graphics programmer now!!";
     	g2d.drawString(s, (width/2) - s.length() * 3, height / 2);
     	
     	// 2000 random magenta collored tick marks
     	g2d.setColor(Color.MAGENTA);
     	Random random = new Random();
     	for(int i = 0; i < 2000; i++) {
     	x = Math.abs(random.nextInt()) % width;
     	y = Math.abs(random.nextInt()) % height;
     	g2d.drawLine(x, y, x+2, y+2);
     		
     	} // end of for loop
     	
     	
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
