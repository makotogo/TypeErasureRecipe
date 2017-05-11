package com.makotojava.learn.recipe.typeerasure;

/*
 * Copyright 2016 Makoto Consulting Group, Inc.
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
public class Employee extends Person {

  private String employeeNumber;

  public Employee(String name, int age, String employeeNumber) {
    super(name, age);
    this.employeeNumber = employeeNumber;
  }

  public String getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  @Override
  public String toString() {
    return "Employee [employeeNumber=" + employeeNumber
        + ", " + super.toString() + "]";
  }

}
