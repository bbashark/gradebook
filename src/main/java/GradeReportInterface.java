package gradebook.model;


/**
 * GradeReport fosters Adapter pattern style uniform score and
 * grade reporting for Course, Class, Section and Student objects.
 *
 */
public interface GradeReportInterface {

    float avgScore();

    String letterGrade();
}
