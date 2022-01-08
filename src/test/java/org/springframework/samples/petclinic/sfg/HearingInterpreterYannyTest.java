package org.springframework.samples.petclinic.sfg;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HearingInterpreterYannyTest {

    HearingInterpreter hearingInterpreter;

    @Before
    public void setUp() throws Exception {
        hearingInterpreter = new HearingInterpreter(new YannyWordProducer());
    }

    @Test
    public void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Yanny", word);
    }
}