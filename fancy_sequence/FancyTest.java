package fancy_sequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FancyTest {

    @Test
    void example1() {
        Fancy fancy = new Fancy();

        fancy.append(2);   // [2]
        fancy.addAll(3);   // [5]
        fancy.append(7);   // [5, 7]
        fancy.multAll(2);  // [10, 14]

        assertThat(fancy.getIndex(0)).isEqualTo(10);

        fancy.addAll(3);   // [13, 17]
        fancy.append(10);  // [13, 17, 10]
        fancy.multAll(2);  // [26, 34, 20]

        assertThat(fancy.getIndex(0)).isEqualTo(26);
        assertThat(fancy.getIndex(1)).isEqualTo(34);
        assertThat(fancy.getIndex(2)).isEqualTo(20);
    }
}