package com.mike.domain;

import javax.persistence.*;

/**
 * Represents the foo entity
 * <p/>
 * User: mike
 * Date: 1/5/13
 * Time: 10:00 PM
 */
@Entity
@Table(name = "foo")
@NamedQuery(name = Foo.FIND_BY_ID, query = "select f from Foo f where f.id = :id")
public class Foo
{
    public static final String FIND_BY_ID = "foo.findById";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

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

        Foo foo = (Foo) o;

        if (id != null ? !id.equals(foo.id) : foo.id != null)
        {
            return false;
        }
        if (name != null ? !name.equals(foo.name) : foo.name != null)
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
        return result;
    }
}
