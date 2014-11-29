

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class HighScoreList {
	
	public static final int ANZAHL_DER_SCORES = 10;
	private static String value;
	private static String key;
	private File file;
	private TreeMap<Integer, String> list;
	
	/**
	 * initialize File and list
	 * 
	 */
	public HighScoreList() {
		this.file = new File("HighScore.txt");
		this.list = loadList();
	}
	
	/**
	 * add a new score to the list
	 * 
	 * @param name - name of the player
	 * @param points - points that the player has reached
	 */
	public void newScore(String name, int points) {
		loadList();
		FileWriter writer;
		this.list.put(points, name);
		
		try {
			writer = new FileWriter(this.file, false);
			
			for(int i = 0; i < pointsAsArray().length; i++)
				writer.write(namesAsArray()[i] + " " + pointsAsArray()[i] + "\r\n");
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadList();
	}
	
	private TreeMap<Integer, String> loadList() {
		TreeMap<Integer, String> map = new TreeMap<>();
		Scanner s;
		String line;
		String[] token;
		int pos = 0;
		
		try {
			s = new Scanner(file);
			while(s.hasNextLine() && pos < ANZAHL_DER_SCORES) {
				line = s.nextLine();
				token = line.split(" ");
				map.put(Integer.parseInt(token[1]), token[0]);
				pos++;
			}
			
			s.close();
			
		} catch (FileNotFoundException e) {
			map.put(0, "");
			return map;
		}
		
		return map;
	}
	
	/**
	 * names of the players in the list. The name of the highest score is at
	 * the end of the string
	 * 
	 * @return all the names in the list as string
	 */
	public String names() {
		loadList();
		value = "";
		BiConsumer<Integer, String> values = (x, y) -> value += y + " ";
		this.list.forEach(values);
		return value;
	}
	
	/**
	 * all names in the list as array. The name of the highest score is at 
	 * the beginning of the array
	 * 
	 * @return all names in the list as a string array
	 */
	public String[] namesAsArray() {
		int length = (names().split(" ")).length;
		String[] names;
		
		if(length < ANZAHL_DER_SCORES)
			names = new String[length];
		else
			names = new String[ANZAHL_DER_SCORES];
		
		for(int i = 0; i < names.length; i++)
			names[i] = (names().split(" "))[length-i-1];
			
		return names;
	}
	
	/**
	 * scores of the players in the list. The highest score is at the end of 
	 * the string
	 * 
	 * @return all the scores in the list as string
	 */
	public String points() {
		loadList();
		key = "";
		BiConsumer<Integer, String> keys = (x, y) -> key += x + " ";
		this.list.forEach(keys);
		return key;
	}
	
	/**
	 * all scores in the list as array. The highest score is at the beginning of 
	 * the array
	 * 
	 * @return all scores in the list as an integer array
	 */
	public int[] pointsAsArray() {
		int length = (points().split(" ")).length;
		int[] points;
		
		if(length < ANZAHL_DER_SCORES)
			points = new int[length];
		else
			points = new int[ANZAHL_DER_SCORES];
		
		for(int i = 0; i < points.length; i++)
			points[i] = Integer.parseInt((points().split(" "))[length-i-1]);
		
		return points;
	}
	
	/**
	 * returns the highscore list
	 * 
	 * @return the highscore list as treemap
	 */
	public TreeMap<Integer, String> getList() {
		return this.list;
	}
	
	private void setList(TreeMap<Integer, String> map) {
		this.list = map;
	}
	
	/**
	 * returns the name of the file
	 * 
	 * @return the name of the file as file
	 */
	public File getFile() {
		return this.file;
	}
	
	private void setFile(File location) {
		this.file = location;
	}
	
	/**
	 * returns the object as string:
	 * 1Platz Name Punkte
	 * 2Platz Name Punkte
	 * @return
	 */
	public String print() {
		String txt = "HighScore";
		
		
		
		for(int i = 0; i < pointsAsArray().length; i++) {
			txt += (i + 1) + "Platz: " + namesAsArray()[i] + " " + pointsAsArray()[i] + "\n";
		}
		
		return txt;
	}
	
}