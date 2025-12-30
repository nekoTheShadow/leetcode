package count_mentions_per_user;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        PriorityQueue<Event> pq = new PriorityQueue<>();
        for (List<String> event : events) {
            pq.add(new Event(event.get(0), Integer.parseInt(event.get(1)), event.get(2)));
        }

        Set<Integer> online = new HashSet<>();
        for (int i = 0; i < numberOfUsers; i++) {
            online.add(i);
        }

        int[] counts = new int[numberOfUsers];
        while (!pq.isEmpty()) {
            Event event = pq.remove();
            if (event.name().equals("MESSAGE")) {
                if (event.id().equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        counts[i]++;
                    }
                } else if (event.id().equals("HERE")) {
                    for (int i : online) {
                        counts[i]++;
                    }
                } else {
                    Matcher matcher = Pattern.compile("[0-9]+").matcher(event.id());
                    while (matcher.find()) {
                        counts[Integer.parseInt(matcher.group())]++;
                    }
                }
            } else if (event.name().equals("OFFLINE")) {
                online.remove(Integer.parseInt(event.id()));
                pq.add(new Event("ONLINE", event.timestamp() + 60, event.id()));
            } else {
                // ONLINE
                online.add(Integer.parseInt(event.id()));
            }
        }

        return counts;
    }
}

record Event(String name, int timestamp, String id) implements Comparable<Event> {

    private static int rank(String name) {
        if (name.equals("ONLINE")) {
            return 0;
        } else if (name.equals("OFFLINE")) {
            return 1;
        } else {
            // Message
            return 2;
        }
    }

    @Override
    public int compareTo(Event other) {
        int c = Integer.compare(this.timestamp, other.timestamp);
        if (c == 0) {
            return Integer.compare(rank(this.name), rank(other.name));
        } else {
            return c;
        }
    }
}