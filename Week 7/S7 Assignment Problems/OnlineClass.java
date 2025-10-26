class Course {
    String title;

    Course(String t) {
        title = t;
    }

    void showProgress() {
        System.out.println(title + ": General progress");
    }
}

class VideoCourse extends Course {
    VideoCourse(String t) {
        super(t);
    }

    void showProgress() {
        System.out.println(title + ": 70% watched");
    }
}

class InteractiveCourse extends Course {
    InteractiveCourse(String t) {
        super(t);
    }

    void showProgress() {
        System.out.println(title + ": 80% quiz done");
    }
}

public class OnlineClass {
    public static void main(String[] args) {
        Course c1 = new VideoCourse("Java Basics");
        Course c2 = new InteractiveCourse("Python Hands-on");
        c1.showProgress();
        c2.showProgress();
    }
}
