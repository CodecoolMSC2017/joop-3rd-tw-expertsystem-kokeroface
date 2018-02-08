package com.codecool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {

    FactParser factParserTest = new FactParser();

    @Test
    void getFactRepository() throws Exception {
        FactRepository test = factParserTest.getFactRepository();
        Fact mortal_kombat_komplete_edition = test.getIterator().next();
        assertEquals(false,mortal_kombat_komplete_edition.getValueById("money"));
        assertEquals(true,mortal_kombat_komplete_edition.getValueById("graphics"));
        assertEquals(true,mortal_kombat_komplete_edition.getValueById("multiplayer"));
        assertEquals(true,mortal_kombat_komplete_edition.getValueById("pegi"));
        assertEquals(false,mortal_kombat_komplete_edition.getValueById("type"));
        assertEquals(true,mortal_kombat_komplete_edition.getValueById("view"));
        assertEquals(false,mortal_kombat_komplete_edition.getValueById("details"));
    }
}