package escapeRoom;

public class Window {
    private boolean opened;

    public void openAWindow(){
        opened = true;
    }

    public void closeAWindow(){
        opened = false;
    }



    public boolean isOpened() {
        return opened;
    }




}
