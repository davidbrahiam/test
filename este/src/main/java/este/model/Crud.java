/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package este.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crud")
public class Crud implements Serializable {

	private long id;
	private String nome;

	public Crud() {

	}

	public Crud(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome; // To change body of generated methods, choose Tools | Templates.
	}

	@Column(nullable = false)
	public String getNome() {
		return this.nome;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return this.id;

	}

	public void setId(long id) {
		this.id = id;
	}

}
