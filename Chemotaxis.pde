Bacteria [] numBac;
void setup()   
{     
 	size(500,500) ; 
 	numBac = new Bacteria [24] ;
 for (int i = 0; i < numBac.length; ++i) 
 {
 	numBac [i] = new Bacteria((int)(Math.random()*500),(int)(Math.random()*500));
 }
 	
}   
void draw()   
{
	frameRate(25);
 	background(240);
 	for (int j = 0; j < numBac.length; ++j) 
  {
 	 	numBac[j].move();
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
 void keyPressed()
 {
 	if (key == 'r') 
{
	for (int i = 0; i < numBac.length; ++i) 
 {
 	numBac [i] = new Bacteria((int)(Math.random()*500),(int)(Math.random()*500));
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
 	  void move()
 	  {
 	  	if (Math.random() > .5)
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
 	  void follow()
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
 	  void moveGrab()
 	  {
 	  	locationYbob = mouseY;
 	    locationXbob = mouseX;
 	  }
 	  	
 	  void showNormal()
 	  {
 	  	fill(0, bacColor, 0);
 	  	ellipse(locationXbob, locationYbob, 10, 10);

 	  }
 	  void showGrab()
 	  {
 	  	fill(255, 0, 0);
 	  	ellipse(mouseX, mouseY, 10, 10);
 	  }
 }   
