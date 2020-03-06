package iteach.eaap.architecturestyles.hexagonal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private double price;
}
