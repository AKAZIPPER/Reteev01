package com.project.reteev.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Search {
	private int start;
	private int limit;
	private String search;
}
