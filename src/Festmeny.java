import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;


public class Festmeny {
    String cim;
    String festo;
    String stilus;
    int licitekszama = 0;
    int legmagasabblicit = 0;
    LocalDateTime legutolsolicitideje;
    boolean elkelt = false;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
    }
    public  Festmeny(String row){
        var s=row.split(";");
        this.cim = s[0];
        this.festo = s[1];
        this.stilus = s[2];
    }

    @Override
    public String toString() {
        return
                "cim='" + cim + '\'' +
                ", festo='" + festo + '\'' +
                ", stilus='" + stilus + '\'' +
                '}';
    }
}
