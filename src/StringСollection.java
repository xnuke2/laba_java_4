import java.util.Iterator;

public class StringСollection implements Iterable {
    private String[] arrayList;
    private int currentSize;
    public StringСollection(String[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }
    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public String next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
