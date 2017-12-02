/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package este.exceptions;

/**
 *
 * @author Machado
 */
public class CrudRemoveException extends Exception {
	private String message;

	public CrudRemoveException() {
		// TODO Auto-generated constructor stub
	}

	public CrudRemoveException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
