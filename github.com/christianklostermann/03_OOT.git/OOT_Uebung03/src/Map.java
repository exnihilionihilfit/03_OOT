/**
 * Represents the game-board
 * dimension of 5x5
 * @author
 *
 */

public class Map {

	private String[][] map;
	private String[] mapNum = { "A", "B", "C", "D", "E" };
	// dimension of the map
	private int mapX;
	private int mapY;
	private String[][] oldMap;
	
	

	public Map() {
		this.mapX = 5;
		this.mapY = 5;
		
	}

	/**
	 * @return the map
	 */
	public String[][] getMap() {
		return map;
	}

	/**
	 * @param map
	 *            the map to set
	 */
	public void setMap(String[][] map) {
		this.oldMap = this.map; // the last state before a chance is saved her
		this.map = map;
	}

	/**
	 * format and print the map
	 */

	public void printMap() {

		String print = "";
		if (map != null) {

			print = "\n";

			for (int i = 0; i < map.length; i++) {
				print += "" + mapNum[i] + "|  ";
				for (int k = 0; k < map.length; k++) {

					print += " " + map[i][k] + " ";

				}
				print += "\n\n";
			}
			print += "___________________________________\n";
			print += "      1    2    3    4    5   \n";
		}
		System.out.println(print);
	}

	/**
	 * 
	 * craetes a new map
	 */

	public void newMap() {
		this.map = new String[this.mapX][this.mapY];

		for (int i = 0; i < this.map.length; i++) {
			for (int k = 0; k < this.map.length; k++) {

				this.map[i][k] = " * ";

			}
		}
		
		
	}
	/**
	 * saves the old map 
	 * not used yet.
	 */
	public void saveMap(){
		this.oldMap = this.map;
		
		
	}

	public boolean isChange() {
	
		if (this.map != null && this.oldMap != null) {

			if (oldMap.equals(map)) {
				
				return false;
			}else{
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the mapX
	 */
	protected int getMapX() {
		return mapX;
	}

	/**
	 * @param mapX the mapX to set
	 */
	protected void setMapX(int mapX) {
		this.mapX = mapX;
	}

	/**
	 * @return the mapY
	 */
	protected int getMapY() {
		return mapY;
	}

	/**
	 * @param mapY the mapY to set
	 */
	protected void setMapY(int mapY) {
		this.mapY = mapY;
	}

	/**
	 * just for testing, sets an char at 
	 * the point on the map wich given by 
	 * console input.
	 * @param moveOrder
	 */
	public void moveToken(int[] moveOrder) {
	    
		this.map[moveOrder[0]][moveOrder[1]] = " X ";
	    
    }

}
