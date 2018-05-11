package repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Pack;
import model.Skin;
import model.Weapon;
import model.types.Rarity;

public class Reader {
	public static BufferedReader b;
	private static final String SKINS_FILE = "data/input/skins.dat";
	private static final String WEAPONS_FILE = "data/input/weapons.dat";
	private static final String PACKS_FILE = "data/input/packs.dat";

	public static HashMap<String, Skin> loadSkin() {
		List<String> lines = readFile(SKINS_FILE);
		HashMap<String, Skin> skins = new HashMap<>();
		for (String line : lines) {
			String[] data = line.split("@");
			String id = data[0];
			String name = data[1];
			String description = data[2];
			float price = Float.parseFloat(data[3]);
			Rarity type = Rarity.valueOf(data[4]);
			Skin skin = new Skin(id, name, description, price, type);
			skins.put(skin.getId(), skin);
		}
		return skins;
	}

	public static HashMap<String, Weapon> loadWeapon() {
		List<String> lines = readFile(WEAPONS_FILE);
		HashMap<String, Weapon> weapons = new HashMap<>();
		for (String line : lines) {
			String[] data = line.split("@");
			String id = data[0];
			String name = data[2];
			Rarity rarity = Rarity.valueOf(data[3]);
			int magazine = Integer.parseInt(data[8]);
			int damage = Integer.parseInt(data[5]);
			int envDamage = Integer.parseInt(data[6]);
			float dps = Float.parseFloat(data[4]);
			float fireRate = Float.parseFloat(data[7]);
			float reloadTime = Float.parseFloat(data[9]);
			String image = data[1];
			Weapon weapon = new Weapon(id, name, rarity, magazine, damage,
					envDamage, dps, fireRate, reloadTime, image);
			weapons.put(weapon.getId(), weapon);
		}
		return weapons;
	}

	public static HashMap<String, Pack> loadPacks() {
		List<String> lines = readFile(PACKS_FILE);
		HashMap<String, Pack> packs = new HashMap<>();
		for (String line : lines) {
			String[] data = line.split("@");
			String idPack = data[0];
			String idSkin = data[1];
			String idWeapon = data[2];
			Pack pack = new Pack(idPack, idSkin, idWeapon);
			packs.put(pack.getIdPack(), pack);
		}
		return packs;
	}

	private static List<String> readFile(String file) {
		List<String> lines = new ArrayList<>();
		try {
			b = new BufferedReader(new FileReader(file));
			while (b.ready()) {
				lines.add(b.readLine());
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("El archivo fichero " + file + " no se encontro");
		} catch (IOException e) {
			new RuntimeException(
					"Error de entrada/salida con el fichero " + file);
		}
		return lines;
	}

}
