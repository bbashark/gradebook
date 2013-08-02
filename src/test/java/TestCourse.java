/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;*/


//import org.junit.Test;
//import junit.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Comparator;
import java.util.ArrayList;

import gradebook.model.*;

/** 
 * Test cases for Course
 * 
 */
public class TestCourse {

	/**
	 * Testing Course.
	 */
	@Test
	public void testCourseFunctions() {
        // catagories (uses the Decorator pattern)
        // drop lowest
        DropLowestCategory dlCat = new DropLowestCategory(0.4f);
        GradebookItem dlItem1 = new GradebookItem("Quiz", 20.0f);
        GradebookItem dlItem2 = new GradebookItem("Quiz2", 20.0f);
        dlCat.addGradebookItem(dlItem1);
        dlCat.addGradebookItem(dlItem2);
        // normal category
        NormalCategory nCat = new NormalCategory(0.6f);
        GradebookItem nItem1 = new GradebookItem("Test", 100.0f);
        nCat.addGradebookItem(nItem1);
        // grading scheme
        GradingScheme gradingScheme = new GradingScheme();
        gradingScheme.addCategory(dlCat);
        gradingScheme.addCategory(nCat);
        
        // now for the Composite patterned Course structure
        // students
        Student brian = new Student("Brian", gradingScheme);
        brian.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        Student moo = new Student("Moo", gradingScheme);
        moo.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        Student wakka = new Student("Wakka", gradingScheme);
        wakka.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        
        // sections
        Section a1 = new Section();
        a1.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        a1.addStudent(brian);
        Section b1 = new Section();
        b1.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        b1.addStudent(moo);
        b1.addStudent(wakka);
        
        // classes
        GradebookClass physicsAM = new GradebookClass();
        physicsAM.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        physicsAM.addSection(a1);
        GradebookClass physicsPM = new GradebookClass();
        physicsPM.setGradeScale(60.0f, 70.0f, 80.0f, 90.0f);
        physicsPM.addSection(b1);
        
        // course
        ArrayList<String> prereqs = new ArrayList<String>();
        prereqs.add("Moo Math");
        prereqs.add("Moo Science");
        Course course = new Course("Physics", 101, "Physics Of Moo", prereqs);
        
        // give students grades
        // section a1
        brian.enterScore("Quiz", 20.0f);
        brian.enterScore("Quiz2", 0.0f);
        brian.enterScore("Test", 100.0f);
        // section b1
        moo.enterScore("Quiz", 20.0f);
        moo.enterScore("Quiz2", 17.0f);
        moo.enterScore("Test", 100.0f);
        wakka.enterScore("Quiz", 20.0f);
        wakka.enterScore("Quiz2", 5.0f);
        wakka.enterScore("Test", 100.0f);
        
        float finalAvgScore = course.avgScore();
        String finalAvgLetterGrade = course.letterGrade();
		assertEquals("Final average score should be equal to 100.0f", 100.0f, finalAvgScore);
        assertEquals("Final average letter grade should be 'A'", 'A', finalAvgLetterGrade.toCharArray()[0]);
	}
	
}
