package com.ETW.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_note")
public class NoteEntity extends AbstractBaseEntity {

    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "selectedString", length = 50)
    private String selectedString;

    @Column(name = "start_index")
    private int startIndex;

    @Column(name = "title", length = 30)
    private String title;

    @Column(name = "content")
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedString() {
        return selectedString;
    }

    public void setSelectedString(String selectedString) {
        this.selectedString = selectedString;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", selectedString='" + selectedString + '\'' +
                ", startIndex=" + startIndex +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", owner=" + owner +
                '}';
    }
}
