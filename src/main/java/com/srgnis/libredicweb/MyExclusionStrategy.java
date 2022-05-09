package com.srgnis.libredicweb;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class MyExclusionStrategy implements ExclusionStrategy {

    MyExclusionStrategy() {
    }

    public boolean shouldSkipField(FieldAttributes f) {
      return f.getAnnotation(Foo.class) != null;
    }

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
  }
