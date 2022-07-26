
package dto;

public class Empleado {
    private Integer id;
    private String dni;
    private String nom;
    private String apellido;
    private String telefono;
    private String user;
    private String contraseña;
    private String tipo;
    private int salario;
    private String estado;

    public Empleado() {
    }

    public Empleado(Integer id, String dni, String nom, String apellido, String telefono, String user, String contraseña, String tipo, int salario, String estado) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.apellido = apellido;
        this.telefono = telefono;
        this.user = user;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.salario = salario;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    
    
}
