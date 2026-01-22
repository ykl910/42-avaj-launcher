package app;

import utils.WeatherProvider;
import utils.Coordinates;
import utils.InvalidTypeException;
import aircraft.AircraftFactory;
import tower.WeatherTower;
import flyables.Flyable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
	
	private static void run(String filename) {
		WeatherProvider wp = WeatherProvider.getInstance();
		AircraftFactory af = AircraftFactory.getInstance();
		WeatherTower wt = new WeatherTower();
		int nbChange = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String firstLine = br.readLine();
			if (firstLine == null || firstLine.trim().isEmpty()) {
				System.err.println("Empty first line");
				return;
			}
			nbChange = Integer.parseInt(firstLine.trim());
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				String[] parts = line.split(" ");
				if (parts.length != 5) {
					System.err.println("Error: Invalid line: " + line);
					return;
				}
				String type = parts[0];
				String name = parts[1];
				int lon = Integer.parseInt(parts[2]);
				int lat = Integer.parseInt(parts[3]);
				int hei = Integer.parseInt(parts[4]);
				Coordinates coor = new Coordinates(lon, lat, hei);
				try {
					Flyable f = af.newAircraft(type, name, coor);
					f.registerTower(wt);					
				} catch (InvalidTypeException e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error: Unknown file");
		}
		for(int i = 0; i < nbChange; i++) {
			wt.changeWeather();
		}	
	}

	public static void main(String[] args) {
		if (args.length != 	1) {
			System.out.println("only one parameter allowed");
			return;
		} 
		try {
			PrintStream fileOut = new PrintStream("simulation.txt");
			System.setOut(fileOut);
			run(args[0]);
			fileOut.close();
		}
		catch (Exception e) {
			System.err.println("Error: cannot create output file");
		}
	}
}

