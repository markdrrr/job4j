package ru.job4j.tracker;

/**
 * 1. Обеспечить бесперебойную работу приложения Tracker.[#193289]
 * @author Andrey Markushin
 * @version 1.1
 * @since 03.12.2019
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }



    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        return askInt(question);
    }
}