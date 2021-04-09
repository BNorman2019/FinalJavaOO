import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PPM
{
	String identifier = "P6";
	String width;
	String height;
	String maxValue = "255";
	String outputFile = "output.ppm";
	Image imageBase;

	public PPM(Image image)
	{
		width = String.valueOf(image.getWidth());
		height = String.valueOf(image.getHeight());
		imageBase = image;
	}

	public void generatePPM()
	{
		String header = identifier + " " + width + " " + height + " " + maxValue + "\n";
		
		try
		{
			FileWriter myWriter = new FileWriter("output.txt");
        	myWriter.write(header);
			for(int i = 0; i < imageBase.getWidth(); i++)
			{
				for(int j = 0; j < imageBase.getHeight(); j++)
				{
					 myWriter.write(Integer.toBinaryString(imageBase.getPixel(i, j).getRed()) + ' ' + Integer.toBinaryString(imageBase.getPixel(i, j).getGreen()) + ' ' + Integer.toBinaryString(imageBase.getPixel(i, j).getBlue()) + '\t');
				}
			}
			

			myWriter.close();
		}
		catch(IOException e)
		{
			System.out.println("An error occurred.");
     		e.printStackTrace();
		}
		
	}

}