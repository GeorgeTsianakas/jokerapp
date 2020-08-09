package jokerapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {

    public static Integer[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
    public static Integer[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    public static Set<Integer> numbersForDrawSet = new HashSet(Arrays.asList(ar));
    public static Set<Integer> numbersForDrawJokerSet = new HashSet(Arrays.asList(ar1));
    public static Map<Player, List<Ticket>> ticketsPerPlayerMap = new HashMap<>();
    public static List<Ticket> allTicketList = new ArrayList<>();
    public static List<Ticket> allWinnableTicketsList = new ArrayList<>();

}
