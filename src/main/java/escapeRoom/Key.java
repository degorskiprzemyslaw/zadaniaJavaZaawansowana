package escapeRoom;

public class Key {

    private boolean taken;
    //private Player player = new Player();


    public void takeAKey(){
        taken = true;
        //player.setHasAKey(true);

    }

    public boolean isTaken() {
        return taken;
    }
}


