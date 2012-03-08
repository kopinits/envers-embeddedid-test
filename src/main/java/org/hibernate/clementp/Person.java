package org.hibernate.clementp;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
public class Person implements Serializable {
  @Id
  @GeneratedValue
  public long id;

  @Column
  public String name;

  //@NotAudited
  @OneToMany(mappedBy = "personA", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
  public Set<PersonTuple> personATuples = new HashSet<PersonTuple>();

  //@NotAudited
  @OneToMany(mappedBy = "personB", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
  public Set<PersonTuple> personBTuples = new HashSet<PersonTuple>();
}
