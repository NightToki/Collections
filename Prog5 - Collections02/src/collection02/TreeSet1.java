package collection02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSet1 {
	public static TreeSet<String> readTreeSet = new TreeSet<>();
	public static void alice() {
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
				readTreeSet.add(line2);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		time2 = System.nanoTime();
		System.out.println("Elapsed time for loading TreeSet: " + (time2 - time1) + " nano-seconds");
		String[] hash100 = new String[100]; // creates a stirng that can hold 100 things
		Random rand = new Random();
		Iterator<String> hSetIt = readTreeSet.iterator();
		int randHash = rand.nextInt(readTreeSet.size());
		int count = 0;
		int i = 0;
		time1 = System.nanoTime();
		while(hSetIt.hasNext() && i < hash100.length){
			String temp = hSetIt.next();
			if(count == randHash){
				hash100[i] = temp;
				i++;
				hSetIt = readTreeSet.iterator();
			}
			count++;
		}
		time2 = System.nanoTime();
		System.out.println("Elapsed time for searching TreeSet: " + (time2 - time1) + " nano-seconds");
		System.out.print("Press any key to continue . . . ");
		String cont = txtFile.nextLine();
		System.out.println();
		
	}
	
	

}
