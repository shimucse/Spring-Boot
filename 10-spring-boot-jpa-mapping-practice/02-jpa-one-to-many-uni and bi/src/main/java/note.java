public class note
{

    /*
    JPA / Hibernate Cheat Sheet
🧠 1. Core Idea
Owner side → controls DB
Inverse side → mappedBy
FK decides owner
Always sync both sides


🔑 2. One-to-One
✅ Owner
@OneToOne
@JoinColumn(name="instructor_detail_id")
private InstructorDetail instructorDetail;


✅ Inverse
@OneToOne(mappedBy = "instructorDetail")
private Instructor instructor;

✔ Owner = has FK
✔ Inverse = uses mappedBy



🔁 3. One-to-Many
✅ Many side (OWNER)
@ManyToOne
@JoinColumn(name="instructor_id")
private Instructor instructor;

✅ One side (INVERSE)
@OneToMany(mappedBy="instructor", cascade = CascadeType.ALL)
private List<Course> courses;
🔧 Helper
public void addCourse(Course c){
    if(courses == null) courses = new ArrayList<>();
    courses.add(c);
    c.setInstructor(this);
}

🔗 4. Many-to-Many
✅ Owner
@ManyToMany(cascade = {PERSIST, MERGE})
@JoinTable(
  name="course_student",
  joinColumns=@JoinColumn(name="student_id"),
  inverseJoinColumns=@JoinColumn(name="course_id")
)
private List<Course> courses;


✅ Inverse
@ManyToMany(mappedBy="courses")
private List<Student> students;
⚡ 5. Cascade
Use	Setting
OneToOne	ALL
OneToMany	ALL
ManyToMany	PERSIST, MERGE
💤 6. Lazy Loading

❌ Error:

LazyInitializationException



✅ Fix:

@Transactional

OR

JOIN FETCH
❗ 7. Common Errors
Error	Fix
No @Id	use jakarta.persistence.Id
Unsaved entity	add cascade or save first
Duplicate entry	change value / remove UNIQUE
Lazy error	use transaction
🔥 8. Owner Rule (IMPORTANT)
Relation	Owner
OneToOne	FK side
OneToMany	Many side
ManyToMany	@JoinTable side
🎯 9. 4-Step Thinking
Where is FK?
Who is owner?
Need cascade?
Lazy safe?
💯 Final Rule

👉 If DB changes → owner side must handle it
     */
}
