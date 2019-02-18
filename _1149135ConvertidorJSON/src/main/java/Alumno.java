import lombok.Data;

@Data
public class Alumno {

    private String nombre;
    private String apeidoP;
    private String apeidoM;
    private int matricula;

    public Alumno(String nombre, String apeidoP, String apeidoM, int matricula) {
        this.nombre = nombre;
        this.apeidoP = apeidoP;
        this.apeidoM = apeidoM;
        this.matricula = matricula;
    }
}
