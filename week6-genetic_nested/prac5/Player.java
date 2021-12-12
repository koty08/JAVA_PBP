public abstract class Player {
    private String name ;
    private int jerseyNumber ;
    protected int speed ;

    public static class Builder {
        public String name;
        public int jerseyNumber;
        public int speed;
        private String type;

        public Builder setPlayerType(String type){
            this.type = type;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setJerseyNumber(int num){
            this.jerseyNumber = num;
            return this;
        }

        public Builder setSpeed(int speed){
            this.speed = speed;
            return this;
        }

        public Player build(){
            if(type.equals("forward")){
                return new Forward(this);
            }
            else if(type.equals("midfielder")){
                return new MidFielder(this);
            }
            else{
                return new Defender(this);
            }
        }
    }
    protected abstract int getSpeed() ;
}
