import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Input from console
 * @author 
 *
 */
public class Input {
 // saves all input, each one separate
	ArrayList<String> inputStrList = new ArrayList<String>();

	/**
	 * read the input, is still waiting for an input each time it is called.
	 * all Upper-Case inputs are ignored
	 */
	public void readConsole() {
		BufferedReader console = new BufferedReader(new InputStreamReader(
		        System.in));
		System.out.print("Geben Sie etwas ein: ");
		String zeile = null;
		try {
			zeile = console.readLine();

		} catch (IOException e) {

			return;
		}

		
		if (!this.isUpperCase(zeile)) {
			 inputStrList.add(zeile);
		}
	}
	/**
	 * filter to check if forbidden Upper-Case is used
	 * @param the Input-String
	 * @return if is Upper-case true, else false
	 */

	private boolean isUpperCase(String str) {

		int tmp;
		for (int i = 0; i < str.length(); i++) {

			tmp = str.charAt(i);
			
			if (tmp < 91 && tmp > 64) {
				return true;
			}

		}

		return false;

	}

	/**
	 * @return the inputString
	 */
	public ArrayList<String> getInputString() {
		return inputStrList;
	}

	/**
	 * @param inputString
	 *            the inputString to set
	 */
	public void setInputString(ArrayList<String> inputString) {
		this.inputStrList = inputString;
	}
	/**
	 * get the last entry from inputStringList.
	 * @return the last entry as String
	 */

	public String getLastInput() {
		if (inputStrList.size() > 0) {
			return inputStrList.get(inputStrList.size() - 1);

		}
		return "";
	}

}
