package com.Journal.entity;

import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();

    public User(@NonNull String userName, @NonNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userName = this.getuserName();
        final Object other$userName = other.getuserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$journalEntries = this.getJournalEntries();
        final Object other$journalEntries = other.getJournalEntries();
        if (this$journalEntries == null ? other$journalEntries != null : !this$journalEntries.equals(other$journalEntries))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userName = this.getuserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $journalEntries = this.getJournalEntries();
        result = result * PRIME + ($journalEntries == null ? 43 : $journalEntries.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", userName=" + this.getuserName() + ", password=" + this.getPassword() + ", journalEntries=" + this.getJournalEntries() + ")";
    }

    public ObjectId getId() {
        return this.id;
    }

    public @NonNull String getuserName() {
        return this.userName;
    }

    public @NonNull String getPassword() {
        return this.password;
    }

    public List<JournalEntry> getJournalEntries() {
        return this.journalEntries;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
