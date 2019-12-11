package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

/**
 * 9.2. Тесты вывода на консоль в StartUI[#193270]
 * @author Andrey Markushin
 * @version 1.0
 * @since 03.12.2019
 */
public class StubActionTest {
//    @Test
//    public void whenExit() {
//        StubInput input = new StubInput(
//                new String[] {"0"}
//        );
//        StubAction action = new StubAction(0,"Stub action");
//        new StartUI().init(input, new Tracker(), new BaseAction[] { action });
//        assertThat(action.isCall(), is(true));
//    }
//
//    @Test
//    public void whenPrtMenu() {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PrintStream def = System.out;
//        System.setOut(new PrintStream(out));
//        StubInput input = new StubInput(
//                new String[] {"0"}
//        );
//        StubAction action = new StubAction(0,"Stub action");
//        new StartUI().init(input, new Tracker(), new BaseAction[] { action });
//        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
//                .add("Menu.")
//                .add("0. Stub action")
//                .toString();
//        assertThat(new String(out.toByteArray()), is(expect));
//        System.setOut(def);
//    }
}
