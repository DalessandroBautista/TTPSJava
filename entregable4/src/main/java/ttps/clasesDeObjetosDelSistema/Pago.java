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
@Table(name = "pagos")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="gasto_id")
	private Long id;
	
	@Column
	private double monto;
	
	@Column
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="grupo_id", nullable=false)
	private Grupo grupo;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
