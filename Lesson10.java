import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.Properties;

class Employee implements Serializable {
  private String name;
  private int age;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

class Depertment implements Serializable {
  private String name;
  private Employee leader;

  public Depertment(String name, Employee e) {
    this.name = name;
    this.leader = e;
  }
  public String getName() {
    return this.name;
  }
}

public class Lesson10 {
  public static void main(String[] args) throws Exception {
    Reader fr = new FileReader("pref.properties");
    Properties p = new Properties();
    p.load(fr);
    String capital = p.getProperty("aichi.capital");
    String food = p.getProperty("aichi.food");

    System.out.println(capital + "：" + food);
    fr.close();

    Employee e1 = new Employee("田中太郎", 41);
    Depertment d1 = new Depertment("総務部", e1);

    FileOutputStream fout = new FileOutputStream("company.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(d1);
    oos.flush();
    oos.close();

    FileInputStream fis = new FileInputStream("company.dat");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Depertment d2 = (Depertment) ois.readObject();
    ois.close();

    System.out.println(d2.getName());
  }
}
