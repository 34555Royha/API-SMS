package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Study.Study;
import com.sms.demo.Model.Study.StudyCreate;
import com.sms.demo.Repositories.StudyRepository;
import com.sms.demo.Service.StudyService;

import org.springframework.stereotype.Service;

@Service
public class StudyServiceImpl implements StudyService{

    private StudyRepository studyRepository;

    

    public StudyServiceImpl(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }



    @Override
    public java.util.List<Study> List() {
        return this.studyRepository.List();
    }



    @Override
    public Study getById(String id) {
        return this.studyRepository.getById(id);
    }



    @Override
    public Boolean Delete(String id) {
        return this.studyRepository.Delete(id);
    }



    @Override
    public Boolean Create(StudyCreate studyCreate) {
        return this.studyRepository.Create(studyCreate);
    }



    @Override
    public Boolean Update(Study study) {
        return this.studyRepository.Update(study);
    }



    @Override
    public java.util.List<Study> Search(String StudyType) {
        return this.studyRepository.Search(StudyType);
    }
    
}
