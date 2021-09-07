public class IteratorSample {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Iterator<String> iterator = menu.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

class Menu{
    private String[]  items = {"fish", "cheese"};

    Iterator<String> getIterator(){
        return new Iterator<String>() {
            int i;
            @Override
            public boolean hasNext() {
                return i < items.length;
            }

            @Override
            public String next() {
                return items[i++];
            }
        };
    }

}

interface Iterator<T>{
    boolean hasNext();
    T next();
}
