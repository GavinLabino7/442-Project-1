package edu.towson.cis.cosc442.project1.monopoly;

public class UtilityCell extends Cell {

	public static final String COLOR_GROUP = "UTILITY";
	private static int PRICE;

	/** 
	 * @param price
	 * @set sets the price of a utility cell
	 */
	public static void setPrice(int price) {
		UtilityCell.PRICE = price;
	}

	/** 
	 * @return int price of utility
	 */
	public int getPrice() {
		return UtilityCell.PRICE;
	}

	/** 
	 * @param diceRoll
	 * @return int of dice roll * 4 or 10 depending on numberOfUtil()
	 */
	public int getRent(int diceRoll) {
		if(theOwner.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (theOwner.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	/**	(non-Javadoc)
	 * 
	 * @implNote Goes through a players turn and checks if they have to pay rent
	 */
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				GameMaster.instance().utilRollDice();
				int diceRoll = GameMaster.instance().getUtilDiceRoll();
				currentPlayer.payRentTo(theOwner, getRent(diceRoll));
			}
		}
	}
}
