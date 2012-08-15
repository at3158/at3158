void setup()
{
  size(120,120);
  smooth();
}

void draw()
{
  background(204);
  if(keyPressed)
  {
    if((key=='h'))
    {
      line(30,60,90,60);
    }
    if(key=='n')
    {
      line(30,20,90,100);
    }
  }
  
  line(30,20,30,100);
  line(90,20,90,100);
}
