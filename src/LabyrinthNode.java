/**
 * Construct a single labyrinth node made out of enum. Contains properties
 * passable, entrance and exit.
 */
public enum LabyrinthNode {
	// characters of each types of node
	PATH(true, false, false), WALL(false, false, false), ENTRANCE(true, true,
			false), EXIT(true, false, true);

	// properties
	private final boolean isPassable;
	private final boolean isEntrance;
	private final boolean isExit;

	/**
	 * Constructor, include three properties
	 */
	LabyrinthNode(boolean passable, boolean entrance, boolean exit) {
		isPassable = passable;
		isEntrance = entrance;
		isExit = exit;
	}

	/**
	 * Check if passable
	 */
	public boolean isPassable() {
		return isPassable;
	}

	/**
	 * Check if entrance
	 */
	public boolean isEntrance() {
		return isEntrance;
	}

	/**
	 * Check if exit
	 */
	public boolean isExit() {
		return isExit;
	}

	/**
	 * Display properties of each node type
	 */
	public String toString() {
		String result = super.toString();

		if (isPassable())
			result += " is Passable";
		else
			result += " is not Passable";

		if (isEntrance())
			result += ", Entrance,";

		if (isExit())
			result += ", Exit";

		return result;
	}

	/**
	 * Display nodes
	 */
	public String drawNode() {
		String result = "";

		if (isEntrance())
			result += "E";
		else if (isExit())
			result += "X";
		else if (isPassable())
			result += "_";
		else
			result += "#";

		return result;
	}

	/**
	 * Run the program
	 */
	public static void main(String[] args) {
		for (LabyrinthNode l : LabyrinthNode.values()) {
			System.out.println(l.toString());
		}
	}
}
