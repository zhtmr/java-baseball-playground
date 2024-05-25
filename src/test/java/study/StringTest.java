package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1", "2");
        String[] split1 = "1".split(",");
        assertThat(split1).containsExactly("1");
    }

    @Test
    void substring() {
        String s = "(1,2)";
        String substring = s.substring(1, s.length() -1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("범위를 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    void charAt() {
        assertThatThrownBy(() -> {
            String s = "abc";
            char c = s.charAt(999);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 999");
    }


}
