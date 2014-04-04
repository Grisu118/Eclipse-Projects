package ch.grisu118.diestaemme.foundenemy.business.Objects;

public class Player {
    /**
     * The number of villages of this Player.
     */
    private final int villages;
    /**
     * The points of this Player
     */
    private final int points;
    /**
     * The ingamename of this Player
     */
    private final String userName;
    /**
     * Array with the indices of the possible enemy targets.
     */
    private int[] targets;
    /**
     * Is true if this Player have enemys in his range.
     */
    private boolean hasTargets;
    
    public Player(String userName, int villages, int points) {
        this.villages = villages;
        this.points = points;
        this.userName = userName;
        this.hasTargets = false;
    }

    public int getVillages() {
        return villages;
    }

    public int getPoints() {
        return points;
    }

    public String getUserName() {
        return userName;
    }

    public void setTargets(int[] targets) {
        if (targets != null) {
            this.hasTargets = true;
            this.targets = targets;
        } else {
            this.hasTargets = false;
            this.targets = null;
        }

    }

    public int[] getTargets() {
        return targets;
    }

    public boolean hasTargets() {
        return hasTargets;
    }
    @Override
    public boolean equals(Object p) {

        if (p instanceof Player) {
            Player p1 = (Player) p;
            return this.points == p1.points && this.villages == p1.villages && this.userName.equals(p1.userName);
        } else
            return false;

    }
}
