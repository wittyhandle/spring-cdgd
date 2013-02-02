package com.mike.domain;

import javax.persistence.*;

/**
 * Represents a work entity.
 * <p/>
 * User: mike
 * Date: 2/2/13
 * Time: 8:36 AM
 */
@Entity
@Table(name = "works")
@NamedQueries({
        @NamedQuery(name = Work.FIND_BY_ID, query = "select w from Work w where w.id = :id"),
        @NamedQuery(name = Work.FIND_BY_NAME, query = "select w from Work w where w.name = :name")
})
public class Work
{
    public static final String FIND_BY_ID = "work.findById";
    public static final String FIND_BY_NAME = "work.findByName";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Work work = (Work) o;

        if (description != null ? !description.equals(work.description) : work.description != null)
        {
            return false;
        }
        if (id != null ? !id.equals(work.id) : work.id != null)
        {
            return false;
        }
        if (name != null ? !name.equals(work.name) : work.name != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Work{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
