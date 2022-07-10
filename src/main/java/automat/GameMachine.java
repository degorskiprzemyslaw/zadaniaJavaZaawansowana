package automat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMachine {
    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void buyAGame() throws NoSuchTitleException, NotEnoughMoneyException {
        String gameName = getGameTitleFromUser();


        for (Game game : games) {
            if (game.getGameTitle().equals(gameName)) {
                int gamePrice = getMoneyFromUser(game);
                    if (gamePrice > game.getGamePrice()) {
                        System.out.println("Dziękuję za zakup. Zwracam resztę w wysokości: " + (gamePrice - game.getGamePrice()) + " zł");
                        return;
                    } else if (gamePrice == game.getGamePrice()) {
                        System.out.println("Dziękuję za zakup. Miłego dnia!");
                        return;
                    } else {

                        throw new NotEnoughMoneyException("Wrzucona suma pieniędzy jest za mała");
                    }

            }

        }
        throw new NoSuchTitleException("Nie znaleziono tytułu");

    }

    public void assessMoneyValue(Game game) throws NotEnoughMoneyException {

        int gamePrice = getMoneyFromUser(game);
        if (gamePrice > game.getGamePrice()) {
            System.out.println("Dziękuję za zakup. Zwracam resztę w wysokości: " + (gamePrice - game.getGamePrice()) + " zł");
            return;
        } else if (gamePrice == game.getGamePrice()) {
            System.out.println("Dziękuję za zakup. Miłego dnia!");
            return;
        } else {

            throw new NotEnoughMoneyException("Wrzucona suma pieniędzy jest za mała");
        }
    }


    private String getGameTitleFromUser() {
        System.out.println("Wybierz grę, którą chcesz zakupić: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    private int getMoneyFromUser(Game game) {
        System.out.println("Zaplac " + game.getGamePrice() + " zł");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    @Override
    public String toString() {
        return "GameMachine{" +
                "games=" + games +
                '}';
    }
}

    /*Dla chętnych:
        Projekt Automat
        Tworzymy aplikację dla automatu, w którym można kupić gry komputerowe. Automat przechowuje kilka najnowszych
        tytułów. Każda gra opisana jest za pomocą nazwy i ceny.

        Działanie automatu jest następujące:

        użytkownik wpisuje na ekranie nazwę gry, którą chce wypożyczyć
        użytkownik wrzuca do do automatu pieniądze (zakładamy pełne złotówki, bez groszy)
        Użytkownik powinien zobaczyć w odpowiedzi, że grę udało się kupić lub, że dana gra nie
        została odnaleziona.
        Dodatkowo jeśli użytkownik wrzucił zbyt mało pieniędzy powinien
        zobaczyć komunikat o zbyt małej kwocie, a jeśli wpłacił zbyt dużo pieniędzy, to powinien
        otrzymać resztę.

        Zdefiniuj następujące klasy:

        Game - pojedyncza gra,
        GameMachine - przechowuje kilka gier i pozwala je kupić. W sytuacji, gdy użytkownik próbuje zakupić grę, której
         nie ma w automacie lub wpłacił zbyt mało pieniędzy rzuć w metodzie obsługującej zakup odpowiednie wyjątki
         zdefiniowane przez siebie,
        GameMachineController - klasa interakcji z użytkownikiem, jest to jedyne miejsce w programie, gdzie powinno być
        wyświetlanie oraz wczytywanie danych od użytkownika.

        Oprócz tego może istnieć dodatkowa klasa startowa lub inne klasy, które uznasz za stosowne.*/

