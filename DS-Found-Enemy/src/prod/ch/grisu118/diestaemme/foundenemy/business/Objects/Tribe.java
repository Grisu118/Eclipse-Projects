package ch.grisu118.diestaemme.foundenemy.business.Objects;

public class Tribe {
    /**
     * The name of this Tribe. Should be not null or empty!
     */
    private final String tribeName;
    /**
     * The short name of this Tribe. Should be not null or empty!
     */
    private final String name;
    /**
     * The number of {@link Player} in this Tribe. Should not be smaller than one!
     */
    private final int memberCount;
    /**
     * The array with all Player's of this tribe.
     */
    private final Player[] members;
    /**
     * The index to remember the actual position of the Player on which we are working.
     */
    private int index = 0;

    /**
     * Creates a new Tribe Object
     * 
     * @param tName name of this Tribe. <b>Must not be null or empty!</b>
     * @param name short name of this Tribe. <b>Must not be null or empty!</b>
     * @param memberCount the number of {@link Player} in this Tribe. <b> muss be bigger than
     *            zero!</b>
     */
    public Tribe(String tName, String name, int memberCount) {
        if (tName == null || tName.equals(""))
            throw new IllegalArgumentException("illegal Tribe name");
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("illegal Tribe short name");
        if (memberCount < 1)
            throw new IllegalArgumentException("illegal memberCount");
        this.tribeName = tName;
        this.name = name;
        this.memberCount = memberCount;
        this.members = new Player[memberCount];
    }

    /**
     * Returns the name of this tribe.
     * 
     * @return name of this tribe.
     */
    public String getTribeName() {
        return tribeName;
    }

    /**
     * Returns the short name.
     * 
     * @return the short name of this tribe.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of {@link Player} in this tribe.
     * 
     * @return number of members.
     */
    public int getMemberCount() {
        return memberCount;
    }

    /**
     * Add a {@link Player} to the Player array. at the position of index.
     * 
     * @param player The Player which should be added to the array. <b>Must not be null!</b>
     */
    public void addPlayer(Player player) {
        if (player == null)
            throw new IllegalArgumentException("illegal player");
        members[index++] = player;
    }

    /**
     * Returns the {@link Player} on index id from the Player array.
     * 
     * @param id on which position is the requested Player is.
     * @return A Player which is a member of this Tribe.
     */
    public Player getPlayer(int id) {
        return members[id];
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tribe) {
            Tribe t = (Tribe) obj;
            return this.name.equals(t.getName()) && this.tribeName.equals(t.tribeName)
                    && this.memberCount == t.getMemberCount();
        } else
            return false;
    }
}
