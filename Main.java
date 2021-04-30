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
			Image image = new Image(50, 50);
			PPM ppm = new PPM(image);
			ppm.generatePPM(fileName);
	  	}
		else
		{
			System.out.println("Input file name");
			String file = console.next();
			PPM ppm = new PPM(file + ".txt");
			choice = 0;
			while(choice == 1)
			{
				ppm.modifyPixel(console);
				ppm.generatePPM(file);

				System.out.println("Are you done modifying? Press 1 if yes, 2 if no.");
				choice = console.nextInt();
			}
		}
  	}

}