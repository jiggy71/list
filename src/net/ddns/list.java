package net.ddns;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class list {

    public static void main(String[] args) {
        String name;
        if (args.length < 1)    {
            name = Paths.get(".").toAbsolutePath().normalize().toString();
        } else  {
            name = args[0];
        }
        Directory directory = new Directory(name);
	    directory.printDir();
    }
}

class Directory {
    private ArrayList<DirectoryItem> dirItems = new ArrayList<>(100);

    Directory(String dirName) {
        //wypełnienie tablicy poszczególnymi pozycjami z katalogu
        File rootDir = new File(dirName);
        if (!rootDir.exists())  {
            System.out.println("Nie ma takiego katalogu: " + dirName);
            System.exit(1);
        }
        File[] rawDirItems = rootDir.listFiles();
        for (File item: rawDirItems)   {
            if (item.isFile())  {
                this.dirItems.add(new FileItem(item.getName()));
            }
            if (item.isDirectory())  {
                this.dirItems.add(new DirItem(item.getName()));
            }
        }
    }
    public void printDirs() {
        for (DirectoryItem item: this.dirItems)  {
            if (item instanceof DirItem)    {
                item.print();
            }
        }
    }
    public void printFiles()    {
        for (DirectoryItem item: this.dirItems) {
            if (item instanceof FileItem)   {
                item.print();
            }
        }
    }
    public void printDir()  {
        this.printDirs();
        this.printFiles();
    }
}
abstract class DirectoryItem {
    private String name;

    public DirectoryItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print();
}

class FileItem extends DirectoryItem {
    public FileItem(String name) {
        super(name);
    }
    public void print() {
        System.out.println(this.getName());
    }

}
class DirItem extends DirectoryItem {
     public DirItem(String name) {
         super(name);
     }
     public void print()    {
         System.out.println("<DIR>" + this.getName());
     }

 }