public class Person implements MyMovable{
    private String type;

    public Person(String type){
        this.type = type;
    }

    @Override
    public String moveBy() {
        return String.format("나는 %s로 출근한다.", type);
    }
}
