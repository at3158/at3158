Robot bot1;
Robot bot2;

void setup()
{
  size(720,480);
  bot1=new Robot("robot1.svg",90,80);
  bot2=new Robot("robot2.svg",440,30);
}

void draw()
{
  background(204);
  
  bot1.update();
  bot1.display();
  
  bot2.update();
  bot2.display();
}

class Robot
{
  
  float xpos;
  float ypos;
  float angle;
  PShape botShape;
  float yoffset=0.0;
  
  Robot(String svgname,float tempx,float tempy)
  {
    //botShape=loadShape(svgname);
    botShape=loadShape("robot1.svg");
    xpos=tempx;
    ypos=tempy;
    angle=random(0,TWO_PI);
  }
  
  void update()
  {
    angle+=0.05;
    yoffset=sin(angle)*20;
  }
  
  void display()
  {
    shape(botShape,xpos,ypos+yoffset);
  }
  
  
}
