class JitterBug
{
  float x;
  float y;
  int diameter;
  float speed=2.5;
  
  JitterBug(float tempx,float tempy,int tempdiamter)
  {
    x=tempx;
    y=tempy;
    diameter=tempdiamter;
  }
  
  void move()
  {
    x+=random(-speed,speed);
    y+=random(speed,speed);
    
  }
  
  void display()
  {
    ellipse(x,y,diameter,diameter);
  }
}
