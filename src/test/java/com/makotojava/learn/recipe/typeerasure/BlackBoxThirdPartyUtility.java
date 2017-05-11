/*
 * Copyright 2017 Makoto Consulting Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
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
