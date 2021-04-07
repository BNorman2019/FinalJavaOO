import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    ArrayList<Pixel> list = new ArrayList<Pixel>();
    for(int i = 0; i < 10; i++)
    {
      Pixel pixel = new Pixel(i, i, i);
      list.add(pixel);
    }
    
  }
}