import java.util.ArrayList;

public class Column
{
  private ArrayList<Pixel> pixelList = new ArrayList<Pixel>();

  public Column(ArrayList<Pixel> list)
  {
    this.pixelList = list;
  }

  public void addPixelToColumn(Pixel pixel)
  {
    pixelList.add(pixel);
  }

  //public Pixel getPixelFromColumn(int element)
  //{
  //  return pixelList.get(element);
  //}

  


}