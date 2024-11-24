package lambda_exercitii_dupa_sesiuni;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {

//        (x,y)->x%y==0;

//        x->x.length();

        //Function e o interfata generica din java in care intra ceva si iese ceva
        Function<String, Integer> lengthCalculator = x -> x.length();
        System.out.println(lengthCalculator.apply("tralalalala"));

        Function<String, String> substringExtractor1 = x -> x.substring(5);
        System.out.println(substringExtractor1.apply("tralalalala"));

        Function<String, String> substringExtractor2 = x -> x.substring(1, 3);
        System.out.println(substringExtractor2.apply("abcdefghij"));

        //AICI FOLOSIM O CLASA DigiFM
        DigiFM digiFM = new DigiFM();
        digiFM.play("La multi ani, nu folosesti expresie lambda, te folosesti de o clasa DigiFM!");

        //PUTEM SCRIE O METODA LAMBDA CARE FACE FIX CE AVEM MAI SUS LA LINIILE 8 SI 9 FARA SA MAI DEFINIM O CLASA SEPARATA DigiFM
        RadioBroadcast kissFM = message -> System.out.println("esti la kissfm" + message);
        kissFM.play("la multi ani cu lambda");

        Function<Integer, Integer> habarNuAmCeFac = x -> {
            x += 2;
            x += 3;
            int a = x + 4;
            return a;
        };
        System.out.println(habarNuAmCeFac.apply(10));


        //CLASA ANONIMA (in general nu se scrie asa in practica, dar e important sa stim ca exista.  )
        Calculator calculator = new Calculator() {
            @Override
            public Integer add(Integer a, Integer b) {
                return a + b;
            }
        };
        System.out.println(calculator.add(2, 3));

        //folosim expresie lambda care face fix ce avrm mai sus cu clasa anonima
        Calculator calculator1 = (x, y) -> x + y;
        System.out.println(calculator1.add(3, 6));

        //apelam functia printResultOfLambda cu un parametru o variabila care contine o expresie lambda
        printResultOfLambda(lengthCalculator);

        //bagam rezultatul unei expresii lambda intr-o variabila charArrayDigitsCounter si apelam functia printResultOfLambda cu parametrul charArrayDigitsCounter
        Function<String, Integer> charArrayDigitsCounter = s -> {
            int count = 0;
            //PARCURG FIECARE CARACTER DIN arrayul de caractere(prin toCharArray()
            for (Character c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    count++;
                }
            }
            return count;
        };
        printResultOfLambda(charArrayDigitsCounter);

        //cum apelam functia direct cu expresia lambda fara sa mai bagam intr-o variabila
        printResultOfLambda(x -> x.length());

        Greeting indianGreeting = new IndianGreeting();
        indianGreeting.sayHello();

        //pe clasa WellWisher apelam metoda wish care accepta ca si parametru ceva de tip greeting,asadar se va printa namaste si sa auzim numai de bine
        WellWisher.wish(indianGreeting);

        //cum facem fara sa definim o alta clasa GermanGreeting sa salute ceaules
        Greeting ceaulesGreeting = () -> System.out.println("ceaules");
        WellWisher.wish(ceaulesGreeting);
        //se poate si asa, bagam ca parametru la wish direct expresia lambda
        WellWisher.wish(() -> System.out.println("ceaules"));


        //PREDICATE-intra ceva si iese boolean. e o interfata generica din java.
        Predicate<Character> isDigit = c -> Character.isDigit(c);
        System.out.println(isDigit.test('2'));

        IntPredicate isEven = val -> val % 2 == 0;
        System.out.println(isEven.test('2'));

        //SUPPLIER-intra nimic si iese ceva.Practic Stringul ce il dam imediat dupa Supplier e ce vrem sa iasa
        Supplier<String> stringSupplier = () -> "Hello World!" + "O sa devin programator :)))";
        System.out.println(stringSupplier.get());

        //CONSUMER-intra ceva(un T) si nu iese nimic.
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("abcdefg123456");

        //BICONSUMER-intra 2 parametri si iese nimic
        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + " " + s2);
        greet.accept("costel", "leana");

        //FUNCTION-in care intra ceva si iese ceva, BIFUNCTION-in care intra 2 si iese 1. Vezi mai sus!
        //BINARYOPERATOR

       //BIFUNCTION-intra 2 si iese 1 de acelasi tip
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        System.out.println(concat.apply("ioana", "maria"));

        //Binaryoperator-intra ceva si iese ceva de acelasi tip
        BinaryOperator<String> concat2 = (s1, s2) -> s1 + s2;
        System.out.println(concat2.apply("ioana", "maria"));

    }

    //pasam ca parametru la o metoda o expresie lambda
    public static void printResultOfLambda(Function<String, Integer> function) {
        System.out.println(function.apply("hopahop"));
    }


}
