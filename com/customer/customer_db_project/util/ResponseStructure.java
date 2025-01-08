package com.customer.customer_db_project.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<D> {

	private int statusCode;
	private String message;
	private D data;
}
