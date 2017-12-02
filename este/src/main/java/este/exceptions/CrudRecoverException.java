/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package este.exceptions;

/**
 *
 * @author Álefe Macedo
 */
public class CrudRecoverException extends Exception {
	private String message;

	public CrudRecoverException() {
		// TODO Auto-generated constructor stub
	}

	public CrudRecoverException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
