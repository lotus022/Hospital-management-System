package com.cg.exception;

public class AmbulanceNotFoundException extends RuntimeException {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String msg;
		
		public AmbulanceNotFoundException(String msg) {
			this.msg = msg;
		}
		
		@Override
		public String getMessage() {
			return msg;
			
		}
	}


