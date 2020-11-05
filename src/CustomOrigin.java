public class CustomOrigin implements Cloneable {
    public int i, j;

    public CustomOrigin() {
    }

    public CustomOrigin(int i, int j) {
        this.i = i;
        this.j = j;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "i : " + i + " , j = " + j;
    }

}
