package zbijak;

public enum FieldType {

    PLAYER("[&]"), ENEMY("[X]"), EMPTY("[ ]");

    private String playerType;

    FieldType(String playerType) {
        this.playerType = playerType;
    }

    @Override
    public String toString() {
        return playerType;
    }
}
