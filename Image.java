import java.util.ArrayList;

public class Image
{
	private ArrayList<Column> image = new ArrayList<Column>();
	private int width;
	private int height;

	public Image()
	{
		int count = 1;
		for(int i = 0; i < 10; i++)
		{
			Column column = new Column();
			for(int f = 0; f < 10; f++)
			{
				Pixel pixel = new Pixel(count, count, count);
				column.addPixel(pixel);
				count++;
			}
			image.add(column);
		}
		width = 10;
		height = 10;
	}

	public Image(ArrayList<Column> list, int width, int height)
	{
		this.image = list;
		this.height = height;
		this.width = width;
	}

	public Image(int width, int height)
	{
		this.width = width;
		this.height = height;
		for(int i = 0; i < width; i++)
		{
			Column column = new Column();
			for(int f = 0; f < height; f++)
			{
				Pixel pixel = new Pixel(0, 0, 0);
				column.addPixel(pixel);
			}
			image.add(column);
		}
	}

	public Column getColumn(int column)
	{
		return image.get(column);
	}

	public Pixel getPixel(int x, int y)
	{
		return image.get(x).getPixel(y);
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight()
	{
		this.height = height;
	}
}