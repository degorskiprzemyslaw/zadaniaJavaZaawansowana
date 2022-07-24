package zbijak;

import java.util.Scanner;

public class ZbijakController {
    private Board board = new Board();
    private boolean running = true;
    private int turnCounter;


    public void startMenu(){
        board.initializeBoard(welcomeMessage());
        displayBoard();
        do {
            while(turnCounter < 2) {
                if(turnCounter == 0){
                    System.out.println("Twoja tura\n");
                }
                board.playerMovement(playerMovementDirection());
                board.checkIfBeatEnemy();

                    if(board.getEnemies().length ==0){
                        System.out.println("Koniec gry, zbiłeś wszystkich przeciwników");
                    displayBoard();
                    return;
                }
                displayBoard();
                turnCounter++;
            }
            if(turnCounter == 2){
                System.out.println("Tura przeciwnika \n");
            }


            board.enemyMovement();
            displayBoard();
            if(board.losingGame()){
                System.out.println("Pregrałeś, zostałeś zbity.");
                break;
            }
            turnCounter = 0;

        }while(true);
    }

    private String playerMovementDirection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kierunek ruchu");
        String direction = scanner.nextLine().toLowerCase();
        return direction;
    }



    private int welcomeMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t Gra w Zbijaka\n" + "\t\t---------------\n\n" +
                "\tWygrywasz, gdy zbijesz wszystkich przeciwników\n" +
                        "\tZbijesz przeciwnika, gdy wejdziesz na jego pole\n" +
                "\tPoruszasz się klawiszami:\nW - góra,\nS - dół, \nA - lewo, \nD - prawo\n\n" +
                "\tPodaj, wielkość planszy: ");
        int length = scanner.nextInt();
        return length;
    }

    private void displayBoard(){

        for(int i = 0; i < board.getLength(); i++){
            for(int j = 0; j < board.getLength(); j++){
                System.out.print(board.getBoard()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }






}
