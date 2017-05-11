package com.makotojava.learn.recipe.typeerasure;

public class Foo {

  public void bar() {
  }

  public void bar(int a) {
  }

  public void bar(String a) {
  }

  public void bar(Person a) {
  }

  public void bar(Employee a) {
  }

  public void bar(Person[] a) {
  }

  public void bar(Employee[] a) {
  }

// public void bar(List<Person> a) {
// }

  // Uncomment this and watch what happens...
// public void bar(List a) {
// }

}
