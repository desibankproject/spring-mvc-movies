package com.movie.soap.webservice.provider;

public class SoapError {
		private String message;
		private String code;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		@Override
		public String toString() {
			return "SoapError [message=" + message + ", code=" + code + "]";
		}
		
}
