package com.killian.mowItNow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.killian.mowItNow.entities.Lawn;
import com.killian.mowItNow.entities.LawnMower;
import com.killian.mowItNow.entities.Position;
import com.killian.mowItNow.runner.LawnMowerRunner;

public class MowItNowApplication {

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			throw new IllegalArgumentException();
		}

		String inputFile = args[0];
        LawnMowerRunner runner = parser(inputFile);
		//On éxecute les instructions des tondeuses;
		List<String> results = runner.run();
		for (String result : results) {
			System.out.println(result);
		}
	}

	private static LawnMowerRunner parser(String inputFile) throws IOException {
		LawnMowerRunner lawnMowerRunner = new LawnMowerRunner();

		//On lit le fichier
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));) {
			//On récupère la taille de la pelouse première ligne
            String[] lawnSize = reader.readLine().split(" ");
			//On crée l'objet pelouse
            Lawn lawn = new Lawn(Integer.parseInt(lawnSize[0]), Integer.parseInt(lawnSize[1]));

			List<LawnMower> lawnMowers = new ArrayList<>();
			//On boucle sur le reste du fichier pour récupèreer les infos des tondeuses
            String line;
            while ((line = reader.readLine()) != null) {
                String[] mowerInit = line.split(" ");
				//On récupère la position de la tondeuse
				Position position = new Position(Integer.parseInt(mowerInit[0]), Integer.parseInt(mowerInit[1]), mowerInit[2].charAt(0));
				//On récupère les instructions de la tondeuse
                String instructions = reader.readLine();
				//On crée la tondeuse
				LawnMower newLawnMower = new LawnMower(position, instructions);
				lawnMowers.add(newLawnMower);
            }

			//On configure la classe d'excecution
			lawnMowerRunner.setLawn(lawn);
			lawnMowerRunner.setLawnMowers(lawnMowers);
        } catch (IOException e) {
			throw e;
        }

		return lawnMowerRunner;
	}
}
