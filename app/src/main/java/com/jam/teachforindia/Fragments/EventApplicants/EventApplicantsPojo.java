package com.jam.teachforindia.Fragments.EventApplicants;

/**
 * Created by Jam on 24-02-2018.
 */

public class EventApplicantsPojo {
    String userId;
    String applicationId;
    String email;
    String contact;
    String name;
    String score;
    String age;
    String gender;
    String education;
    String educationDetails;
    String organisationDetails;
    String applicationNote;
    String skillSets;
    String priorExperience;
    String isSelected;

    public EventApplicantsPojo(String userId, String applicationId, String email, String contact, String name, String score, String age, String gender, String education, String educationDetails, String organisationDetails, String applicationNote, String skillSets, String priorExperience, String isSelected) {
        this.userId = userId;
        this.applicationId = applicationId;
        this.email = email;
        this.contact = contact;
        this.name = name;
        this.score = score;
        this.age = age;
        this.gender = gender;
        this.education = education;
        this.educationDetails = educationDetails;
        this.organisationDetails = organisationDetails;
        this.applicationNote = applicationNote;
        this.skillSets = skillSets;
        this.priorExperience = priorExperience;
        this.isSelected = isSelected;
    }

    public String getApplicationNote() {
        return applicationNote;
    }

    public void setApplicationNote(String applicationNote) {
        this.applicationNote = applicationNote;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    public String getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(String educationDetails) {
        this.educationDetails = educationDetails;
    }

    public String getOrganisationDetails() {
        return organisationDetails;
    }

    public void setOrganisationDetails(String organisationDetails) {
        this.organisationDetails = organisationDetails;
    }

    public String getSkillSets() {
        return skillSets;
    }

    public void setSkillSets(String skillSets) {
        this.skillSets = skillSets;
    }

    public String getPriorExperience() {
        return priorExperience;
    }

    public void setPriorExperience(String priorExperience) {
        this.priorExperience = priorExperience;
    }

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }
}
