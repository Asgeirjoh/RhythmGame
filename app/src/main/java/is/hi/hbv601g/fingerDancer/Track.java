package is.hi.hbv601g.fingerDancer;

public class Track {

    private String name;
    private int id;
    private int length;
    private Double bpm;
    private Note[] note;
    private int offset;


    public Track(String name, int id, int length, Double bpm, Note[] note, int offset) {
        this.name = name;
        this.id = id;
        this.length = length;
        this.bpm = bpm;
        this.note = note;
        this.offset = offset;
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

    public Note[] getNote() {
        return note;
    }

    public void setNote(Note[] note) {
        this.note = note;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
