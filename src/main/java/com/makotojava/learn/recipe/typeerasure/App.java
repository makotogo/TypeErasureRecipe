package com.makotojava.learn.recipe.typeerasure;

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
 */
import java.util.List;
import java.util.logging.Logger;

public class App {

  private static final Logger log = Logger.getLogger(App.class.getName());

  // Totally generic method to process List of stuff
  public <T> int process(List<T> things) {
    for (T thing : things) {
      log.info("Processing thing: " + thing.toString());
    }
    return things.size();
  }

  // Alternative #1 - Use a covariant type (array)
  public int process(Person... people) {
    for (Person person : people) {
      log.info("Processing person: " + person.toString());
    }
    return people.length;
  }

  // Alternative #2 - Change the method name
  public int processPeople(List<Person> people) {
    for (Person person : people) {
      log.info("Processing person: " + person.toString());
    }
    return people.size();
  }

  // Alternative #1 - Use a covariant type (array)
  public int process(Employee... employees) {
    for (Employee employee : employees) {
      log.info("Processing employee: " + employee.toString());
    }
    return employees.length;
  }

  // Alternative #2 - Change the method name
  public int processEmployees(List<Employee> employees) {
    for (Employee employee : employees) {
      log.info("Processing employee: " + employee.toString());
    }
    return employees.size();
  }

}
