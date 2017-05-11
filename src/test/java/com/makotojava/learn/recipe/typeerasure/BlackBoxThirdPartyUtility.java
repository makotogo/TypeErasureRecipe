package com.makotojava.learn.recipe.typeerasure;

import java.util.ArrayList;
import java.util.List;

public class BlackBoxThirdPartyUtility {

  /**
   * Creates and returns a List of Persons.
   * We can't be more specific, or it would spoil
   * our evil plot. So just... trust us...
   * <br/>
   * BWAHAHAAAAAA
   * 
   * @param persons
   *          The Person objects that go into the List
   *          that is returned.
   * 
   * @return List - Person objects are in here. Sure (wink). Trust us.
   */
  public static List createPeople(Person... persons) {
    List ret = new ArrayList();
    for (Person person : persons) {
      // Obviously if we own the code we wouldn't do this,
      /// but we don't always own the code, do we?
      ret.add(person.getName());
    }
    return ret;
  }

}
