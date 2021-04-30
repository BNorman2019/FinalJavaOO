import java.util.ArrayList;

public class Column
{
  private ArrayList<Pixel> pixelList = new ArrayList<Pixel>();

	public Column(){}

  public Column(ArrayList<Pixel> list)
  {
    this.pixelList = list;
  }

  public void addPixel(Pixel pixel)
  {
    pixelList.add(pixel);
  }

  public Pixel getPixel(int element)
  {
    return pixelList.get(element);
  }

  public int getSize()
  {
	  return pixelList.size();
  }
}