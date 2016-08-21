package serenitylabs.tutorials.vetclinic.collections.exercises;

import com.google.common.collect.Lists;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.utility.LengthComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

// import static org.hamcrest.Matchers

public class WhenWorkingWithAListOfPetNames {

    @Test
    public void should_add_Fido_to_the_list_of_pets() {
        List<String> names = Lists.newArrayList();
        names.add("Fido");
        assertThat(names, contains("Fido"));
    }

    @Test
    public void should_remove_Fido_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");
        names.remove("Fido");
        assertThat(names, contains("Felix", "Spot"));
    }

    @Test
    public void should_remove_the_first_pet_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");

        names.remove(0);
        assertThat(names, hasItems("Fido", "Spot"));
    }

    @Test
    public void should_make_a_list_of_cats_and_dogs() {
        List<String> cats = Lists.newArrayList("Felix", "Spot");
        List<String> dogs = Lists.newArrayList("Fido", "Rover");

        List<String> catsAndDogs = new ArrayList<String>();
        catsAndDogs.addAll(cats);
        catsAndDogs.addAll(dogs);

        assertThat(catsAndDogs, hasItems("Felix", "Spot", "Fido", "Rover"));
    }

    @Test
    public void should_put_the_dogs_among_the_cats() {
        List<String> cats = Lists.newArrayList("Felix", "Spot");
        List<String> dogs = Lists.newArrayList("Fido", "Rover");

        // TODO
        List<String> catsAndDogs = null;
        catsAndDogs = cats;
        catsAndDogs.addAll(dogs);
        assertThat(catsAndDogs, hasItems("Felix", "Fido", "Rover", "Spot"));
    }

    @Test
    public void should_organise_pets_in_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

        Collections.sort(pets);
        assertThat(pets, contains("Felix", "Fido", "Rover", "Spot"));
    }

    @Test
    public void should_organise_pets_in_reverse_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

        Collections.sort(pets);
        Collections.reverse(pets);
        assertThat(pets, contains("Spot", "Rover", "Fido", "Felix"));
    }

    @Test
    public void should_organise_pets_by_name_length() {
        List<String> pets = Lists.newArrayList("Felix", "Alfred", "Spot");

        Collections.sort(pets, new LengthComparator());
        assertThat(pets, contains("Spot","Felix","Alfred"));
    }

}
