package ttps.clasesDeObjetosDelSistema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="usuario_id")
	private long id;
	
	@Column
	private String nombreUsuario;
	
	@Column
	private String email;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String clave;
	
//	@ManyToMany()
//	@JoinTable(name="usuarios_gastos",
//			   joinColumns = @JoinColumn(name = "usuarios_id"), 
//			   inverseJoinColumns = @JoinColumn(name = "gastos_id")
//	)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "realizaGasto")
	private List<Gasto> gastos;
	
	@ManyToMany()
	@JoinTable(name="usuarios_grupos",
			   joinColumns = @JoinColumn(name = "usuarios_id"), 
			   inverseJoinColumns = @JoinColumn(name = "grupos_id")
	)
	private List<Grupo> grupos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "usuario")
	private List<Pago> pagos;
	
	@ManyToMany()
	@JoinTable(name="amigos",
			   joinColumns = @JoinColumn(name = "usuarios_id"), 
			   inverseJoinColumns = @JoinColumn(name = "usuarios_id")
	)
	private List<Usuario> amigos;
	
	public Usuario() {
		
	}
	
	
	



	public Usuario(String nombreUsuario, String email, String nombre, String apellido, String clave, List<Gasto> gastos,
			List<Grupo> grupos, List<Pago> pagos, List<Usuario> amigos) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
		this.gastos = gastos;
		this.grupos = grupos;
		this.pagos = pagos;
		this.amigos = amigos;
	}






	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}






	public List<Usuario> getAmigos() {
		return amigos;
	}






	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}
	
	
	
}