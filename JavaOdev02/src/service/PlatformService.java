package service;

import model.Category;
import model.Movie;
import model.Platform;

import java.util.ArrayList;
import java.util.Scanner;

public class PlatformService {
	public void addPlatform(ArrayList<Platform> platformArrayList) {
		int exitStatus = 1;
		while (exitStatus == 1) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please enter the name of the platform you would like to add");
			String platformName = scn.nextLine();
			Platform newPlatform = new Platform(platformName);
			platformArrayList.add(newPlatform);
			System.out.println("Would you like to add another platform? (1 for yes, 0 for no)");
			try {
				exitStatus = scn.nextInt();
				if (exitStatus != 0 && exitStatus != 1) {
					System.out.println("Invalid input detected, exiting to admin panel");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input detected, exiting to admin panel");
				exitStatus = 0;
			}
		}
	}

	public void showPlatforms(ArrayList<Platform> platformArrayList) {
		if (platformArrayList.size() == 0) {
			System.out.println("There are no platforms");
			return;
		}
		for (int i = 0; i < platformArrayList.size(); i++) {
			System.out.println(i + ". " + platformArrayList.get(i).toString());
		}
	}
}
