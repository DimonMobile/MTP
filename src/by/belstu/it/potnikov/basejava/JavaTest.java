package by.belstu.it.potnikov.basejava;


public class JavaTest {

    final int a = 10;
    public final int b = 11;
    public static final int c = 23;

    public static void main(String[] args) {
        char charVar = 'a';
        int intVar = 2;
        short shortVar = 321;
        byte byteVar = 13;
        long longVar = -32131;
        boolean booleanVar = false;
        double doubleVar = 123.421;
        String stringVar = "stringVar ";

        System.out.println(stringVar + charVar);
        System.out.println(stringVar + intVar);
        System.out.println(stringVar + doubleVar);
//        byteVar = byteVar + intVar;
//        System.out.println(byteVar);
//        intVar = doubleVar + longVar;
        longVar = 2147483647L + intVar;
        System.out.println(longVar);
        System.out.println(sint);
        System.out.println(booleanVar && booleanVar);
        System.out.println(booleanVar ^ booleanVar);
        longVar = 9223372036854775807L;
        System.out.println(longVar);
        char first = 'a';
        char second = '\u0061';
        char third = 97;
        System.out.println(first + second + third);
        System.out.println(3.45 % 2.4);
        System.out.println(1.0/0.0);
        System.out.println(0.0/0.0);
        System.out.println(Math.log(-345));

        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        double dE = Math.round(Math.E);
        double dP = Math.round(Math.PI);

        System.out.println(dE + " " + dP + " " + Math.min(dE, dP));

        Boolean bBool = false;
        Character cChar = 'a';
        Integer iInteger = 1234;
        Byte bByte = 123;
        Short sShort = 12345;
        Long lLong = 12345678901L;

        bBool = false & true;
        iInteger = iInteger + 10;

        System.out.println(Long.MIN_VALUE + " " + Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " " + Long.MAX_VALUE);

        iInteger = 10;
        lLong = 123L;
        bByte = 12;
        System.out.println(iInteger.intValue());
        System.out.println(lLong.longValue());
        System.out.println(bByte.byteValue());

        System.out.println(Integer.parseInt("12332"));
        System.out.println(Integer.toHexString(1232));
        System.out.println(Integer.compare(234, 23));
        System.out.println(Integer.toString(123));
        System.out.println(Integer.bitCount(5));

        // f
    }
    static int sint;
}
