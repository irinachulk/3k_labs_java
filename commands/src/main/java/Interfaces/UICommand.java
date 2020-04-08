package Interfaces;

public interface UICommand {

    String getLabel();
    String getText();

    enum UCType {
        FUNC ("FUNC"),
        BASIC ("BASIC"), // / * - + ( ) mod
        NUM ("NUM"),      // 0-9, A-F
        UNKNOWN ("UNKNOWN");
        private String current;

        UCType(String def) {
            current = def;
        }

        @Override
        public String toString() {
            return current;
        }
    }


    enum RadixType {
        BIN ("BIN", 2),  // 2
        DEC ("DEC", 10), // 10
        HEX ("HEX", 16), // 16
        UNKNOWN ("UNKNOWN", 0);
        private String current;
        private int radix;

        RadixType(String def, int radix) {
            current = def;
            this.radix = radix;
        }

        public int toInt() {return radix;}

        @Override
        public String toString() {
            return current;
        }
    }
}
