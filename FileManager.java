import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileManager {
    private List<FileEntry> files;

    public FileManager(List<FileEntry> files){
        files = new ArrayList<>();
    }

    public void addFiles(String fileName, String content){
        FileEntry newFile = new FileEntry(fileName, content);
        files.add(newFile);
        System.out.println("File: " + newFile + " added succesfully");
    }

    public void viewFile(){
        if(files.isEmpty()){
            System.out.println("No files available.");
        } else {
            System.out.println("List of files: ");
            for(FileEntry file : files){
                System.out.println(file);
            }
        }
    }

    public void deleteFile(String fileName) throws FileNotFoundException {
        Iterator<FileEntry> iterator = files.iterator();
        boolean found = false;

        while(iterator.hasNext()){
            FileEntry file = iterator.next();
            if(file.getFileName().equals(fileName)){
                iterator.remove();
                found=true;
                System.out.println("File deleted succesfully: " + file);
                break;
            }
        }

        if(!found){
            throw new FileNotFoundException("File not found.");
        }
    }

    public void saveToFile(String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(files);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            files = (List<FileEntry>) ois.readObject();

        } catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
