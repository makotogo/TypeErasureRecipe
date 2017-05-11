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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing App class")
public class AppTest {

  private static final Logger log = Logger.getLogger(AppTest.class.getName());

  private App classUnderTest;

  private Person person1;
  private Person person2;
  private Employee employee1;
  private Employee employee2;

  @BeforeEach
  public void setUp() throws Exception {
    classUnderTest = new App();

    person1 = new Person("Joe", 32);
    person2 = new Person("Jane", 35);

    employee1 = new Employee("Joe", 32, "EMP000101");
    employee2 = new Employee("Jane", 35, "EMP000201");

  }

  @AfterEach
  public void tearDown() throws Exception {
    person1 = person2 = null;
    employee1 = employee2 = null;
  }

  @Nested
  @DisplayName("Processing List of Things")
  public class ProcessListOfThings {
    @Test
    @DisplayName("People")
    public void processPeople() {
      List<Person> people = createPeople(person1, person2);
      classUnderTest.process(people);
    }

    @Test
    @DisplayName("Employees")
    public void processEmployees() {
      List<Employee> employees = createEmployees(employee1, employee2);
      classUnderTest.process(employees);
    }

    @Test
    @Disabled
    @DisplayName("Disabled test - compiler error")
    public void process() {
      List<Employee> employees = createEmployees(employee1);
// classUnderTest.processPeople(employees);
      classUnderTest.processEmployees(employees);
    }
  }

  @Nested
  @DisplayName("Processing List of Person")
  public class ProcessListOfPerson {

    private List<Person> people;

    @BeforeEach
    public void setUp() {
      people = createPeople(person1, person2);
    }

    @Test
    @DisplayName("Alternative 1 - use covariant type - array in this case")
    public void process() {
      Person[] people = this.people.toArray(new Person[] {});
      classUnderTest.process(people);
    }

    @Test
    @DisplayName("Alternative 2 - change method name")
    public void processPeople() {
      classUnderTest.processPeople(people);
    }
  }

  @Nested
  @DisplayName("Processing List of Employee")
  public class ProcessListOfEmployee {

    private List employees;

    @BeforeEach
    public void setUp() {
      employees = createEmployees(employee1, employee2);
    }

    @Test
    @DisplayName("Alternative 1 - use covariant type - array in this case")
    public void process() {
      // Using a raw List type is a LOT of work!
      Employee[] employees = new Employee[this.employees.size()];
      for (int aa = 0; aa < this.employees.size(); aa++) {
        employees[aa] = (Employee) this.employees.get(aa);
      }
      classUnderTest.process(employees);
    }

    @Test
    @DisplayName("Alternative 2 - change method name")
    public void processPeople() {
      classUnderTest.processEmployees(employees);
    }
  }

  @Nested
  @DisplayName("Ignoring compiler warnings")
  public class IgnoreWarnings {

    @Test
    @DisplayName("Processing Person - PolluteHeap in the process")
    public void processPerson() {
      // The compiler is trying to warn us
// List people = BlackBoxThirdPartyUtility.createPeople(person1, person2);
      List<Person> people = BlackBoxThirdPartyUtility.createPeople(person1, person2);
      classUnderTest.processPeople(people);
    }
  }

  //
  public static List<Person> createPeople(Person... persons) {
    List<Person> ret = new ArrayList<>();
    for (Person person : persons) {
      ret.add(person);
    }
    return ret;
  }

  public static List<Employee> createEmployees(Employee... employees) {
    List<Employee> ret = new ArrayList<>();
    for (Employee employee : employees) {
      ret.add(employee);
    }
    return ret;
  }

}
