package jump_game_vii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        assertThat(new Solution().canReach(s, minJump, maxJump)).isTrue();
    }

    @Test
    void example2() {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        assertThat(new Solution().canReach(s, minJump, maxJump)).isFalse();
    }

    @Test
    void ng1() {
        String s = "01";
        int minJump = 1;
        int maxJump = 1;
        assertThat(new Solution().canReach(s, minJump, maxJump)).isFalse();
    }

    @Test
    void ng2() {
        String s = "0000000000";
        int minJump = 2;
        int maxJump = 5;
        assertThat(new Solution().canReach(s, minJump, maxJump)).isTrue();
    }
}