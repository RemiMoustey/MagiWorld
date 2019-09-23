package com.cursan.magiworld;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;

public class InitialisationTest {
    private ByteArrayInputStream testIn;

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void Given_ChoiceInput1OfCharacter_WhenGameIsBeginning_Then_ReturnCorrectChoice() {
        final String data = "1";
        provideInput(data);

        int result = Initialization.choiceCharacter(1);
        assertEquals(Integer.parseInt(data), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Given_IncorrectChoiceUser_WhenCallingBuildCharacterWithClass_Then_ThrowIllegalArgumentException() {
        Initialization.buildCharacterWithClass(4, 1);
    }
}
