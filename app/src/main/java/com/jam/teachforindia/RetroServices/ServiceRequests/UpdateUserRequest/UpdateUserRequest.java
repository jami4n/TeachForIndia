package com.jam.teachforindia.RetroServices.ServiceRequests.UpdateUserRequest;

/**
 * Created by Jam on 22-02-2018.
 */

public class UpdateUserRequest {

    String userid;
    String firstname;
    String lastname;
    String age;
    String gender;
    String contactnumber;
    String currentemail;
    String address;
    String education;
    String educationdetails;
    String organisationdetails;
    String availablemonths;
    String availableweekdays;
    String availabletimeslot;
    String skillsets;
    String preferedcity;
    String volunteerreason;
    String priorteachingexperience;
    String priorapplication;
    String othersupport;


    public UpdateUserRequest(String userid, String firstname, String lastname, String age, String gender, String contactnumber, String currentemail, String address, String education, String educationdetails, String organisationdetails, String availablemonths, String availableweekdays, String availabletimeslot, String skillsets, String preferedcity, String volunteerreason, String priorteachingexperience, String priorapplication, String othersupport) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.contactnumber = contactnumber;
        this.currentemail = currentemail;
        this.address = address;
        this.education = education;
        this.educationdetails = educationdetails;
        this.organisationdetails = organisationdetails;
        this.availablemonths = availablemonths;
        this.availableweekdays = availableweekdays;
        this.availabletimeslot = availabletimeslot;
        this.skillsets = skillsets;
        this.preferedcity = preferedcity;
        this.volunteerreason = volunteerreason;
        this.priorteachingexperience = priorteachingexperience;
        this.priorapplication = priorapplication;
        this.othersupport = othersupport;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAvailablemonths() {
        return availablemonths;
    }

    public void setAvailablemonths(String availablemonths) {
        this.availablemonths = availablemonths;
    }

    public String getAvailableweekdays() {
        return availableweekdays;
    }

    public void setAvailableweekdays(String availableweekdays) {
        this.availableweekdays = availableweekdays;
    }

    public String getAvailabletimeslot() {
        return availabletimeslot;
    }

    public void setAvailabletimeslot(String availabletimeslot) {
        this.availabletimeslot = availabletimeslot;
    }

    public String getSkillsets() {
        return skillsets;
    }

    public void setSkillsets(String skillsets) {
        this.skillsets = skillsets;
    }

    public String getPreferedcity() {
        return preferedcity;
    }

    public void setPreferedcity(String preferedcity) {
        this.preferedcity = preferedcity;
    }

    public String getVolunteerreason() {
        return volunteerreason;
    }

    public void setVolunteerreason(String volunteerreason) {
        this.volunteerreason = volunteerreason;
    }

    public String getPriorteachingexperience() {
        return priorteachingexperience;
    }

    public void setPriorteachingexperience(String priorteachingexperience) {
        this.priorteachingexperience = priorteachingexperience;
    }

    public String getPriorapplication() {
        return priorapplication;
    }

    public void setPriorapplication(String priorapplication) {
        this.priorapplication = priorapplication;
    }

    public String getOthersupport() {
        return othersupport;
    }

    public void setOthersupport(String othersupport) {
        this.othersupport = othersupport;
    }
}
