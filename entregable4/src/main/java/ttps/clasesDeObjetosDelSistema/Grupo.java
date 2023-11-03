package ttps.clasesDeObjetosDelSistema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="grupo_id")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private double miSaldo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToMany(mappedBy = "usuarios")
	private List<Usuario> usuarios;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "grupo")
	private List<Gasto> gastos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "grupo")
	private List<Pago> pagos;
}