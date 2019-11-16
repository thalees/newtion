package ftt.app.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ftt.app.infra.enums.AvailableInterests;
import ftt.app.infra.enums.AvailablePlatforms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private ArrayList<AvailableInterests> interests;
    private ArrayList<AvailablePlatforms> platforms;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "";
        this.interests = new ArrayList<AvailableInterests>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.interests = new ArrayList<AvailableInterests>();
    }

    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /* ----------------- interests ----------------- */
    @Column
    public Collection<AvailableInterests> getInterests() {
        return Collections.unmodifiableCollection(this.interests);
    }

    public void addInterest(AvailableInterests interest) {
        this.interests.add(interest);
    }

    public void removeInterest(AvailableInterests interest) {
        for (int idx = 0; idx < this.interests.size(); idx++) {
            if(this.interests.get(idx) == interest) {
                this.interests.remove(idx);
            }
        }
    }

    public void setInterests(ArrayList<AvailableInterests> interests) {
        this.interests = interests;
    }

    /* ----------------- platforms ----------------- */
    @Column
    public Collection<AvailableInterests> getPlatforms() {
        return Collections.unmodifiableCollection(this.interests);
    }

    public void addPlatforms(AvailablePlatforms platform) {
        this.platforms.add(platform);
    }

    public void removePlatforms(AvailablePlatforms platforms) {
        for (int idx = 0; idx < this.platforms.size(); idx++) {
            if(this.platforms.get(idx) == platforms) {
                this.platforms.remove(idx);
            }
        }
    }

    public void setPlatforms(ArrayList<AvailablePlatforms> platforms) {
        this.platforms = platforms;
    }
}
