package com.demo.model;

import java.time.LocalDate;

public class Todo {

    private int id;
    private String title;
    private String email;
    private String description;
    private LocalDate targetDate;
    private boolean status;

    protected Todo() {

    }

    public Todo(int id, String title, String email, String description, LocalDate targetDate, boolean isDone) {
        super();
        this.id = id;
        this.title = title;
        this.email= email;
        this.description = description;
        this.targetDate = targetDate;
        this.status = isDone;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Todo(String title, String email, String description, LocalDate targetDate, boolean isDone) {
        super();
        this.title = title;
        this.email= email;
        this.description = description;
        this.targetDate = targetDate;
        this.status = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
