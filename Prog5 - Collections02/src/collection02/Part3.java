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
import java.util.TreeMap;

public class Part3 {
	public static TreeMap<String, Integer> readTreeMap = new TreeMap<>();
	private static TreeMap<Character, Integer> mapPoints1 = new TreeMap<>();

	public static void points() {
		BufferedReader br;
		Scanner txtFile = new Scanner(System.in);
		File alice = new File("Alice.txt");
		String line;
		long time1, time2;
		time1 = System.nanoTime();
		try {
			br = new BufferedReader(new FileReader(alice));
			br.readLine();
			while((line=br.readLine())!=null) {
				String line2 = line.replaceAll("[^a-zA-Z]","").toLowerCase();
				readTreeMap.put(line2, 0);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		time2 = System.nanoTime();
		System.out.println("Time for loading into TreeMap " + (time2 - time1) + " nano-seconds");
		Scanner points;
		try {
			points = new Scanner(new FileReader("pointValue.txt"));
			while (points.hasNextLine()) {
				mapPoints1.put(points.next().charAt(0), Integer.parseInt(points.next()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (String i : readTreeMap.keySet()) {
          String word = i;
          int score = 0;
          for (int j = 0; j < word.length(); j++) {
            if (mapPoints1.containsKey(word.charAt(j))) {
              score += mapPoints1.get(word.charAt(j));
            }
          }
          readTreeMap.replace(i, score);
        }
		System.out.println("Using TreeMap");
		time1 = System.nanoTime();
		Iterator treeIt = readTreeMap.entrySet().iterator();
		int totalScore = 0;
		int entries = 0;
		Map.Entry k = (Map.Entry)treeIt.next(); 
		for (Integer l : readTreeMap.values()) {
			totalScore = totalScore + l;
			entries++;
				
		}
		System.out.println("Total Entries: "+entries);
		System.out.println("Total Score: "+totalScore);
		System.out.println();
		time2 = System.nanoTime();
		System.out.println("Time for counting entries and tallying Score " + (time2 - time1) + " nano-seconds");
		System.out.print("Press any key to continue . . . ");
		String cont = txtFile.nextLine();
		System.out.println();
		
		
	

}
private static HashMap<String, Integer> readHashMap = new HashMap<>();
private static HashMap<Character, Integer> mapPoints = new HashMap<>();
	
	public static void points2()  {
		BufferedReader br;
		Scanner txtFile = new Scanner(System.in);
		File alice = new File("Alice.txt");
		String line;
		long time1, time2;
		time1 = System.nanoTime();
		try {
			br = new BufferedReader(new FileReader(alice));
			br.readLine();
			while((line=br.readLine())!=null) {
				String line2 = line.replaceAll("[^a-zA-Z]","").toLowerCase();
				readHashMap.put(line2, 0);
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
				mapPoints1.put(points.next().charAt(0), Integer.parseInt(points.next()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (String i : readHashMap.keySet()) {
          String word = i;
          int score = 0;
          for (int j = 0; j < word.length(); j++) {
            if (mapPoints1.containsKey(word.charAt(j))) {
              score += mapPoints1.get(word.charAt(j));
            }
          }
          readHashMap.replace(i, score);
        }
		
		System.out.println("Using HashMap");
		time1 = System.nanoTime();
		Iterator hashIt = readHashMap.entrySet().iterator();
		
		int totalScore = 0;
		int entries = 0;
		Map.Entry k = (Map.Entry)hashIt.next(); 
		for (Integer l : readHashMap.values()) {
			totalScore = totalScore + l;
			entries++;
				
		}
		System.out.println("Total Entries: "+entries);
		System.out.println("Total Score: "+totalScore);
		
		System.out.println();
		
		time2 = System.nanoTime();
		System.out.println("Time for Counting Entries and tallying Score " + (time2 - time1) + " nano-seconds");
		System.out.print("Press any key to continue . . . ");
		String cont = txtFile.nextLine();
		System.out.println();
	}
	

}