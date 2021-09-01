import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeSample {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder usr = new Folder("usr");
        Folder data = new Folder("data");
        Folder data1 = new Folder("data_1");
        Folder data2 = new Folder("data_2");
        Folder data3 = new Folder("data_2");
        root.addFolders(usr, data);
        data.addFolders(data1, data2, data3);

        root.printFolders();
    }
}
class Folder{
    private String name;
    private List<Folder> list = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    void addFolders(Folder... folders){
        list.addAll(Arrays.asList(folders));
    }

    void printFolders(){
        list.forEach(folder -> {
            System.out.println(folder.name);
            folder.printFolders();
        });
    }
}
