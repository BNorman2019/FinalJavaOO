import java.io.*;
import java.util.Scanner;


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
		Scanner scanner = new Scanner(file);
		String header = scanner.nextLine();
		header.split(" ");

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

	public void modifyPixel(Scanner scanner)
	{
		System.out.println("What pixel would you like to modify? Enter x then y.");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		Pixel p = imageBase.getPixel(x, y);

		System.out.println("What values would you like to give the pixel? Enter r, g, then b.");
		int r = scanner.nextInt();
		int g = scanner.nextInt();
		int b = scanner.nextInt();

		p.setRed(r);
		p.setGreen(g);
		p.setBlue(b);
	}
}