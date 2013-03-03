package com.mike.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

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
        @NamedQuery(name = Project.FIND_BY_ID, query = "select p from Project p where p.id = :id"),
        @NamedQuery(name = Project.FIND_BY_NAME, query = "select p from Project p where p.name = :name")
})
public class Project
{
    public static final String FIND_BY_ID = "work.findById";
    public static final String FIND_BY_NAME = "work.findByName";

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "{project.name.empty}")
    private String name;

    @NotEmpty(message = "{project.description.empty}")
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
        if (o == null)
        {
            return false;
        }

        if (getClass() != o.getClass())
        {
            return false;
        }

        final Project otherProject = (Project) o;

        return  Objects.equal(this.name, otherProject.name) &&
                Objects.equal(this.description, otherProject.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.name, this.description);
    }

    @Override
    public String toString()
    {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
