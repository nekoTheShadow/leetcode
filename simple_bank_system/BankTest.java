package simple_bank_system;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    void example() {
        // 初期化: Bank([[10,100,20,50,30]])
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});

        // withdraw(3, 10) → true（口座3の残高50から10引き出し）
        assertThat(bank.withdraw(3, 10)).isTrue();

        // transfer(5, 1, 20) → true（口座5の残高30から20を口座1へ振込）
        assertThat(bank.transfer(5, 1, 20)).isTrue();

        // deposit(5, 20) → true（口座5に20を預け入れ）
        assertThat(bank.deposit(5, 20)).isTrue();

        // transfer(3, 4, 15) → true（口座3の残高40から15を口座4へ振込）
        assertThat(bank.transfer(3, 4, 15)).isFalse();

        // withdraw(10, 50) → false（口座10は存在しないため失敗）
        assertThat(bank.withdraw(10, 50)).isFalse();
    }
}