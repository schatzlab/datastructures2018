public class Student {
  private String name;
  private int grade;
  private Student partner;

  public Student(String n, int g) {
    this.name = n;
    this.grade = g;
  }

  public void setName(String s) {
    this.name = s;
  }

  public void setGrade(int g) {
    this.grade = g;
  }

  public void setPartner(Student p) {
    this.partner = p;
  }

  public String getName() {
    return this.name;
  }

  public int getGrade() {
    return this.grade;
  }

  public Student getPartner() {
    return this.partner;
  }

  public static void main(String[] args) {
    Student s1 = new Student("Mike", 100);
    Student s2 = new Student("Peter", 95);

    s1.setPartner(s2);
    s2.setPartner(s1);

    System.out.println(s1.getName() + " " + s1.getGrade() + " " + s1.getPartner().getName());
    System.out.println(s2.getName() + " " + s2.getGrade() + " " + s2.getPartner().getName());

    s2 = new Student("Kelly", 99);

    System.out.println(s1.getName() + " " + s1.getGrade() + " " + s1.getPartner().getName());
    System.out.println(s2.getName() + " " + s2.getGrade() + " " + s2.getPartner().getName());
  }
}
