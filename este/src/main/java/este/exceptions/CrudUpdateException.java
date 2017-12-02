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
public class CrudUpdateException extends Exception {
	private String message;

	public CrudUpdateException() {
		// TODO Auto-generated constructor stub
	}

	public CrudUpdateException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
