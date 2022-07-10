package automat;

import java.util.Scanner;

public class GameMachineController {


    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.addGame(new Game("Unravel 2", 59));
        gameMachine.addGame(new Game("Prince of Persia", 41));
        gameMachine.addGame(new Game("LittleBigPlanet 3", 28));
        gameMachine.addGame(new Game("The Legend of Zelda: Breath of the Wild", 32));

        try{
            gameMachine.buyAGame();
        } catch (NoSuchTitleException | NotEnoughMoneyException e){
            System.out.println(e.getMessage());

        }
    }

}




    /*public String getGameTitleFromUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }*/

