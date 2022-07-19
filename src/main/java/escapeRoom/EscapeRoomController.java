package escapeRoom;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EscapeRoomController {
    private int input;
    private Window window = new Window();
    private Door door = new Door();
    private Key key = new Key();
    private Player player = new Player();
    private boolean running = true;



    public void startGame(){
        System.out.println("Witaj w Escape Roomie.");
        Scanner scanner = new Scanner(System.in);

        do{
            try{
                askAQuestion(scanner);

                switch(input){
                    case 1:
                        moveAWindow();
                        break;

                    case 2:
                        moveADoor();
                        break;

                    case 3:
                        moveAKey();
                        break;

                    default:
                        System.out.println("Nie ropoznano wyboru.");

                }
            } catch(InputMismatchException e){
                System.out.println("Nie rozpoznano wyboru\n");
                startGame();
            }
        }while(running);




    }

    private void moveAKey() {
        key.takeAKey();
        System.out.println("Wziąłeś klucz");
    }

    private void moveADoor() {
        if (key.isTaken()){
            door.openADoor();
            System.out.println("Udało Ci się otworzyć drzwi i wyjść z pokoju!");
            running = false;
        }
        else{
            System.out.println("Nie można otworzyć drzwi, ponieważ są zamkniete.");
        }
    }

    private void moveAWindow() {
        if (window.isOpened()){
            window.closeAWindow();
            System.out.println("Okno zostało zamknięte");
        }
        else{
            window.openAWindow();
            System.out.println("Okno zostało otwarte");
        }
    }

    private void askAQuestion(Scanner scanner) {
        getMenuText();
        input = scanner.nextInt();
    }

    private void getMenuText() {
        System.out.println("Wybierz, który przedmiot chciałbyś użyć:");
        if(key.isTaken()){
            System.out.println("1. Okno \n" + "2. Drzwi \n\n" + "Posiadane: klucz" );
        }else{
            System.out.println("1. Okno \n" + "2. Drzwi \n" + "3. Klucz \n\n" + "Posiadane: -");
        }
    }


}
