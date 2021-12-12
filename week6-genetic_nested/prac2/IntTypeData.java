public class IntTypeData extends SpecificTypeData<Integer>{
    public IntTypeData(int data) {
        super(data);
    }

    @Override
    public void addData(Integer data) {
        super.data += data;
    }
}
