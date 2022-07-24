package zbijak;

import java.util.Random;
import java.util.Scanner;

public class Board {

    private int length;
    private FieldType[][] fieldTypes;
    private FieldType playerField = FieldType.PLAYER;
    private Player player = new Player();
    private FieldType[] enemiesField = {FieldType.ENEMY, FieldType.ENEMY, FieldType.ENEMY};

    private Player[] enemies = {new Player(), new Player(), new Player()};


    public void initializeBoard(int length) {
        //board = new Board(length);
        this.length = length;
        fieldTypes = new FieldType[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                fieldTypes[i][j] = FieldType.EMPTY;
            }
        }
        int playerXPosition = playerStartingPosition()[0];
        player.setxPosition(playerXPosition);
        int playerYPosition = playerStartingPosition()[1];
        player.setyPosition(playerYPosition);
        fieldTypes[playerXPosition][playerYPosition] = playerField;

        for (int i = 0; i < enemiesField.length; i++) {
            int enemyXPosition;
            int enemyYPosition;
            do {
                enemyXPosition = enemyStartingPosition()[0];
                enemies[i].setxPosition(enemyXPosition);
                enemyYPosition = enemyStartingPosition()[1];
                enemies[i].setyPosition(enemyYPosition);
            }
            while (fieldTypes[enemyXPosition][enemyYPosition] != FieldType.EMPTY);
            fieldTypes[enemyXPosition][enemyYPosition] = enemiesField[i];

        }

    }


    public void playerMovement(String direction) {

        switch (direction) {
            case "w":
                if (player.getxPosition() > 0) {
                    fieldTypes[player.getxPosition()][player.getyPosition()] = FieldType.EMPTY;
                    player.setxPosition(player.getxPosition() - 1);
                }
                fieldTypes[player.getxPosition()][player.getyPosition()] = playerField;
                break;

            case "s":
                if (player.getxPosition() < length - 1) {
                    fieldTypes[player.getxPosition()][player.getyPosition()] = FieldType.EMPTY;
                    player.setxPosition(player.getxPosition() + 1);
                    fieldTypes[player.getxPosition()][player.getyPosition()] = playerField;
                }
                break;
            case "a":
                if (player.getyPosition() > 0) {
                    fieldTypes[player.getxPosition()][player.getyPosition()] = FieldType.EMPTY;
                    player.setyPosition(player.getyPosition() - 1);
                    fieldTypes[player.getxPosition()][player.getyPosition()] = playerField;
                }
                break;

            case "d":
                if (player.getyPosition() < length - 1) {
                    fieldTypes[player.getxPosition()][player.getyPosition()] = FieldType.EMPTY;
                    player.setyPosition(player.getyPosition() + 1);
                    fieldTypes[player.getxPosition()][player.getyPosition()] = playerField;
                }
                break;

            default:
                break;
        }
    }



    public void enemyScanMovementForPlayer(int i){ // nie dziala
        boolean isUpAble = true;
        boolean isDownAble = true;
        boolean isLeftAble = true;
        boolean isRightAble = true;
        int scanUp;
        int scanDown;
        int scanLeft;
        int scanRight;
        //for(int i = 0; i < enemies.length; i++){
            scanUp = enemies[i].getxPosition() - 1;
            scanDown = enemies[i].getxPosition() + 1;
            scanLeft = enemies[i].getyPosition() - 1;
            scanRight = enemies[i].getyPosition() + 1;
            if(scanUp < 0){
                isUpAble = false;
            }
            if(scanDown > length - 1){
                isDownAble = false;
            }
            if(scanLeft < 0){
                isLeftAble = false;
            }
            if(scanRight > length - 1){
                isRightAble = false;
            }
            if(scanUp == player.getxPosition() && enemies[i].getyPosition() == player.getyPosition() && isUpAble){
                enemyUpMovement(i);
            }

            if(scanDown == player.getxPosition() && enemies[i].getyPosition() == player.getyPosition() && isDownAble){
                enemyDownMovement(i);
            }

            if(scanLeft == player.getyPosition() && enemies[i].getxPosition() == player.getxPosition() && isLeftAble){
                enemyLeftMovement(i);
            }

            if(scanRight == player.getyPosition() && enemies[i].getxPosition() == player.getxPosition() && isRightAble){
                enemyRightMovement(i);
            }

        }

    //}

    public void enemyMovement() {
        Random r = new Random();
        for (int i = 0; i < enemies.length; i++) {
            if ((Math.abs(player.getxPosition() - enemies[i].getxPosition()) == 1 && player.getyPosition() == enemies[i].getyPosition())
                    || (Math.abs(player.getyPosition() - enemies[i].getyPosition()) == 1 && (player.getxPosition() == enemies[i].getxPosition()))) {
                enemyScanMovementForPlayer(i);
            }

            else {
                int direction = r.nextInt(4);
                switch (direction) {
                    case 0: //up
                        if (enemies[i].getxPosition() > 0) {
                            enemyUpMovement(i);
                        } else if (enemies[i].getxPosition() == 0 && enemies[i].getyPosition() == 0) { //up left corner
                            movementIfUpperLeftCorner(i);
                        } else if (enemies[i].getxPosition() == 0 && enemies[i].getyPosition() == length - 1) { //up right corner
                            movementIfUpperRightCorner(i);
                        } else {
                            movementIfUpperWall(i);
                        }
                        break;

                    case 1: //down
                        if (enemies[i].getxPosition() < length - 1) {
                            enemyDownMovement(i);
                        } else if (enemies[i].getxPosition() == length - 1 && enemies[i].getyPosition() == 0) { //down left corner
                            movementIfLowerLeftCorner(i);
                        } else if (enemies[i].getxPosition() == length - 1 && enemies[i].getyPosition() == length - 1) { //down right corner
                            movementIfLowerRightCorner(i);
                        } else {
                            movementIfLowerWall(i);
                        }
                        break;
                    case 2: // left
                        if (enemies[i].getyPosition() > 0) {
                            enemyLeftMovement(i);
                        } else if (enemies[i].getxPosition() == 0 && enemies[i].getyPosition() == 0) { //up left corner
                            movementIfUpperLeftCorner(i);
                        } else if (enemies[i].getxPosition() == length - 1 && enemies[i].getyPosition() == 0) { //down left corner
                            movementIfLowerLeftCorner(i);
                        } else {
                            movementIfLeftWall(i);
                        }
                        break;


                    case 3: //right
                        if (enemies[i].getyPosition() < length - 1) {
                            enemyRightMovement(i);
                        } else if (enemies[i].getxPosition() == 0 && enemies[i].getyPosition() == length - 1) { //up right corner
                            movementIfUpperRightCorner(i);
                        } else if (enemies[i].getxPosition() == length - 1 && enemies[i].getyPosition() == length - 1) { //down right corner
                            movementIfLowerRightCorner(i);
                        } else {
                            movementIfRightWall(i);
                        }
                        break;

                    default:
                        break;
                }
            }
        }}


    private void movementIfUpperLeftCorner(int i) {
        Random r3 = new Random();
        int direction2 = r3.nextInt(2);
        switch (direction2) {
            case 0:
                enemyDownMovement(i);
                break;
            case 1:
                enemyRightMovement(i);
                break;

        }
    }

    private void movementIfUpperRightCorner(int i) {
        Random r3 = new Random();
        int direction2 = r3.nextInt(2);
        switch (direction2) {
            case 0:
                enemyDownMovement(i);
                break;
            case 1:
                enemyLeftMovement(i);
                break;

        }
    }

    private void movementIfLowerLeftCorner(int i) {
        Random r3 = new Random();
        int direction2 = r3.nextInt(2);
        switch (direction2) {
            case 0:
                enemyUpMovement(i);
                break;
            case 1:
                enemyRightMovement(i);
                break;

        }
    }

    private void movementIfLowerRightCorner(int i) {
        Random r3 = new Random();
        int direction2 = r3.nextInt(2);
        switch (direction2) {
            case 0:
                enemyUpMovement(i);
                break;
            case 1:
                enemyLeftMovement(i);
                break;

        }
    }

    private void movementIfRightWall(int i) {
        Random r2 = new Random();
        int direction2 = r2.nextInt(3);
        switch (direction2) {
            case 0:
                enemyDownMovement(i);
                break;
            case 1:
                enemyLeftMovement(i);
                break;
            case 2:
                enemyUpMovement(i);
                break;
        }
    }

    private void movementIfLeftWall(int i) {
        Random r2 = new Random();
        int direction2 = r2.nextInt(3);
        switch (direction2) {
            case 0:
                enemyDownMovement(i);
                break;
            case 1:
                enemyUpMovement(i);
                break;
            case 2:
                enemyRightMovement(i);
                break;
        }
    }

    private void movementIfUpperWall(int i) {
        Random r2 = new Random();
        int direction2 = r2.nextInt(3);
        switch (direction2) {
            case 0:
                enemyDownMovement(i);
                break;
            case 1:
                enemyLeftMovement(i);
                break;
            case 2:
                enemyRightMovement(i);
                break;
        }
    }

    private void movementIfLowerWall(int i) {
        Random r2 = new Random();
        int direction2 = r2.nextInt(3);
        switch (direction2) {
            case 0:
                enemyUpMovement(i);
                break;
            case 1:
                enemyLeftMovement(i);
                break;
            case 2:
                enemyRightMovement(i);
                break;
        }
    }

    public boolean losingGame() {
        for (Player enemy : enemies) {
            if (enemy.getxPosition() == player.getxPosition() && enemy.getyPosition() == player.getyPosition())
                return true;
        }
        return false;
    }

    public void checkIfBeatEnemy() {
        boolean beatEnemy = false;
        int beatCounter;
        for (int i = 0; i < enemies.length; i++) {
            if (player.getxPosition() == enemies[i].getxPosition() && player.getyPosition() == enemies[i].getyPosition()) {
                enemies[i] = null;
                beatEnemy = true;
                break;

            }
        }


        Player[] enemiesTemp = new Player[enemies.length - 1];
        //Player enemiesTemp = new Player();
        if (beatEnemy) {
            beatCounter = enemies.length - 1;
            System.out.println("Zbiłeś przeciwnika! Zostało do zbicia jeszcze " + beatCounter);
            for(int i = 0; i < enemies.length; i++){
                if(enemies[i] == null){
                    for(int j = i; j < enemies.length - 1; j++){
                       enemies[j] = enemies[j+1];
                    }
                }
            }
            for(int i = 0; i< enemiesTemp.length; i++){
                enemiesTemp[i] = enemies[i];
            }


            /*for (int i = 0; i < enemies.length - 1; i++)
                {
                for (int j = i; j < enemies.length; j++) {
                    if (enemies[j] != null) {
                        enemiesTemp[i] = enemies[j];
                        break;
                    }
                }
            }*/
                /*{

                if(enemies[i] == null){
                    enemiesTemp = enemies[i];
                    enemies[enemies.length - 1] = enemies[i];
                    enemiesTemp = enemies[enemies.length - 1];
                }
            }
            for (int i = 0; i < enemiesTemps.length; i++){
                enemiesTemps[i] = enemies[i];
            }*/


                /*{
                for (int j = 0; j < enemies.length; j++) {
                    if (enemies[j] != null) {
                        enemiesTemp[i] = enemies[j];
                        break;
                    }
                }
            }*/
            enemies = enemiesTemp;


        }
    }


    private void enemyRightMovement(int i) {
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = FieldType.EMPTY;
        enemies[i].setyPosition(enemies[i].getyPosition() + 1);
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = enemiesField[i];
    }

    private void enemyLeftMovement(int i) {
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = FieldType.EMPTY;
        enemies[i].setyPosition(enemies[i].getyPosition() - 1);
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = enemiesField[i];
    }

    private void enemyDownMovement(int i) {
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = FieldType.EMPTY;
        enemies[i].setxPosition(enemies[i].getxPosition() + 1);
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = enemiesField[i];
    }

    private void enemyUpMovement(int i) {
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = FieldType.EMPTY;
        enemies[i].setxPosition(enemies[i].getxPosition() - 1);
        fieldTypes[enemies[i].getxPosition()][enemies[i].getyPosition()] = enemiesField[i];
    }


    private int[] playerStartingPosition() {
        Random random = new Random();
        int playerPositionX = random.nextInt(length);
        int playerPositionY = random.nextInt(length);
        return new int[]{playerPositionX, playerPositionY};
    }

    private int[] enemyStartingPosition() {
        Random random = new Random();
        int enemyPositionX = random.nextInt(length);
        int enemyPositionY = random.nextInt(length);
        return new int[]{enemyPositionX, enemyPositionY};
    }


    public int getLength() {
        return length;
    }

    public FieldType[][] getBoard() {
        return fieldTypes;
    }


    public Player[] getEnemies() {
        return enemies;
    }
}
