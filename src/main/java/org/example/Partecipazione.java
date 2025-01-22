package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
  
}
