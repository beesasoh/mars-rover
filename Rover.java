package MarsRovers;

import java.util.Scanner;


public class Rover {
	private int xCoordinate;
	private int yCoordinate;
    private String controlString;
	private Direction direction;
	private Plateau plateau;
	
	public Rover(){
	}
	
	public Rover(Plateau p){
		this.plateau = p;
	}
	
	public void start(){
		Plateau plateau = Plateau.setTopCoordinates();
		while(true){
			Rover rover = new Rover(plateau);
			rover.setInitialPosition();
			rover.getControlString();
			rover.processControlString();
		}
	}
	
	private void setInitialPosition(){
		String[] coordinates = getInitialRoverPosition();
		try {
			positionRover(coordinates);
		}catch(RoverInputErrors e){
			System.out.println("Point entered is not on the Plateau. Try again \n");
			setInitialPosition();
		}catch (Exception e) {
			System.out.println("Error input! TRY AGAIN \n");
			setInitialPosition();
		}
	}
	
	private static String[] getInitialRoverPosition(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the initial rover position: ");
		String roverPosition = input.nextLine();
		return roverPosition.split(" ");
	}
	
	private void positionRover(String[] position) throws Exception{
		this.xCoordinate = Integer.parseInt(position[0]);
		this.yCoordinate = Integer.parseInt(position[1]);
		if(!this.plateau.hasPoint(this.xCoordinate,this.yCoordinate)){
			throw new RoverInputErrors("Point not on the plateau");
		}
		char orientation = position[2].toUpperCase().charAt(0);
		this.direction = Direction.convertToDirection(orientation);
	}
	
	private  void getControlString(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter control string: ");
        this.controlString = input.nextLine().toUpperCase();
	}
	
	private void processControlString(){
		for(int i=0; i < controlString.length(); i++){
			if(controlString.charAt(i)== 'L') this.turnLeft();
			else if(controlString.charAt(i)=='R') this.turnRight();
			else if(controlString.charAt(i)=='M') this.move();
		}
		System.out.println("=> " + this.xCoordinate+" "+ this.yCoordinate +" "+ this.direction.compassDirection);
		System.out.print("================================\n\n");
	}
	
	private void turnLeft(){
		this.direction = this.direction.left;
	}
	
	private void turnRight(){
		this.direction = this.direction.right;
	}
	
	private void move(){
		switch (this.direction.compassDirection) {
		case NORTH:
			if(this.yCoordinate<this.plateau.maxY) this.yCoordinate++;
			break;
		case SOUTH:
			if(this.yCoordinate>0) this.yCoordinate--;
		break;
		case WEST:
			if(this.xCoordinate>0) this.xCoordinate--;
		break;
		case EAST:
			if(this.xCoordinate<this.plateau.maxX) this.xCoordinate++;
		break;
		}
	}
}
