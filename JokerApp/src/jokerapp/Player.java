package jokerapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static jokerapp.Ticket.fillPlayersTicket;

public class Player {

    private String name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }

    public static void createPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please type name of player. If you do not wish to add any more players, "
                + "please type 'stop' and press Enter. ");
        String name = in.next();
        while (!name.equals("stop")) {
            Player player = new Player(name);
            List<Ticket> listaDeltion = new ArrayList<>();
            System.out.println("how many tickets have been played?");
            int y = 1;
            while (y == 1) {
                try {
                    int arithmosDeltion = in.nextInt();
                    for (int i = 0; i < arithmosDeltion; i++) {
                        fillPlayersTicket(player, listaDeltion);
                        System.out.println("Ticket number: " + (i + 1) + " for : " + player.getName().toString() + " completed. ");

                    }
                    System.out.println(player.toString() + " Tickets: ");
                    for (int j = 0; j < listaDeltion.size(); j++) {
                        System.out.println(j + 1 + "." + listaDeltion.get(j));
                    }
                    y = 2;
                } catch (Exception e) {
                    System.out.println("please type number of tickets");
                    in.next();
                };
            }
            System.out.println("Please type name of player. If you do not wish to add any more players, "
                    + "please type 'stop' and press Enter. ");
            name = in.next();
        }
    }

}
