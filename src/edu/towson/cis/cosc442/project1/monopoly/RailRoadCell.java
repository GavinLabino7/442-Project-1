package edu.towson.cis.cosc442.project1.monopoly;

public class RailRoadCell extends Cell {
	static private int baseRent;
	static public String COLOR_GROUP = "RAILROAD";
	static private int price;

	/** 
	 * @param baseRent
	 * @set sets the base rent
	 */
	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	/** 
	 * @param price
	 * @set sets the price of a railroad cell
	 */
	public static void setPrice(int price) {
		RailRoadCell.price = price;
	}
	
	/** 
	 * @return int price of the railroad cell
	 */
	public int getPrice() {
		return RailRoadCell.price;
	}

	/** 
	 * @return int rent price
	 */
	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, theOwner.numberOfRR() - 1);
	}
	
	/**	(non-Javadoc)
	 * 
	 * @see play a turn
	 */
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				currentPlayer.payRentTo(theOwner, getRent());
			}
		}
	}
}
