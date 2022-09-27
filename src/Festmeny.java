import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;


public class Festmeny {
   private String cim;
   private String festo;
   private String stilus;
   private int licitekszama;
   private int legmagasabblicit;
   private LocalDateTime legutolsolicitideje;
   private boolean elkelt = false;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekszama=0;
        this.legmagasabblicit=0;
        this.legutolsolicitideje=null;
        this.elkelt=false;
    }

    public String getCim() {
        return cim;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekszama() {
        return licitekszama;
    }

    public int getLegmagasabblicit() {
        return legmagasabblicit;
    }

    public LocalDateTime getLegutolsolicitideje() {
        return legutolsolicitideje;
    }

    public boolean isElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }
    public void licit(){
        if (this.elkelt){
            throw new RuntimeException("elkelt");
        }
        if (this.licitekszama==0){
            this.legmagasabblicit=100;

        }else {
            int ujlicit=(int)(this.legmagasabblicit*1.1);
            String szovegeslicit=String.valueOf(ujlicit);
            int hossz=szovegeslicit.length();
            StringBuilder veglegeslicit=new StringBuilder(szovegeslicit.substring(0,2));
            for (int i = 0; i < hossz-2; i++) {
                veglegeslicit.append(0);
            }
            int veglegeszam=Integer.parseInt(veglegeslicit.toString());
            this.legmagasabblicit=veglegeszam;
        }
        this.licitekszama++;
        this.legutolsolicitideje=LocalDateTime.now();
    }
    public void licit(int mertek){
        if (mertek<10||mertek>100){
            throw new IllegalArgumentException("10 es 100 kozott kell legyen");
        }
        if (this.elkelt){
            throw new RuntimeException("elkelt");
        }
        if (this.licitekszama==0){
            this.legmagasabblicit=100;

        }else {
            int ujlicit=(this.legmagasabblicit*(100+mertek)/100);
            String szovegeslicit=String.valueOf(ujlicit);
            int hossz=szovegeslicit.length();
            StringBuilder veglegeslicit=new StringBuilder(szovegeslicit.substring(0,2));
            for (int i = 0; i < hossz-2; i++) {
                veglegeslicit.append(0);
            }
            int veglegeszam=Integer.parseInt(veglegeslicit.toString());
            this.legmagasabblicit=veglegeszam;
        }
        this.licitekszama++;
        this.legutolsolicitideje=LocalDateTime.now();
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
