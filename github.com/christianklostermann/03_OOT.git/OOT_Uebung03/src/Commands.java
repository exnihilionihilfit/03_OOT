/**
 * Commands which are needed to navigate through
 * the game and give orders for the game-board  
 * @author 
 *
 */
public class Commands {

	// possible commands for input
	String[] commands = { "/start", "/end", "/back", "/forward", "/restart",
	        "/save", "/load","/high","/debug" };

	String aktualCommand = null;
	int mapX;
	int mapY;
	int[] charRange = { 49, 0, 97, 0 };// //Number[0][1] ///Char[2][3]
	int[] moveOrder;
	String[][] map;

	private Map mapObj;

	/**
	 * The map size is set needed for range of chars and number of the input
	 * like b2c4 , only numbers and chars in range are considered
	 * 
	 * charRange is set uses to get the Range of char in the Ascii-table 48 to
	 * 57 for Numbers , 0 is excluded 98 to 129 for down-case chars
	 */

	public Commands() {

		this.mapX = 5;
		this.mapY = 5;

		charRange[1] = charRange[0] + mapX - 1; // numbers
		charRange[3] = charRange[2] + mapY - 1; // down-case letters

	}

	/**
	 * searches for possible commands if the string size is not 0. firstly it
	 * checks for an token move-order secondly for an token put order
	 * 
	 * then for menu commands
	 * 
	 * @param str
	 *            input String
	 */
	void findeCommand(String str) {

		if (str.length() > 0) {

			// if its an move order example b4c2
			if (str.length() == 4) {

				int charOne = str.charAt(0);
				int charTwo = str.charAt(1);
				int charThree = str.charAt(2);
				int charFour = str.charAt(3);

				// / numbers
				if (charOne >= charRange[2] && charOne <= charRange[3]
				        && charThree >= charRange[2]
				        && charThree <= charRange[3]) {
					// / chars
					if (charTwo >= charRange[0] && charTwo <= charRange[1]
					        && charFour >= charRange[0]
					        && charFour <= charRange[1]) {
						System.out.println("spiel stein gesetzt");

						System.out.println(charOne - charRange[2] + "  ");
						System.out.println(charTwo - charRange[0]);

						this.moveOrder = new int[4];

						this.moveOrder[0] = charOne - charRange[2];
						this.moveOrder[1] = charTwo - charRange[0];

						this.moveOrder[2] = charThree - charRange[2];
						this.moveOrder[3] = charFour - charRange[0];

						this.aktualCommand = "/moveToken";

					}

				}

			}

			// if its a speacial move order
			if (str.length() == 2) {

			}

			// test if its a command
			if (str.charAt(0) == '/') {

				// deletes all whitespaces
				str = str.replaceAll("\\s+", "");

				// searches test if command is in the list
				for (String tmpStr : commands) {

					if (tmpStr.equals(str)) {
						System.out.println("Kommando: " + tmpStr
						        + " wird ausgeführt");

						this.aktualCommand = tmpStr;

					}
				}

			}
		}
	}

	/**
	 * @return the list of menu commands ( like /end, /start )
	 */
	protected String getCommands() {
		String erg = "Befehle: \t";

		for (String str : this.commands) {
			erg += str + " ";
		}
		return erg;
	}

	/**
	 * @param aktualCommand
	 *            the aktualCommand to set
	 */
	protected void setAktualCommand(String aktualCommand) {
		this.aktualCommand = aktualCommand;
	}

	/**
	 * @return the aktualCommand the last one who input with the console
	 */
	protected String getAktualCommand() {
		if (this.aktualCommand != null) {
			return aktualCommand;
		} else {
			return null;
		}
	}
	
	/**
	 * set the map Object, needed for internal use
	 * not sure if this is truely needed.
	 * @param map
	 */

	public void setMap(Map map) {
		this.mapObj = map;

	}

}
