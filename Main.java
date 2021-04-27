import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) 
  	{
		System.out.println("Are you creating (1) or modifying (2) a ppm?");
		Scanner console = new Scanner(System.in);

		int choice = console.nextInt();

	  	if(choice == 1)
	  	{
			System.out.println("Name your file.");
			String fileName = console.next();
			Image image = new Image(10, 50);
			PPM ppm = new PPM(image);
			ppm.generatePPM(fileName);
	  	}
		else
		{
			System.out.println("Input file name");
			String file = console.next();
			PPM ppm = new PPM(file + ".txt");
			choice = 0;
			while(choice != 4)
			{
				System.out.println("Would you like to modify a pixel (1), a row (2), or "
				+ "the entire picture (3)? You can also stop editing with (4).");
				choice = console.nextInt();
				switch(choice)
				{
					case 1:
					ppm.modifyPixel(console);
					break;
					case 2:
					//modifyRow();
					break;
					case 3:
					//modifyImage();
					break;
					default:
				}
			}
		}
  	}

}