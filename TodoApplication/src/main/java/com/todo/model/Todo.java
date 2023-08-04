package com.todo.model;

import java.time.LocalDate;

/**
 * The Class Todo.
 */
public class Todo {

	/** The id. */
	private Long id;

	/** The title. */
	private String title;

	/** The username. */
	private String username;

	/** The description. */
	private String description;

	/** The target date. */
	private LocalDate targetDate;

	/** The status. */
	private boolean status;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the target date.
	 *
	 * @return the target date
	 */
	public LocalDate getTargetDate() {
		return targetDate;
	}

	/**
	 * Sets the target date.
	 *
	 * @param targetDate the new target date
	 */
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Instantiates a new todo.
	 *
	 * @param id          the id
	 * @param title       the title
	 * @param username    the username
	 * @param description the description
	 * @param targetDate  the target date
	 * @param status      the status
	 */
	public Todo(Long id, String title, String username, String description, LocalDate targetDate, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
	}

	/**
	 * Instantiates a new todo.
	 *
	 * @param title       the title
	 * @param username    the username
	 * @param description the description
	 * @param targetDate  the target date
	 * @param isDone      the is done
	 */
	public Todo(String title, String username, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.title = title;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.status = isDone;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", username=" + username + ", description=" + description
				+ ", targetDate=" + targetDate + ", status=" + status + "]";
	}

	/**
	 * Instantiates a new todo.
	 */
	public Todo() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
