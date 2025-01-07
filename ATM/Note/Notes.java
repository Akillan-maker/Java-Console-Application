package ATM.Note;

public class Notes implements Cloneable{
    private String note;      // Declared a variable note
    private long notecount;   // Declared a variable notecount

    protected Notes(String note, int count){      // Constructor is created and initialized

        this.note=note;    // Assigns note
        this.notecount=count;    // Assigns notecount

    }

    public String getNote(){  // Gets note

        return note;  // Returns note

    }

    public long getNotecount(){   // Gets notecount

        return notecount; // Returns notecount

    }
//    public void setNote(String note){  // Sets note
//
//        this.note=note;
//
//    }

    public void setNotecount(long notecount) {   // Sets notecount

        this.notecount = notecount;   // Assigns notecount

    }

    // To avoid the CloneNotSupportedExpection

    @Override
    public Notes clone() throws CloneNotSupportedException{
        return (Notes) super.clone();

    }
}