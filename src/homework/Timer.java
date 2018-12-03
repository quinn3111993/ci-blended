package homework;

public class Timer {
    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    void tick() {
        if (seconds < 59) {
            seconds += 1;
        } else if (minutes < 59) {
            minutes += 1;
            seconds = 0;
        } else if (hours < 23) {
            hours += 1;
            minutes = 0;
            seconds = 0;
        } else {
            hours = 0;
            minutes = 0;
            seconds = 0;
        }
    }

    void reset() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
}

class TestTimer {
    public static void main(String[] args) {
        Timer t = new Timer();

        for (int i = 0; i < 86401; i++) {
            t.tick();
            System.out.printf("%02d:%02d:%02d \n", t.hours, t.minutes, t.seconds);
        }

        t.reset();
        System.out.printf("%02d:%02d:%02d \n", t.hours, t.minutes, t.seconds);

    }
}
