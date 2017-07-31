package MarsRovers;

public class Direction {
	public enum CompassDirections {
        NORTH('N') , WEST('W') , EAST('E') , SOUTH('S') ;

        private char directionShortName;
        private CompassDirections(char s){
              this.directionShortName = s;
        }

        @Override
        public String toString() {
            return String.valueOf(this.directionShortName);
        }
    }
	public CompassDirections compassDirection;
	public Direction left;
	public Direction right;

	public Direction(CompassDirections cD){
		this.compassDirection = cD;
	}
	
	public static Direction convertToDirection(char orientation) throws Exception{
		Direction north = new Direction(CompassDirections.NORTH);
		Direction east = new Direction(CompassDirections.EAST);
		Direction south = new Direction(CompassDirections.SOUTH);
		Direction west = new Direction(CompassDirections.WEST);
		
		north.right=east; north.left=west;
		east.right=south; east.left=north;
		south.right=west; south.left=east;
		west.right=north; west.left =south;

		
		switch (orientation) {
		case 'N': return north;
		case 'E': return east;
		case 'W': return west;
		case 'S': return south;
		default: 
			throw new RoverInputErrors("Direction is invalid, use only [N,E,S,W]: ");
		}
	}
}
