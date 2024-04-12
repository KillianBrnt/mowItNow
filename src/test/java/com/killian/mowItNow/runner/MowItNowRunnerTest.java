package com.killian.mowItNow.runner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.killian.mowItNow.entities.Lawn;
import com.killian.mowItNow.entities.LawnMower;
import com.killian.mowItNow.entities.Position;

class MowItNowRunnerTest {
	@Test
	public void basic_test() {
		Lawn lawn = new Lawn(5, 5);
        Position position1 = new Position(1, 2, 'N');
        LawnMower lawnMower1 = new LawnMower(position1, "GAGAGAGAA");
        Position position2 = new Position(3, 3, 'E');
        LawnMower lawnMower2 = new LawnMower(position2, "AADAADADDA");
        List<LawnMower> lawnMowers = new ArrayList<>();
        lawnMowers.add(lawnMower1);
        lawnMowers.add(lawnMower2);

        LawnMowerRunner runner = new LawnMowerRunner(lawnMowers, lawn);
        List<String> result = runner.run();
        assertEquals("1 3 N", result.get(0));
        assertEquals("5 1 E", result.get(1));
	}


}
