package is.hi.hbv601g.fingerDancer;

public class Track {

    private String name;
    private int id;
    private int length;
    private Double bpm;
    private int[] notes;
    private int offset;
    private String filePath;

    public Track(String name, Double bpm, String filePath) {
        this.name = name;
        this.bpm = bpm;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Double getBpm() {
        return bpm;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
