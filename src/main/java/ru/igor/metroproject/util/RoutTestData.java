package ru.igor.metroproject.util;

import ru.igor.metroproject.model.Rout;

import java.util.Arrays;
import java.util.List;

public class RoutTestData {


    public static Rout ROUT1 = new Rout(123,"A-B");
    public static Rout ROUT2 = new Rout(222,"C-D");
    public static Rout ROUT3 = new Rout(333,"E-K");
    public static Rout ROUT4 = new Rout(444,"X-Z");
    public static Rout ROUT5 = new Rout(555,"V-Q");

    public static List<Rout> getRouts() {
        return Arrays.asList(ROUT1, ROUT2, ROUT3, ROUT4, ROUT5);
    }
}
