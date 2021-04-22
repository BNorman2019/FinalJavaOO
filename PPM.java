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

	public PPM(String file)
	{

	}

	public void generatePPM(String fileName)
	{
		String header = identifier + " " + width + " " + height + " " + maxValue + "\n";
		
		try
		{
			FileWriter myWriter = new FileWriter(fileName + ".txt");
        	myWriter.write(header);
			for(int i = 0; i < imageBase.getHeight(); i++)
			{
				for(int j = 0; j < imageBase.getWidth(); j++)
				{
					 myWriter.write(Integer.toBinaryString(imageBase.getPixel(j, i).getRed()) + ' ' + Integer.toBinaryString(imageBase.getPixel(j, i).getGreen()) + ' ' + Integer.toBinaryString(imageBase.getPixel(j, i).getBlue()) + '\t');
				}
				myWriter.write('\n');
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