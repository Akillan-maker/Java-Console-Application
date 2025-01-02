package ATM;

public class Notes implements Cloneable{
    private  String note;
    private long notecount;

    public Notes(String note,int count){
        this.note=note;
        this.notecount=count;
    }

    public String getNote(){

        return note;

    }
    public void setNote(String note){

        this.note=note;

    }

    public void setNotecount(long notecount) {

        this.notecount = notecount;
    }

    public long getNotecount(){

        return notecount;

    }

    @Override
    public Notes clone() throws CloneNotSupportedException{
        return (Notes) super.clone();

    }
}
