package com.stone.util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class ExtJsonAdapter<T> {
	private int totalCount;
	
	private List<T> results = new ArrayList<T>();

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	public void addResult(T e)
	{
		this.results.add(e);
	}
}
