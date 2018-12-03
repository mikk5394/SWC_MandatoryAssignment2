package com.example.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "CourseTable")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseId")
    private Long id;

    @Column(name = "nameCourseDanish")
    private String nameDanish;

    @Column(name = "nameCourseEnglish")
    private String nameEnglish;

    @Column(name = "semester")
    private int semester;

    @Column(name = "studyProgram")
    private String studyProgram;

    @Column(name = "mandatoryOrElective")
    private boolean mandatory;

    @Column(name = "ects")
    private int ectsPoints;

    @Column(name = "courseLanguage")
    private String language;

    @Column(name = "minNumberStudents")
    private int minNumberStudents;

    @Column(name = "maxNumberOfStudents")
    private int maxNumberOfStudents;

    @Column(name = "expNumberOfStudents")
    private int expNumberOfStudents;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "learningOutcome")
    private String learningOutcome;

    @Column(name = "content")
    private String content;

    @Column(name = "learningActivities")
    private String learningActivities;

    @Column(name = "examForm")
    private String examForm;

    //skal muligvis laves om til en int senere
    @Column(name = "assignedTeachers")
    private List<Teacher> assignedTeachers;




    public Course(){}

    public Course(String nameDanish, String nameEnglish, int semester, String studyProgram, boolean mandatory, int ectsPoints, String language,
                  int minNumberStudents, int maxNumberOfStudents, int expNumberOfStudents, String prerequisites, String learningOutcome, String content,
                  String learningActivities, String examForm, List<Teacher> assignedTeachers) {
        this.nameDanish = nameDanish;
        this.nameEnglish = nameEnglish;
        this.semester = semester;
        this.studyProgram = studyProgram;
        this.mandatory = mandatory;
        this.ectsPoints = ectsPoints;
        this.language = language;
        this.minNumberStudents = minNumberStudents;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.expNumberOfStudents = expNumberOfStudents;
        this.prerequisites = prerequisites;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
        this.assignedTeachers = assignedTeachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDanish() {
        return nameDanish;
    }

    public void setNameDanish(String nameDanish) {
        this.nameDanish = nameDanish;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMinNumberStudents() {
        return minNumberStudents;
    }

    public void setMinNumberStudents(int minNumberStudents) {
        this.minNumberStudents = minNumberStudents;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public int getExpNumberOfStudents() {
        return expNumberOfStudents;
    }

    public void setExpNumberOfStudents(int expNumberOfStudents) {
        this.expNumberOfStudents = expNumberOfStudents;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivities() {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) {
        this.learningActivities = learningActivities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public List<Teacher> getAssignedTeachers() {
        return assignedTeachers;
    }

    public void setAssignedTeachers(List<Teacher> assignedTeachers) {
        this.assignedTeachers = assignedTeachers;
    }
}
