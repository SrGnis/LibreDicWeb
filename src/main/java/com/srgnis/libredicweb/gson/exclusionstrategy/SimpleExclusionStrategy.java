package com.srgnis.libredicweb.gson.exclusionstrategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.srgnis.libredicweb.annotation.Exclude;
import com.srgnis.libredicweb.annotation.Verbose;

public class SimpleExclusionStrategy implements ExclusionStrategy{
	public SimpleExclusionStrategy() {
    }

    public boolean shouldSkipField(FieldAttributes f) {
      return f.getAnnotation(Exclude.class) != null || f.getAnnotation(Verbose.class) != null;
    }

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}
