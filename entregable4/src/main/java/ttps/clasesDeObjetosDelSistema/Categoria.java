package ttps.clasesDeObjetosDelSistema;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="categoria_id")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private File imagen;
	
	@Column
	private int tipo;

}