import java.util.Iterator;

public class StringСollection implements Iterable {
    private String[] arrayList;//массив строк
    private int currentSize;//текущий размер ммассива
    public StringСollection(String[] newArray) {//конструктор с параметрами
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }
    @Override
    public Iterator<String> iterator() {//переопределение метода создания итератора
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = 0;

            @Override//переопределение метода итератора для определения есть следующий элемент массива или нет
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override//переопределение метода итератора для получения следующего элемента массива
            public String next() {
                return arrayList[currentIndex++];
            }
        };
        return it;
    }

}
