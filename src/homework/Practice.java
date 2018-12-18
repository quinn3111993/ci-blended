package homework;

class DrumKit {
    boolean topHat = true;
    boolean snare = true;

    void playTopHat() {
        System.out.println("ding ding da-ding");
    }

    void playSnare() {
        System.out.println("band bang ba-bang");
    }
}

class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.snare = false;
        if (d.snare == true) {
            d.playSnare();
        } else {
            d.playSnare();
            d.playTopHat();
        }
    }
}

class Echo {
    int count = 0;
    void hello() {
        System.out.println("helloooo...");
    }
}

class EchoTestDrive {
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2 = new Echo();
        int x = 0;
        while (x < 4) {
            e1.hello();
            e1.count = e1.count + 1;
            if (x > 0) {
                e2.count = e2.count + 5;
            }
            if (x > 0) {
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);
    }
}




