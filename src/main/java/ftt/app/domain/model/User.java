package ftt.app.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private ArrayList<Interest> interests;
    private ArrayList<Platform> platforms;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "";
        this.interests = new ArrayList<Interest>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.interests = new ArrayList<Interest>();
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
    public Collection<Interest> getInterests() {
        return Collections.unmodifiableCollection(this.interests);
    }

    public void addInterest(Interest interest) {
        this.interests.add(interest);
    }

    public void removeInterest(Interest interest) {
        for (int idx = 0; idx < this.interests.size(); idx++) {
            if(this.interests.get(idx) == interest) {
                this.interests.remove(idx);
            }
        }
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    /* ----------------- platforms ----------------- */
    @Column
    public Collection<Interest> getPlatforms() {
        return Collections.unmodifiableCollection(this.interests);
    }

    public void addPlatforms(Platform platform) {
        this.platforms.add(platform);
    }

    public void removePlatforms(Platform platforms) {
        for (int idx = 0; idx < this.platforms.size(); idx++) {
            if(this.platforms.get(idx) == platforms) {
                this.platforms.remove(idx);
            }
        }
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }
}
