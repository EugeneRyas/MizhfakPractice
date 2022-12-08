package org.example.characters;

import org.example.Army;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.Battle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    @Test
    @DisplayName("1. Fight")
    void testFight1() {
        var carl = new Warrior();
        var jim = new Knight();

        var res = Battle.fight(carl, jim);

        assertEquals(false, res);
    }

    @Test
    @DisplayName("2. Fight")
    void testFight2() {
        var ramon = new Knight();
        var slevin = new Warrior();

        var res = Battle.fight(ramon, slevin);

        assertEquals(true, res);
    }

    @Test
    @DisplayName("3. Fight")
    void testFight3() {
        var connor = new Warrior();
        var markus = new Warrior();

        var res = Battle.fight(connor, markus);
        var alive = connor.isAlive();
        //throw new NegativeArraySizeException();

        assertEquals(true, alive);
    }

    @Test
    @DisplayName("4. Fight")
    void testFight4() {
        var zeus = new Knight();
        var godkiller = new Warrior();

        var res = Battle.fight(zeus, godkiller);
        var alive = zeus.isAlive();
        //throw new NegativeArraySizeException();
        //assertEquals(false, res);
        assertEquals(true, alive);
    }

    @Test
    @DisplayName("5. Fight")
    void testFight5() {
        var sans = new Warrior();
        var frisk = new Warrior();

        var res = Battle.fight(sans, frisk);
        var alive = frisk.isAlive();
        //throw new NegativeArraySizeException();

        assertEquals(false, alive);
    }

    @Test
    @DisplayName("6. Fight")
    void testFight6() {
        var dragon = new Warrior();
        var knight = new Knight();

        var res = Battle.fight(dragon, knight);
        var alive = knight.isAlive();
        //throw new NegativeArraySizeException();

        assertEquals(true, alive);
    }

    @Test
    @DisplayName("7. Fight")
    void testFight7() {
        var unit1 = new Warrior();
        var someUnit = new Knight();
        var npc = new Warrior();

        var res = Battle.fight(unit1, someUnit);
        var result = Battle.fight(someUnit, npc);
        //throw new NegativeArraySizeException();

        assertEquals(false, result);
    }

    @Test
    @DisplayName("Health")
    void testHealth1() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var npc = new Warrior();

        var res = unit1.getHp();

        assertEquals(60, res);
    }

    @Test
    @DisplayName("8. Fight")
    void testFight8() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();

        var res = Battle.fight(unit1, unit3);

        assertEquals(true, res);
    }

    @Test
    @DisplayName("9. Fight")
    void testFight9() {
        var freelancer = new Lancer();
        var vampire = new Vampire();

        var res = Battle.fight(freelancer, vampire);

        assertEquals(true, res);
    }

    @Test
    @DisplayName("10. Fight")
    void testFight10() {
        var unit1 = new Healer();
        var unit2 = new Knight();

        var res = Battle.fight(unit1, unit2);

        assertEquals(false, res);
    }

    @Test
    @DisplayName("11. Fight")
    void testFight11() {
        var unit1 = new Knight();
        var unit2 = new Lancer();

        var res = Battle.fight(unit1, unit2);

        assertEquals(true, res);
    }

    @Test
    @DisplayName("12. Fight")
    void testFight12() {
        var v = new Vampire();
        var k = new Knight();

        var res = Battle.fight(v, k);

        assertEquals(false, res);
    }

    @Test
    @DisplayName("1. Battle")
    void testBattle1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnit(() -> new Warrior(), 1);
        army2.addUnit(() -> new Warrior(), 2);

        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2. Battle")
    void testBattle2() {
        var armyThree = new Army();
        var armyFourth = new Army();

        armyThree.addUnit(() -> new Warrior(), 2);
        armyFourth.addUnit(() -> new Warrior(), 3);

        var res = Battle.fight(armyThree, armyFourth);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("3. Battle")
    void testBattle3() {
        var myArmy = new Army();
        var enemyArmy = new Army();

        myArmy.addUnit(() -> new Warrior(), 5);
        enemyArmy.addUnit(() -> new Warrior(), 7);

        var res = Battle.fight(myArmy, enemyArmy);
        assertEquals(false, res);
    }


    @Test
    @DisplayName("4. Battle")
    void testBattle4() {
        var badArmy = new Army();
        var coolArmy = new Army();

        badArmy.addUnit(() -> new Warrior(), 10);
        coolArmy.addUnit(() -> new Warrior(), 11);

        var res = Battle.fight(badArmy, coolArmy);
        assertEquals(true, res);
    }

    @Test
    @DisplayName("5. Battle")
    void testBattle5() {
        var badArmy = new Army();
        var coolArmy = new Army();

        badArmy.addUnit(() -> new Warrior(), 11);
        coolArmy.addUnit(() -> new Warrior(), 7);

        var res = Battle.fight(badArmy, coolArmy);
        assertEquals(true, res);
    }

    @Test
    @DisplayName("6. Battle")
    void testBattle6() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Warrior(), 5).addUnit(() -> new Defender(), 4).addUnit(() -> new Defender(), 5);
        army2.addUnit(() -> new Warrior(), 4);

        var res = Battle.fight(army1, army2);
        assertEquals(true, res);
    }

    @Test
    @DisplayName("7. Battle")
    void testBattle7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 5).addUnit(() -> new Warrior(), 20);
        army2.addUnit(() -> new Warrior(), 21);
        army1.addUnit(() -> new Defender(), 4);

        var res = Battle.fight(army1, army2);
        assertEquals(true, res);
    }

    @Test
    @DisplayName("8. Battle")
    void testBattle8() {
        var army1 = new Army();
        var army2 = new Army();

        army2.addUnit(() -> new Defender(), 5).addUnit(() -> new Warrior(), 10);
        army1.addUnit(() -> new Warrior(), 5);
        army2.addUnit(() -> new Defender(), 10);

        var res = Battle.fight(army1, army2);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("9. Battle")
    void testBattle9() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 2).addUnit(() -> new Knight(), 1).addUnit(() -> new Defender(), 1);
        army2.addUnit(() -> new Knight(), 5);

        var res = Battle.fight(army1, army2);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("10. Battle")
    void testBattle10() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 5).addUnit(() -> new Vampire(), 6).addUnit(() -> new Warrior(), 7);
        army2.addUnit(() -> new Warrior(), 6).addUnit(() -> new Defender(), 6).addUnit(() -> new Vampire(), 6);

        var res = Battle.fight(army1, army2);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("11. Battle")
    void testBattle11() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 2).addUnit(() -> new Vampire(), 3).addUnit(() -> new Warrior(), 4);
        army2.addUnit(() -> new Knight(), 4).addUnit(() -> new Defender(), 4).addUnit(() -> new Vampire(), 3);

        var res = Battle.fight(army1, army2);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("12. Battle")
    void testBattle12() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 11).addUnit(() -> new Vampire(), 3).addUnit(() -> new Warrior(), 4);
        army2.addUnit(() -> new Warrior(), 4).addUnit(() -> new Defender(), 4).addUnit(() -> new Vampire(), 13);

        var res = Battle.fight(army1, army2);
        assertEquals(true, res);
    }


    @Test
    @DisplayName("13. Battle")
    void testBattle13() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Defender(), 9).addUnit(() -> new Vampire(), 3).addUnit(() -> new Warrior(), 8);
        army2.addUnit(() -> new Warrior(), 4).addUnit(() -> new Defender(), 4).addUnit(() -> new Vampire(), 13);

        var res = Battle.fight(army1, army2);
        assertEquals(true, res);
    }

    @Test
    @DisplayName("14. Battle")
    void testBattle14() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnit(() -> new Warrior(), 1).addUnit(() -> new Lancer(), 1);
        army2.addUnit(() -> new Lancer(), 2).addUnit(() -> new Knight(), 2);

        var res = Battle.fight(army1, army2);
        assertEquals(false, res);
    }

    @Test
    @DisplayName("15. Battle")
    void testBattle15() {
        var myArmy = new Army();
        var enemyArmy = new Army();
        myArmy.addUnit(() -> new Defender(), 2).addUnit(() -> new Vampire(), 2)
                .addUnit(() -> new Lancer(), 4).addUnit(() -> new Warrior(), 1);
        enemyArmy.addUnit(() -> new Warrior(), 2).addUnit(() -> new Lancer(), 2)
                .addUnit(() -> new Defender(), 2).addUnit(() -> new Vampire(), 3);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("16. Battle")
    void testBattle16() {
        var myArmy = new Army();
        var enemyArmy = new Army();
        myArmy.addUnit(() -> new Warrior(), 1).addUnit(() -> new Lancer(), 1)
                .addUnit(() -> new Defender(), 2);
        enemyArmy.addUnit(() -> new Vampire(), 3).addUnit(() -> new Warrior(), 1)
                .addUnit(() -> new Lancer(), 2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertFalse(res);
    }

    @Test
    @DisplayName("17. Battle")
    void testBattle17() {
        var armyOne = new Army();
        var armyTwo = new Army();
        armyOne.addUnit(Lancer::new, 5).addUnit(Vampire::new, 3)
                .addUnit(Warrior::new, 4).addUnit(Defender::new, 2);
        armyTwo.addUnit(Warrior::new, 4).addUnit(Defender::new, 4)
                .addUnit(Vampire::new, 6).addUnit(Lancer::new, 5);
        var res = Battle.fight(armyOne, armyTwo);
        assertFalse(res);
    }

    @Test
    @DisplayName("18. Battle")
    void testBattle18() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnit(Lancer::new, 7).addUnit(Vampire::new, 3)
                .addUnit(Warrior::new, 4).addUnit(Defender::new, 2);
        army2.addUnit(Warrior::new, 4).addUnit(Defender::new, 4)
                .addUnit(Vampire::new, 6).addUnit(Lancer::new, 4);
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("19. Battle")

    /*This test is not working :-( */

    void testBattle19() {
        var armyWarrior = new Army();
        var armyLancer = new Army();
        armyWarrior.addUnit(Warrior::new, 2);
        armyLancer.addUnit(Lancer::new, 1);
        armyLancer.addUnit(Warrior::new, 1);
        var res = Battle.fight(armyWarrior, armyLancer);
        assertFalse(res);
    }

    @Test
    @DisplayName("20. Battle")
    void testBattle20() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnit(Warrior::new, 1);
        army2.addUnit(Warrior::new, 1).addUnit(Healer::new, 1);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("21. Battle")
    void testBattle21() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnit(Lancer::new, 7).addUnit(Vampire::new, 3).addUnit(Healer::new, 1)
                .addUnit(Warrior::new, 4).addUnit(Healer::new, 1).addUnit(Defender::new, 2);
        army2.addUnit(Warrior::new, 4).addUnit(Defender::new, 4).addUnit(Healer::new, 1)
                .addUnit(Vampire::new, 6).addUnit(Lancer::new, 4);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("22. Battle")
    void testBattle22() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnit(Lancer::new, 1).addUnit(Warrior::new, 3).addUnit(Healer::new, 1)
                .addUnit(Warrior::new, 4).addUnit(Healer::new, 1).addUnit(Knight::new, 2);
        army2.addUnit(Warrior::new, 4).addUnit(Defender::new, 4).addUnit(Healer::new, 1)
                .addUnit(Vampire::new, 6).addUnit(Lancer::new, 4);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }


    @Test
    @DisplayName("23. Battle")
    void testBattle23() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnit(Lancer::new, 7).addUnit(Vampire::new, 3).addUnit(Warrior::new, 4)
                .addUnit(Defender::new, 2).addUnit(Healer::new, 2);
        army2.addUnit(Warrior::new, 4).addUnit(Defender::new, 4)
                .addUnit(Vampire::new, 6).addUnit(Lancer::new, 4).addUnit(Healer::new, 1);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("24. Battle")
    void testBattle24() {
        var people = new Army();
        var aliens = new Army();
        people.addUnit(Defender::new, 2).addUnit(Knight::new, 2).addUnit(Healer::new, 1);
        aliens.addUnit(Vampire::new, 1).addUnit(Warrior::new, 2).addUnit(Knight::new, 1);
        var res = Battle.fight(people, aliens);
        assertTrue(res);
    }

    @Test
    @DisplayName("25. Battle")
    void testBattle25() {
        var people = new Army();
        var aliens = new Army();
        people.addUnit(Knight::new, 5).addUnit(Rookie::new, 15).addUnit(Vampire::new, 4);
        aliens.addUnit(Rookie::new, 20).addUnit(Warrior::new, 5).addUnit(Healer::new, 1);
        var res = Battle.fight(people, aliens);
        assertTrue(res);
    }


    @Test
    @DisplayName("999. Battle")
    void test999() {
        var army1 = new Army();
        var army2 = new Army();
        var army3 = new Army();
        var army4 = new Army();

        army1.addUnit(() -> new Defender(), 2).addUnit(() -> new Vampire(), 2).addUnit(() -> new Warrior(), 1);
        army2.addUnit(() -> new Warrior(), 2).addUnit(() -> new Defender(), 2).addUnit(() -> new Vampire(), 3);
        army3.addUnit(() -> new Warrior(), 1).addUnit(() -> new Defender(), 4);
        army4.addUnit(() -> new Vampire(), 3).addUnit(() -> new Warrior(), 2);


        var res = Battle.fight(army1, army2);
        var res2 = Battle.fight(army3, army4);
        assertEquals(false, res);
        assertEquals(true, res2);
    }


    @ParameterizedTest
    @MethodSource
    @DisplayName("Duel for two armies")
    void testDuelArmy(Army army1, Army army2, boolean expected) {
        var res = Battle.fight(army1, army2);
        assertEquals(expected, res);
    }

    static Stream<Arguments> testDuelArmy() {
        return Stream.of(
                Arguments.of(new Army().addUnit(Warrior::new, 5),
                        new Army().addUnit(Knight::new, 1).addUnit(Warrior::new, 1),
                        true),
                Arguments.of(new Army().addUnit(Warrior::new, 3).addUnit(Knight::new, 2),
                        new Army().addUnit(Knight::new, 3).addUnit(Knight::new, 2),
                        false)
        );
    }

    @Test
    @DisplayName("Smoke test for Defender task")
    void smokeTestForDef() {
        var myArmy = new Army();
        myArmy.addUnit(() -> new Warrior(), 5);

        var notMyArmy = new Army();
        notMyArmy.addUnit(() -> new Defender(), 4);

        var alsoMyArmy = new Army();
        alsoMyArmy.addUnit(() -> new Defender(), 4).addUnit(() -> new Defender(), 1);

        var army4 = new Army();
        army4.addUnit(() -> new Warrior(), 4);

        var res = Battle.fight(myArmy, notMyArmy);
        var alsoRes = Battle.fight(alsoMyArmy, army4);

        assertEquals(true, res);
        assertEquals(true, alsoRes);
    }

    @Test
    @DisplayName("Smoke test for Rookie task")
    void smokeTestForRookie() {
        var army01 = new Army();
        army01.addUnit(() -> new Rookie(), 1);

        var army02 = new Army();
        army02.addUnit(() -> new Rookie(), 3);

        var res = Battle.fight(army01, army02);
        assertEquals(false, res);

        var army03 = new Army();
        army03.addUnit(() -> new Warrior(), 1).addUnit(() -> new Rookie(), 10);

        var army04 = new Army();
        army04.addUnit(() -> new Rookie(), 20).addUnit(() -> new Knight(), 3);

        var result =  Battle.fight(army03, army04);
        assertEquals(false, result);
    }


    @ParameterizedTest
    @MethodSource
    @DisplayName("Duel for two warriors")
    void testDuel(Warrior warrior1, Warrior warrior2, boolean expected) {
        var res = Battle.fight(warrior1, warrior2);
        assertEquals(expected, res);
    }

    static Stream<Arguments> testDuel() {
        return Stream.of(Arguments.of(new Defender(), new Defender(), true),
                Arguments.of(new Warrior(), new Defender(), false),
                Arguments.of(new Knight(), new Defender(), true),
                Arguments.of(new Defender(), new Warrior(), true),
                Arguments.of(new Rookie(), new Defender(), false),
                Arguments.of(new Warrior(), new Rookie(), true),
                Arguments.of(new Rookie(), new Lancer(), false),
                Arguments.of(new Lancer(), new Vampire(), true),
                Arguments.of(new Defender(), new Lancer(), false),
                Arguments.of(new Vampire(), new Healer(), true)
        );
    }
}