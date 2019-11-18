package net.ddns;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Directory directory = new Directory("C:/Users/adams");
	directory.printDir();
    }
}

class Directory {
    private ArrayList<DirectoryItem> dirItems = new ArrayList<>(100);

    Directory(String dirName) {
        //wypełnienie tablicy poszczególnymi pozycjami z katalogu
        File rootDir = new File(dirName);
        File[] rawDirItems = rootDir.listFiles();
        assert rawDirItems != null;
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
                ((DirItem) item).print();
            }
        }
    }
    public void printFiles()    {
        for (DirectoryItem item: this.dirItems) {
            if (item instanceof FileItem)   {
                ((FileItem) item).print();
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

    public void setName(String name) {
        this.name = name;
    }
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