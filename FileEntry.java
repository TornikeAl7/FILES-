import java.io.Serializable;

public class FileEntry implements Serializable {
    private String fileName;
    private String content;

    public FileEntry(String fileName, String content){
        this.fileName=fileName;
        this.content=content;
    }

    public String getFileName(){
        return fileName;
    }

    public String getContent(){
        return content;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContent(String content){
        this.content=content;
    }

    @Override
    public String toString() {
        return "FileEntry{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
