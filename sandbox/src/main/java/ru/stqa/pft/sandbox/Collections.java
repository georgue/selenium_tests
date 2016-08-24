package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by goga on 22.08.2016.
 */
public class Collections {
    public static void main(String[] args) {
        // заполняем массив
        String[] langs = new String[4];
        langs[0] = "java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";

        // так же можно заполнять массив вот так
        String[] langs2 = { "java", "C#", "Python", "PHP"};

        //проходимся по массиву
        for (int i = 0; i < langs2.length; i++){
            System.out.println("я хочу выучить " + langs2[i]);
        }

        for (int i = 0; i < 3; i++){
            System.out.println("");
        }

        // цикл прохождения по массиву можно записать так
        for (String l : langs2) {
            System.out.println("я хочу выучить " + l);
        }

        // коллекции список на массиве
        // слева интерфейс справа реализация
        List<String> languages = new ArrayList<>();
        // инициализируем коллекцию
        languages.add("java");
        languages.add("C#");

        System.out.println("");

        for (String l : languages) {
            System.out.println("я хочу выучить " + l);
        }

        // более компактная запись инициализировать коллекцию как массив в одну стоку
        List<String> languages3 = Arrays.asList("java", "C#", "Python", "PHP");

        for (int i = 0; i< languages3.size(); i++){
            System.out.println("я хочу выучить " + languages3.get(i));
        }




    }
}
