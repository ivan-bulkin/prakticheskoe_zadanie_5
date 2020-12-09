package prakticheskoe_zadanie_5;

import lesson5.Cat;
import prakticheskoe_zadanie_4.TicTacToe;

import java.time.Year;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    //Создать массив из 5 сотрудников
    public static Sotrudnik[] sotrudnikArray = new Sotrudnik[5];// Вначале объявляем массив объектов

    public static void main(String[] args) {
        privetstvie_programmi();

        sotrudnikArray[0] = new Sotrudnik("Иванов Иван Иванович", "Директор", "1@1.ru", "9-911-111-11-11", 58000, 1970);
        sotrudnikArray[1] = new Sotrudnik("Петров Пётр Петрович", "Заместитель директора", "2@2.ru", "9-922-222-22-22", 51000, 1980);
        sotrudnikArray[2] = new Sotrudnik("Иванова Анастасия Петровна", "Помощник директора", "3@3.ru", "9-933-333-33-33", 48000, 1995);
        sotrudnikArray[3] = new Sotrudnik("Ломакина Милания Евстафьевна", "Менеджер по клинингу", "4@4.ru", "9-944-444-44-44", 18000, 1960);
        sotrudnikArray[4] = new Sotrudnik("Розенфельд Исаак Васильевич", "Бухгалтер", "5@5.ru", "9-955-555-55-55", 98000, 1965);

        vibor_deistvya();

/*        sotrudnikArray[0].printFIO_and_email_nomer_telefona();
        System.out.println();
        sotrudnikArray[1].printFIO_and_doljnost_z_plata();
        System.out.println();
        sotrudnikArray[2].printALL_dannie_sotrudnika();
        System.out.println();*/
    }

    private static void vibor_deistvya() {
        int vibor_deistviya;
        do {
            vibor_deistviya = vvod_tselogo_chisla(1, 3, "Выберите какую информацию вывести в консоль");
            if (vibor_deistviya != -100) {
            } else {
                System.out.print("Вы ошиблись. ");
            }
            if (vibor_deistviya == 1) {
                System.out.println();
                System.out.println("Полную информация о сотрудниках старше 40 лет:");
                for (int i = 0; i < sotrudnikArray.length; i++) {
                    if ((Year.now().getValue() - sotrudnikArray[i].god_rojdenya) > 40) {
                        sotrudnikArray[i].printALL_dannie_sotrudnika();
                    }
                }
            }
            if (vibor_deistviya == 2) {
                System.out.println();
                System.out.println("ФИО, email и телефон всех сотрудников:");
                for (int i = 0; i < sotrudnikArray.length; i++) {
                    sotrudnikArray[i].printFIO_and_email_nomer_telefona();
                }
            }
            if (vibor_deistviya == 3) {
                System.out.println();
                System.out.println("ФИО, должность и зарплата всех сотрудников:");
                for (int i = 0; i < sotrudnikArray.length; i++) {
                    sotrudnikArray[i].printFIO_and_doljnost_z_plata();
                }
            }
        }
        while (vibor_deistviya == -100);
        if (!vixod_iz_programmi()) {//надо будет привыкнуть к такому написанию
            privetstvie_programmi();
            vibor_deistvya();
        }
    }

    private static void privetstvie_programmi() {
        System.out.println("\nПрактическое задание к уроку № 5");
        System.out.println("Создать класс \"Сотрудник\" с полями: ФИО, должность, email, телефон, зарплата, возраст;");
        System.out.println("Конструктор класса должен заполнять эти поля при создании объекта;");
        System.out.println("Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль");
        System.out.println("Создать массив из 5 сотрудников");
        System.out.println("С помощью цикла вывести информацию только о сотрудниках старше 40 лет;");
        System.out.println();
        System.out.println("1. Вывести полную информацию о сотрудниках старше 40 лет;");
        System.out.println("2. ФИО, email и телефон всех сотрудников;");
        System.out.println("3. ФИО, должность и зарплата всех сотрудников;");
    }

    //Универсальная процедура ввода целого числа, буду её использовать в других программах
    //На вход процедуры передаём от какого до какого числа пользовательо должен ввести число
    //min_znachenie - меньше этого числа вводить нельзя
    //max_znachenie - больше этого числа вводить нельзя
    //возвращает -100, если число введено не верно и возвращает целое число, если число введено верно и в нужном интервале
    //message - сообщение пользователю о том, что именно надо вводить
    private static int vvod_tselogo_chisla(int min_znachenie, int max_znachenie, String message) {
        System.out.print(message + ", введите число от " + min_znachenie + " до " + max_znachenie + ": ");
        int vvedennoe_chislo = -100;
        if (in.hasNextInt()) {
            vvedennoe_chislo = in.nextInt();
            if (vvedennoe_chislo < min_znachenie || vvedennoe_chislo > max_znachenie) {
                vvedennoe_chislo = -100;
            }
        } else {
            in.next();
        }
        return vvedennoe_chislo;
    }
    //Универсальная процедура выхода из программы, буду её использовать в других программах
    //Выходит из программы, если пользователь выбирает "y", "yes", "д", "да", "+", "торжественно подтверждаю"
    //Возвращает false, если пользователь выбирает "n", "н", "-", "играть, так играть, продолжаем"
    //продолжает спрашивать о выходе, если пользователь ввёл любое другое значение
    private static boolean vixod_iz_programmi() {
        System.out.println("\nВыходим из программы, Вы уверены? y/n (д/н)");
        String n = in.next();
        switch (n) {
            case "y", "yes", "д", "да", "+", "торжественно подтверждаю" -> {
                System.out.println("\nДо новых встреч, ждём Вас снова.");
                in.close();//Необходимо закрыть объект in
                System.exit(0);
            }
            case "n", "н", "-", "играть, так играть, продолжаем" -> {
                System.out.println();
                return false;
            }
            default -> {
                System.out.printf("Вы ввели: " + n + ", такого значения нет в списке%n" + "Выберите y/n или д/н и попробуйте ещё разик.");
                vixod_iz_programmi();
            }
        }
        return false;
    }
}
