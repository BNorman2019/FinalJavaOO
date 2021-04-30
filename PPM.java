import java.io.*;
import java.util.*;


public class PPM
{
	String identifier = "P3";
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
		try
		{
			File thing = new File(file);
			Scanner scanner = new Scanner(thing);
			String header = scanner.nextLine();
			//header = scanner.nextLine();
			String[] arrOfStr = header.split(" ");

			if(arrOfStr[0].equals(identifier))
			{
				width = arrOfStr[1];
				height = arrOfStr[2];
				maxValue = arrOfStr[3];
				ArrayList<Column> list = new ArrayList<Column>();

				for(int i = 0; i < Integer.parseInt(height); i++)
				{
					String line = scanner.nextLine();
					String[] split = line.split("\\t+");
					ArrayList<Pixel> pixelList = new ArrayList<Pixel>();
					//System.out.println(Arrays.toString(split));
					
					
					for(int j = 0; j < Integer.parseInt(width); j++)
					{
						char[] rgb = split[j].toCharArray();
						Pixel pixel = new Pixel(Character.getNumericValue(rgb[0]), Character.getNumericValue(rgb[2]), Character.getNumericValue(rgb[4]));
						//System.out.println(String.valueOf(pixel.getRed()));
						pixelList.add(pixel);
					}
					Column column = new Column(pixelList);
					list.add(column);
				}
				scanner.close();
				Image base = new Image(list, Integer.parseInt(width), Integer.parseInt(height));
				imageBase = base;

				/*for(int i = 0; i < list.size(); i++)
				{
					for(int j = 0; i < list.get(i).getSize(); i++)
					{
						System.out.println(list.get(i).getPixel(j).getRed());
					}
				}*/
			}
			else
			{
				System.out.println("FAIL");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

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
					//System.out.println(imageBase.getPixel(j, i).getRed());
					myWriter.write(Integer.toString(imageBase.getPixel(j, i).getRed()) + ' ' + Integer.toString(imageBase.getPixel(j, i).getGreen()) + ' ' + Integer.toString(imageBase.getPixel(j, i).getBlue()) + '\t');
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