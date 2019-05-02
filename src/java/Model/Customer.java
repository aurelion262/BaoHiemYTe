/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Customer {
    int id,gender,phone,families_id, group_id, group_objects_id, businesses_id;
    String code_BHXH, name, card_id, date_given, place_given, addr, original_addr, birthday, jobs, created_at, updated_at;

    @Override
    public boolean equals(Object o)
    {
        return
        (
                ((Customer)o).getAddr().equals(this.getAddr())
                &&  ((Customer)o).getBirthday() == this.getBirthday()
                &&  ((Customer)o).getBusinesses_id() == this.getBusinesses_id()
                &&  ((Customer)o).getCard_id().equals(this.getAddr())
                &&  ((Customer)o).getCode_BHXH().equals(this.getCode_BHXH())
                &&  ((Customer)o).getCreated_at().equals(this.getCreated_at())
                &&  ((Customer)o).getDate_given().equals(this.getDate_given())
                &&  ((Customer)o).getFamilies_id() == this.getFamilies_id()
                &&  ((Customer)o).getGender() == this.getGender()
                &&  ((Customer)o).getGroup_id() == this.getId()
                &&  ((Customer)o).getGroup_objects_id() == this.getGroup_objects_id()
                &&  ((Customer)o).getId() == this.getId()
                &&  ((Customer)o).getJobs().equals(this.getJobs())
                &&  ((Customer)o).getName().equals(this.getName())
                &&  ((Customer)o).getOriginal_addr().equals(this.getOriginal_addr())
                &&  ((Customer)o).getPhone()== this.getPhone()
                &&  ((Customer)o).getPlace_given().equals(this.getPlace_given())
                &&  ((Customer)o).getUpdated_at().equals(this.getUpdated_at())
        );
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getFamilies_id() {
        return families_id;
    }

    public void setFamilies_id(int families_id) {
        this.families_id = families_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getGroup_objects_id() {
        return group_objects_id;
    }

    public void setGroup_objects_id(int group_objects_id) {
        this.group_objects_id = group_objects_id;
    }

    public int getBusinesses_id() {
        return businesses_id;
    }

    public void setBusinesses_id(int businesses_id) {
        this.businesses_id = businesses_id;
    }

    public String getCode_BHXH() {
        return code_BHXH;
    }

    public void setCode_BHXH(String code_BHXH) {
        this.code_BHXH = code_BHXH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getDate_given() {
        return date_given;
    }

    public void setDate_given(String date_given) {
        this.date_given = date_given;
    }

    public String getPlace_given() {
        return place_given;
    }

    public void setPlace_given(String place_given) {
        this.place_given = place_given;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOriginal_addr() {
        return original_addr;
    }

    public void setOriginal_addr(String original_addr) {
        this.original_addr = original_addr;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
}
