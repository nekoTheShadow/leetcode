package find_servers_that_handled_most_number_of_requests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = IntStream.range(0, k).boxed().collect(Collectors.toCollection(TreeSet::new));
        PriorityQueue<Server> busy = new PriorityQueue<>(Comparator.comparing(Server::finish));
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek().finish() <= arrival[i]) {
                Server server = busy.poll();
                free.add(server.name());
            }

            if (free.isEmpty()) {
                continue;
            }

            Integer name = free.ceiling(i % k);
            if (name == null) {
                name = free.first();
            }
            busy.add(new Server(name, arrival[i] + load[i]));
            counter.merge(name, 1, Integer::sum);
            free.remove(name);
        }
        int maxCount = counter.values().stream().max(Comparator.naturalOrder()).get();
        return counter.keySet().stream().filter(name -> counter.get(name) == maxCount).toList();
    }

    record Server(int name, int finish) {
    }

}
