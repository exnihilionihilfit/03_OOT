public class Main {

	// All needed Objects
	private Output op;
	private Input in;

	private Map map;
	private Save save;
	private Commands com;
	private HighScoreList high;
	private SaveContainer saveCon;
	public static boolean debug = false;

	/**
	 * set all needed Object then run the game
	 */
	public Main() {

		this.op 	 = new Output();
		this.in		 = new Input();
		this.save	 = new Save();
		this.saveCon = new SaveContainer();
		this.map 	 = new Map();
		this.com 	 = new Commands(); // need map size for range of move
		                           // commands
		this.high	 = new HighScoreList();
		run();

	}

	/**
	 * only needed to start the game by init. the game itself
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Contains a while-loop
	 * 
	 * firstly some out-puts (the list of Commandos you can use)
	 * 
	 * secondly it checks for an aktual Command, by checking the last entry in
	 * the ArrayList in obj. input.
	 * 
	 * third if an command is set, and the game board was created the board will
	 * drawn each time the board is chanced
	 * 
	 * fours waiting for new input
	 * 
	 * Fifth check if new entry is a command
	 */

	public void run() {

		System.out.println(com.getCommands());

		while (true) {

			if (debug) {
				System.out.println("Gesamte Eingabe: "
				        + in.getInputString().toString());
			}
			if (com.getAktualCommand() != null) {

				System.out.println("Letzter Befehl: " + com.getAktualCommand());

				if (com.getAktualCommand().equals("/save")) {
					op.print("Spiel gespeichert.");
					
					
					save.saveMap("savegame", map.getMap());

				} else if (com.getAktualCommand().equals("/load")) {
					op.print("Spiel geladen.");				
					map.setMap(save.loadMap());

				} else if (com.getAktualCommand().equals("/end")) {
					System.out.println("Spiel beended.");

					break;
				} else if (com.getAktualCommand().equals("/start")) {
					System.out.println("Neues Spiel..");

					com.setMap(this.map);
					map.newMap();
				} else if (com.getAktualCommand().equals("/moveToken")) {
					map.moveToken(com.moveOrder);

				} else if (com.getAktualCommand().equals("/high")) {
			
					
					op.printHigh(this.high.print());
				}else if(com.getAktualCommand().equals("/debug")){
					if(Main.debug){
						Main.debug = false;
						
					}else{
						Main.debug = true;
					}
					op.printDebug();
				}

				com.setAktualCommand(null);
				com.moveOrder = null;
				op.printMap(map);
			}

			in.readConsole();
			com.findeCommand(in.getLastInput());

		}

	}
}
