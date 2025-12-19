package find_all_people_with_secret;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<Tuple>> graph = IntStream.range(0, n).mapToObj(_ -> new ArrayList<Tuple>())
                .collect(Collectors.toList());

        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];
            graph.get(person1).add(new Tuple(person2, time));
            graph.get(person2).add(new Tuple(person1, time));
        }
        graph.get(0).add(new Tuple(firstPerson, 0));

        int[] scores = IntStream.range(0, n).map(_ -> Integer.MAX_VALUE).toArray();
        scores[0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(tuple -> tuple.time()));
        pq.add(new Tuple(0, 0));
        while (pq.poll() instanceof Tuple(int person, int time)) {
            if (scores[person] < time) {
                continue;
            }

            for (Tuple next : graph.get(person)) {
                if (time <= next.time() && next.time() < scores[next.person()]) {
                    scores[next.person()] = next.time();
                    pq.add(next);
                }
            }
        }

        return IntStream.range(0, n).filter(person -> scores[person] != Integer.MAX_VALUE).boxed()
                .toList();
    }
}


record Tuple(int person, int time) {

}


class Test {
    void main() {
        example1();
        example2();
        example3();
    }

    void example1() {
        int n = 6;
        String meetings = "[[1,2,5],[2,3,8],[1,5,10]]";
        int firstPerson = 1;
        IO.println(new Solution().findAllPeople(n, matrix(meetings), firstPerson));
    }

    void example2() {
        int n = 4;
        String meetings = "[[3,1,3],[1,2,2],[0,3,3]]";
        int firstPerson = 3;
        IO.println(new Solution().findAllPeople(n, matrix(meetings), firstPerson));
    }

    void example3() {
        int n = 5;
        String meetings = "[[3,4,2],[1,2,1],[2,3,1]]";
        int firstPerson = 1;
        IO.println(new Solution().findAllPeople(n, matrix(meetings), firstPerson));
    }

    int[][] matrix(String string) {
        return parse(string, "\\[[0-9,]+\\]").map(line -> {
            return parse(line, "[0-9]+").mapToInt(Integer::parseInt).toArray();
        }).toArray(int[][]::new);
    }

    Stream<String> parse(String string, String pattern) {
        return Pattern.compile(pattern).matcher(string).results().map(MatchResult::group);
    }
}