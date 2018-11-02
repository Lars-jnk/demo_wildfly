/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.freizeitbaltrum.lars.cdi.entity.repo;

import de.freizeitbaltrum.lars.cdi.entity.Person;
import javax.ejb.Stateless;

/**
 *
 * @author Lars
 */
@Stateless
public class PersonRepo extends AbsRepo<Person> {

    public PersonRepo() {
        super(Person.class);
    }
}
