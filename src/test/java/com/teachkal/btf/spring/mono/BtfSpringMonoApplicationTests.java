package com.teachkal.btf.spring.mono;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BtfSpringMonoApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itShouldMultipleTwoNumbers() {
        // given
        int numberOne = 2;
        int numberTwo = 10;

        // when
        int result = underTest.multiple(numberOne, numberTwo);

        // then
        int expected = 20;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldSquareNumber() {
        // given
        int number = 2;

        // when
        int result = underTest.square(number);

        // then
        int expected = 4;
        assertThat(result).isEqualTo(expected);
    }

    static class Calculator {
        int multiple(int a, int b) {
            return a * b;
        }

        int square(int a){
            return a * a;
        }
    }
}
