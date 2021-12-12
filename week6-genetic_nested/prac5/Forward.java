public class Forward extends Player{
    private String name;
    private int jerseyNumber;
    protected int speed;
    public Forward(Builder builder) {
        this.name = builder.name;
        this.speed = builder.speed;
        this.jerseyNumber = builder.jerseyNumber;
    }

    @Override
    protected int getSpeed() {
        return this.speed;
    }

    @Override
    public String toString(){
        return String.format("Player Name='%s, JerseyNumber=%d, SPEED=%d, Forward", this.name, this.jerseyNumber, this.getSpeed());
    }
}
