package com.makotojava.learn.recipe.typeerasure;

public class PersonContainer extends ObjectContainer<Person> {

  public PersonContainer(Person contained) {
    super(contained);
  }

  @Override
  public void setContained(Person contained) {
    super.setContained(contained);
  }

}
