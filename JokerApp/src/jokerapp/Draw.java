package jokerapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Draw {

    private int firstnum;
    private int secondnum;
    private int thirdnum;
    private int fourthnum;
    private int fifthnum;
    private int joker;
    private LocalDate drawDate;

    public Draw() {
    }

    public Draw(int firstnum, int secondnum, int thirdnum, int fourthnum, int fifthnum, int joker, LocalDate drawDate) {
        this.firstnum = firstnum;
        this.secondnum = secondnum;
        this.thirdnum = thirdnum;
        this.fourthnum = fourthnum;
        this.fifthnum = fifthnum;
        this.joker = joker;
        this.drawDate = drawDate;
    }

    public Draw(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public Draw(int firstnum) {
        this.firstnum = firstnum;
    }

    public Draw(int firstnum, int secondnum, int thirdnum, int fourthnum, int fifthnum, int joker) {
        this.firstnum = firstnum;
        this.secondnum = secondnum;
        this.thirdnum = thirdnum;
        this.fourthnum = fourthnum;
        this.fifthnum = fifthnum;
        this.joker = joker;
    }

    public int getFirstnum() {
        return firstnum;
    }

    public void setFirstnum(int firstnum) {
        this.firstnum = firstnum;
    }

    public int getSecondnum() {
        return secondnum;
    }

    public void setSecondnum(int secondnum) {
        this.secondnum = secondnum;
    }

    public int getThirdnum() {
        return thirdnum;
    }

    public void setThirdnum(int thirdnum) {
        this.thirdnum = thirdnum;
    }

    public int getFourthnum() {
        return fourthnum;
    }

    public void setFourthnum(int fourthnum) {
        this.fourthnum = fourthnum;
    }

    public int getFifthnum() {
        return fifthnum;
    }

    public void setFifthnum(int fifthnum) {
        this.fifthnum = fifthnum;
    }

    public int getJoker() {
        return joker;
    }

    public void setJoker(int joker) {
        this.joker = joker;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    @Override
    public String toString() {
        return "Draw{" + "firstnum=" + firstnum + ", secondnum=" + secondnum + ", thirdnum=" + thirdnum + ", fourthnum=" + fourthnum + ", fifthnum=" + fifthnum + ", joker=" + joker + ", drawDate=" + drawDate + '}';
    }

    public static int firstNumberDraw() {

        int num1 = new Random().nextInt(45) + 1;
        Collections.numbersForDrawSet.remove(num1);
        return num1;

    }

    public static int secondNumberDraw() {

        int num2 = new Random().nextInt(45) + 1;
        while (!Collections.numbersForDrawSet.contains(num2)) {
            secondNumberDraw();
        }
        Collections.numbersForDrawSet.remove(num2);
        return num2;

    }

    public static int trirdNumberDraw() {

        int num3 = new Random().nextInt(45) + 1;
        while (!Collections.numbersForDrawSet.contains(num3)) {
            trirdNumberDraw();
        }
        Collections.numbersForDrawSet.remove(num3);
        return num3;

    }

    public static int fourthNumberDraw() {

        int num4 = new Random().nextInt(45) + 1;
        while (!Collections.numbersForDrawSet.contains(num4)) {
            fourthNumberDraw();
        }
        Collections.numbersForDrawSet.remove(num4);
        return num4;
    }

    public static int fifthNumberDraw() {

        int num5 = new Random().nextInt(45) + 1;
        while (!Collections.numbersForDrawSet.contains(num5)) {
            fifthNumberDraw();
        }
        Collections.numbersForDrawSet.remove(num5);
        return num5;

    }

    public static int jokerWiNumber() {

        int joker = new Random().nextInt(20) + 1;
        return joker;

    }

    public static void doDraw() {
        Scanner in = new Scanner(System.in);
        List<Integer> listCheckedWinNumbers = new ArrayList<>();
        int k1 = firstNumberDraw();
        listCheckedWinNumbers.add(k1);
        int k2 = secondNumberDraw();
        listCheckedWinNumbers.add(k2);
        int k3 = trirdNumberDraw();
        listCheckedWinNumbers.add(k3);
        int k4 = fourthNumberDraw();
        listCheckedWinNumbers.add(k4);
        int k5 = fifthNumberDraw();
        listCheckedWinNumbers.add(k5);
        int j = jokerWiNumber();
        Draw draw = new Draw(k1, k2, k3, k4, k5, j);
        System.out.println("Which are the tickets of this draw?(M/d/yyyy)");
        int x = 1;
        while (x == 1) {
            try {
                String dateinput = in.next();
                draw.setDrawDate(dateInput(dateinput));
                System.out.println(draw.toString());
                x = 2;
            } catch (Exception e) {
                System.out.println("you input an invalid date. Please input valid date(M/d/yyyy)");
            }
        }
        for (int i = 0; i < Collections.allTicketList.size(); i++) {
            if (draw.getDrawDate().equals(Collections.allTicketList.get(i).getTicketdate())) {
                List<Integer> common = new ArrayList<Integer>(Collections.allTicketList.get(i).getTicketnumbers());
                common.retainAll(listCheckedWinNumbers);
                if (common.size() == 5) {
                    Collections.allWinnableTicketsList.add(Collections.allTicketList.get(i));
                    if (Collections.allTicketList.get(i).getTicketnumbersjoker().contains(draw.joker)) {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 5 +1 lucky numbers");
                    } else {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 5  lucky numbers");
                    }
                } else if (common.size() == 4) {
                    Collections.allWinnableTicketsList.add(Collections.allTicketList.get(i));
                    if (Collections.allTicketList.get(i).getTicketnumbersjoker().contains(draw.joker)) {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 4 +1 lucky numbers");
                    } else {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 4  lucky numbers");
                    }
                } else if (common.size() == 3) {
                    Collections.allWinnableTicketsList.add(Collections.allTicketList.get(i));
                    if (Collections.allTicketList.get(i).getTicketnumbersjoker().contains(draw.joker)) {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 3 +1 lucky numbers");
                    } else {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 3  lucky numbers");
                    }
                } else if (common.size() == 2) {
                    Collections.allWinnableTicketsList.add(Collections.allTicketList.get(i));
                    if (Collections.allTicketList.get(i).getTicketnumbersjoker().contains(draw.joker)) {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 2 +1 lucky numbers");
                    } else {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 2 lucky numbers ");
                    }
                } else if (common.size() == 1) {
                    Collections.allWinnableTicketsList.add(Collections.allTicketList.get(i));
                    if (Collections.allTicketList.get(i).getTicketnumbersjoker().contains(draw.joker)) {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 1 +1 lucky numbers");
                    } else {
                        System.out.println(Collections.allTicketList.get(i).toString() + " contains: 1 lucky number ");
                    }
                }
            }
        }
        if (Collections.allWinnableTicketsList.isEmpty()) {
            System.out.println("No ticket wins...");
        } else {
            System.out.println("Tickets that win are: " + Collections.allWinnableTicketsList.toString());
        }
    }

    public static LocalDate dateInput(String userInput) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        System.out.println(date);
        return date;

    }

}
