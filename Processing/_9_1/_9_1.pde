JitterBug bug;

void setup()
{
  size(480,120);
  smooth();
  bug=new JitterBug(width/2,height/2,20);
}

void draw()
{
  bug.move();
  bug.display();
}
