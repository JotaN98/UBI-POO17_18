package myinput;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ler {
    private String s;
    private Scanner streamScanner;
    private boolean inited = false;

    private static Scanner keyboardScanner = new Scanner(System.in);


    public Ler(InputStream stream){
        streamScanner = new Scanner(stream);
        inited = true;
    }

    // static methods
    public static int processarTecladoInt() throws IOException{
        return keyboardScanner.nextInt();
    }
    public static float processarTecladoFloat() throws IOException{
        return keyboardScanner.nextFloat();
    }
    public static double processarTecladoDouble() throws IOException{
        return keyboardScanner.nextDouble();
    }
    public static long processarTecladoLong() throws IOException{
        return keyboardScanner.nextLong();
    }
    public static String processarTecladoString() throws IOException{
        return keyboardScanner.nextLine();
    }
    public static boolean processarTecladoBoolean() throws IOException {
        return keyboardScanner.nextBoolean();
    }
    // object methods
    int processar(int tipoDeVariavel) throws IOException{
        return streamScanner.nextInt();
    }
    float processar(float tipoDeVariavel) throws IOException{
        return streamScanner.nextFloat();
    }
    double processar(double tipoDeVariavel) throws IOException{
        return streamScanner.nextDouble();
    }
    String processar(String tipoDeVariavel) throws IOException{
        return streamScanner.nextLine();
    }
    boolean processar(boolean tipoDeVariavel) throws IOException {
        return streamScanner.nextBoolean();
    }
}
