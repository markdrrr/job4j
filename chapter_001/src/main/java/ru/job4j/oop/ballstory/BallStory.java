package ru.job4j.oop.ballstory;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();

        ball.run(hare, fox, wolf);
        hare.eat(ball);
        fox.eat(ball);
        wolf.eat(ball);
    }
}
