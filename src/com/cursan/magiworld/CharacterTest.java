package com.cursan.magiworld;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.testng.Assert.assertEquals;


public class CharacterTest {

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

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private Character Warrior = new Warrior(1) {

    };

    @Test
    public void Given_ChoiceInput2OfFeatureStrength_WhenCallingChoiceFeature_Then_ReturnCorrectChoice() {
        final String data = "2";
        provideInput(data);

        int result = Character.catchChoiceUser(1, 2, "force");
        assertEquals(Integer.parseInt(data), result);
    }

    @Test
    public void Given_Level_WhenCallingChoiceFeature_Then_ReturnCorrectMaxAndMin() {
        int[] bounds = Character.choiceFeature("level");
        int[] result = {1, 100};
        assertEquals(result, bounds);
    }

    @Test
    public void Given_OtherFeature_WhenCallingChoiceFeature_Then_ReturnCorrectMaxAndMin() {
        int[] bounds = Character.choiceFeature("other_feature");
        int[] result = {0, 100};
        assertEquals(result, bounds);
    }

    @Test
    public void Given_1_WhenCallingSloganCharacter_Then_ReturnCorrectSlogan() {
        String slogan = Character.sloganCharacter(1);
        assertEquals("Woarg", slogan);
    }

    @Test
    public void Given_4_WhenCallingSloganCharacter_Then_ReturnCorrectSlogan() {
        String slogan = Character.sloganCharacter(4);
        assertEquals("", slogan);
    }

    @Test
    public void Given_1_WhenCallingClassCharacter_Then_ReturnCorrectClass() {
        String classPersonnage = Character.classCharacter(1);
        assertEquals("Guerrier", classPersonnage);
    }

    @Test
    public void Given_4_WhenCallingClassCharacter_Then_ReturnCorrectClass() {
        String classPersonnage = Character.classCharacter(4);
        assertEquals("", classPersonnage);
    }
}
