package com.jam.teachforindia.RetroServices.ServiceResponses.EventApplicants;

/**
 * Created by Jam on 24-02-2018.
 */

public class ApplicantData {

    String applicationid;
    String userid;
    String eventid;
    String contactnumber;
    String currentemail;
    String applicationnote;
    String isselected;
    String firstname;
    String age;
    String gender;
    String education;
    String educationdetails;
    String organisationdetails;
    String priorteachingexperience;
    String skillsets;

    public ApplicantData(String applicationid, String userid, String eventid, String contactnumber, String currentemail, String applicationnote, String isselected, String firstname, String age, String gender, String education, String educationdetails, String organisationdetails, String priorteachingexperience, String skillsets) {
        this.applicationid = applicationid;
        this.userid = userid;
        this.eventid = eventid;
        this.contactnumber = contactnumber;
        this.currentemail = currentemail;
        this.applicationnote = applicationnote;
        this.isselected = isselected;
        this.firstname = firstname;
        this.age = age;
        this.gender = gender;
        this.education = education;
        this.educationdetails = educationdetails;
        this.organisationdetails = organisationdetails;
        this.priorteachingexperience = priorteachingexperience;
        this.skillsets = skillsets;
    }

    public String getPriorteachingexperience() {
        return priorteachingexperience;
    }

    public void setPriorteachingexperience(String priorteachingexperience) {
        this.priorteachingexperience = priorteachingexperience;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getCurrentemail() {
        return currentemail;
    }

    public void setCurrentemail(String currentemail) {
        this.currentemail = currentemail;
    }

    public String getApplicationnote() {
        return applicationnote;
    }

    public void setApplicationnote(String applicationnote) {
        this.applicationnote = applicationnote;
    }

    public String getIsselected() {
        return isselected;
    }

    public void setIsselected(String isselected) {
        this.isselected = isselected;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationdetails() {
        return educationdetails;
    }

    public void setEducationdetails(String educationdetails) {
        this.educationdetails = educationdetails;
    }

    public String getOrganisationdetails() {
        return organisationdetails;
    }

    public void setOrganisationdetails(String organisationdetails) {
        this.organisationdetails = organisationdetails;
    }

    public String getSkillsets() {
        return skillsets;
    }

    public void setSkillsets(String skillsets) {
        this.skillsets = skillsets;
    }
}
