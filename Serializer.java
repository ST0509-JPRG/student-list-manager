import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    public static void serialize(Student[] students, String filepath) {
        FileOutputStream fout;
        ObjectOutputStream oos;
        try {
            fout = new FileOutputStream(filepath);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(students);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception!");
            e.printStackTrace();
        }
    }

    public static Student[] deserialize(String filepath) {
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream(filepath));
            Student[] deserializedStudentModules = (Student[]) fin.readObject();
            fin.close();
            return deserializedStudentModules;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!");
            e.printStackTrace();
        }

        return null;
    }
}
