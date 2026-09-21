package edu.towson.cis.cosc442.project1.monopoly;

public class Die {
	/** 
	 * @return int dice roll
	 */
	public int getRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
