package com.project.bootcamp.exception;

import com.project.bootcamp.comon.MessageCommon;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(MessageCommon.RECORDS_NOT_FOUND);
	}
}