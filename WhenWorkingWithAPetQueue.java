package serenitylabs.tutorials.vetclinic.collections.exercises;

import org.hamcrest.Matchers;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.LinkedList;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWorkingWithAPetQueue {

    @Test
    public void should_add_Fido_to_the_end_of_the_queue() {
        Queue<Pet> waitingList = new LinkedList<Pet>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        Pet pet =((LinkedList<Pet>) waitingList).getLast();
        assertThat(pet.getName(), Matchers.equalTo("Fido"));
    }

    @Test
    public void should_see_who_is_at_the_top_of_the_queue_without_removing_it() {
        Queue<Pet> waitingList = new LinkedList<Pet>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        Pet nextInLine = waitingList.peek();

        // TODO
        assertThat(nextInLine.getName(), Matchers.equalTo("Felix"));
    }


}
