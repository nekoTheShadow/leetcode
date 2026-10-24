package count_days_spent_together;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate start1 = parse(arriveAlice);
        LocalDate end1 = parse(leaveAlice);
        LocalDate start2 = parse(arriveBob);
        LocalDate end2 = parse(leaveBob);

        LocalDate start = Stream.of(start1, start2).max(LocalDate::compareTo).get();
        LocalDate end = Stream.of(end1, end2).min(LocalDate::compareTo).get();
        if (start.isAfter(end)) {
            return 0;
        }
        return (int) (ChronoUnit.DAYS.between(start, end) + 1);
    }

    private LocalDate parse(String mmdd) {
        return LocalDate.parse("2026-" + mmdd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
