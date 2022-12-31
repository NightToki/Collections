package collection02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMap1 {
	private static HashMap<String, Integer> readHashMap = new HashMap<>();
	private static HashMap<Character, Integer> mapPoints = new HashMap<>();

	
	public static void points() {
		BufferedReader br;
		Scanner txtFile = new Scanner(System.in);
		File qWords = new File("q not followed by a u.txt");
		String line;
		long time1, time2;
		time1 = System.nanoTime();
		try {
			br = new BufferedReader(new FileReader(qWords));
			br.readLine();
			while((line=br.readLine())!=null) {
				readHashMap.put(line, 0);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		time2 = System.nanoTime();
		System.out.println("Time for loading into HashMap " + (time2 - time1) + " nano-seconds");
		Scanner points;
		try {
			points = new Scanner(new FileReader("pointValue.txt"));
			while (points.hasNextLine()) {
				mapPoints.put(points.next().charAt(0), Integer.parseInt(points.next()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (String i : readHashMap.keySet()) {
          String word = i;
          int score = 0;
          for (int j = 0; j < word.length(); j++) {
            if (mapPoints.containsKey(word.charAt(j))) {
              score += mapPoints.get(word.charAt(j));
            }
          }
          readHashMap.replace(i, score);
        }
		System.out.println("Using HashMap");
		time1 = System.nanoTime();
		Iterator hashIt = readHashMap.entrySet().iterator();
		while(hashIt.hasNext()){
			Map.Entry k = (Map.Entry)hashIt.next();
			System.out.println(k.getKey() + " --> " + k.getValue());
		}
		System.out.println();
		time2 = System.nanoTime();
		System.out.println("Time for printing HashMap " + (time2 - time1) + " nano-seconds");
		System.out.print("Press any key to continue . . . ");
		String cont = txtFile.nextLine();
		System.out.println();
	}
	

}
