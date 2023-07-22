package tree;

import human.Human;
import human.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person>{

    private List<Person> humanList;

    public FamilyTree(List<Person> human) {
        this.humanList = human;
    }

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    /**
     * Добавление в список нового человека
     *
     * @param human
     */
    public void addHumanList(Person human) {
        humanList.add(human);
    }

    /**
     * Получение полного списка людей в дереве
     *
     * @return
     */
//    public String getHumanListInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список всех людей: \n");
//        stringBuilder.append("\n");
//        for (Human human : humanList) {
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        stringBuilder.append("=".repeat(50));
//        return stringBuilder.toString();
//    }




    /**
     * Поиск человека по имени
     *
     * @param name
     * @return
     */
    public String findPerson(String name) {
        System.out.println("Введите имя для поиска: ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей с именем " + name);
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (Human human : humanList) {
            if (human.getFirstName().equalsIgnoreCase(name.toLowerCase())) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByAge(){
        Collections.sort(humanList, new PersonComparatorByAge());
    }
}

