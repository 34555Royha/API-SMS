package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Study.Study;
import com.sms.demo.Model.Study.StudyCreate;

import org.springframework.stereotype.Service;


@Service
public interface StudyService {
    List<Study> List();
    Study getById(String id);
    Boolean Delete(String id);
    Boolean Create(StudyCreate studyCreate);
    Boolean Update(Study study);
    List<Study> Search(String StudyType);
}
