/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
    
public class Transaction {
    int id;
    long paid,support;
    String customer_id;
    Timestamp created_at;
    
    @Override
    public boolean equals(Object o)
    {
        Transaction t = (Transaction)o;
        return
        (
                t.getCustomer_id().equals(this.getCustomer_id())
                && t.getId() == this.getId()
                && t.getPaid() == this.getPaid()
                && t.getSupport() == this.getSupport()
        );
    }

    public Timestamp getCreated_at() {
        return created_at;        
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }   

    public long getPaid() {
        return paid;
    }

    public void setPaid(long paid) {
        this.paid = paid;
    }

    public long getSupport() {
        return support;
    }

    public void setSupport(long support) {
        this.support = support;
    }

    
}
