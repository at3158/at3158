float x;
int offset=10;

void setup()
{
  size(240,120);
  smooth();
  x=width/2;
}

void draw()
{
  background(204);
  
  if(mouseX>X)
  {
    x+=0.5;
    offset=-10;
  }
   
 if(mouseX<=X)
  {
    x-=0.5;
    offset=10;
  }

  line(x,0,x,height);
  line(mouseX,mouseY,mouseX+offset,mouseY-10);
  line(mouseX,mouseY,mouseX+offset,mouseY+10);
  line(mouseX,mouseY,mouseX+offset*3,mouseY);
}
