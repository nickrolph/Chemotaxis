import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] numBac;
public void setup()   
{     
 	size(500,500) ; 
 	numBac = new Bacteria [24] ;
 for (int i = 0; i < numBac.length; ++i) 
 {
 	numBac [i] = new Bacteria((int)(Math.random()*500),(int)(Math.random()*500));
 }
 	
}   
public void draw()   
{
	frameRate(25);
 	background(240);
 	for (int j = 0; j < numBac.length; ++j) 
  {
  	//if (mousePressed == true ) 
 	 //{
 	 	//numBac[j].follow();
 	// }
 	// else 
 	// {
 	 	numBac[j].move();
 	// }
 	 for (int k = 0; k < numBac.length; ++k) 
  	{
	 if (mousePressed == true && (mouseX < numBac[k].locationXbob + 11 && mouseX  > numBac[k].locationXbob - 11 ) && (mouseY < numBac[k].locationYbob +11 && mouseY > numBac[k].locationYbob -11 ))
 	  	{
 	  		numBac[k].moveGrab();
 	  		numBac[k].showGrab();
 	  		numBac[j].follow();
 	  	}
 	  	else 
 	  	{
 	  		numBac[k].showNormal();
 		}
 	}

  }	  
}
 
 class Bacteria  
 {     
 	int locationXbob, locationYbob, yMove, xMove, bacColor;
 	  Bacteria(int x, int y)
 	  {
 	  	locationXbob = x;
 	  	locationYbob = y;
 	  	yMove = (int)(Math.random()*3)-1;
 	  	xMove = (int)(Math.random()*3)-1;
 	  	bacColor = (int)(Math.random()* 255);

 	  }
 	  public void move()
 	  {
 	  	if (Math.random() > .5f)
 	  	{
 	  		yMove = (int)(Math.random()*7)-3;
 	  		locationYbob = locationYbob + yMove;
 	  	}
 	  	else 
 	  	{
 	  		xMove = (int)(Math.random()*7)-3;
 	  		locationXbob = locationXbob + xMove;
 	  	}
 	  }
 	  public void follow()
 	  {
 	  	if (mouseX > locationXbob)
 	  	{
 	  		xMove = (int)(Math.random()*4);
 	  		locationXbob = locationXbob + xMove;

 	  	}
 	  	if (mouseX < locationXbob)
 	  	{
 	  		xMove = (int)(Math.random()*4);
 	  		locationXbob = locationXbob - xMove;
 	  		
 	  	}
 	  	if (mouseY > locationYbob)
 	  	{
 	  		yMove = (int)(Math.random()*4);
 	  		locationYbob = locationYbob + yMove;
 	  	}
 	  	if (mouseY < locationYbob)
 	  	{
 	  		yMove = (int)(Math.random()*4);
 	  		locationYbob = locationYbob - yMove;
 	  	}
 	  }
 	  public void moveGrab()
 	  {
 	  	locationYbob = mouseY;
 	    locationXbob = mouseX;
 	  }
 	  	
 	  public void showNormal()
 	  {
 	  	fill(0, bacColor, 0);
 	  	ellipse(locationXbob, locationYbob, 10, 10);

 	  }
 	  public void showGrab()
 	  {
 	  	fill(255, 0, 0);
 	  	ellipse(mouseX, mouseY, 10, 10);
 	  }
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
