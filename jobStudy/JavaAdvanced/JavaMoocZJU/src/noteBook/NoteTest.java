package noteBook;

/**
 * @author filwsx
 * @date 2022-03-03 13:48
 */
public class NoteTest {
    public static void main(String[] args) {
        Notebook note = new Notebook();
        note.add("helloWorld");
        note.add("filwsx");
        note.add("Third");
        note.add("end");
        System.out.println(note.getSize());
        System.out.println(note.getNote(2));
        System.out.println(note.getNote(0));
        System.out.println(note.getNote(4));
        note.removeNote(4);
        System.out.println(note.getNote(4));
        String res[] = note.list();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
