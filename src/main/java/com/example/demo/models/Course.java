package com.example.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameDanish;
    private String nameEnglish;
    private int semester;
    private String studyProgram;
    private boolean mandatory;
    private int ectsPoints;
    private String language;
    private int minNumberStudents;
    private int maxNumberOfStudents;
    private int expNumberOfStudents;
    private String prerequisites;
    private String learningOutcome;
    private String content;
    private String learningActivities;
    private String examForm;

    @ManyToMany
    private List<Teacher> assignedTeachers;

    @ManyToMany
    private List<Student> assignedStudents;

    @ManyToMany
    private List<Student> studentWaitingList;

    public Course(){}

    public Course(String nameDanish, String nameEnglish, int semester, String studyProgram, boolean mandatory,
                  int ectsPoints, String language, int minNumberStudents, int maxNumberOfStudents, int expNumberOfStudents,
                  String prerequisites, String learningOutcome, String content, String learningActivities, String examForm,
                  List<Teacher> assignedTeachers, List<Student> assignedStudents, List<Student> studentWaitingList) {
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
        this.assignedStudents = assignedStudents;
        this.studentWaitingList = studentWaitingList;
    }

    public void addStudentToCourse(Student student){
        assignedStudents.add(student);
    }

    public void addStudentToWaitingList(Student student){
        studentWaitingList.add(student);
    }

    public void removeStudentFromWaitingList(Student student){

        int index = 0;

        for (int i = 0; i<studentWaitingList.size(); i++){
            if(studentWaitingList.get(i).getId().equals(student.getId())){
                index = i;
            }
        }
        studentWaitingList.remove(index);

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

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(List<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public List<Student> getStudentWaitingList() {
        return studentWaitingList;
    }

    public void setStudentWaitingList(List<Student> studentWaitingList) {
        this.studentWaitingList = studentWaitingList;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
