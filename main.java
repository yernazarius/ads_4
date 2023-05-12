public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "Database Management Systems | Assanova Nurgul");
        bst.put(2, "History of Kazakhstan | Batalov Kairat");
        bst.put(3, "Algorithms and Data Structures | Khaimuldin Askar");
        bst.put(3, "Cultural Studies | Uyzbayeva Anar");
        bst.put(4, "Sociology SE | Kusmanova Asem");
        bst.put(5, "Psychology | Issakhanova Assel");
        bst.delete(4);
        System.out.println("This is size "+ bst.size());
        for (var n : bst ) System.out.println(n.key+" "+n.value);
    }
}
