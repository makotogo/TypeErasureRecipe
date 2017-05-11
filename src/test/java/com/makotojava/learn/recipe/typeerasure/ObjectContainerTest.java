package com.makotojava.learn.recipe.typeerasure;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ObjectContainerTest {

  @Test
  public void testSetContained() {
    ObjectContainer<Integer> objectContainer = new ObjectContainer<>(Integer.valueOf(238));
    objectContainer.setContained(Integer.valueOf(239));
  }

}
