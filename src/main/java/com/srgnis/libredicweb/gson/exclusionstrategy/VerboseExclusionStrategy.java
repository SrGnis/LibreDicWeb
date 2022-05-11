package com.srgnis.libredicweb.gson.exclusionstrategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.srgnis.libredicweb.annotation.Exclude;

public class VerboseExclusionStrategy implements ExclusionStrategy{
	public VerboseExclusionStrategy() {
    }

    public boolean shouldSkipField(FieldAttributes f) {
      return f.getAnnotation(Exclude.class) != null;
    }

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}
