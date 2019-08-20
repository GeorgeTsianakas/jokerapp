package jokerapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import static jokerapp.Draw.dateInput;

public class Ticket {

    private List<Integer> ticketnumbers;
    private List<Integer> ticketnumbersjoker;
    private Player player;
    private LocalDate ticketdate;

    public Ticket(List<Integer> ticketnumbers, List<Integer> ticketnumbersjoker, Player player, LocalDate ticketdate) {
        this.ticketnumbers = ticketnumbers;
        this.ticketnumbersjoker = ticketnumbersjoker;
        this.player = player;
        this.ticketdate = ticketdate;
    }

    public Ticket(List<Integer> ticketnumbers, List<Integer> ticketnumbersjoker, Player player) {
        this.ticketnumbers = ticketnumbers;
        this.ticketnumbersjoker = ticketnumbersjoker;
        this.player = player;
    }

    public Ticket(List<Integer> ticketnumbers) {
        this.ticketnumbers = ticketnumbers;
    }

    public Ticket() {
    }

    public List<Integer> getTicketnumbers() {
        return ticketnumbers;
    }

    public void setTicketnumbers(List<Integer> ticketnumbers) {
        this.ticketnumbers = ticketnumbers;
    }

    public List<Integer> getTicketnumbersjoker() {
        return ticketnumbersjoker;
    }

    public void setTicketnumbersjoker(List<Integer> ticketnumbersjoker) {
        this.ticketnumbersjoker = ticketnumbersjoker;
    }

    public LocalDate getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(LocalDate ticketdate) {
        this.ticketdate = ticketdate;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketnumbers=" + ticketnumbers + ", ticketnumbersjoker=" + ticketnumbersjoker + ", player=" + player + ", ticketdate=" + ticketdate + '}';
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static void fillPlayersTicket(Player player, List<Ticket> ticketList) {
        Integer[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
        Set<Integer> numbersEligibleSet = new HashSet(Arrays.asList(ar));
        Integer[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Set<Integer> jokersEligibleSet = new HashSet(Arrays.asList(ar1));
        List<Integer> listSelectedNumbers = new ArrayList<>();
        List<Integer> listSelectedJokers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Ticket ticket = new Ticket();
        ticket.setPlayer(player);
        System.out.println("Date the next ticket is draw?(M/d/yyyy)");
        int x = 1;
        while (x == 1) {
            try {
                String dateinput = in.next();
                ticket.setTicketdate(dateInput(dateinput));
                x = 2;
            } catch (Exception e) {
                System.out.println("you input an invalid date. Please input valid date(M/d/yyyy)");
            }
        }
        System.out.println("Choose from 5 to 45 numbers between 1-45. After each number selection press 'Enter'. "
                + "When done selecting, please type 'stop' and press 'Enter'. ");
        int count = 0;

        while (in.hasNextInt() && count < 45) {
            int num = in.nextInt();
            if (numbersEligibleSet.contains(num)) {
                listSelectedNumbers.add(num);
                numbersEligibleSet.remove(num);
                count++;
                if (count < 5) {
                    System.out.println("you need to select at least " + (5 - count) + " more numbers");
                } else {
                    if (count == 45) {
                        System.out.println("you have reached maximum number of 45 numbers.");
                    } else {
                        System.out.println("you have selected " + count + " numbers");
                        System.out.println("you may select " + (45 - count) + " more numbers. If done selecting, type any letter and press Enter. ");
                    }
                }
            } else if (listSelectedNumbers.contains(num)) {
                System.out.println("you have already selected number " + num);
            } else {
                System.out.println("the number is out of range");
            }

        }
        if (in.hasNext() && count >= 5) {
            ticket.setTicketnumbers(listSelectedNumbers);
            String a = in.next();
            System.out.println("Choose from 1 to 20 numbers between 1-20. After each number selection press 'Enter'. "
                    + "When done selecting, please type 'stop' and press 'Enter'. ");
            int countj = 0;

            while (in.hasNextInt() && countj < 20) {
                int num = in.nextInt();
                if (jokersEligibleSet.contains(num)) {
                    listSelectedJokers.add(num);
                    jokersEligibleSet.remove(num);
                    countj++;
                    if (countj < 1) {
                        System.out.println("you need to select at least " + (1 - countj) + " more numbers");
                    } else {
                        if (countj == 20) {
                            System.out.println("you have reached maximum number of 20 numbers.");
                        } else {
                            System.out.println("you have selected " + countj + " numbers");
                            System.out.println("you may select " + (20 - countj) + " more numbers. If done selecting, type any letter and press Enter. ");
                        }
                    }
                } else if (listSelectedJokers.contains(num)) {
                    System.out.println("you have already selected number " + num);
                } else {
                    System.out.println("the number is out of range");
                }

            }
            if (in.hasNext() && countj >= 1) {
                ticket.setTicketnumbersjoker(listSelectedJokers);
                ticketList.add(ticket);
                Collections.ticketsPerPlayerMap.put(player, ticketList);
                Collections.allTicketList.add(ticket);
                System.out.println(ticket.toString());
                int numbercolumns = listSelectedNumbers.size();
                int numberjokers = listSelectedJokers.size();
                long cost = numberjokers * factorial(numbercolumns) / (factorial(numbercolumns - 5) * factorial(5));
                System.out.println("Ticket cost is (charge: 1 Euro/column): " + cost + " Euro.");
            } else if (in.hasNext() && countj == 0) {
                System.out.println("you have to select 1-20 numbers as Joker lucky number. Please try again.");
                Collections.ticketsPerPlayerMap.clear();
                fillPlayersTicket(player, ticketList);
            }
        } else if (in.hasNext() && count < 5) {
            System.out.println("you have to select 5-45 numbers. Please try again.");
            Collections.ticketsPerPlayerMap.clear();
            fillPlayersTicket(player, ticketList);
        }

    }

}
