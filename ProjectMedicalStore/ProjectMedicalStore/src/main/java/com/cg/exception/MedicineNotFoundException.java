package com.cg.exception;

public class MedicineNotFoundException extends RuntimeException {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String msg;
		
		public MedicineNotFoundException(String msg) {
			this.msg = msg;
		}
		
		@Override
		public String getMessage() {
			return msg;
			
		}
	}


