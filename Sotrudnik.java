package prakticheskoe_zadanie_5;

import java.time.Year;

//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class Sotrudnik {

    protected String fio;
    protected String doljnost;
    protected String email;
    protected String nomer_telefona;
    protected int z_plata;
    protected int god_rojdenya;//Заменю поле возраст из задания, на год рождения, чтобы можно было использовать эту программу и в 2120 году. Надеюсь, не наругают за это

    //Конструктор класса должен заполнять эти поля при создании объекта;
    //Заметка. Область памяти, в которой создаются и хранятся объекты, называется кучей (heap).
    public Sotrudnik(String fio, String doljnost, String email, String nomer_telefona, int z_plata, int god_rojdenya) {
        this.fio = fio != null ? fio : null;
        this.doljnost = doljnost != null ? doljnost : null;
        this.email = email != null ? email : null;
        this.nomer_telefona = nomer_telefona != null ? nomer_telefona : null;
        this.z_plata = z_plata;
        this.god_rojdenya = god_rojdenya;
    }

/*    //Мы можем как не объявлять ни одного конструктора, так и объявить их несколько.
    //Это конструктор по-умолчанию
    public Sotrudnik() {
    }*/

    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    //Выводит в консоль ФИО, email и телефон
    void printFIO_and_email_nomer_telefona() {
        System.out.println(fio + " " + email + " " + nomer_telefona);
    }

    //Выводит в консоль ФИО, должность и зарплата
    void printFIO_and_doljnost_z_plata() {
        System.out.println(fio + " " + doljnost + " " + z_plata+"р.");
    }

    //Выводит в консоль все данные о сотрудники, также вычисляем возраст сотрудника
    void printALL_dannie_sotrudnika() {
        System.out.println("ФИО: " + fio + ", должность: " + doljnost + "\nе-майл: " + email + ", номер телефона: " + nomer_telefona);
        System.out.println("Заработная плата: " + z_plata + "р. Год рождения: " + god_rojdenya + ", возраст: " + (Year.now().getValue() - god_rojdenya));
    }

}
