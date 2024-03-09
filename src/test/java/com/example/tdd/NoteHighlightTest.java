package com.example.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NoteHighlightTest {

    @DisplayName("기본테스트")
    @Test
    void highlight() {
        assertThat(hightlight("abc")).isEqualTo("abc");
        assertThat(hightlight("note")).isEqualTo("{note}");
        assertThat(hightlight("1 note")).isEqualTo("1 {note}");
        assertThat(hightlight("1 note 2")).isEqualTo("1 {note} 2");
        assertThat(hightlight("keynote")).isEqualTo("keynote");
        assertThat(hightlight("ke1note")).isEqualTo("ke1note");
        assertThat(hightlight("yes note1")).isEqualTo("yes note1");

    }

    private String hightlight(String str) {
        int idx = str.indexOf("note");
        if(idx == -1) {
            return str;
        }
        if(isPrechNotSpace(str, idx)) return str;
        if(isPosthNotSpace(str, idx)) return str;

        return str.replace("note", "{note}");
    }

    private boolean isPosthNotSpace(String str, int idx) {
        boolean postchNotSpace = false;
        int postchIdx = idx + "note".length();
        if (postchIdx < str.length() && isNotBlank(str.charAt(postchIdx))) {
            postchNotSpace = true;
        }
        return postchNotSpace;
    }


    private static boolean isPrechNotSpace(String str, int idx) {
        boolean prechNotSpace = false;
        int prechIdx = idx - 1;
        if (prechIdx >= 0 && isNotBlank(str.charAt(prechIdx))) {
            prechNotSpace = true;
        }
        return prechNotSpace;
    }

    private static boolean isNotBlank(char pre) {
        return pre != ' ';
    }

}
