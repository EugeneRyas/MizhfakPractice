package org.example;

import org.example.characters.HasWarriorBehind;
import org.example.characters.Lancer;
import org.example.characters.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private List<Warrior> units = new LinkedList<Warrior>();
    public Iterator<Warrior> firstAlive() {
        return new FirstAlive();
    }

    private class FirstAlive implements Iterator<Warrior> {
        @Override
        public boolean hasNext() {
            while(peekFirst() != null && !peekFirst().isAlive()) {
                deleteFirst();
            }
            return peekFirst() != null;
        }

        @Override
        public Warrior next() {
            if(!hasNext()) throw new NoSuchElementException();
            return peekFirst();
        }
    }

    public Army addUnit(Warrior warrior) {
        if(!units.isEmpty()) {
            units.get(units.size() - 1).setBehind(warrior);
        }
        units.add(warrior);
        return this;
    }

    public Army addUnit(Supplier<Warrior> production, int n) {
        if(n < 0) throw new NullPointerException();
        for (int i = 0; i < n; i++) {
            addUnit(production.get());
        }
        return this;
    }

    public Warrior peekFirst() {
        //return units.peek();
        return units.isEmpty() ? null : units.get(0);
    }

    private void deleteFirst() {
        //units.poll();
        units.remove(0);
    }
}
