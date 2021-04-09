import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Image image = new Image(10, 50);
	PPM ppm = new PPM(image);
	ppm.generatePPM();
    
  }
}