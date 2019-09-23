package com.cursan.magiworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.rules.ExpectedException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class MainTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void Given_ChoiceInput1OfPersonnage_WhenGameIsBeginning_Then_ReturnCorrectChoice() {
        final String data = "1";
        provideInput(data);

        int result = Main.choiceCharacter(1);
        assertEquals(Integer.parseInt(data), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Given_IncorrectChoiceUser_WhenCallingBuildCharacterWithClass_Then_ThrowIllegalArgumentException() {
        Main.buildCharacterWithClass(4, 1);
    }
}
