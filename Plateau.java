package MarsRovers;

import java.util.Scanner;

public class Plateau {
	public int maxX;
	public int maxY;

    private Plateau(){}
	public static Plateau setTopCoordinates(){
		String[] coordinates = getTopCoordinates();
		Plateau plateau = new Plateau();
		try {
			plateau.maxX = Integer.parseInt(coordinates[0]);
			plateau.maxY = Integer.parseInt(coordinates[1]);
		} catch (Exception e) {
			System.out.println("Error input! TRY AGAIN.\n");
			Plateau.setTopCoordinates();
		}
		return plateau;
	}

    private static String[] getTopCoordinates(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the top plateau coordinate: ");
        String topCoordinate = input.nextLine();
        return topCoordinate.split(" ");
    }

	public boolean hasPoint(int x,int y){
        boolean doesNotExceedX = (x >= 0) && (x <= this.maxX);
        boolean doesNotExceedY = (y >= 0) && (y <= this.maxY);
		return (doesNotExceedX && doesNotExceedY)? true: false;
	}
}
