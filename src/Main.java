import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        var lines= Files.readAllLines(Paths.get("festmenyek.csv"));
        var paintings=new LinkedList<Festmeny>();
        for (var line:lines){
            var festmenyek=new Festmeny(line);
            paintings.add(festmenyek);
        }
        System.out.println(paintings);
    }
}