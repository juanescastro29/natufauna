package com.uptc.natufaunabackend.model;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private int adoption_id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user_id;
    @OneToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id", nullable = false)
    private Pet pet_id;
    @Column(name = "date")
    private Date date;
    @Column(name = "last_update")
    private Date date_update;
    @Column(name = "adoption_comments", nullable = false)
    private String adoption_comments;
    @Column(name = "status")
    private String status;

    @PrePersist
    public void prePersist() {
        this.date = new Date();
        this.status = "On progress";
    }

    @PreUpdate
    public void preUpdate() {
        this.date_update = new Date();
    }

    public Adoption() {
    }

    public int getAdoption_id() {
        return adoption_id;
    }

    public void setAdoption_id(int adoption_id) {
        this.adoption_id = adoption_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Pet getPet_id() {
        return pet_id;
    }

    public void setPet_id(Pet pet_id) {
        this.pet_id = pet_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

    public String getAdoption_comments() {
        return adoption_comments;
    }

    public void setAdoption_comments(String adoption_comments) {
        this.adoption_comments = adoption_comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
