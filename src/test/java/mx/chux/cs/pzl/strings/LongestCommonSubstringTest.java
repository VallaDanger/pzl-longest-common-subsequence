package mx.chux.cs.pzl.strings;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestCommonSubstringTest {

    LongestCommonSubsequence testCase;
    
    @Before
    public void initializeArray() {
        testCase = new LongestCommonSubsequence("abbcdez");
    }
    
    @Test
    public void nullLCSSTest() {
        assertThat(testCase.apply(null)).isZero();
    }
    
    @Test
    public void emptyLCSSTest() {
        assertThat(testCase.apply("")).isZero();
    }
    
    @Test
    public void lcssTest() {
        assertThat(testCase.apply("abcd")).isEqualTo(4);
        assertThat(testCase.apply("abc")).isEqualTo(3);
        assertThat(testCase.apply("abe")).isEqualTo(3);
        assertThat(testCase.apply("acz")).isEqualTo(3);
    }
    
}
