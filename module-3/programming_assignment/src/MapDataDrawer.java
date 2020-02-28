// Daniel Oh
// CSCI 165
// Map elevation 

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


class MapDataDrawer extends JPanel {
	
	public static int[][] map;
	public static String filename; 

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public MapDataDrawer() {
        initUI();
    }
    
    private void initUI() {
    	int[] size = MapData.fileSize(filename);
    	int x = 16 + size[1];
    	int y = 39 + size[0];
    	
        window.add(this);
        window.setTitle("Elevation Map");
        window.setSize(x, y);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g , map);
        System.out.printf("%nThe index of the lowest elevation path is: %d",indexOfLowestElevPath(g, map));
        drawLowestElevPath(g, 226 ,map, "G");
  
    }
    
    private int indexOfLowestElevPath(Graphics g, int[][] map) {
    	int[] array = new int[map.length];
    	
    	
    	
    	for (int i = 0; i < array.length; i++) 
    		array[i] = drawLowestElevPath(g, i, map, "Red");
    	
    	int index = 0;
    	int min = array[0]; 
    	
    	for (int i = 0; i < array.length; i++) {
    		if (array[i] < min) {
    		min = array[i];
    		index = i;
    		
    		} // end of if 
    				
    		

    	} // end of for loop
    	return index;
    	
    	
    } // end of index of lowest elevation path
    
    private void drawMap(Graphics g, int[][] map) {
    
		Graphics2D g2d = (Graphics2D) g;
		
		
        int MIN = MapData.findMin(map);
        int MAX = MapData.findMax(map);
        int RANGE = MAX - MIN;
        
        // c = color
        int cMin = 0;
        int cMax = 255;
 
        int height = 1;
        int width = 1;
        
        double difference;
        double percentage;
        double value;
        double shadeValue;
        int shade;
        
        // drawing map 
        for(int row = 0; row < map.length; row++) {
        	for (int column = 0; column < map[row].length; column++) {
        		
        		// find gray scale
        		value = map[row][column]; 
        		difference = (value - MIN);
        		percentage = difference / RANGE;
        		shadeValue = (((cMax) * percentage) + cMin);
        		shade = (int) shadeValue;
        		
        		// set color and draw 
        		g2d.setColor(new Color(shade, shade, shade));
        		g2d.fillRect(column, row, width, height);
        	
                	    		 
        	} // end of nested loop
        	
        		
        } // end of for loop
	} // end of drawMap
    
    private int drawLowestElevPath(Graphics g, int row, int [][] map, String color) {

        Graphics2D g2d = (Graphics2D) g;
        
        
        // drawing path 
        int height = 1;
        int width = 1;
        int col = 1;
        int currentValue;
        int up, step, down;
        int ele1, ele2, ele3;
        int dif1, dif2, dif3;
        int minChange;
        int totalEle = 0; 
        
        
        //set color (green or red)
        if (color == "G" || color == "green")
        	g2d.setColor(Color.GREEN);
        else
        	g2d.setColor(Color.RED);
        
        
        
        //staring place
        g2d.fillRect(col, row, width, height);;
        
        while (col < map[0].length) {
        	if (row == 0 || row == map.length - 1) {
        		
        		currentValue = map[row][col - 1];
        		
        		step = map[row][col];
        		ele2 = currentValue - step;
        		dif2 = Math.abs(ele2);
        		
        		if (row == 0) {
        			
    	        	down = map[row + 1][col];       			     			
    	        	ele3 = currentValue - down;	        	  	        	
    	        	dif3 = Math.abs(ele3);
        			
        			if (dif2 > dif3) {
        				// take a step down
        				g2d.fillRect(col, row + 1, width, height);
        				row++;
        				col++;
        				totalEle += ele3;
        				
        			} else {
        				
        				// take a step
	        			g2d.fillRect(col, row, width, height);
	            		col++;
	            		totalEle += ele2;
        				
        			}
        			
        			
        		} else {
        			up = map[row - 1][col];    	           	    
    	        	ele1 = currentValue - up;   	        	    	        	
    	        	dif1 = Math.abs(ele1);
    	        	
    	        	if (dif2 > dif1) {
        				// take a step down
        				g2d.fillRect(col, row - 1, width, height);
        				row--;
        				col++;
        				totalEle += ele1;
        				
        			} else {
        				
        				// take a step
	        			g2d.fillRect(col, row, width, height);
	            		col++;
	            		totalEle += ele2;
        			}
    	        	
    	        	
        		} // end of nested 
        			
        		
        		
        	} else {
        		
	        	up = map[row - 1][col];
	        	step = map[row][col];
	        	down = map[row + 1][col];
	        	currentValue = map[row][col - 1];
	        	
	        	ele1 = currentValue - up;
	        	ele2 = currentValue - step;
	        	ele3 = currentValue - down;
	        	
	        	dif1 = Math.abs(ele1);
	        	dif2 = Math.abs(ele2);
	        	dif3 = Math.abs(ele3);
	        	
	        	minChange = MapData.leastChange(dif1, dif2, dif3);
	        	
	        	
	        	
	        	// Case 4
	        	if (dif1 == dif3 && dif1 == minChange) {
	        		
	        		// tossing a coin
	        		if (Math.random() < 0.5) { // step up
	        			g2d.fillRect(col, row - 1, width, height);
	        			// moving current row
	        			row--;
	        			col++;
	        			totalEle += ele1;
	        		
	        		} else { // step down
	        			g2d.fillRect(col, row + 1, width, height);
	        			// moving current row
	        			row++;
	        			col++;
	        			totalEle += ele3;
	        			
	        		} // end of nested if and else
	        		
	        	
	        	// Case 3
	        	} else if ((dif2 == dif3 || dif2 == dif1) && dif2 == minChange) {
	        		//  take a step
	        		g2d.fillRect(col, row, width, height);
	        		col++;
	        		totalEle += ele2;
	        	
	        	// Case 2
	        	} else {
	        	
	        		// finding the minimal change 
	          		if (dif1 == minChange) {
	        			// take a step up
	        			g2d.fillRect(col, row - 1, width, height);
	        			row--;
	        			col++;
	        			totalEle += ele1;
	        			
	        			
	        		} else if (dif2 == minChange) {
	        			// take a step
	        			g2d.fillRect(col, row, width, height);
	            		col++;
	            		totalEle += ele2;
	        			
	        		} else {
	        			// take a step down
	        			g2d.fillRect(col, row + 1, width, height);
	        			// moving current row
	        			row++;
	        			col++;
	        			totalEle += ele3;
	        		} //
	        		
	        	} // end of else
	        		
	  
	        
	        	
	        		
        	}
        } // end of while
   
        return totalEle;
        	
    } // end of find lowest elevation 
         	
    public static void main(String[] args) {
    	
    	map = MapData.MapDataArray(args[0]);
    	filename = args[0];
    	
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                MapDataDrawer ex = new MapDataDrawer();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
