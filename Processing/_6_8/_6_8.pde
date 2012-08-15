PFont font;
String quote="GOOD DAY";

void setup()
{
  size(480,120);
  font=loadFont("Andalus-48.vlw");
  textFont(font);
}

void draw()
{
  background(102);
  text(quote,26,30,240,100);
}
