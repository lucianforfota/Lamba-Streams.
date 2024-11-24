package lambda.exemple_sesiunea34nuintotalitate_si_sesiunea35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PassingLambdasAsParameters {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John",23));
        persons.add(new Person("Carl",23));
        persons.add(new Person("Bsffg",23));
        persons.add(new Person("Zfgfdg",23));


        //Collections.sort(persons, new AgeComparator());

//apelam metoda wish direct cu o expresie lambda. Daca nu am bagat expresia intr-o variabila de tipul interfetei functionale,de unde stie expresia de care interfata sa se lege?
        //sa inteleg ca expresia lambda intra in variabila greeting?

        //Varianta 1
        wish(() -> System.out.println("cealues"));

        //Varianta 2
        //putem baga valoarea expresiei lambda intr-o variabila de tip greeting si pe urma sa apelam metoda wish cu variabila
        Greeting lambdaexpresion=() -> System.out.println("cealues");
        wish(lambdaexpresion);

        //Varianta 1-ii dam direct expresia lambda ca si parametru
        Collections.sort(persons, new AgeComparator());

        //Varianta 2-ii dam direct expresia lambda ca si parametru
        Collections.sort(persons, (p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()));



        persons.forEach(p -> System.out.println(p));


        persons.removeIf(p -> p.getAge()<18);

        IndianGreeting indianGreeting = new IndianGreeting();
        wish (indianGreeting);
        wish( new EnglishGreeting());
    }

    public static void wish(Greeting greeting){
        greeting.sayHello();
        System.out.println("sa ne auzim de bine");
    }

}

