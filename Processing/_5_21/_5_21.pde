int x=214;

void setup()
{
  size(480,120);
}

void draw()
{
  if(keyPressed&&(key==CODED))
  {
    if(keyCode==LEFT)
    {
      x--;
    }
     if(keyCode==RIGHT)
    {
      x++;
    }
  }
  rect(x,40,50,50);
}
