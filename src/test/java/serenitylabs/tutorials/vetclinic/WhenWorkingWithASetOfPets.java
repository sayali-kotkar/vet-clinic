package serenitylabs.tutorials.vetclinic.collections.exercises;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class WhenWorkingWithASetOfPets {

    @Test
    public void should_add_Fido_to_the_set_of_pets() {
        Set<String> names = Sets.newHashSet();
        names.add("Fido");
        assertThat(names, contains("Fido"));
    }

    @Test
    public void a_set_of_pets_should_not_contain_duplicates() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");
        names.add("Felix");
        names.add("Fido");

        assertThat(names, contains("Fido", "Felix"));
    }

    @Test
    public void adding_several_pets() {
        Set<String> names = Sets.newHashSet("Fido", "Felix");

        names.addAll(Sets.newHashSet("Felix", "Spot"));

        // TODO
        assertThat(names, contains("Felix", "Fido", "Spot"));
    }


}
