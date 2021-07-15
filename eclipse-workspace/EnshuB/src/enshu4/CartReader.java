//B9TB2174
//西川凜

package enshu4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CartReader {
	private HashMap<String, Integer> item;
	private boolean match = false;

	public CartReader(String fname) {
		BufferedReader br = null;
		item = new HashMap<String, Integer>();

		try {
			br = new BufferedReader(new FileReader(fname));
			String line;
			while ((line = br.readLine()) != null) {
				if(line.startsWith("//") || line.length() == 0) {
					continue;
				}
				String[] splt = line.split(",");
				splt[0] = splt[0].trim();
				splt[1] = splt[1].trim();
				for (String k : item.keySet()) {
					if(splt[0].equals(k)){
						int i = item.get(k);
						i += Integer.valueOf(splt[1]);
						item.remove(k);
						item.put(k, Integer.valueOf(i));
						match = true;
						break;
					}
				}
				if(match == false) {
					item.put(splt[0], Integer.valueOf(splt[1]));
				}
				

			}
			br.close();
		} catch (FileNotFoundException e1) {
			System.out.println(fname + "が見つかりませんで	した。");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printAll() {
		for (String k : item.keySet()) {
			System.out.println(k + " x" + item.get(k));
		}
	}

	public static void main(String[] args) {
		CartReader ct2 = new CartReader("input.txt");
		ct2.printAll();
	}
}