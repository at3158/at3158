PImage img;

void setup()
{
  size(720,720);
  img=loadImage("835605568.jpg");
}

void draw()
{
  background(0);
  image(img,0,0,mouseX*2,mouseY*2);
}
