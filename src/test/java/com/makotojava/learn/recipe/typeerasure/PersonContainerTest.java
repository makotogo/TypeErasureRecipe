package com.makotojava.learn.recipe.typeerasure;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing PersonContainer")
public class PersonContainerTest {

  @Nested
  public class PersonContainerTestOptimistic {

    @Test
    @DisplayName("Test PersonContainer in a @SafeVarargs way")
    public void testSetContainedPerson() {
      processPersonContainers(
          new PersonContainer(
              new Person("Test1", 23)));
    }

    @SafeVarargs
    final private <T extends ObjectContainer<Person>> void processPersonContainers(T... personContainers) {
      for (T personContainer : personContainers) {
        personContainer.setContained(new Person("Test2", 33));
      }
    }

  }

  @Nested
  @DisplayName("Pollute heap test")
  public class PersonContainerTestPolluteHeap {

    @Test
    @DisplayName("Testing PersonContainer - will throw ClassCastException")
    public void testSetContainedPerson() {
      PersonContainer pc = new PersonContainer(new Person("Test", 23));

      ObjectContainer oc = pc;// WARNING occurs here
      System.out.println("PersonContainer (through ObjectContainer): " + oc.toString());
      // ClassCastException. Not good.
      oc.setContained("Howdy!");
      assertThrows(ClassCastException.class, () -> oc.setContained("Howdy!"));
    }
  }

}
