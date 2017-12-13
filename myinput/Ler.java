package myinput;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ler {
    private String s;
    private Scanner streamScanner;

    private static Scanner keyboardScanner = new Scanner(System.in);


    public Ler(InputStream stream){
        streamScanner = new Scanner(stream);
    }



    // static methods
	public static int processarTecladoInt() {
    	return processarTecladoInt("Ocurreu um erro, volte a tentar.")
	}
	public static int processarTecladoInt(String errormessage ) {
    	int val;
    	while(true) {
			try {
				val = keyboardScanner.nextInt();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}
	public static float processarTecladoFloat() {
    	return processarTecladoFloat("Ocurreu um erro, volte a tentar.")
	}
	public static float processarTecladoFloat(String errormessage ) {
    	float val;
    	while(true) {
			try {
				val = keyboardScanner.nextFloat();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}
	public static double processarTecladoDouble() {
    	return processarTecladoDouble("Ocurreu um erro, volte a tentar.")
	}
	public static double processarTecladoDouble(String errormessage ) {
    	double val;
    	while(true) {
			try {
				val = keyboardScanner.nextDouble();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}
	public static long processarTecladoLong() {
    	return processarTecladoLong("Ocurreu um erro, volte a tentar.")
	}
	public static long processarTecladoLong(String errormessage ) {
    	long val;
    	while(true) {
			try {
				val = keyboardScanner.nextLong();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}
	public static String processarTecladoString() {
    	return processarTecladoString("Ocurreu um erro, volte a tentar.")
	}
	public static String processarTecladoString(String errormessage ) {
    	String val;
    	while(true) {
			try {
				val = keyboardScanner.nextLine();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}
	public static boolean processarTecladoBoolean() {
    	return processarTecladoBoolean("Ocurreu um erro, volte a tentar.")
	}
	public static boolean processarTecladoBoolean(String errormessage ) {
    	boolean val;
    	while(true) {
			try {
				val = keyboardScanner.nextBoolean();
				return val;
			} catch (InputMismatchException e) {
				System.out.println(errormessage);
			}
		}
	}

    public static int _processarTecladoInt() throws InputMismatchException {
        return keyboardScanner.nextInt();
    }
    public static float _processarTecladoFloat() throws InputMismatchException {
        return keyboardScanner.nextFloat();
    }
    public static double _processarTecladoDouble() throws InputMismatchException {
        return keyboardScanner.nextDouble();
    }
    public static long _processarTecladoLong() throws InputMismatchException {
        return keyboardScanner.nextLong();
    }
    public static String _processarTecladoString() throws InputMismatchException {
        return keyboardScanner.nextLine();
    }
    public static boolean _processarTecladoBoolean() throws InputMismatchException {
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
