public class Pixel
{
  private int red;
  private int green;
  private int blue;

  public Pixel(int r, int g, int b)
  {
    this.red = r;
    this.green = g;
    this.blue = b;
  }
  /**
   * @return the red
   */
  public int getRed() {
    return red;
  }

  /**
   * @return the green
   */
  public int getGreen() {
    return green;
  }

  /**
   * @return the blue
   */
  public int getBlue() {
    return blue;
  }

  /**
   * @param red the red to set
   */
  public void setRed(int red) {
    this.red = red;
  }

  /**
   * @param green the green to set
   */
  public void setGreen(int green) {
    this.green = green;
  }

  /**
   * @param blue the blue to set
   */
  public void setBlue(int blue) {
    this.blue = blue;
  }
}