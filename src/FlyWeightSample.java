import java.util.WeakHashMap;

public class FlyWeightSample {
    public static void main(String[] args) {
        StudentCache cache = new StudentCache();
        StudentUniversityInfo info = cache.getStudentUniversityInfo("management");
        StudentUniversityInfo info1 = cache.getStudentUniversityInfo("management");
        System.out.println(info == info1);
    }
}

// mutable
class StudentPersonalInfo{
    String name;
    int age;
    String homeAddress;
    double averageMark;
}
class Hostel{}

// immutable
class StudentUniversityInfo{
    private String faculty;
    private String universityCity;
    private Hostel hostel;

    public StudentUniversityInfo(String faculty, String universityCity, Hostel hostel) {
        this.faculty = faculty;
        this.universityCity = universityCity;
        this.hostel = hostel;
    }
}

class StudentCache{
    private final static WeakHashMap<String, StudentUniversityInfo> studentUniversityInfos = new WeakHashMap<>();

    StudentUniversityInfo getStudentUniversityInfo(String facultyName){
        StudentUniversityInfo info = studentUniversityInfos.get(facultyName);
        if(info == null){
            info = createStudentUniversityInfo(facultyName);
            studentUniversityInfos.put(facultyName, info);
        }
        return  info;
    }

    private StudentUniversityInfo createStudentUniversityInfo(String facultyName){
        switch (facultyName){
            case "jurisprudence":
                return new StudentUniversityInfo(facultyName, "NY", new Hostel());
            case "management":
                return new StudentUniversityInfo(facultyName, "LA", new Hostel());
            default:
                throw new IllegalArgumentException("wrong faculty");
        }
    }
}
