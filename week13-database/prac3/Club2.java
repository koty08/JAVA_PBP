public class Club2 {
    private int ID;
    private String CLUB_NAME;

    public Club2(int id, String name){
        this.ID = id;
        this.CLUB_NAME = name;
    }

    @Override
    public String toString() {
        return "Club{" +
                "ID=" + ID +
                ", CLUB_NAME='" + CLUB_NAME + '\'' +
                '}';
    }
}
