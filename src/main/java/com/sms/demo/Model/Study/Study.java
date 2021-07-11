package com.sms.demo.Model.Study;

public class Study {
    private String Id;
    private String StudyType;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStudyType() {
        return StudyType;
    }

    public void setStudyType(String studyType) {
        StudyType = studyType;
    }

    public Study(String id, String studyType) {
        Id = id;
        StudyType = studyType;
    }

    @Override
    public String toString() {
        return "Study [Id=" + Id + ", StudyType=" + StudyType + "]";
    }

    public Study() {
    }

}
