package ftt.app.domain.model;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private Collection<Interest> interests;
//    private ArrayList<Platform> platforms;

    public User() {
        this.username = "";
        this.nickname = "";
        this.email = "";
        this.password = "";
    }

    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int userId) { id = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Interest> getInterests() {
        return Collections.unmodifiableCollection(this.interests);
    }

    public void addInterest(Interest interest) {
        this.interests.add(interest);
    }

    public void removeInterest(Interest interest) {
        for (int idx = 0; idx < this.interests.size(); idx++) {
            if(this.interests.contains(interest)) {
                this.interests.remove(idx);
            }
        }
    }

    public void setInterests(Collection<Interest> interests) {
        this.interests = interests;
    }

//    /* ----------------- platforms ----------------- */
//    public Collection<Interest> getPlatforms() {
//        return Collections.unmodifiableCollection(this.interests);
//    }
//
//    public void addPlatforms(Platform platform) {
//        this.platforms.add(platform);
//    }
//
//    public void removePlatforms(Platform platforms) {
//        for (int idx = 0; idx < this.platforms.size(); idx++) {
//            if(this.platforms.get(idx) == platforms) {
//                this.platforms.remove(idx);
//            }
//        }
//    }
//
//    public void setPlatforms(ArrayList<Platform> platforms) {
//        this.platforms = platforms;
//    }
}
