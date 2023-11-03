package ttps.clasesDeObjetosDelSistema;

import java.io.File;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "gastos")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="gasto_id")
	private Long id;
	
	@Column
	private double monto;
	
	@Column
	private File imagen;
	
	@Column
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	private Grupo grupo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_carga_id")
	private Usuario cargaGasto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_realiza_id")
	private Usuario realizaGasto;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "estrategia_id")
//	private EstrategiaDivision estrategia;

}